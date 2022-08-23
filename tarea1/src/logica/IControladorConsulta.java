package logica;

import excepciones.DepartamentoNoExisteException;

public interface IControladorConsulta {
	public abstract DataUsuario[] listarUsuarios();
	public abstract DataUsuario ingresarDatos(String ci);
	public abstract DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException;
}
