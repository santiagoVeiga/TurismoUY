package logica;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Salida {
	
	private Set<CompraGeneral> colCG;
	
	private String nombre;
	private String lugar;
	private Date hora;
	private Date fecha;
	private Date fechaAlta;
	private int cant;
	
	public Salida(String n,String l,Date h,Date f,Date fa,int c)
	{
		setNombre(n);
		setLugar(l);
		setHora(h);
		setFecha(f);
		setFechaAlta(fa);
		setCant(c);
	};
	
	public boolean estaVigente()
	{
		LocalDate localDate = LocalDate.now();
		Date ahora = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		int cantActual = 0;
		Iterator<CompraGeneral> it = colCG.iterator();
		while(it.hasNext()) {
			cantActual = it.next().getCantidad();
		}
		return ahora.before(fecha) && cantActual<=cant;
	}
	
	public DataSalida getDataST()
	{
		return new DataSalida(nombre,lugar,hora,fecha,fechaAlta,cant);
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

	public Set<CompraGeneral> getColCG() {
		return colCG;
	}

	public void setColCG(Set<CompraGeneral> colCG) {
		this.colCG = colCG;
	}
	
	public boolean excedeTuristas(int cantTuristas) {
		Iterator<CompraGeneral> itr = colCG.iterator();
    	int cant = 0;
    	while(itr.hasNext()) {
    		cant += itr.next().getCantidad();
    	}
    	return (cant+cantTuristas)<=this.getCant();
	}
	
}
