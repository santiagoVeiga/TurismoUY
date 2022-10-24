package logica;
import java.util.Date;

public class DataCompraGeneral{
	
	private int cantidad;
	private Date fecha;
	private int costo; 
	private DataSalida salida;
	private boolean porPaquete;
	
	public DataCompraGeneral(Date fecha, int cant, int costo, DataSalida dataSal) {
		this.setCantidad(cant);
		this.setFecha(fecha);
		this.setCosto(costo);
		this.setSalida(dataSal);
		this.setPorPaquete(false);
	}
	
	public DataCompraGeneral(Date fecha, int cant, int costo, boolean paq, DataSalida dataSal) {
		this.setCantidad(cant);
		this.setFecha(fecha);
		this.setCosto(costo);
		this.setSalida(dataSal);
		this.setPorPaquete(paq);
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
	
	public DataSalida getSalida() {
        return salida;
    }
    
    /* Setters */

    public boolean isPorPaquete() {
		return porPaquete;
	}

	public void setPorPaquete(boolean porPaquete) {
		this.porPaquete = porPaquete;
	}

	public void setCantidad(int cant) {
    	cantidad = cant;
    }

    public void setFecha(Date fechaC) {
    	fecha = fechaC;
    }

    public void setCosto(int costoC) {
    	costo = costoC;
    }
    
    public void setSalida(DataSalida salida) {
    	this.salida = salida;
    }

	public boolean esSalida(Salida salida) {
		return salida.equals(salida);
	}
    
}