package logica;
import java.util.*;

public class DataTurista extends DataUsuario {

    private String nacionalidad;
    private Set<DataSalida> salidas;

    public DataTurista(String nick,String nom, String apellido,String mail, Date nacimiento, String nacionalidad,Set<DataSalida> Salidass) {
        super(nick,nom,apellido,mail,nacimiento);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    }
    
    public DataTurista(String nick,String nom, String apellido,String mail, Date nacimiento, String nacionalidad,Set<DataSalida> Salidass,String pass, byte[] imagen) {
        super(nick,nom,apellido,mail,nacimiento,pass,imagen);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    }
    
    public Set<DataSalida> getDataSalidas()
    {
    	return salidas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

}
