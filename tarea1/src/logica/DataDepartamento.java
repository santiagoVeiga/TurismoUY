package logica;


import java.util.HashSet;
import java.util.Set;

public class DataDepartamento {
	
	public DataDepartamento() {
		colAct = new HashSet<DataActividad>();
	}
	
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



	public Set<DataActividad> getColAct() {
		return colAct;
	}



	public void setColAct(Set<DataActividad> colAct) {
		this.colAct = colAct;
	}
}
