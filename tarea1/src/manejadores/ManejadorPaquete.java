package manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import excepciones.PaqueteNoExisteException;
import logica.DataPaquete;
import logica.Paquete;
 
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
    	Iterator<Entry<String, Paquete>> iter = aux.iterator();
    	int cont = 0;
    	while(iter.hasNext()){
    		resultado[cont] = iter.next().getValue().getNombre();
    		cont++;
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
    
    public Paquete getPaqueteIns(String nom) throws PaqueteNoExisteException {
    	Paquete paq = colPaq.get(nom);
    	if(paq == null) {
    		throw new PaqueteNoExisteException("No existe un paquete con el nombre: " + nom);
    	}
    	return paq;
    }
    
    public DataPaquete getDataPaquete(String nom) {
    	Paquete paq = colPaq.get(nom);
    	return paq.getDataP();
    }

	public String[] getPaquetesNoComp() {
		Set<String> inter = new HashSet<String>();
		Set<Entry<String, Paquete>> aux = colPaq.entrySet();
    	Iterator<Entry<String, Paquete>> iter = aux.iterator();
    	int cont = 0;
    	while(iter.hasNext()){
    		Paquete elem = iter.next().getValue();
    		if(!elem.isComprado()) {
    			inter.add(elem.getNombre());
    		cont++;
    		}
    	}
    	String[] res = new String[cont];
    	cont=0;
    	for (String it1 : inter) {
    		res[cont] = it1;
    		cont++;
    	}
		return res;
	}

}