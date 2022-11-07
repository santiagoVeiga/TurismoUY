package logica;
import java.util.Set;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidasNoExisteException;
import excepciones.UsuarioNoExisteException;
import manejadores.ManejadorActividad;
import manejadores.ManejadorCategoria;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorPaquete;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	public DataUsuario[] listarUsuarios() {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		return  mUsu.getUsuariosComp();
	}
	
    public DataUsuario ingresarDatos(String nick){
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
		for (int i = 0; i < arrAct.length; i++) {
			res[i] = arrAct[i].getDataAT();
		}
		return res;
	}
	
	public DataUsuario obtenerDataUsuarioNick(String nick) throws UsuarioNoExisteException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Usuario usu = mUsu.obtenerUsuarioNick(nick);
		if (usu == null) {
			throw new UsuarioNoExisteException("No existe el usuario con nickname: " + nick);
		}
		return usu.getDataUsuarioComp();
	}
	
	public DataUsuario obtenerDataUsuarioMail(String mail) throws UsuarioNoExisteException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Usuario usu = mUsu.obtenerUsuarioMail(mail);
		if (usu == null) {
			throw new UsuarioNoExisteException("No existe el usuario con email: " + mail);
		}
		return usu.getDataUsuarioComp();
	}
	
	public DataActividad obtenerDataActividad(String nomAct) throws ActividadNoExisteException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		Actividad act = mAct.getActividad(nomAct);
		if (act == null) {
			throw new ActividadNoExisteException("No existe la actividad con nombre: " + nomAct);
		}
		return act.getDataAT();
	}
	
	public DataSalida obtenerDataSalida(String nomSal) throws SalidasNoExisteException{
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		String nomAct = mAct.obtenerNomActvidiadDeSalida(nomSal);
		try {
			Actividad act = mAct.getActividad(nomAct);
			return act.getSalida(nomSal).getDataST();
		} catch (ActividadNoExisteException e) {
			throw new SalidasNoExisteException("No existe una actividad asociada a la salida con nombre" + nomSal);
		}
	}

	@Override
	public void sumarVistaAAct(String act) throws ActividadNoExisteException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		Actividad acti = mAct.getActividad(act);
		acti.incrementarVisitas();
	}

	@Override
	public void sumarVistaASal(String sal) throws SalidasNoExisteException, ActividadNoExisteException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		String sali = mAct.obtenerNomActvidiadDeSalida(sal);
		Actividad act = mAct.getActividad(sali);
		Salida salid = act.getSalida(sal);
		salid.incrementarVisitas();
	}
}
