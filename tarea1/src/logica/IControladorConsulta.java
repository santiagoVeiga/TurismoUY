package logica;

import excepciones.DepartamentoNoExisteException;

public interface IControladorConsulta {
	public abstract DataUsuario[] listarUsuarios();
	public abstract DataUsuario ingresarDatos(String ci);
	public abstract DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException;
	public abstract String[] listarPaquetes();
	public abstract DataPaquete obtenerDataPaquete(String p);
}
