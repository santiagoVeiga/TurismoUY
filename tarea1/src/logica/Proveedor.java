package logica;
import java.util.*;

public class Proveedor extends Usuario {

    private String descripcion;
    private String link;
    private boolean hayLink;
    private HashMap<String, Actividad> actividades;

    public Proveedor(String nick, String nom,String apellido, String mail, Date nacimiento, String desc,String link,boolean hayl) {
        super(nick,nom,apellido,mail,nacimiento);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }


    public String getDescripcion() {
        return descripcion;
    }
    
    public String getLink() {
        return link;
    }
    
    public boolean getHayLink() {
        return hayLink;
    }
    
    public void setDescripcion(String d) {
    	descripcion = d;
    }

    public void setLink(String l) {
    	link = l;
    }
    
    public void setHayLink(boolean h) {
    	hayLink = h;
    }

    public void agregarActividad(Actividad act){
    	String nomAct = act.getNombre();
        actividades.put(nomAct, act);
        }

}
