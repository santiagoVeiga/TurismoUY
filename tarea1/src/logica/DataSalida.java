package logica;

import java.util.Date;

public class DataSalida {
	
	public DataSalida() {
	}
	
	private String nombre;
	

	private String lugar;
	private Date hora;
	private Date fecha;
	private Date fechaAlta;
	private int cant;
	//private byte[] imagen;
	
	public DataSalida(String nom, String lug, Date hor, Date fech, Date fechAlta, int can) {
		nombre = nom;
		lugar = lug;
		//imagen = null;
		hora = hor;
		fecha = fech;
		fechaAlta = fechAlta;
		cant = can;
	}

	
	public String getImagen(){
		return ".src/data/Salidas" + this.getNombre() + ".jpg";
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
}
