package logica;
import java.util.*;

public class Turista extends Usuario{

    private String nacionalidad;
    //private Set<CompraGeneral> comprasG;

    public Turista(String nick,String nom, String ap,String mail, Date nacimiento, String nacionalidad) {
        super(nick,nom,ap,mail,nacimiento);
    	this.nacionalidad = nacionalidad;
    	//this.comprasG = new HashSet<CompraGeneral>();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String n) {
    	nacionalidad = n;
    }

    /*public void agregarCompraG(CompraGeneral cg){
     comprasG.put(cg);
     }
     */

}
