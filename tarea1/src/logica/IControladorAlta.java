package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

/**
 * @author TProg2017
 *
 */
public interface IControladorAlta {
    
    /**
     * Registra al usuario en el sistema.
     * @param n Nombre del usuario.
     * @param ap Apellido del usuario.
     * @param ci Cédula del usuario.
     * @throws UsuarioRepetidoException Si la cédula del usuario se encuentra registrada en el sistema.
     */
    public abstract void confirmarAltaTurista(String nick, String nom , String ap, String mail ,Date nacimiento ,String nacionalidad) throws UsuarioRepetidoException;

    public abstract void confirmarAltaProveedor(String nick, String nom , String ap, String mail ,Date nacimiento ,String descripcion, String link, boolean hayLink) throws UsuarioRepetidoException;
    
    public abstract DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException;
    
    public abstract void registrarActividad(String dep, String nom , String desc,int dur, int costo, String ciudad ,Date f,String proveedor, Set<String> cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException;

    /**
     * Retorna la información de un usuario con la cédula indicada.
     * @param ci Cédula del usuario.
     * @return Información del usuario.
     * @throws UsuarioNoExisteException Si la cédula del usuario no está registrada en el sistema.
     */
    public abstract DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException;

    /**
     * Retorna la información de todos los usuarios registrados en el sistema.
     * @return Información de los usuarios del sistema.
     * @throws UsuarioNoExisteException Si no existen usuarios registrados en el sistema.
     */
    public abstract DataUsuario[] getUsuarios() throws UsuarioNoExisteException;

	public abstract void cargarDptos() throws IOException, DepartamentoYaExisteExeption;

	public abstract void cargarUsuarios() throws IOException, UsuarioRepetidoException, ParseException ;
    public abstract void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad ;

	public abstract void cargarActs() throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException, ParseException, UsuarioNoExisteException, ProveedorNoNacidoException;
	
	public abstract void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption ; 
	
	public abstract void cargarSalidas() throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad;

	public abstract void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException;
	
    public abstract void actualizarDatosTurista(String nick,String mail,String nombre,String apellido,Date fechaN,String nacionalidad);

	public abstract void actualizarDatosProveedor(String nick,String mail,String nombre,String apellido,Date fechaN,String descripcion,String link,boolean hayLink);

	public abstract void cargarPaquetes() throws FileNotFoundException, NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException;

	public abstract Set<String> obtenerCategorias();

	public abstract void registrarCategoria(String text) throws CategoriaYaExiste;




}
