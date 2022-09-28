package logica;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import excepciones.DepartamentoNoExisteException;
import manejadores.ManejadorCategoria;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorPaquete;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	public DataUsuario[] listarUsuarios() 
	{
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		return  mu.getUsuarios();
	}
	
    public DataUsuario ingresarDatos(String ci)
    {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario u = mu.obtenerUsuarioNick(ci);
    	return u.getDataUsuario();
    }

    public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
    	ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();
    	DataDepartamento[] res = md.obtenerDataDepartamentos();
    	if (res == null) {
    		throw new DepartamentoNoExisteException("No existen departamentos");
    	} else {
    	return res;
    	}
    }
    
    public String[] listarPaquetes() {
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		return mp.getPaquetesN();
	}
    
	public DataPaquete obtenerDataPaquete(String p) {
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		return mp.getDataPaquete(p);
	}
	   
	public Set<String> obtenerNombreCategorias() {    	
		ManejadorCategoria mc = ManejadorCategoria.getInstance();
		return mc.obtenerNombreCategorias();
    }
	
	public DataActividad[] obtenerActividadCategoria(String categoria) {
		ManejadorCategoria mc = ManejadorCategoria.getInstance();
		Categoria cat = mc.getCategoria(categoria);
		Actividad[] arrAct = cat.getActividades();
		DataActividad[] res = new DataActividad[arrAct.length];
		for(int i = 0; i < arrAct.length;i++) {
			res[i] = arrAct[i].getDataAT();
		}
		return res;
	}
}
