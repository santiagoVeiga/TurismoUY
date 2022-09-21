package logica;

import java.util.HashMap;
import java.util.Map;

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

	
}
