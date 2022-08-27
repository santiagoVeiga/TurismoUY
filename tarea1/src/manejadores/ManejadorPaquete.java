package manejadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import excepciones.PaqueteNoExisteException;
import logica.Actividad;
import logica.DataActividad;
import logica.DataPaquete;
import logica.Paquete;
import logica.Usuario;
 
public class ManejadorPaquete {

	// Atributos

	private static ManejadorPaquete instancia = null;

	private Map<String,Paquete> colPaq;
	
	// Constructor
    
	private ManejadorPaquete() {
    	colPaq = new HashMap<String,Paquete>();
    }

    public static ManejadorPaquete getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPaquete();
        }
        return instancia;
    }

    //Operaciones
    public void addPaquete(Paquete paq) {
        String nombre = paq.getNombre();
        colPaq.put(nombre, paq);
    }

    public Set<DataPaquete> getDataPaquetes() {
    	Set<DataPaquete> resultado = null;
    	Set<Entry<String, Paquete>> aux = colPaq.entrySet();
    	Iterator<Entry<String, Paquete>> it = aux.iterator();
    	while(it.hasNext()){
    		resultado.add(it.next().getValue().getDataP());
    	}
    	return resultado;
    }

    public Map<String,Paquete> getcolPaq() {
    	return colPaq ;
    }

    public Paquete getPaquete(String nom) {
    	Paquete paq = colPaq.get(nom);
    	/*
    	if (paq == null) {
    		throw new PaqueteNoExisteException("No existe un Paquete con ese nombre");
    	}
    	*/
    	return paq;
    }
    
	/* Da problemas cuando consultas por una Actividad que no esta registrada. Quitar del DCD (ya fue entregado)
	 * public boolean actividadEstaRegistrada(Actividad actividad) {
		Actividad res = colPaq.get(actividad.getNombre());
		return res != null;
	}*/

}