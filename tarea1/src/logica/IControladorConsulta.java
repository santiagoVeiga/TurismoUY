package logica;

import java.util.Set;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidasNoExisteException;
import excepciones.UsuarioNoExisteException;

public interface IControladorConsulta {
	public abstract DataUsuario[] listarUsuarios();
	public abstract DataUsuario ingresarDatos(String nick);
	public abstract DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException;
	public abstract String[] listarPaquetes();
	public abstract DataPaquete obtenerDataPaquete(String paq);
	public abstract Set<String> obtenerNombreCategorias();
	public abstract DataActividad[] obtenerActividadCategoria(String categoria);
	public abstract DataUsuario obtenerDataUsuarioNick(String nick) throws UsuarioNoExisteException;
	public abstract DataUsuario obtenerDataUsuarioMail(String mail) throws UsuarioNoExisteException;
	public abstract DataActividad obtenerDataActividad(String nomAct) throws ActividadNoExisteException;
	public abstract DataSalida obtenerDataSalida(String nomSal) throws SalidasNoExisteException;
}
