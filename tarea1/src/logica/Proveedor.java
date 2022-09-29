package logica;
import java.util.*;

public class Proveedor extends Usuario {

    private String descripcion;
    private String link;
    private boolean hayLink;
    private Map<String, Actividad> actividades;

    public Proveedor(String nick, String nom,String apellido, String mail, Date nacimiento, String desc,String link,boolean hayl) {
        super(nick,nom,apellido,mail,nacimiento);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }
    
    public Proveedor(String nick, String nom,String apellido, String mail, Date nacimiento, String desc,String link,boolean hayl, String pass) {
        super(nick,nom,apellido,mail,nacimiento,pass);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }
    
    public Proveedor(String nick, String nom,String apellido, String mail, Date nacimiento, String desc,String link,boolean hayl,String pass, byte[] im) {
        super(nick,nom,apellido,mail,nacimiento,pass,im);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }

    /* Getters */

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getLink() {
        return link;
    }
    
    public boolean getHayLink() {
        return hayLink;
    }
   
    /* Setters */

    public void setDescripcion(String d) {
    	descripcion = d;
    }

    public void setLink(String l) {
    	link = l;
    }
    
    public void setHayLink(boolean h) {
    	hayLink = h;
    }

    /* Otras */
    
    /* Agrega Actividad al Map de Actividades del Proveedor*/
    public void agregarActividad(Actividad act){
    	String nomAct = act.getNombre();
        actividades.put(nomAct, act);
        }
    
    public DataProveedor getDataUsuario()
    {
    	
    	Set<DataActividad> DS = new HashSet<DataActividad>();
    	for (Map.Entry<String, Actividad> entry : actividades.entrySet()) 
    	{ 
    		Actividad S = entry.getValue();
    		DS.add(S.getDataAT());
    	}
    	DataProveedor DT = new DataProveedor(getNickname(),getNombre(),getApellido(),getMail(),getNacimiento(),descripcion,link,DS);
    	return DT;
    }

}
