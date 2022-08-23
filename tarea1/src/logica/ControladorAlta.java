package logica;

import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorUsuario;

/**
 * Controlador de altas.
 * @author TProg2017
 *
 */
public class ControladorAlta implements IControladorAlta {

    public ControladorAlta() throws DepartamentoYaExisteExeption{
    	confirmarAltaDepartamento("Canelones","","");
    }

    public void confirmarAltaTurista(String nick, String nom , String ap, String mail ,Date nacimiento ,String nacionalidad) throws UsuarioRepetidoException {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Turista(nick, nom, ap, mail, nacimiento, nacionalidad);
        mu.addUsuario(u);
    }

    public void confirmarAltaProveedor(String nick, String nom , String ap, String mail ,Date nacimiento ,String descripcion, String link, boolean hayLink) throws UsuarioRepetidoException {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Proveedor(nick, nom, ap, mail, nacimiento, descripcion, link, hayLink);
        mu.addUsuario(u);
    }
    
    public void registrarActividad(Departamento dep, String nom , String desc,int dur, int costo, String ciudad ,Date f) throws ActividadRepetidaException {
    	ManejadorActividad mAct = ManejadorActividad.getInstance();
    	Actividad act = mAct.getActividad(nom);
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);        
        act = new Actividad(nom, desc,f,ciudad, costo, dur, dep);
        mAct.addActividad(act);
    }
    
    public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(ci);
        if (u != null)
            return null; //new DataUsuario(u.getNombre(), u.getApellido(), u.getCedulaIdentidad());
        else
            throw new UsuarioNoExisteException("El usuario " + ci + " no existe");

    }

    public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario[] usrs = mu.getUsuarios();

        if (usrs != null) {
            DataUsuario[] du = new DataUsuario[usrs.length];
            Usuario usuario;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                du[i] = null; //new DataUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCedulaIdentidad());
            }

            return du;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");

    }


    public void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption {
        ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();

        Departamento deptoprueba = md.getDepartamento(nombre);
        if (deptoprueba != null)
            throw new DepartamentoYaExisteExeption("Ya existe un departamento registrado con el nombre:  " + nombre);

        Departamento dpto = new Departamento(nombre, descripcion, URL) ;
        md.addDepartamento(dpto) ;
    }


    public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption{
        ManejadorActividad ma = ManejadorActividad.getInstance();
        Actividad act = ma.getActividad(nombreActividad);

        //chequeo si existe una salida con el mismo nombre que el ingresado en el sistema, recorriendo las salidas registradas para todas las actividades
        boolean existeSalidaNombre = false ;
        DataActividad setDact = ma.getDAct();
        Map<String,Actividad> coleccionAct = ma.getColAct() ;
        for (Map.Entry<String,Actividad> entry : coleccionAct.entrySet()){
            Actividad acti = entry.getValue() ;
            Map<String,Salida> coleccionSal = acti.getColSal() ;
            for (Map.Entry<String,Actividad> entry2 : coleccionSal.entrySet()){
                if(entry2.getValue().getNombre() == nombreActividad)
                    existeSalidaNombre = true ;
            }
        }
        if (existeSalidaNombre)
            throw new SalidaYaExisteExeption("ya existe una salida registrada para esta actividad con el nombre : " + nombreSalida) ; 

        Salida salida = new Salida(nombreActividad, lugar, hora, fecha, fechaAlta, maxCantTuristas);
        act.addSalida(salida);

    }
}
