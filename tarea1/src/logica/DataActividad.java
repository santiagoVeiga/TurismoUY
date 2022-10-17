package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class DataActividad {
	
	public DataActividad() {
		salidas = new HashSet<DataSalida>();
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
	private Set<DataSalida> salidas;
	private Set<String> paquetes;
	private Set<String> categorias;
	private estadoAct estado;
	private byte[] imagen;
	
	public DataActividad(String nom, String des, Date fecha, String ciudad, int cos, int dur,Set<DataSalida> dataSalidas,Set<String> paquetes, estadoAct estado2) {
		this.nombre = nom;
		this.descripcion = des;
		this.fechaAlta = fecha;
		this.ciudad = ciudad;
		this.costo = cos;
		this.duracion = dur;
		this.salidas = dataSalidas;
		this.paquetes = paquetes;
		estado = estado2;
		this.setImagen(null);
	}
	
	public DataActividad(String nom, String des, Date fecha, String ciudad, int cos, int dur,Set<DataSalida> dataSalidas,Set<String> paquetes, estadoAct estado2, Set<String> categorias, String dep, byte[] imagen) {
		this.nombre = nom;
		this.descripcion = des;
		this.fechaAlta = fecha;
		this.ciudad = ciudad;
		this.costo = cos;
		this.duracion = dur;
		this.salidas = dataSalidas;
		this.paquetes = paquetes;
		this.setCategorias(categorias);
		estado = estado2;
		this.setDepartamento(dep);
		this.setImagen(imagen);
	}
	
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

	public Set<String> getPaquetes() {
		return paquetes;
	}

	public String getDepartamento() {
		return departamento;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public boolean HayPaquetes() {
		return paquetes.size() > 0;
	}

	public boolean HaySalidas() {
		// TODO Auto-generated method stub
		if(salidas!=null)
			return salidas.size()>0;
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
	
	public Set<DataSalida> getSalidas() {
		return salidas;
	}

	public void setSalidas(Set<DataSalida> setSalidas) {
		salidas = setSalidas;
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
