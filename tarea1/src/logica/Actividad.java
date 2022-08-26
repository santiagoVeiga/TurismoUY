package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import excepciones.SalidaYaExisteExeption;

public class Actividad {
	
	private Map<String,Salida> colSal;
	
	private Map<String,Paquete> colpaq;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fechaAlta;
	
	private String ciudad;
	
	private int costo;
	
	private int duracion;

	private Departamento departamento;

	public Actividad(String nom, String desc, Date f, String ciudad, int costo, int dur, Departamento dep) {
		colSal = new HashMap<String,Salida>();
		nombre = nom;
		descripcion = desc;
		fechaAlta = f;
		this.ciudad = ciudad;
		this.costo = costo;
		this.duracion = dur;
		this.departamento = dep;
		this.colpaq = null;
	}
	
	//Getters
    
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
	
	public Departamento getDepartamento() {
		return this.departamento;
	}
	
	public Map<String,Salida> getColSal() {
		return colSal;
	}
	
	// Setters
	
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
	

	public void setDepartamento(Departamento dep) {
		departamento = dep;
	}	
	
	public void addSalida(Salida s) {
		this.colSal.put(s.getNombre(), s);
	}
	
	//Operaciones
	
	public DataActividad getDataAT() {
		return new DataActividad(this.nombre,this.descripcion,this.fechaAlta,this.ciudad,this.costo,this.duracion,this.getSalidas(),this.getPaquetes());
	}
	
	public Set<DataPaquete> getPaquetes(){	
		Set<DataPaquete> res = null;
		if(colpaq != null) {
			res = new HashSet<DataPaquete>();
			Set<Entry<String, Paquete>> aux = colpaq.entrySet();
	    	Iterator<Entry<String, Paquete>> it = aux.iterator();
	    	while(it.hasNext()){
	    			res.add(it.next().getValue().getDataP());
	    	}
		}
		return res;
	}

	//revisar
	public Set<DataSalida> getSalidas() {
		Set<DataSalida> res = new HashSet<DataSalida>();
		Set<Entry<String, Salida>> aux = colSal.entrySet();
    	Iterator<Entry<String, Salida>> it = aux.iterator();
    	while(it.hasNext()){
    		//if(it.next().getValue().estaVigente())
    			res.add(it.next().getValue().getDataST());
    	//
    			}
		return res;
	}

	public Salida getSalida(String s) {
		return colSal.get(s);
	}

	public void altaSalida(String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas,
			Date fechaAlta2) throws SalidaYaExisteExeption {
		// TODO Auto-generated method stub
		Salida aux = this.getSalida(nombreSalida);
		if(aux != null) {
			throw new SalidaYaExisteExeption("Ya existe una salida con el nombre: " + nombreSalida);
		}
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta, maxCantTuristas);
		colSal.put(nombreSalida,aux);
	}
	
}
