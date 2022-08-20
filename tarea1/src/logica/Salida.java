package logica;
import java.util.Date;

public class Salida {
	
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
		return true;
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
	
}
