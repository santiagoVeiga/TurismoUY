package logica;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

public class DataProveedor extends DataUsuario {

    private String descripcion;
    private String link;
    private Set<DataActividad> actividades;

    public DataProveedor() {
    	
    }
    
    public DataProveedor(String nickname, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades) {
        super(nickname, nombre, apellido, mail, nacimiento);
    	this.descripcion = descripcion;
    	this.link = link;
    	this.actividades = Actividades;
    }
    
    public DataProveedor(String nick, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades, String pass) { //, byte[] imagen) {
        super(nick, nombre, apellido, mail, nacimiento, pass); //, imagen);
    	this.descripcion = descripcion;
    	this.link = link;
    	this.actividades = Actividades;
    }
    
    public DataProveedor(String nick, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades, String pass, Set<String> seguidores, Set<String> seguidos) {
        super(nick, nombre, apellido, mail, nacimiento, pass, seguidores, seguidos);
    	this.descripcion = descripcion;
    	this.link = link;
    	this.actividades = Actividades;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }
    
    public Set<DataActividad> getActividades(){
    	return actividades;
    }
    
}
