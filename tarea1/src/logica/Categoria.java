package logica;

import java.util.HashMap;
import java.util.Map;

import excepciones.ActividadRepetidaException;

public class Categoria {
	private String categoria ; 
	private Map<String,Actividad> colAct;
	
	public Categoria(String cat) {
		this.categoria = cat ; 
		colAct = new HashMap<String,Actividad>();
	}
	
	public String getCategoria(){
		return categoria ; 
	}

	public Actividad[] getActividades() {
		return colAct.values().toArray(new Actividad[0]);
	}
	
	public void agregarAct(Actividad act) throws ActividadRepetidaException {
		if(colAct.get(act.getNombre()) != null) {
			throw new ActividadRepetidaException("Ya existe una actividad con nombre: " + act.getNombre() + "para la categoria: " + categoria);
		} else {
			colAct.put(act.getNombre(), act);
		}
	}
	
}
