package manejadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import logica.Actividad;
import logica.DataActividad;
 
public class ManejadorActividad {
	
	// Atributos 
	private static ManejadorActividad instancia = null;
	
	private Map<String,Actividad> colAct;
// Constructor
    private ManejadorActividad() {
    	colAct = new HashMap<String,Actividad>();
    }

    public static ManejadorActividad getInstance() {
        if (instancia == null) {
            instancia = new ManejadorActividad();
        }
        return instancia;
    }
    
    //Operaciones
	
    public Set<DataActividad> getDAct() {
    	Set<DataActividad> resultado = null;
    	Set<Entry<String, Actividad>> aux = colAct.entrySet();
    	Iterator<Entry<String, Actividad>> it = aux.iterator();
    	while(it.hasNext()){
    		resultado.add(it.next().getValue().getDataAT());
    	}
    	return resultado;  
    }  
    
    public Actividad getActividad(String nom) {
    	return colAct.get(nom);
    }
}