package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public abstract class Usuario {

	private String nickname;
    private String nombre;
    private String apellido;
    private String mail;
    private Date nacimiento;
    private String password;
    private byte[] imagen;
    private Map<String, Usuario> seguidores;
    private Map<String, Usuario> seguidos;

    public Usuario(String nickname, String nombre, String apellido, String mail, Date nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.mail = mail;
        this.nacimiento = nacimiento;
        password = "1234";
        imagen = null;
        this.setSeguidores(new HashMap<String, Usuario>());
        this.setSeguidos(new HashMap<String, Usuario>());
    }
   
    public Usuario(String nickname, String nombre, String apellido, String mail, Date nacimiento, String pass, byte[] imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.mail = mail;
        this.nacimiento = nacimiento;
        this.password = pass;
        this.imagen = imagen;
        this.setSeguidores(new HashMap<String, Usuario>());
        this.setSeguidos(new HashMap<String, Usuario>());
    }
    public Usuario(String nickname, String nombre, String apellido, String mail, Date nacimiento, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.mail = mail;
        this.nacimiento = nacimiento;
        password = pass;
        imagen = null;
        this.setSeguidores(new HashMap<String, Usuario>());
        this.setSeguidos(new HashMap<String, Usuario>());
    }
    
    /* Getters */
    public abstract DataUsuario getDataUsuario();
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }
    
    public String getMail() {
        return mail;
    }
    
    public Date getNacimiento() {
        return nacimiento;
    }    
    
    /* Setters */
    
    public Map<String, Usuario> getSeguidores() {
		return seguidores;
	}

	public Map<String, Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(Map<String, Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public void setSeguidores(Map<String, Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public void setNombre(String nom) {
        nombre = nom;
    }

    public void setApellido(String apellidoU) {
        apellido = apellidoU;
    }

    public void setNickname(String nick) {
    	nickname = nick;
    }

    public void setMail(String mailU) {
    	mail = mailU;
    }

    public void setNacimiento(Date nac) {
        nacimiento = nac;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public void seguirUsuario(Usuario usuAgregar) throws UsuarioRepetidoException {
		if (this.getSeguidos().get(usuAgregar.getNickname()) != null) {
			throw new UsuarioRepetidoException("El usuario " + this.getNickname() + "ya sigue al usuario " + usuAgregar.getNickname());
		}
		this.getSeguidos().put(usuAgregar.getNickname(), usuAgregar);
	}
	
	public void dejarDeSeguirUsuario(Usuario usuQuitar) throws UsuarioNoExisteException {
		if (this.getSeguidos().get(usuQuitar.getNickname()) == null) {
			throw new UsuarioNoExisteException("El usuario " + this.getNickname() + "no sigue al usuario " + usuQuitar.getNickname());
		}
		this.getSeguidos().remove(usuQuitar.getNickname());
	}
	
	public void agregarSeguidor(Usuario usuAgregar) throws UsuarioRepetidoException {
		if (this.getSeguidores().get(usuAgregar.getNickname()) != null) {
			throw new UsuarioRepetidoException("El usuario " + this.getNickname() + "ya es seguido por el usuario " + usuAgregar.getNickname());
		}
		this.getSeguidores().put(usuAgregar.getNickname(), usuAgregar);
	}
	
	public void eliminarSeguidor(Usuario usuQuitar) throws UsuarioNoExisteException {
		if (this.getSeguidores().get(usuQuitar.getNickname()) == null) {
			throw new UsuarioNoExisteException("El usuario " + this.getNickname() + "no es seguido por el usuario " + usuQuitar.getNickname());
		}
		this.getSeguidores().remove(usuQuitar.getNickname());
	}
	
	public abstract DataUsuario getDataUsuarioComp();
}
