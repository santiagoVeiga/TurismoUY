package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Paquete {

	private String nombre;
	private int descuento;
	private String descripcion;
	private Date fechaAlta;
	private int validez;
	private Map<String,Actividad> colAct;
	private byte[] imagen;
	private boolean comprado;

	public Paquete(String nom,String desc,int descuento,Date fecha, int val)
	{
		this.nombre = nom;
		this.descuento = descuento;
		this.descripcion = desc;
		this.fechaAlta = fecha;
		this.validez = val;
		this.colAct = new HashMap<String,Actividad>();
		comprado = false;
	}
	
	public Paquete(String nombre2, String descripcion2, int descuento2, Date fechaAlta2, int validez2,
			byte[] imgBytes) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre2;
		this.descuento = descuento2;
		this.descripcion = descripcion2;
		this.fechaAlta = fechaAlta2;
		this.validez = validez2;
		this.colAct = new HashMap<String,Actividad>();
		comprado = false;
		imagen = imgBytes;
	}

	public DataPaquete getDataP(){
		DataActividad[] dtAct = new DataActividad[colAct.size()];
		int cont = 0;
		for (Iterator<Map.Entry<String, Actividad>> entries = colAct.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Actividad> entry = entries.next();
		    dtAct[cont] = entry.getValue().getDataAT();
		    cont++;
		}
		return new DataPaquete(nombre, descripcion, descuento, fechaAlta, validez, dtAct,imagen);
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
		if(act!=null) {
			colAct.put(act.getNombre(), act);
		}
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	
	public Map<String, Actividad> getColAct() {
		return colAct;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}
