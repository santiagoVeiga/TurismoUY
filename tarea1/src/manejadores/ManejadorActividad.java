package manejadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import logica.Actividad;
import logica.DataActividad;
import logica.Usuario;
 
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
	
    public void addActividad(Actividad act) {
        String nombre = act.getNombre();
        colAct.put(nombre, act);
    }
    
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
    
	public boolean actividadEstaRegistrada(Actividad actividad) {
		Actividad res = colAct.get(actividad.getNombre());
		return res != null;
	}

}