package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.NoExisteCategoriaException;
import excepciones.PaqueteNoExisteException;
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
    public abstract void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad) throws UsuarioRepetidoException;
    public abstract void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass) throws UsuarioRepetidoException;
    public abstract void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException;

    public abstract void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink) throws UsuarioRepetidoException;
    public abstract void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass) throws UsuarioRepetidoException;
    public abstract void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad, String link, boolean hayLink, String pass, byte[] imagen) throws UsuarioRepetidoException;
    
    public abstract DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException;
    
    public abstract void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException;
    public abstract void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat, byte[] imagen) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException;
    
    public abstract DataUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException;
    public abstract DataUsuario[] getUsuarios() throws UsuarioNoExisteException;
    public abstract DataUsuario[] getUsuariosComp() throws UsuarioNoExisteException;

	
	public void cargarDptos(CSVReader reader) throws IOException, DepartamentoYaExisteExeption;
	
	public abstract void cargarCategorias();

	
	public abstract void cargarUsuarios(CSVReader reader, Map<String, byte[]> imgs) throws IOException, UsuarioRepetidoException, ParseException ;
    
	public abstract void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad ;
	public abstract void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta, byte[] imagen) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad ;
	
	
	public abstract void cargarActs(CSVReader reader, Map<String, byte[]> imgBytes) throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException, ParseException, UsuarioNoExisteException, ProveedorNoNacidoException;
	
	public abstract void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption ; 
	
	
	public abstract void cargarSalidas(CSVReader reader, Map<String, byte[]> imgBytes) throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad;

	public abstract void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException;
	
    public abstract void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad);

	public abstract void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink);

	
	public abstract void cargarPaquetes(CSVReader reader, Map<String, byte[]> imagenes) throws FileNotFoundException, NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException;

	public abstract void cargarDatos() throws  Exception;
	
	public abstract Set<String> obtenerNombreCategorias() throws NoExisteCategoriaException;

	public abstract void registrarCategoria(String text) throws CategoriaYaExiste;

	public abstract void cargarCompPaq() throws IOException, ParseException, NumberFormatException, PaqueteNoExisteException, PaqueteRepetidoException;
	public abstract void cargarCompPaq(CSVReader reader) throws IOException, ParseException, PaqueteNoExisteException, PaqueteRepetidoException;


}
