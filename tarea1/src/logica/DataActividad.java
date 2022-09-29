package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class DataActividad {
	
	public DataActividad() {
		DS = new HashSet<DataSalida>();
		paquetes = new HashSet<String>();
		categorias = new HashSet<String>();
	}
	
	private String nombre;
	

	private String descripcion;
	private Date fechaAlta;
	private String ciudad;
	private int costo;
	private int duracion;
	private String departamento;
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
	
	public DataActividad(String n, String d, Date f, String c, int cos, int dur,Set<DataSalida> ds,Set<String> paquetes, estadoAct estado2, Set<String> categorias, String dep) {
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
		this.setDepartamento(dep);
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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
	
	public Set<DataSalida> getDS() {
		return DS;
	}

	public void setDS(Set<DataSalida> dS) {
		DS = dS;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setPaquetes(Set<String> paquetes) {
		this.paquetes = paquetes;
	}
}
