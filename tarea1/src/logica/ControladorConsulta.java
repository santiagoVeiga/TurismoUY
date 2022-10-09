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
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		return  mUsu.getUsuarios();
	}
	
    public DataUsuario ingresarDatos(String nick)
    {
    	ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
    	Usuario usu = mUsu.obtenerUsuarioNick(nick);
    	return usu.getDataUsuario();
    }

    public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
    	DataDepartamento[] res = mDep.obtenerDataDepartamentos();
    	if (res == null) {
    		throw new DepartamentoNoExisteException("No existen departamentos");
    	} else {
    	return res;
    	}
    }
    
    public String[] listarPaquetes() {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		return mPaq.getPaquetesN();
	}
    
	public DataPaquete obtenerDataPaquete(String paq) {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		return mPaq.getDataPaquete(paq);
	}
	   
	public Set<String> obtenerNombreCategorias() {    	
		ManejadorCategoria mCat = ManejadorCategoria.getInstance();
		return mCat.obtenerNombreCategorias();
    }
	
	public DataActividad[] obtenerActividadCategoria(String categoria) {
		ManejadorCategoria mCat = ManejadorCategoria.getInstance();
		Categoria cat = mCat.getCategoria(categoria);
		Actividad[] arrAct = cat.getActividades();
		DataActividad[] res = new DataActividad[arrAct.length];
		for(int i = 0; i < arrAct.length;i++) {
			res[i] = arrAct[i].getDataAT();
		}
		return res;
	}
}
