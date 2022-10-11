package logica;
import java.util.*;

public class DataTurista extends DataUsuario {

    private String nacionalidad;
    private Set<DataSalida> salidas;
    private Set<String> paquetes;

    public DataTurista(String nick,String nom, String apellido,String mail, Date nacimiento, String nacionalidad,Set<DataSalida> Salidas) {
        super(nick,nom,apellido,mail,nacimiento);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidas;
    }
    
    public DataTurista(String nick,String nom, String apellido,String mail, Date nacimiento, String nacionalidad,Set<DataSalida> Salidass,String pass, byte[] imagen, Set<String> paq) {
        super(nick,nom,apellido,mail,nacimiento,pass,imagen);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    	this.paquetes = paq;
    }
    
    public Set<DataSalida> getDataSalidas()
    {
    	return salidas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public Set<String> getPaquetes(){
    	return paquetes;
    }

}
