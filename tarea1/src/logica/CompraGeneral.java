package logica;
import java.util.Date;

public class CompraGeneral{
	
	private int cantidad;
	private Date fecha;
	private int costo; 
	private Salida salida;
	private boolean porPaquete;
	
	public CompraGeneral(Date fecha, int cant, int costo) {
		this.cantidad = cant;
		this.fecha = fecha;
		this.costo = costo;
		this.setPorPaquete(false);
	}
	
	public CompraGeneral(Date fecha, int cant, int costo, boolean paq) {
		this.cantidad = cant;
		this.fecha = fecha;
		this.costo = costo;
		this.setPorPaquete(paq);
	}

	/*
	public CompraGeneral(int cant, Date f,Salida salida) {
    	this.cantidad = cant;
    	this.fecha = f;
    	this.salida = salida;


		El costo de una CompraGeneral se calcula com
		o el costo de la Actividad asociada a la instancia
		 de Salida correspondiente por el atributo cantidad 
		 de CompraGeneral y se le sustrae el porcentaje dado por descuento de Paquete si corresponde.
	}
	 */
	
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

    public boolean isPorPaquete() {
		return porPaquete;
	}

	public void setPorPaquete(boolean porPaquete) {
		this.porPaquete = porPaquete;
	}
	
	public boolean getPorPaquete() {
		return this.porPaquete;
	}

	public void setCantidad(int cost) {
    	costo = cost;
    }

    public void setFecha(Date fechaC) {
    	fecha = fechaC;
    }

    public void setCosto(int costoC) {
    	costo = costoC;
    }
    
    public void setSalida(Salida salida) {
    	this.salida = salida;
    }

	public boolean esSalida(Salida salida) {
		return salida.equals(salida);
	}
    
	public DataCompraGeneral getDataCompraGeneral() {
		return new DataCompraGeneral(this.getFecha(), this.getCantidad(), this.getCosto(), this.getPorPaquete(), this.getSalida().getDataST());
	}
	
}