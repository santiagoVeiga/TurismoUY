package logica;

import java.util.Set;

public class Departamento {

	private String nombre;
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	private String descripcion;
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	private String url;
	
	public void seturl(String d) {
		this.descripcion = d;
	}

	public String getUrl() {
		return this.url;
	}
	
	public Set<DataActividad> getActividades() {
		Set<DataActividad> res = null;
		
		return res;
	}
}
