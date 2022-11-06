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
	private String imagen;
	private DataActividad[] dtAct;
	private String[] categorias;

	public DataPaquete(String nom, String desc, int descuento, Date fecha, int val, DataActividad[] dtAct){
		this.setNombre(nom);
		this.setDescuento(descuento);
		this.setDescripcion(desc);
		this.setFechaAlta(fecha);
		this.setValidez(val);
		this.setDtAct(dtAct);
		this.setImagen(".src/data/Paqs/" + this.getNombre() + ".jpg");
		this.setCategorias(this.obtenerCategorias().toArray(new String[0]));
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String[] getCategorias() {
		return categorias;
	}

	public void setCategorias(String[] categorias) {
		this.categorias = categorias;
	}

	public Set<String> obtenerCategorias(){
		Set<String> resultado = new HashSet<String>();
		for (DataActividad itAct: dtAct) {
			resultado.addAll(itAct.getCategorias());
		}
		return resultado;
	}
}
