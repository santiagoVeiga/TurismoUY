package logica;

import java.util.Date;

public class DataSalida {
	
	private String nombre;
	private String lugar;
	private Date hora;
	private Date fecha;
	private Date fechaAlta;
	private int cant;

	public DataSalida(String n,String l,Date h,Date f,Date fa,int c) {
		nombre = n;
		lugar = l;
		hora = h;
		fecha = f;
		fechaAlta = fa;
		cant = c;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getLugar()
	{
		return lugar;
	}
	
	public Date gethora()
	{
		return hora;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public Date getFechaAlta()
	{
		return fechaAlta;
	}
	
	public int getCant()
	{
		return cant;
	}
}
