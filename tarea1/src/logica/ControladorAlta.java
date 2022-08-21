package logica;

import java.util.Date;

import excepciones.ActividadRepetidaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import manejadores.ManejadorActividad;
import manejadores.ManejadorUsuario;

/**
 * Controlador de altas.
 * @author TProg2017
 *
 */
public class ControladorAlta implements IControladorAlta {

    public ControladorAlta() {
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
        if (mAct.actividadEstaRegistrada(mAct.getActividad(nom)))
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);        
        Actividad actividad = new Actividad(nom, desc,f,ciudad, costo, dur, dep);
        mAct.addActividad(actividad);
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
}
