package servidor;

import jakarta.xml.ws.*;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;

import java.io.File;
import java.io.FileInputStream;
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
import excepciones.SalidasVigentesException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.estadoActividadIncorrecto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import logica.DataActividad;
import logica.DataCompraGeneral;
import logica.DataCompraPaquete;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataProveedor;
import logica.DataSalida;
import logica.DataTurista;
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
	
	// DATAS
	
    @WebMethod
    public DataDepartamento dataDepartamentoNull(){
    	return null;
    }
	
    @WebMethod
    public DataTurista dataTuristaNull(){
    	return null;
    }
    
    @WebMethod
    public DataProveedor dataProveedorNull(){
    	return null;
    }
    
    @WebMethod
    public DataActividad dataActividadNull(){
    	return null;
    }
    
    @WebMethod
    public DataCompraGeneral dataCGNull(){
    	return null;
    }
    
    @WebMethod
    public DataCompraPaquete dataCPNull(){
    	return null;
    }
    
    public estadoAct estadoActNull() {
    	return estadoAct.agregada;
    }
    
	// EXCEPTIONS
	
    @WebMethod
    public void excepciones() throws ActividadNoExisteException, ActividadRepetidaException, CategoriaYaExiste, DepartamentoNoExisteException, DepartamentoYaExisteExeption, estadoActividadIncorrecto,ExcedeTuristas,FechaAltaSalidaAnteriorActividad,FechaAltaSalidaInvalida,InscFechaDespSalida,InscFechaInconsistente,NoExisteCategoriaException,NoHayCuposException, PaqueteNoExisteException, PaqueteRepetidoException, ProveedorNoNacidoException, SalidasNoExisteException, SalidasVigentesException, TuristaConSalida, TuristaNoHaNacido, UsuarioNoExisteException, UsuarioRepetidoException{
    }
    
	
	//Controlador Alta
	
    
    @WebMethod
    public void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
    }
    
    @WebMethod
    public void confirmarAltaTuristaCompleto(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaTurista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass, imagen);
    }
    
    @WebMethod
    public  void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass);
    }

    @WebMethod
    public void confirmarAltaProveedorCompleto(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass, byte[] imagen) throws UsuarioRepetidoException{
    	conAlta.confirmarAltaProveedor(nick, nom, apellido, mail, nacimiento, nacionalidad, link, hayLink, pass, imagen);
    }
    
   @WebMethod
    public  DataColeccionObject obtenerDataDepartamentos() throws DepartamentoNoExisteException{
	   return new DataColeccionObject((Object[]) conCons.obtenerDataDepartamentos());
	}
   
    @WebMethod
    public  void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, DataColeccionObject cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{
    	Set<String> categorias = new HashSet<String>();
    	Collections.addAll(categorias,((String[]) cat.getArray()));
    	conAlta.registrarActividad(dep, nom, desc, dur, costo, ciudad, fecha, proveedor, categorias);
    }

    @WebMethod
    public  void registrarActividadImagen(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, DataColeccionObject cat, byte[] imagen) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException{
    	Set<String> categorias = new HashSet<String>();
    	Collections.addAll(categorias,((String[]) cat.getArray()));
    	conAlta.registrarActividad(dep, nom, desc, dur, costo, ciudad, fecha, proveedor, categorias, imagen);
    }
    
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

    @WebMethod
	public  void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta);
    }

    @WebMethod
    public  void confirmarAltaSalidaImagen(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta, byte[] imagen) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
    	conAlta.confirmarAltaSalida(nombreActividad, nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta, imagen);
    }
    
    @WebMethod
    public  void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad);
    }

    @WebMethod
	public  void actualizarDatosTuristaCompleto(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad, String password,byte[] imagen){
    	conAlta.actualizarDatosTurista(nick, mail, nombre, apellido, fechaN, nacionalidad, password, imagen);
    }
    
    @WebMethod
	public  void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink);
    }

    @WebMethod
	public  void actualizarDatosProveedorCompleto(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink, String password, byte[] imagen){
    	conAlta.actualizarDatosProveedor(nick, mail, nombre, apellido, fechaN, descripcion, link, hayLink, password, imagen);
    }
    
    @WebMethod
	public  DataColeccionObject obtenerNombreCategorias() throws NoExisteCategoriaException{
		return new DataColeccionObject(conAlta.obtenerNombreCategorias().toArray(new String[0]));
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
	public DataColeccionObject listarActividadesAgregadas(){
		return new DataColeccionObject(conInsc.listarActividadesAgregadas().toArray(new String[0]));
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
	
    @WebMethod
    public void seguirDejarDeSeguirUsuario(String nickSeguidor, String nickASeguir, boolean seguir) throws UsuarioNoExisteException, UsuarioRepetidoException{
    	conInsc.seguirDejarDeSeguirUsuario(nickSeguidor, nickASeguir, seguir);
    }
	
    @WebMethod
    public void agregarQuitarActividadFavorita(String nickTurista, String nombreAct, boolean agregar) throws UsuarioNoExisteException, ActividadNoExisteException, ActividadRepetidaException {
    	conInsc.agregarQuitarActividadFavorita(nickTurista, nombreAct, agregar);
    }
    
    @WebMethod
    public void finalizarActividad(String nombreActividad) throws ActividadNoExisteException, SalidasVigentesException{
    	conInsc.finalizarActividad(nombreActividad);
    }
    
    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String name)
                    throws  IOException {
        byte[] byteArray = null;
        try {
                File f = new File(name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
                streamer.close();
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
    }
	
    @WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}


}
