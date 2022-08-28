package logica;

import java.util.*;

public class DataPaquete {
	
	private String nombre;
	private int descuento;
	private String descripcion;
	private Date fechaAlta;
	private int validez;
	private DataActividad[] dtAct;

	public DataPaquete(String nom,String desc,int descuento,Date fecha, int val, DataActividad[] dtAct){
		this.setNombre(nom);
		this.setDescuento(descuento);
		this.setDescripcion(desc);
		this.setFechaAlta(fecha);
		this.setValidez(val);
		this.setDtAct(dtAct);
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
}
