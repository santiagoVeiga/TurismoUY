package manejadores;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import excepciones.ActividadNoExisteException;
import excepciones.SalidaYaExisteExeption;
import excepciones.SalidasNoExisteException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.Actividad;
import logica.DataActividad;
import logica.Proveedor;
import logica.Turista;
 
public class ManejadorActividad {

	// Atributos

	private static ManejadorActividad instancia = null;

	private Map<String, Actividad> colAct;
	private Set<String> actsFinalizadas;
	
	// Constructor
    
	private ManejadorActividad() {
    	colAct = new HashMap<String, Actividad>();
    	actsFinalizadas = new HashSet<String>();
    }

    public static ManejadorActividad getInstance() {
        if (instancia == null) {
            instancia = new ManejadorActividad();
        }
        return instancia;
    }

    //Operaciones
    public void addActividad(Actividad act) {
        String nombre = act.getNombre();
        colAct.put(nombre, act);
    }

    public Set<DataActividad> getDAct() {
    	Set<DataActividad> resultado = new HashSet<DataActividad>();
    	Set<Entry<String, Actividad>> aux = colAct.entrySet();
    	Iterator<Entry<String, Actividad>> iter = aux.iterator();
    	while (iter.hasNext()){
    		resultado.add(iter.next().getValue().getDataAT());
    	}
    	return resultado;
    }

    public Map<String, Actividad> getColAct() {
    	return colAct ;
    }

    public Actividad getActividad(String nom) throws ActividadNoExisteException {
    	return colAct.get(nom);
    }
    
	public void verificarSalida(String nombreSalida) throws SalidaYaExisteExeption {
		Set<Entry<String, Actividad>> aux = colAct.entrySet();
    	Iterator<Entry<String, Actividad>> iter = aux.iterator();
    	while (iter.hasNext()){
    		if (iter.next().getValue().perteneceSalida(nombreSalida)) {
    			throw new SalidaYaExisteExeption("Ya existe una salida registrada con el nombre: " + nombreSalida);
    		}
    	}
	}
	
	public String obtenerNomActvidiadDeSalida(String salida) throws SalidasNoExisteException {
		String res =  null;
		for (Actividad it : colAct.values()) {
			if (it.perteneceSalida(salida)) {
				res = it.getNombre();
			}
		}
		if (res == null) {
			throw new SalidasNoExisteException("No existe una salida con nombre" + salida);
		}
		return res;
	}
	
	public void finalizarAct(String nomAct, Proveedor prov) throws ActividadNoExisteException {
		if (colAct.get(nomAct) == null) {
			throw new ActividadNoExisteException("No existe una actividad con nombre: " + nomAct);
		}
		Actividad act = colAct.get(nomAct);
		prov.finalizarAct(nomAct);
		Set<Turista> turistas = act.finalizarAct();
		// comienza la persistencia en la base
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		Query queryProv = em.createQuery("SELECT p FROM Proveedor p WHERE p.nickname = '" + prov.getNickname() + "'");
		boolean perProv = false;
		try {
			queryProv.getSingleResult();
		} catch (NoResultException e) {
			perProv = true;
		}
		Query queryTur = null;
		for (Turista iter : turistas) {
			queryTur = em.createQuery("SELECT t FROM Turista t WHERE t.nickname = '" + iter.getNickname() + "'");
			try {
				queryTur.getSingleResult();
				turistas.remove(iter);
			} catch (NoResultException e) {
				
			}
		}
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (perProv)
			em.persist(prov);
		for (Turista iter : turistas) {
			em.persist(iter);
		}
		em.persist(act);
		tx.commit();
		em.close();
		emf.close();
	}
	
}