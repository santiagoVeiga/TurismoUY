package logica;
import java.util.*;

public class DataTurista extends DataUsuario {

    private String nacionalidad;
    private Set<DataSalida> salidas;

    public DataTurista(String nick,String nom, String ap,String mail, Date nacimiento, String nacionalidad) {
        super(nick,nom,ap,mail,nacimiento);
    	this.nacionalidad = nacionalidad;
    	this.salidas = new HashSet<DataSalida>();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

}
