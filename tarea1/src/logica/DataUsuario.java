package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 * @author TProg2017
 *
 */
public class DataUsuario {

	private String nick;
	private String nombre;
    private String apellido;
    private String mail;
    private Date nacimiento;
    private String password;
    private byte[] imagen;
    private Set<String> seguidores;
    private Set<String> seguidos;

    public DataUsuario(String nick, String nombre, String apellido, String mail, Date nacimiento) {
    	this.nick = nick;
    	this.nombre= nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nacimiento = nacimiento;
        this.password = null;
        this.imagen = null;
        this.seguidores = new HashSet<String>();
        this.seguidos = new HashSet<String>();
    }
    
    public DataUsuario(String nick, String nombre, String apellido, String mail, Date nacimiento, String pass, byte[] imagen) {
    	this.nick = nick;
    	this.nombre= nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nacimiento = nacimiento;
        password = pass;
        this.imagen = imagen;
        this.seguidores = new HashSet<String>();
        this.seguidos = new HashSet<String>();
    }
    
    public DataUsuario(String nick, String nombre, String apellido, String mail, Date nacimiento, String pass, byte[] imagen, Set<String> seguidores, Set<String> seguidos) {
    	this.nick = nick;
    	this.nombre= nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nacimiento = nacimiento;
        password = pass;
        this.imagen = imagen;
        this.setSeguidores(seguidores);
        this.setSeguidos(seguidos);
    }

    public String getNick() {
        return nick;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getMail() {
        return mail;
    }

    public Date getNacimiento() {
        return nacimiento;
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

	public Set<String> getSeguidores() {
		return seguidores;
	}

	public Set<String> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(Set<String> seguidos) {
		this.seguidos = seguidos;
	}

	public void setSeguidores(Set<String> seguidores) {
		this.seguidores = seguidores;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
}
