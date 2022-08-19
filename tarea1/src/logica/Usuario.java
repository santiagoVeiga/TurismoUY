package logica;

import java.util.Date;

/**
 * Representa a un usuario en el sistema con nombre, apellido y cédula de identidad.
 * @author TProg2017
 *
 */
public class Usuario {

	private String nickname;
    private String nombre;
    private String apellido;
    private String mail;
    private Date nacimiento;

    public Usuario(String nickname, String nombre, String apellido, String mail, Date nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.mail = mail;
        this.nacimiento = nacimiento;
    }
    
    /* Getters */
    
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
    
    public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String ap) {
        apellido = ap;
    }

    public void setNickname(String nick) {
    	nickname = nick;
    }

    public void setMail(String m) {
    	mail = m;
    }

    public void setNacimiento(Date nac) {
        nacimiento = nac;
    }
}
