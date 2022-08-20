package logica;
import java.util.*;

public class DataProveedor extends DataUsuario {

    private String descripcion;
    private String link;
    private Set<DataActividad> actividades;

    public DataProveedor(String nick,String nom, String ap,String mail, Date nac, String des, String link,Set<DataActividad> Actividades) {
        super(nick,nom,ap,mail,nac);
    	this.descripcion = des;
    	this.link = link;
    	this.actividades = Actividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }
}
