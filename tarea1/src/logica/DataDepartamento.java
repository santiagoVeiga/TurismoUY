package logica;


import java.util.Iterator;
import java.util.Set;

public class DataDepartamento {
	
	private String nombre;
	private String descripcion;
	private String url;
	private Set<DataActividad> colAct;

	public DataDepartamento(String nombre, String descripcion, String URL, Set<DataActividad> setAct){
		this.nombre = nombre ; 
		this.descripcion = descripcion ; 
		this.url = URL ; 
		this.setColAct(setAct);
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
	
	
	public void setUrl(String d) {
		this.descripcion = d;
	}

	public String getUrl() {
		return this.url;
	}



	public Set<DataActividad> getColAct() {
		return colAct;
	}



	public void setColAct(Set<DataActividad> colAct) {
		this.colAct = colAct;
	}
}
