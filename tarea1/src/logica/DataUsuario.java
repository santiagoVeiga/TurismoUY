package logica;

import java.util.Date;

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

    public DataUsuario(String nick, String nombre, String apellido, String mail, Date nacimiento) {
    	this.nick = nick;
    	this.nombre= nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nacimiento = nacimiento;
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

    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
    public String toString() {
        return " (" + getNombre() + " " + getApellido() + ")";
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
