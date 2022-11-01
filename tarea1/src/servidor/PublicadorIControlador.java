package servidor;

import jakarta.xml.ws.*;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoExisteCategoriaException;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.SalidasNoExisteException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.estadoActividadIncorrecto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;
import logica.estadoAct;

/**
 * @author TProg2017
 *
 */
@WebService
@SOAPBinding(style=Style.RPC,parameterStyle=ParameterStyle.WRAPPED)
public class PublicadorIControlador {
	public PublicadorIControlador() {
	}
	private IControladorAlta conAlta = Fabrica.getInstance().getIControladorAlta();
	private IControladorConsulta conCons = Fabrica.getInstance().getIControladorConsulta();
	private IControladorInsc conInsc = Fabrica.getInstance().getIControladorInsc();
	private Endpoint endpoint = null;
	@WebMethod(exclude=true)
	public void publicar() {
		// --- Obtener puerto libre ---
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String puertoLibre = Integer.toString(serverSocket.getLocalPort());
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ------------------------  
		System.out.println("Publicador iniciado en puerto: " + puertoLibre);
		endpoint = Endpoint.publish("http://10.0.2.15:40000/publicador", this);
	}
	
	//Controlador Alta
	
    @WebMethod
    public void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad);
    }
    @WebMethod
    public void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
    }
    @WebMethod
    public void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass, imagen);
    }
    @WebMethod
    public  void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink);
    }
    @WebMethod
    public  void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass);
    }
    @WebMethod
    public  void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass, imagen);
    }
   /* @WebMethod
    public  DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
		return null;}
    @WebMethod
    public  void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{}
    @WebMethod
    public  void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat, byte[] imagen) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{}
    @WebMethod
    public  DataUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException{
		return null;}
   /* @WebMethod
    public  DataUsuario[] getUsuarios() throws UsuarioNoExisteException{
		return null;}
    @WebMethod
    public  DataUsuario[] getUsuariosComp() throws UsuarioNoExisteException{
		return null;}*/

    @WebMethod(exclude = true)
	public void cargarDptos(CSVReader reader) throws IOException, DepartamentoYaExisteExeption{
    	conAlta.cargarDptos(reader);
    }
    @WebMethod(exclude = true)
	public  void cargarCategorias(){
    	conAlta.cargarCategorias();
    }

   // @WebMethod
	//public  void cargarUsuarios(CSVReader reader, Map<String, byte[]> imgs) throws IOException, UsuarioRepetidoException, ParseException {}
    @WebMethod
	public  void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta);
    }
    @WebMethod
    public  void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta, byte[] imagen) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta, imagen);
    }
	
   // @WebMethod
//	public  void cargarActs(CSVReader reader, Map<String, byte[]> imgBytes) throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException, ParseException, UsuarioNoExisteException, ProveedorNoNacidoException{}
    @WebMethod
	public  void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption {
    	conAlta.confirmarAltaDepartamento(nombre, descripcion, URL);
    } 
	
  //  @WebMethod
//	public  void cargarSalidas(CSVReader reader, Map<String, byte[]> imgBytes) throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad{}
    @WebMethod
	public  void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException{
    	conAlta.altaPaquete(nombre, descripcion, descuento, validez, fechaAlta);
    }
    @WebMethod
    public  void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad);
    }
    @WebMethod
	public  void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad, String password,byte[] imagen){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad, password, imagen);
    }
    @WebMethod
	public  void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink);
    }
    @WebMethod
	public  void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink, String password, byte[] imagen){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink, password, imagen);
    }
   // @WebMethod
	//public  void cargarPaquetes(CSVReader reader, Map<String, byte[]> imagenes) throws FileNotFoundException, NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException{}
    @WebMethod(exclude = true)
	public  void cargarDatos() throws FileNotFoundException, IOException, UsuarioRepetidoException, ParseException, NumberFormatException, DepartamentoYaExisteExeption, ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException, SalidaYaExisteExeption, PaqueteRepetidoException, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, NoHayCuposException, PaqueteNoExisteException{
    	conAlta.cargarDatos();
    }
    @WebMethod
	public  DataColeccionString obtenerNombreCategorias() throws NoExisteCategoriaException{
		return new DataColeccionString(conAlta.obtenerNombreCategorias());
	}
    @WebMethod
	public  void registrarCategoria(String text) throws CategoriaYaExiste{
    	conAlta.registrarCategoria(text);
    }
    @WebMethod(exclude = true)
	public  void cargarCompPaq() throws IOException, ParseException, NumberFormatException, PaqueteNoExisteException, PaqueteRepetidoException{
    	conAlta.cargarCompPaq();
    }
    @WebMethod(exclude = true)
    public  void cargarCompPaq(CSVReader reader) throws IOException, ParseException, PaqueteNoExisteException, PaqueteRepetidoException{
    	conAlta.cargarCompPaq(reader);
    }
    
    //Controlador Consulta
    
    /*public DataUsuario[] listarUsuarios() {
	return null;}*/
	@WebMethod
	public DataUsuario ingresarDatos(String nick){
		return null;}
	/*public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
		return null;}
	public String[] listarPaquetes(){
		return null;}*/
	@WebMethod
	public DataPaquete obtenerDataPaquete(String paq){
		return null;}
	/*public Set<String> obtenerNombreCategorias(){
		return null;}
	public DataActividad[] obtenerActividadCategoria(String categoria){
		return null;}*/
	@WebMethod
	public DataUsuario obtenerDataUsuarioNick(String nick) throws UsuarioNoExisteException{
		return null;}
	@WebMethod
	public DataUsuario obtenerDataUsuarioMail(String mail) throws UsuarioNoExisteException{
		return null;}
	@WebMethod
	public DataActividad obtenerDataActividad(String nomAct) throws ActividadNoExisteException{
		return null;}
	@WebMethod
	public DataSalida obtenerDataSalida(String nomSal) throws SalidasNoExisteException{
		return null;}
	
	// Controlador Insc
	
	/*public Set<DataDepartamento> listarDepartamentos(){
		return null;}*/
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido{}
	/*public Set<DataSalida> salidas(String sal) throws ActividadNoExisteException{
		return null;}
	public Set<DataActividad> selecDepartamento(String sal){
		return null;}
	public String[] listarPaquetes(){
		return null;}
	public Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String dep, String sal){
		return null;}*/
	public void confirmar(String paq, String act){}
	//public DataUsuario[] listarUsuarios(){
		//return null;}
	public void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{}
	public void cargarActsPaqs() throws IOException{}
	public void cargarActsPaqs(CSVReader reader) throws IOException{}
	//public Set<String> listarActividadesAgregadas(){
		//return null;}
	public void aceptarRechazarAct(String nomAct, estadoAct estado) throws estadoActividadIncorrecto, ActividadNoExisteException{}
	//public String[] listarPaquetesNoComprados(){
		//return null;}
	public void comprarPaquete(String nick, Date fecha, int cant, String paqString) throws PaqueteNoExisteException, PaqueteRepetidoException{}
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct, String nombrePaq) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{}
	//public String[] obtenerPaquetesComprados(String nickTurista){
		//return null;}
	public String obtenerNomActPorSalida(String salida) throws SalidasNoExisteException{
		return salida;}
	public void cargarInsc(CSVReader reader) throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{}

	//
	
    @WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}


}
