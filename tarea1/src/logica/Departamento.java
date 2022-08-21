package logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Departamento {
	
	private String nombre;
	private String descripcion;
	private String url;

	public Departamento(String nombre, String descripcion, String URL){
		this.nombre = nombre ; 
		this.descripcion = descripcion ; 
		this.URL = URL ; 
	}


	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	
	public void seturl(String d) {
		this.descripcion = d;
	}

	public String getUrl() {
		return this.url;
	}
	
	private Map<String,Actividad> colAct;
	
	public Departamento() {
		colAct = new HashMap<String,Actividad>();
	}
	
	public Set<DataActividad> getActividades() {
		Set<DataActividad> res = null;
		Set<Entry<String, Actividad>> aux = colAct.entrySet();
    	Iterator<Entry<String, Actividad>> it = aux.iterator();
    	while(it.hasNext()){
    		res.add(it.next().getValue().getDataAT());
    	}
		return res;
	}
	
	
	
}
