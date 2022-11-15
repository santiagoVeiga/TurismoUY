package logica;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Actividades_finalizadas")
public class Actividad {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int ident;
	@Column(unique = true, nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private Date fechaAlta;
	@Column(nullable = false)
	private String ciudad;
	@Column(nullable = false)
	private int costo;
	@Column(nullable = false)
	private int duracion;
	@Transient
	private Departamento departamento;
	@ManyToOne
	@JoinColumn(name="id_proveedor", nullable = false)
	private Proveedor proveedor;
	private String nombreDepartamento;
    @JoinColumn(name="id_actividad", nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Salida> salidasPersistir;
    @Transient
	private Map<String, Salida> colSal;
	private estadoAct estado;
	private Date fechaBaja = null;
	@Transient
	private Map<String, Categoria> categorias ;
	@Transient
	private Map<String, Paquete> colpaq;
	@Transient
	private byte[] imagen;
	@Transient
	private int visitas;
	@Transient
	private int cantFavs = 0;
	@Transient
	private String link;
	@Transient
	private boolean hayLink;

	public Actividad() {
		
	}
	
	public Actividad(String nom, String desc, Date fecha, String ciudad, int costo, int dur, Departamento dep, Map<String, Categoria> categorias, String link, boolean hayLink) {
		colSal = new HashMap<String, Salida>();
		setNombre(nom);
		setDescripcion(desc);
		fechaAlta = fecha;
		setCiudad(ciudad);
		setCosto(costo);
		setDuracion(dur);
		setDepartamento(dep);
		setNombreDepartamento(dep.getNombre());
		setHayLink(hayLink);
		setLink(link);
		this.colpaq = new HashMap<String, Paquete>();
		setCategorias(categorias); 
		estado = estadoAct.agregada;
		setVisitas(0);
	}
	
	public Actividad(String nom, String desc, Date fecha, String ciudad, int costo, int dur, Departamento dep, Map<String, Categoria> categorias, String link, boolean hayLink, byte[] imagen) {
		colSal = new HashMap<String, Salida>();
		setNombre(nom);
		setDescripcion(desc);
		fechaAlta = fecha;
		setCiudad(ciudad);
		setCosto(costo);
		setDuracion(dur);
		setDepartamento(dep);
		setHayLink(hayLink);
		setLink(link);
		this.colpaq = new HashMap<String, Paquete>();
		setCategorias(categorias); 
		estado = estadoAct.agregada;
		this.imagen = imagen;
		setVisitas(0);
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
	
	public String getLink() {
		return this.link;
	}
	
	public boolean getHayLink() {
		return this.hayLink;
	}
	
	public Map<String, Salida> getColSal() {
		return colSal;
	}
	
	public Map<String, Categoria> getCategorias(){
		return this.categorias ; 
	}
	
	// Setters
	
	public int getIdent() {
		return ident;
	}

	public Set<Salida> getSalidasPersistir() {
		return salidasPersistir;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public int getCantFavs() {
		return cantFavs;
	}

	public void setCantFavs(int cantFavs) {
		this.cantFavs = cantFavs;
	}

	public void setProveedor(Proveedor prov) {
		this.proveedor = prov;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setSalidasPersistir(Set<Salida> salidasPersistir) {
		this.salidasPersistir = salidasPersistir;
	}

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
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setHayLink(boolean hayLink) {
		this.hayLink = hayLink;
	}
	
	public void addPaquete(Paquete paquete) {
		this.colpaq.put(paquete.getNombre(), paquete);
	}
	
	//Operaciones
	
	public DataActividad getDataAT() {
		if (this.getEstado() != estadoAct.finalizada) {
			return new DataActividad(this.nombre, this.descripcion, this.fechaAlta, this.ciudad, this.costo, this.duracion, this.getSalidas(), this.getPaquetes(), this.estado, this.link, this.hayLink, this.getNombreCategorias(), this.getDepartamento().getNombre(), getVisitas(), getCantFavs(), getFechaBaja()); // , this.getImagen());
		} else {
			return new DataActividad(this.nombre, this.descripcion, this.fechaAlta, this.ciudad, this.costo, this.duracion, this.getSalidas(), this.getPaquetes(), this.estado, "", false, this.getNombreCategorias(), this.getNombreDepartamento(), 0, 0, getFechaBaja()); // , this.getImagen());
		}
	}
	
	public Set<String> getPaquetes(){
		if (this.getEstado() != estadoAct.finalizada) {
			return colpaq.keySet();
		} else {
			return new HashSet<String>();
		}
	}
	
	public Set<String> getNombreCategorias(){
		if (this.getEstado() != estadoAct.finalizada) {
			return categorias.keySet();
		} else {
			return new HashSet<String>();
		}
	}

	//revisar
	public Set<DataSalida> getSalidas() {
		if (this.getEstado() != estadoAct.finalizada) {
			Set<DataSalida> res = new HashSet<DataSalida>();
			Set<Entry<String, Salida>> aux = colSal.entrySet();
	    	Iterator<Entry<String, Salida>> iter = aux.iterator();
	    	while (iter.hasNext()){
	    			res.add(iter.next().getValue().getDataST());
	    			}
			return res;
		} else {
			Set<DataSalida> res = new HashSet<DataSalida>();
			for (Salida sal : salidasPersistir) {
				res.add(sal.getDataST());
			}
			return res;
		}
	}
	
	public void setCategorias(Map<String, Categoria> cat) {
		categorias = cat ; 
	}

	public Salida getSalida(String salida) {
		if (this.estado != estadoAct.finalizada && colSal.containsKey(salida))
			return colSal.get(salida);
		else {
			for (Salida sal : salidasPersistir) {
				if (sal.getNombre().equals(salida))
					System.out.println("Linea 281 Actividad");
					return sal;
			}
			return null;
		}
	}

	public void altaSalida(String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas,
			Date fechaAlta2){
		// TODO Auto-generated method stub
		Salida aux; 
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta, maxCantTuristas);
		colSal.put(nombreSalida, aux);
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
		aux = new Salida(nombreSalida, lugar, hora, fecha, fechaAlta2, maxCantTuristas, imagen2);
		colSal.put(nombreSalida, aux);
	}

	public void incrementarVisitas() {
		setVisitas(getVisitas() + 1);
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public Set<Turista> finalizarAct() {
		Set<Turista> resultado = new HashSet<Turista>();
		this.getDepartamento().removerActividad(this.getNombre());
		for (Categoria cats: this.categorias.values()) {
			cats.removerActividad(this.getNombre());
		}
		for (Salida sal : this.colSal.values()) {
			resultado.addAll(sal.finalizarAct(this.getNombre()));
		}
		Set<Salida> salidas = new HashSet<Salida>();
		salidas.addAll(this.colSal.values());
		this.setSalidasPersistir(salidas);
		LocalDateTime fecha = LocalDateTime.now();
		this.setFechaBaja(java.util.Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant()));
		return resultado;
	}
	
}
