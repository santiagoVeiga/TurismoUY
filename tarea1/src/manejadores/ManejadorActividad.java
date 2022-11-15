package manejadores;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import logica.estadoAct;
 
public class ManejadorActividad {

	// Atributos

	private static ManejadorActividad instancia = null;

	private Map<String, Actividad> colAct;
	private Set<String> actsFinalizadas;
	
	// Constructor
    
	private ManejadorActividad() {
    	colAct = new HashMap<String, Actividad>();
    	actsFinalizadas = new HashSet<String>();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager entM = emf.createEntityManager();
		Query query = entM.createQuery("SELECT a.nombre FROM Actividad a");
		List<String> nomActsFin = query.getResultList();
		Collections.addAll(actsFinalizadas, nomActsFin.toArray(new String[0]));
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
    	Actividad resultado = null;
    	if (this.colAct.containsKey(nom)) {
    		resultado = this.colAct.get(nom);
    	} else if (this.actsFinalizadas.contains(nom)) {
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
    		EntityManager entM = emf.createEntityManager();
    		Query query = entM.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nom");
    		query.setParameter("nom", nom);
    		try {
    			resultado = (Actividad) query.getSingleResult();
    		} catch (NoResultException e) {
    			throw new ActividadNoExisteException("No existe una actividad finalizada con el nombre: " + nom);
    		}
    		entM.close();
    		emf.close();
    	}
    	return resultado;
    }
    
	public void verificarSalida(String nombreSalida) throws SalidaYaExisteExeption {
		Set<Entry<String, Actividad>> aux = colAct.entrySet();
    	Iterator<Entry<String, Actividad>> iter = aux.iterator();
    	while (iter.hasNext()){
    		if (iter.next().getValue().perteneceSalida(nombreSalida)) {
    			throw new SalidaYaExisteExeption("Ya existe una salida registrada con el nombre: " + nombreSalida);
    		}
    	}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager entM = emf.createEntityManager();
		Query query = entM.createQuery("SELECT s FROM Salida s WHERE s.nombre = :nom");
		query.setParameter("nom", nombreSalida);
		try {
			query.getSingleResult();
			throw new SalidaYaExisteExeption("Ya existe una salida registrada con el nombre: " + nombreSalida);
		} catch (NoResultException e) {
			;
		}
		entM.close();
		emf.close();
	}
	
	public String obtenerNomActvidiadDeSalida(String salida) throws SalidasNoExisteException {
		String res =  null;
		for (Actividad it : colAct.values()) {
			if (it.perteneceSalida(salida)) {
				res = it.getNombre();
			}
		}
		if (res == null) {
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
    		EntityManager entM = emf.createEntityManager();
			Query query = entM.createQuery("SELECT a.nombre FROM Actividad a join a.salidasPersistir s WHERE s.nombre = :nom");
			query.setParameter("nom", salida);
			try {
				res = (String) query.getSingleResult();
			} catch (NoResultException e) {
				throw new SalidasNoExisteException("No existe una salida con nombre" + salida);
			}
    		entM.close();
    		emf.close();
		}
		return res;
	}
	
	public void finalizarAct(String nomAct, Proveedor prov) throws ActividadNoExisteException {
		if (colAct.get(nomAct) == null) {
			throw new ActividadNoExisteException("No existe una actividad con nombre: " + nomAct);
		}
		Actividad act = colAct.get(nomAct);
		act.setEstado(estadoAct.finalizada);
		act.setProveedor(prov);
		prov.finalizarAct(nomAct);
		Set<Turista> turistas = act.finalizarAct();
		// comienza la persistencia en la base
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager entM = emf.createEntityManager();
		Query queryProv = entM.createQuery("SELECT p FROM Proveedor p WHERE p.nickname = :provNom");
		queryProv.setParameter("provNom", prov.getNickname());
		boolean perProv = false;
		try {
			queryProv.getSingleResult();
		} catch (NoResultException e) {
			perProv = true;
		}
		Query queryTur = null;
		for (Turista iter : turistas) {
			queryTur = entM.createQuery("SELECT t FROM Turista t WHERE t.nickname = :turNom");
			queryTur.setParameter("turNom", iter.getNickname());
			try {
				queryTur.getSingleResult();
				turistas.remove(iter);
			} catch (NoResultException e) {
				;
			}
		}
		EntityTransaction txn = entM.getTransaction();
		txn.begin();
		if (perProv)
			entM.persist(prov);
		for (Turista iter : turistas) {
			entM.persist(iter);
		}
		entM.persist(act);
		txn.commit();
		entM.close();
		emf.close();
		actsFinalizadas.add(nomAct);
	}
	
}