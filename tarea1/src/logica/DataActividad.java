package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DataActividad extends DataBuscar {
	
	public DataActividad() {
		salidas = new HashSet<DataSalida>();
		paquetes = new HashSet<String>();
		categorias = new HashSet<String>();
	}
	
	private String nombre;
	
	private int cantVis;
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
	private String imagen;
	private String link;
	private boolean hayLink;
	private int cantFavs;
	private Date fechaBaja;
	
	
	
	public DataActividad(String nom, String des, Date fecha, String ciudad, int cos, int dur, Set<DataSalida> dataSalidas, Set<String> paquetes, estadoAct estado2, String link, boolean hayLink, Set<String> categorias, String dep, int cantV, int cantF, Date fBaja) { //, byte[] imagen) {
		this.nombre = nom;
		this.descripcion = des;
		this.fechaAlta = fecha;
		this.ciudad = ciudad;
		this.costo = cos;
		this.duracion = dur;
		this.salidas = dataSalidas;
		this.paquetes = paquetes;
		this.setCategorias(categorias);
		this.estado = estado2;
		this.setDepartamento(dep);
		this.link = link;
		this.hayLink = hayLink;
		this.setImagen("./src/data/Actvs/" + this.getNombre() + ".jpg");
		setCantVis(cantV);
		setCantFavs(cantF);
		setFechaBaja(fBaja);
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
	
	public String getLink() {
		return this.link;
	}

	public boolean getHayLink() {
		return this.hayLink;
	}
	
	public Set<String> getPaquetes() {
		return paquetes;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public boolean hayPaquetes() {
		return paquetes.size() > 0;
	}

	public boolean haySalidas() {
		// TODO Auto-generated method stub
		if (salidas!=null)
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
	
	public void setLink(String link) {
		this.link = link;
	}

	public void setHayLink(boolean hayLink) {
		this.hayLink = hayLink;
	}

	public int getCantVis() {
		return cantVis;
	}

	public void setCantVis(int cantVis) {
		this.cantVis = cantVis;
	}

	public int getCantFavs() {
		return cantFavs;
	}

	public void setCantFavs(int cantFavs) {
		this.cantFavs = cantFavs;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
}
