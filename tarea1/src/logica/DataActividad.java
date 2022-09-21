package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class DataActividad {
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaAlta;
	
	private String ciudad;
	
	private int costo;
	
	private int duracion;
	
	private Set<DataSalida> DS;
	
	private Set<String> paquetes;
	
	private Set<String> categorias;
	
	private estadoAct estado;
	
	public DataActividad(String n, String d, Date f, String c, int cos, int dur,Set<DataSalida> ds,Set<String> paquetes, estadoAct estado2) {
		this.nombre = n;
		this.descripcion = d;
		this.fechaAlta = f;
		this.ciudad = c;
		this.costo = cos;
		this.duracion = dur;
		DS = ds;
		this.paquetes = paquetes;
		estado = estado2;
	}
	
	public DataActividad(String n, String d, Date f, String c, int cos, int dur,Set<DataSalida> ds,Set<String> paquetes, estadoAct estado2, Set<String> categorias) {
		this.nombre = n;
		this.descripcion = d;
		this.fechaAlta = f;
		this.ciudad = c;
		this.costo = cos;
		this.duracion = dur;
		DS = ds;
		this.paquetes = paquetes;
		this.setCategorias(categorias);
		estado = estado2;
	}
	
//Getters y Setters
    
    public String getNombre() {
    	return this.nombre;
    }
    
    public Set<DataSalida> getSalidas() {
		return DS;
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

	public Set<String> getPaquetes() {
		return paquetes;
	}

	public boolean HayPaquetes() {
		return paquetes.size() > 0;
	}

	public boolean HaySalidas() {
		// TODO Auto-generated method stub
		if(DS!=null)
			return DS.size()>0;
		else
			return false;
	}

	public estadoAct getEstado() {
		return estado;
	}

	public Set<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}

	public void setEstado(estadoAct estado) {
		this.estado = estado;
	}
}
