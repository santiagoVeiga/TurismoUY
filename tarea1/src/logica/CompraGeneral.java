package logica;
import java.util.*;

public class CompraGeneral{
	
	private int cantidad;
	private Date fecha;
	private int costo;
	private Salida salida;
	
	public CompraGeneral(int cant, Date f, int costo, Salida salida) {
    	this.cantidad = cant;
    	this.fecha = f;
    	this.costo = costo;
    	this.salida = salida;
	}
	
	/* Getters */
    
	public int getCantidad() {
        return cantidad;
    }
	
	public Date getFecha() {
        return fecha;
    }
	
	public int getCosto() {
        return costo;
    }
	
	public Salida getSalida() {
        return salida;
    }
    
    /* Setters */

    public void setCantidad(int c) {
    	costo = c;
    }

    /*public void setFecha(Date f) {
    	costo = c;
    }*/

    public void setCosto(int c) {
    	costo = c;
    }

	public boolean esSalida(Salida s) {
		return salida.equals(s);
	}
    
}