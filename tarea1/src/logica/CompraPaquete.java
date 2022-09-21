package logica;
import java.util.*;

import excepciones.NoHayCuposException;

import java.util.Calendar;

public class CompraPaquete{
	
	private Paquete paq;
	private int cantidad;
	private int costo; 
	private Date fecha;
	private Date vencimiento;
	private Map<String,Integer> restAct;
	
	public CompraPaquete(Date f, int cant, Paquete paquete) {
		this.cantidad = cant;
		this.fecha = f;
		this.paq = paquete;
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(f);
		calendario.add(Calendar.DAY_OF_MONTH, -paquete.getValidez());
		this.vencimiento = calendario.getTime();
		Set<String> acts = paquete.getColAct().keySet();
		this.restAct = new HashMap<String,Integer>();
		for(String aux: acts) {
			this.restAct.put(aux, cant);
		}
	}
	
	int obtenerCuposAct(String Act) {
		return this.restAct.get(Act);
	}
	
	void reducirCuposAct(String Act, int cant) throws NoHayCuposException {
		if(cant > obtenerCuposAct(Act))
			throw new NoHayCuposException("No hay cupos suficientes en la compra paquete para la actividad:" + Act);
		this.restAct.replace(Act, this.obtenerCuposAct(Act)-cant);
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
	
    
    /* Setters */

    public Paquete getPaq() {
		return paq;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public Map<String, Integer> getRestAct() {
		return restAct;
	}

	public void setPaq(Paquete paq) {
		this.paq = paq;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public void setRestAct(Map<String, Integer> restAct) {
		this.restAct = restAct;
	}

	public void setCantidad(int c) {
    	costo = c;
    }

    public void setFecha(Date f) {
    	fecha = f;
    }

    public void setCosto(int c) {
    	costo = c;
    }
    
}