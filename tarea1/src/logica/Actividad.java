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
	private byte[] imagen;

	public Actividad(String nom, String desc, Date fecha, String ciudad, int costo, int dur, Departamento dep, Map<String,Categoria> categorias) {
		colSal = new HashMap<String,Salida>();
		setNombre(nom);
		setDescripcion(desc);
		fechaAlta = fecha;
		setCiudad(ciudad);
		setCosto(costo);
		setDuracion(dur);
		setDepartamento(dep);
		this.colpaq = new HashMap<String,Paquete>();
		setCategorias(categorias); 
		estado = estadoAct.agregada;
	}
	
	public Actividad(String nom, String desc, Date fecha, String ciudad, int costo, int dur, Departamento dep, Map<String,Categoria> categorias, byte[] imagen) {
		colSal = new HashMap<String,Salida>();
		setNombre(nom);
		setDescripcion(desc);
		fechaAlta = fecha;
		setCiudad(ciudad);
		setCosto(costo);
		setDuracion(dur);
		setDepartamento(dep);
		this.colpaq = new HashMap<String,Paquete>();
		setCategorias(categorias); 
		estado = estadoAct.agregada;
		this.imagen = imagen;
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad ;
	}
	
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

	public void setDepartamento(Departamento depart) {
		departamento = depart;
	}	
	
	public void addSalida(Salida salida) {
		this.colSal.put(salida.getNombre(), salida);
	}
	
	public void addPaquete(Paquete paquete) {
		this.colpaq.put(paquete.getNombre(), paquete);
	}
	
	//Operaciones
	
	public DataActividad getDataAT() {
		return new DataActividad(this.nombre,this.descripcion,this.fechaAlta,this.ciudad,this.costo,this.duracion,this.getSalidas(),this.getPaquetes(),this.estado, this.getNombreCategorias(),this.getDepartamento().getNombre(),this.getImagen());
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
    	Iterator<Entry<String, Salida>> iter = aux.iterator();
    	while(iter.hasNext()){
    			res.add(iter.next().getValue().getDataST());
    			}
		return res;
	}
	
	public void setCategorias(Map<String,Categoria> cat) {
		categorias = cat ; 
	}

	public Salida getSalida(String salida) {
		return colSal.get(salida);
	}

	public void altaSalida(String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas,
			Date fechaAlta2){
		// TODO Auto-generated method stub
		Salida aux; 
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta, maxCantTuristas);
		colSal.put(nombreSalida,aux);
	}
	
	public boolean perteneceSalida(String salN){
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void altaSalida(String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas,
			Date fechaAlta2, byte[] imagen2) {
		Salida aux; 
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta, maxCantTuristas,imagen);
		colSal.put(nombreSalida,aux);
	}
	
}
