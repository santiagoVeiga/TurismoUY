package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DataPaquete extends DataBuscar {
	
	private String nombre;
	private int descuento;
	private String descripcion;
	private Date fechaAlta;
	private int validez;
	private byte[] imagen;
	private DataActividad[] dtAct;

	public DataPaquete(String nom, String desc, int descuento, Date fecha, int val, DataActividad[] dtAct){
		this.setNombre(nom);
		this.setDescuento(descuento);
		this.setDescripcion(desc);
		this.setFechaAlta(fecha);
		this.setValidez(val);
		this.setDtAct(dtAct);
		this.setImagen(null);
	}
	
	public DataPaquete(String nom, String desc, int descuento, Date fecha, int val, DataActividad[] dtAct, byte[] imagen){
		this.setNombre(nom);
		this.setDescuento(descuento);
		this.setDescripcion(desc);
		this.setFechaAlta(fecha);
		this.setValidez(val);
		this.setDtAct(dtAct);
		this.setImagen(imagen);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getValidez() {
		return validez;
	}

	public void setValidez(int validez) {
		this.validez = validez;
	}

	public DataActividad[] getDtAct() {
		return dtAct;
	}

	public void setDtAct(DataActividad[] dtAct) {
		this.dtAct = dtAct;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public Set<String> getCategorias(){
		Set<String> resultado = new HashSet<String>();
		for (DataActividad itAct: dtAct) {
			resultado.addAll(itAct.getCategorias());
		}
		return resultado;
	}
}
