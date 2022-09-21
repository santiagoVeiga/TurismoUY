package manejadores;

import java.util.HashMap;
import java.util.HashSet;
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

    public String[] getPaquetesN() {
    	String[] resultado = new String[colPaq.size()];
    	Set<Entry<String, Paquete>> aux = colPaq.entrySet();
    	Iterator<Entry<String, Paquete>> it = aux.iterator();
    	int i = 0;
    	while(it.hasNext()){
    		resultado[i] = it.next().getValue().getNombre();
    		i++;
    	}
    	return resultado;
    }

    public Map<String,Paquete> getcolPaq() {
    	return colPaq ;
    }

    public Paquete getPaquete(String nom) {
    	Paquete paq = colPaq.get(nom);
    	return paq;
    }
    
    public DataPaquete getDataPaquete(String nom) {
    	Paquete paq = colPaq.get(nom);
    	return paq.getDataP();
    }

	public String[] getPaquetesNoComp() {
		Set<String> inter = new HashSet<String>();
		Set<Entry<String, Paquete>> aux = colPaq.entrySet();
    	Iterator<Entry<String, Paquete>> it = aux.iterator();
    	int i = 0;
    	while(it.hasNext()){
    		Paquete elem = it.next().getValue();
    		if(!elem.isComprado()) {
    			inter.add(elem.getNombre());
    		i++;
    		}
    	}
    	String[] res = new String[i];
    	i=0;
    	for (String it1 : inter) {
    		res[i] = it1;
    		i++;
    	}
		return res;
	}

}