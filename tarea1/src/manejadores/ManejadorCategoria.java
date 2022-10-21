package manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import logica.Categoria;

public class ManejadorCategoria {
	
	private static ManejadorCategoria instancia = null;

	private Map<String, Categoria> colCat;
	
	// Constructor
    
	private ManejadorCategoria() {
    	colCat = new HashMap<String, Categoria>();
    }

    public static ManejadorCategoria getInstance() {
        if (instancia == null) {
            instancia = new ManejadorCategoria();
        }
        return instancia;
    }
    

    //Operaciones
    public void addCategoria(Categoria cat) {
    	if (!this.pertenece(cat.getCategoria()))
    		colCat.put(cat.getCategoria(), cat);
    }
    public Categoria getCategoria(String cat) {
        return colCat.get(cat);
    }
    
    public Set<String> obtenerNombreCategorias() {
    	
    	Set<String> resultado = new HashSet<String>();
    	Set<Entry<String, Categoria>> aux = colCat.entrySet();
    	Iterator<Entry<String, Categoria>> iter = aux.iterator();
    	while (iter.hasNext()){
    		resultado.add(iter.next().getValue().getCategoria());
    	}
    	return resultado;
    	
    }
    
    public boolean pertenece(String cat) {
    	return colCat.get(cat)!=null; 
    }


    
}
