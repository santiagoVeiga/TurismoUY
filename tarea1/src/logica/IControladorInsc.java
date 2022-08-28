package logica;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import excepciones.ActividadNoExisteException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaInconsistente;
import excepciones.TuristaConSalida;

public interface IControladorInsc {
	public abstract Set<DataDepartamento> listarDepartamentos();
	public abstract void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException;
	public abstract Set<DataSalida> salidas(String s) throws ActividadNoExisteException;
	public abstract Set<DataActividad> selecDepartamento(String s);
	public abstract String[] listarPaquetes();
	public abstract Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String Dep, String s);
	public abstract void confirmar(String paq, String act);
	public abstract DataUsuario[] listarUsuarios();
	public abstract void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException;
	public abstract void cargarActsPaqs() throws Exception;
}
