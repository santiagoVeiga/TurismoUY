package servidor;

import jakarta.xml.ws.*;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
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
    public void confirmarAltaTuristaPass(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
    }
    /*
 // Arreglar array de bytes
    @WebMethod
    public void confirmarAltaTuristaCompleto(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass, imagen);
    }
    */
    @WebMethod
    public  void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink);
    }
    
    @WebMethod
    public  void confirmarAltaProveedorPass(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass);
    }
    /*
 // Arreglar array de bytes
    @WebMethod
    public void confirmarAltaProveedorCompleto(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass, imagen);
    }*/
   @WebMethod
    public  DataColeccionObject obtenerDataDepartamentos() throws DepartamentoNoExisteException{
	   return new DataColeccionObject((Object[]) conCons.obtenerDataDepartamentos());
	}
    @WebMethod
    public  void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, DataColeccionObject cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{
    	Set<String> categorias = new HashSet<String>();
    	Collections.addAll(categorias,((String[]) cat.getSet().toArray()));
    	conAlta.registrarActividad(dep, nom, desc, dur, costo, ciudad, fecha, proveedor, categorias);
    }
    /*
 // Arreglar array de bytes
    @WebMethod
    public  void registrarActividadImagen(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, DataColeccionObject cat, byte[] imagen) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{
    	Set<String> categorias = new HashSet<String>();
    	Collections.addAll(categorias,((String[]) cat.getSet().toArray()));
    	conAlta.registrarActividad(dep, nom, desc, dur, costo, ciudad, fecha, proveedor, categorias, imagen);
    }
    */
    @WebMethod
    public  DataUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException{
		return conAlta.verInfoUsuario(nick);
	}
    
    @WebMethod
    public  DataColeccionObject getUsuarios() throws UsuarioNoExisteException{
		return new DataColeccionObject(conAlta.getUsuarios());
	}
    
    @WebMethod
    public  DataColeccionObject getUsuariosComp() throws UsuarioNoExisteException{
		return new DataColeccionObject(conAlta.getUsuariosComp());
	}

    @WebMethod(exclude = true)
	public void cargarDptos(CSVReader reader) throws IOException, DepartamentoYaExisteExeption{
    	conAlta.cargarDptos(reader);
    }
    @WebMethod(exclude = true)
	public  void cargarCategorias(){
    	conAlta.cargarCategorias();
    }

    @WebMethod(exclude = true)
	public  void cargarUsuarios(CSVReader reader, Map<String, byte[]> imgs) throws IOException, UsuarioRepetidoException, ParseException {
    	conAlta.cargarUsuarios(reader, imgs);
    }
    
    @WebMethod
	public  void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta);
    }
    /*
    //Arreglar arreglo de bytes
    @WebMethod
    public  void confirmarAltaSalidaImagen(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta, byte[] imagen) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta, imagen);
    }
	*/
    @WebMethod(exclude = true)
	public  void cargarActs(CSVReader reader, Map<String, byte[]> imgBytes) throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException, ParseException, UsuarioNoExisteException, ProveedorNoNacidoException{
    	conAlta.cargarActs(reader, imgBytes);
    }

    @WebMethod(exclude = true)
	public  void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption {
    	conAlta.confirmarAltaDepartamento(nombre, descripcion, URL);
    } 
	
    @WebMethod(exclude = true)
	public  void cargarSalidas(CSVReader reader, Map<String, byte[]> imgBytes) throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad{
    	conAlta.cargarSalidas(reader, imgBytes);
    }

    @WebMethod(exclude = true)
	public  void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException{
    	conAlta.altaPaquete(nombre, descripcion, descuento, validez, fechaAlta);
    }
    
    @WebMethod
    public  void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad);
    }
    /*
    // Arreglar array de bytes
    @WebMethod
	public  void actualizarDatosTuristaCompleto(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad, String password,byte[] imagen){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad, password, imagen);
    }
    */
    @WebMethod
	public  void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink);
    }
    /*
 // Arreglar array de bytes
    @WebMethod
	public  void actualizarDatosProveedorCompleto(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink, String password, byte[] imagen){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink, password, imagen);
    }*/
    @WebMethod(exclude = true)
	public  void cargarPaquetes(CSVReader reader, Map<String, byte[]> imagenes) throws FileNotFoundException, NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException{
    	conAlta.cargarPaquetes(reader, imagenes);
    }
    
    @WebMethod(exclude = true)
	public  void cargarDatos() throws FileNotFoundException, IOException, UsuarioRepetidoException, ParseException, NumberFormatException, DepartamentoYaExisteExeption, ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException, SalidaYaExisteExeption, PaqueteRepetidoException, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, NoHayCuposException, PaqueteNoExisteException{
    	conAlta.cargarDatos();
    }
    @WebMethod
	public  DataColeccionObject obtenerNombreCategorias() throws NoExisteCategoriaException{
    	Set<Object> res = new HashSet<Object>();
    	Collections.addAll(res, conAlta.obtenerNombreCategorias());
		return new DataColeccionObject(res);
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
    
    public DataColeccionObject listarUsuarios() {
    	return new DataColeccionObject(conCons.listarUsuarios());
	}
    
	@WebMethod
	public DataUsuario ingresarDatos(String nick){
		return conCons.ingresarDatos(nick);
	}
	
	public DataColeccionObject listarPaquetes(){
		return new DataColeccionObject(conCons.listarPaquetes());
	}
	
	@WebMethod
	public DataPaquete obtenerDataPaquete(String paq){
		return conCons.obtenerDataPaquete(paq);
	}
	
	public DataColeccionObject obtenerActividadCategoria(String categoria){
		return new DataColeccionObject(conCons.obtenerActividadCategoria(categoria));
	}
	
	@WebMethod
	public DataUsuario obtenerDataUsuarioNick(String nick) throws UsuarioNoExisteException{
		return conCons.obtenerDataUsuarioNick(nick);
	}
	
	@WebMethod
	public DataUsuario obtenerDataUsuarioMail(String mail) throws UsuarioNoExisteException{
		return conCons.obtenerDataUsuarioMail(mail);
	}
	
	@WebMethod
	public DataActividad obtenerDataActividad(String nomAct) throws ActividadNoExisteException{
		return conCons.obtenerDataActividad(nomAct);
	}
	
	@WebMethod
	public DataSalida obtenerDataSalida(String nomSal) throws SalidasNoExisteException{
		return conCons.obtenerDataSalida(nomSal);
	}
	
	// Controlador Insc
	@WebMethod
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido{
		conInsc.inscribir(nick, nomSalida, cantTuristas, fecha, nombreAct);
	}
	
	@WebMethod
	public DataColeccionObject salidas(String nombreAct) throws ActividadNoExisteException{
		return new DataColeccionObject(conInsc.salidas(nombreAct).toArray(new DataSalida[0]));
	}
	
	@WebMethod
	public DataColeccionObject selecDepartamento(String dep){
		return new DataColeccionObject(conInsc.selecDepartamento(dep).toArray(new DataActividad[0]));
	}
	
	@WebMethod
	public DataColeccionObject actividadesPorDepartamentoNoEnPaquete(String dep, String paq){
		return new DataColeccionObject(conInsc.actividadesPorDepartamentoNoEnPaquete(dep, paq).toArray(new DataActividad[0]));
	}
	
	@WebMethod
	public void confirmar(String paq, String act){
		conInsc.confirmar(paq, act);
	}
	
	@WebMethod(exclude = true)
	public void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{
		conInsc.cargarInsc();
	}
	@WebMethod(exclude = true)
	public void cargarActsPaqs() throws IOException{
		conInsc.cargarActsPaqs();
	}
	
	@WebMethod(exclude = true)
	public void cargarActsPaqs(CSVReader reader) throws IOException{
		conInsc.cargarActsPaqs(reader);
	}
	
	@WebMethod
	public DataColeccionObject listarActividadesAgregadas(){
		return new DataColeccionObject(conInsc.listarActividadesAgregadas().toArray(new String[0]));
	}
	
	@WebMethod
	public void aceptarRechazarAct(String nomAct, estadoAct estado) throws estadoActividadIncorrecto, ActividadNoExisteException{
		conInsc.aceptarRechazarAct(nomAct, estado);
	}
	
	@WebMethod
	public DataColeccionObject listarPaquetesNoComprados(){
		return new DataColeccionObject(conInsc.listarPaquetesNoComprados());
	}
	
	@WebMethod
	public void comprarPaquete(String nick, Date fecha, int cant, String paqString) throws PaqueteNoExisteException, PaqueteRepetidoException{
		conInsc.comprarPaquete(nick, fecha, cant, paqString);
	}
	
	@WebMethod
	public void inscribirPaq(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct, String nombrePaq) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{
		conInsc.inscribir(nick, nomSalida, cantTuristas, fecha, nombreAct, nombrePaq);
	}
	
	@WebMethod
	public DataColeccionObject obtenerPaquetesComprados(String nickTurista){
		return new DataColeccionObject(conInsc.obtenerPaquetesComprados(nickTurista));
	}

	@WebMethod
	public String obtenerNomActPorSalida(String salida) throws SalidasNoExisteException{
		return conInsc.obtenerNomActPorSalida(salida);
	}
	
	@WebMethod(exclude = true)
	public void cargarInsc(CSVReader reader) throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException{
		conInsc.cargarInsc(reader);
	}

	
    @WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}


}
