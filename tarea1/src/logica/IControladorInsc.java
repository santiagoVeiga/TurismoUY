package logica;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import com.opencsv.CSVReader;

import excepciones.ActividadNoExisteException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.SalidasNoExisteException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.estadoActividadIncorrecto;

public interface IControladorInsc {
	public abstract Set<DataDepartamento> listarDepartamentos();
	public abstract void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido;
	public abstract Set<DataSalida> salidas(String sal) throws ActividadNoExisteException;
	public abstract Set<DataActividad> selecDepartamento(String sal);
	public abstract String[] listarPaquetes();
	public abstract Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String dep, String sal);
	public abstract void confirmar(String paq, String act);
	public abstract DataUsuario[] listarUsuarios();
	public abstract void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException;
	public abstract void cargarActsPaqs() throws IOException;
	public abstract void cargarActsPaqs(CSVReader reader) throws IOException;
	public abstract Set<String> listarActividadesAgregadas();
	public abstract void aceptarRechazarAct(String nomAct, estadoAct estado) throws estadoActividadIncorrecto, ActividadNoExisteException;
	public abstract String[] listarPaquetesNoComprados();
	public abstract void comprarPaquete(String nick, Date fecha, int cant, String paqString) throws PaqueteNoExisteException, PaqueteRepetidoException;
	public abstract void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct, String nombrePaq) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException;
	public abstract String[] obtenerPaquetesComprados(String nickTurista);
	public abstract String obtenerNomActPorSalida(String salida) throws SalidasNoExisteException;
	public abstract void cargarInsc(CSVReader reader) throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException;
}
