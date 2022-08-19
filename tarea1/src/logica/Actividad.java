package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Actividad {
	
	private Map<String,Salida> colSal;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaAlta;
	
	private String ciudad;
	
	private int costo;
	
	private int duracion;
	
	public Actividad(String nom, String des, Date f, String c, int costo, int dur) {
		colSal = new HashMap<String,Salida>();
		nombre = nom;
		descripcion = des;
		fechaAlta = f;
		this.costo = costo;
		this.duracion = dur;
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
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public void setDescripcion(String n) {
		descripcion = n;
	}
	
	public void setCiudad(String n) {
		nombre = n;
	}
	
	public void setNombre(Date n) {
		fechaAlta = n;
	}
	
	public void setCosto(int n) {
		costo = n;
	}
	
	public void setDuracion(int n) {
		duracion = n;
	}
	
	public Map<String,Salida> getColSal() {
		return colSal;
	}
	
	public void addSalida(Salida s) {
		this.colSal.put(s.getNombre(), s);
	}
	
	//Operaciones
	
	public DataActividad getDataAT() {
		return new DataActividad(this.nombre,this.descripcion,this.fechaAlta,this.ciudad,this.costo,this.duracion);
	}

	public Set<DataSalida> getSalidas() {
		Set<DataSalida> res = null;
		Set<Entry<String, Salida>> aux = colSal.entrySet();
    	Iterator<Entry<String, Salida>> it = aux.iterator();
    	while(it.hasNext()){
    		res.add(it.next().getValue().getDataST());
    	}
		return res;
	}

	
}
