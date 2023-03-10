package logica;

import java.util.Date;

public class DataSalida {
	
	public DataSalida() {
	}
	
	private String nombre;
	
	private int cantVis;
	private String lugar;
	private Date hora;
	private Date fecha;
	private Date fechaAlta;
	private int cant;
	private String imagen;
	
	public DataSalida(String nom, String lug, Date hor, Date fech, Date fechAlta, int can, int cantV) {
		nombre = nom;
		lugar = lug;
		this.setImagen("./src/data/Salidas/" + this.getNombre() + ".jpg");
		hora = hor;
		fecha = fech;
		fechaAlta = fechAlta;
		cant = can;
		setCantVis(cantV);
	}


	public String getImagen(){
		return this.imagen;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getLugar(){
		return lugar;
	}
	
	public Date gethora(){
		return hora;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public Date getFechaAlta(){
		return fechaAlta;
	}
	
	public int getCant(){
		return cant;
	}
	
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	public void setImagen(String string) {
		this.imagen = string;
	}



	public int getCantVis() {
		return cantVis;
	}


	public void setCantVis(int cantVis) {
		this.cantVis = cantVis;
	}
}
