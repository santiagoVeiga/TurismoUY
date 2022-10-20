package logica;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import excepciones.NoHayCuposException;


public class DataCompraPaquete{
	
	private DataPaquete paq;
	private int cantidad;
	private int costo; 
	private Date fecha;
	private Date vencimiento;
	private Map<String,Integer> restAct;
	
	public DataCompraPaquete(Date fecha, int cant, int costo, Date vencimiento, DataPaquete paquete, Map<String,Integer> restAct) {
		this.setCantidad(cant);
		this.setCosto(costo);
		this.setFecha(fecha);
		this.setVencimiento(vencimiento);
		this.setPaq(paquete);
		this.setRestAct(restAct);
	}
	
	int obtenerCuposAct(String act) {
		return this.restAct.get(act);
	}
    
	public int getCantidad() {
        return cantidad;
    }
	
	public Date getFecha() {
        return fecha;
    }
	
	public int getCosto() {
        return costo;
    }
	

    public DataPaquete getPaq() {
		return paq;
	}
    
    public int getDescuento() {
    	return paq.getDescuento();
    }

	public Date getVencimiento() {
		return vencimiento;
	}

	public Map<String, Integer> getRestAct() {
		return restAct;
	}

	public void setPaq(DataPaquete paq) {
		this.paq = paq;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public void setRestAct(Map<String, Integer> restAct) {
		this.restAct = restAct;
	}

	public void setCantidad(int cant) {
    	cantidad = cant;
    }

    public void setFecha(Date fechaC) {
    	fecha = fechaC;
    }

    public void setCosto(int cost) {
    	costo = cost;
    }
    
}