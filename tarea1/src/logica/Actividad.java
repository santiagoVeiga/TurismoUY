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
	
	private Map<String,Categoria> categorias ; 
	
	private estadoAct estado;

	public Actividad(String nom, String desc, Date f, String ciudad, int costo, int dur, Departamento dep, Map<String,Categoria> categorias) {
		colSal = new HashMap<String,Salida>();
		setNombre(nom);
		setDescripcion(desc);
		fechaAlta = f;
		setCiudad(ciudad);
		setCosto(costo);
		setDuracion(dur);
		setDepartamento(dep);
		this.colpaq = new HashMap<String,Paquete>();
		setCategorias(categorias); 
		estado = estadoAct.agregada;
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
	
	public Map<String,Categoria> getCategorias(){
		return this.categorias ; 
	}
	
	// Setters
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public void setDescripcion(String n) {
		descripcion = n;
	}
	
	public void setCiudad(String n) {
		ciudad = n;
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
	
	public void addPaquete(Paquete p) {
		this.colpaq.put(p.getNombre(), p);
	}
	
	//Operaciones
	
	public DataActividad getDataAT() {
		return new DataActividad(this.nombre,this.descripcion,this.fechaAlta,this.ciudad,this.costo,this.duracion,this.getSalidas(),this.getPaquetes(),this.estado, this.getNombreCategorias());
	}
	
	public Set<String> getPaquetes(){	
		return colpaq.keySet();
	}
	
	public Set<String> getNombreCategorias(){
		return categorias.keySet();
	}

	//revisar
	public Set<DataSalida> getSalidas() {
		Set<DataSalida> res = new HashSet<DataSalida>();
		Set<Entry<String, Salida>> aux = colSal.entrySet();
    	Iterator<Entry<String, Salida>> it = aux.iterator();
    	while(it.hasNext()){
    			res.add(it.next().getValue().getDataST());
    			}
		return res;
	}
	
	public void setCategorias(Map<String,Categoria> cat) {
		categorias = cat ; 
	}

	public Salida getSalida(String s) {
		return colSal.get(s);
	}

	public void altaSalida(String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas,
			Date fechaAlta2){
		// TODO Auto-generated method stub
		Salida aux; 
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta, maxCantTuristas);
		colSal.put(nombreSalida,aux);
	}
	
	public boolean perteneceSalida(String salN) throws SalidaYaExisteExeption {
		if(colSal.get(salN) != null) {
			throw new SalidaYaExisteExeption("Ya existe una salida con el nombre: " + salN);
		}
		return colSal.get(salN) != null;
	}
	
	public boolean pertenecePaquete(String paqN) {
		return colpaq.get(paqN) != null;
	}

	public estadoAct getEstado() {
		return estado;
	}

	public void setEstado(estadoAct estado) {
		this.estado = estado;
	}
	
}
