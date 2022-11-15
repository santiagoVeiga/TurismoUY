package logica;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Salidas")
public class Salida {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String lugar;
	@Column(nullable = false)
	private Date hora;
	@Column(nullable = false)
	private Date fecha;
	@Column(nullable = false)
	private Date fechaAlta;
	@Column(nullable = false)
	private int cant;
	@OneToMany(mappedBy = "salida", cascade = CascadeType.PERSIST)
	private Set<CompraGeneral> inscripciones;
	@Transient
	private int cantRestante;
	@Transient
	private byte[] imagen;
	@Transient
	private int visitas;
	
	public Salida() {
		
	}
	
	public Salida(String nom, String lugar, Date hora, Date fecha, Date fechaAlta, int cant){
		setNombre(nom);
		setLugar(lugar);
		setHora(hora);
		setFecha(fecha);
		setFechaAlta(fechaAlta);
		setCant(cant);
		setCantRestante(cant);
		setImagen(null);
		this.inscripciones = new HashSet<CompraGeneral>();
	};
	
	public Salida(String nombreSalida, String lugar2, Date hora2, Date fecha2, Date fechaAlta2, int maxCantTuristas,
			byte[] imagen) {
		// TODO Auto-generated constructor stub
		setNombre(nombreSalida);
		setLugar(lugar2);
		setHora(hora2);
		setFecha(fecha2);
		setFechaAlta(fechaAlta2);
		setCant(maxCantTuristas);
		setCantRestante(maxCantTuristas);
		this.imagen = imagen;
		this.inscripciones = new HashSet<CompraGeneral>();
	}

	public boolean estaVigente(){
		LocalDate localDate = LocalDate.now();
		Date ahora = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return ahora.before(fecha) && cantRestante<cant;
	}
	
	public DataSalida getDataST(){
		return new DataSalida(nombre, lugar, hora, fecha, fechaAlta, cant, getVisitas()); //, imagen);
	}
	
	public DataSalida getDataSalidaF() {
		return new DataSalida(nombre, lugar, hora, fecha, fechaAlta, cant, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	
	public boolean excedeTuristas(int cantTuristas) {
    	return cantTuristas>cantRestante;
	}

	public int getCantRestante() {
		return cantRestante;
	}

	public void setCantRestante(int cantRestante) {
		this.cantRestante = cantRestante;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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

	public Set<CompraGeneral> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Set<CompraGeneral> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	public void agregarInsc(CompraGeneral cGen) {
		this.inscripciones.add(cGen);
	}
	
	public Set<Turista> finalizarAct(String act) {
		Set<Turista> resultado = new HashSet<Turista>();
		for (CompraGeneral iter : getInscripciones()) {
			resultado.add(iter.finalizarActividad(act));
		}
		return resultado;
	}
	
}
