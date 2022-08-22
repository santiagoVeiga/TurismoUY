package logica;

import java.util.Date;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

/**
 * Controlador de altas.
 * @author TProg2017
 *
 */
public class ControladorAlta implements IControladorAlta {

    public ControladorAlta() {
    }

    public void confirmarAltaTurista(String nick, String nom , String ap, String mail ,Date nacimiento ,String nacionalidad) throws UsuarioRepetidoException {
/*
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u != null)
            throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");

        u = new Usuario(n, ap, ci);
        mu.addUsuario(u);
*/
    }

    public void confirmarAltaProveedor(String nick, String nom , String ap, String mail ,Date nacimiento ,String descripcion, String link) {
    	
    }

	@Override
	public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
		// TODO Auto-generated method stub
		return null;
	}
    
    /*public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u != null)
            return new DataUsuario(u.getNombre(), u.getApellido(), u.getCedulaIdentidad());
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
                du[i] = new DataUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCedulaIdentidad());
            }

            return du;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");

    }*/
}
