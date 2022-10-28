package logica;
import java.util.Date;
import java.util.Set;

public class DataProveedor extends DataUsuario {

    private String descripcion;
    private String link;
    private Set<DataActividad> actividades;

    public DataProveedor(String nickname, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades) {
        super(nickname, nombre, apellido, mail, nacimiento);
    	this.descripcion = descripcion;
    	this.link = link;
    	this.actividades = Actividades;
    }
    
    public DataProveedor(String nick, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades, String pass, byte[] imagen) {
        super(nick, nombre, apellido, mail, nacimiento, pass, imagen);
    	this.descripcion = descripcion;
    	this.link = link;
    	this.actividades = Actividades;
    }
    
    public DataProveedor(String nick, String nombre, String apellido, String mail, Date nacimiento, String descripcion, String link, Set<DataActividad> Actividades, String pass, byte[] imagen, Set<String> seguidores, Set<String> seguidos) {
        super(nick, nombre, apellido, mail, nacimiento, pass, imagen, seguidores, seguidos);
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
