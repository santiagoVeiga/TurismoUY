package logica;

import java.util.Date;

public class DataActividad {
	public DataActividad() {
		  
	}
	
	public DataActividad(String n, String d, Date f, String c, int cos, int dur) {
		this.nombre = n;
		this.descripcion = d;
		this.fechaAlta = f;
		this.ciudad = c;
		this.costo = cos;
		this.duracion = dur;
	}
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaAlta;
	
	private String ciudad;
	
	private int costo;
	
	private int duracion;
	
//Getters y Setters
    
    public String getNombre() {
    	return this.nombre;
    }
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Date getFechaAlta() {
		return this.fechaAlta;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public int getCosto() {
		return this.costo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
}
