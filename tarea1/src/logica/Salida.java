package logica;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Salida {
	
	private String nombre;
	private String lugar;
	private Date hora;
	private Date fecha;
	private Date fechaAlta;
	private int cant;
	private int cantRestante;
	private byte[] imagen;
	private int visitas;
	
	public Salida(String nom, String lugar, Date hora, Date fecha, Date fechaAlta, int cant){
		setNombre(nom);
		setLugar(lugar);
		setHora(hora);
		setFecha(fecha);
		setFechaAlta(fechaAlta);
		setCant(cant);
		setCantRestante(cant);
		setImagen(null);
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
	}

	public boolean estaVigente(){
		LocalDate localDate = LocalDate.now();
		Date ahora = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return ahora.before(fecha) && cantRestante<cant;
	}
	
	public DataSalida getDataST(){
		return new DataSalida(nombre, lugar, hora, fecha, fechaAlta, cant, getVisitas()); //, imagen);
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
	
}
