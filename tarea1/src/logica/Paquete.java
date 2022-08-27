package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Paquete {

	private String nombre;
	private int descuento;
	private String descripcion;
	private Date fechaAlta;
	private int validez;
	private Map<String,Actividad> colAct;

	public Paquete(String nom,String desc,int descuento,Date fecha, int val)
	{
		this.nombre = nom;
		this.descuento = descuento;
		this.descripcion = desc;
		this.fechaAlta = fecha;
		this.validez = val;
		this.colAct = new HashMap<String,Actividad>();
	}
	
	public DataPaquete getDataP()
	{
		return new DataPaquete(nombre, descripcion, descuento, fechaAlta, validez);
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
	
	public void agregarActividad(Actividad act) {
		colAct.put(act.getNombre(), act);
	}
}
