package manejadores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import logica.Usuario;

/**
 * Clase que conserva la colección global de los usuarios del sistema.
 * Los usuarios se identifican por su cédula de identidad.
 * Se implementa en base al patrón Singleton.
 * @author TProg2017
 *
 */
public class ManejadorUsuario {
    private Map<String, Usuario> usuariosNick;
    private Map<String, Usuario> usuariosMail;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuariosNick = new HashMap<String, Usuario>();
        usuariosMail = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();
        String mail = usu.getMail();
        usuariosNick.put(nick, usu);
        usuariosMail.put(mail, usu);
    }

    public Usuario obtenerUsuarioNick(String nick) {
        return ((Usuario) usuariosNick.get(nick));
    }
    
    public Usuario obtenerUsuarioMail(String mail) {
        return ((Usuario) usuariosMail.get(mail));
    }

    public Usuario[] getUsuarios() {
        if (usuariosNick.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosNick.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }

            return usuarios;
        }
    }

}
