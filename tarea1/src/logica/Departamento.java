package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Departamento {
	
	private String nombre;
	private String descripcion;
	private String url;
	private Map<String, Actividad> colAct;

	public Departamento(String nombre, String descripcion, String URL){
		setNombre(nombre); 
		setDescripcion(descripcion); 
		setUrl(URL); 
		this.colAct = new HashMap<String, Actividad>();
	}


	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	
	public void setDescripcion(String des) {
		this.descripcion = des;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
	
	public Actividad[] getActividadesDep() {
		Actividad[] res = colAct.values().toArray(new Actividad[0]);
		return res;
	}
	
	public Set<DataActividad> getActividades() {
		Set<DataActividad> res = new HashSet<DataActividad>();
		if (!colAct.isEmpty()) {
			Set<Entry<String, Actividad>> aux = colAct.entrySet();
	    	Iterator<Entry<String, Actividad>> iter = aux.iterator();
	    	while (iter.hasNext()){
	    		res.add(iter.next().getValue().getDataAT());
	    	}
		}
		return res;
	}
	
	public DataDepartamento obtenerDataDepartamento() {
		DataDepartamento res = new DataDepartamento(this.nombre, this.descripcion, this.url, this.getActividades());
		return res;
	}
	
	public void agregarActividad(Actividad act) {
		colAct.put(act.getNombre(), act);
	}
	
	public void removerActividad(String nomAct) {
		if (this.colAct.containsKey(nomAct)) {
			this.colAct.remove(nomAct);
		}
	}
}
