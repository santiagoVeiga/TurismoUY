package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Proveedor extends Usuario {

    private String descripcion;
    private String link;
    private boolean hayLink;
    private Map<String, Actividad> actividades;

    public Proveedor(String nick, String nom, String apellido, String mail, Date nacimiento, String desc, String link, boolean hayl) {
        super(nick, nom, apellido, mail, nacimiento);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }
    
    public Proveedor(String nick, String nom, String apellido, String mail, Date nacimiento, String desc, String link, boolean hayl, String pass) {
        super(nick, nom, apellido, mail, nacimiento, pass);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    }
    
    public Proveedor(String nick, String nom, String apellido, String mail, Date nacimiento, String desc, String link, boolean hayl, String pass, byte[] imagen) {
        super(nick, nom, apellido, mail, nacimiento, pass, imagen);
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

    public void setDescripcion(String des) {
    	descripcion = des;
    }

    public void setLink(String link) {
    	this.link = link;
    }
    
    public void setHayLink(boolean hayL) {
    	hayLink = hayL;
    }

    /* Otras */
    
    /* Agrega Actividad al Map de Actividades del Proveedor*/
    public void agregarActividad(Actividad act){
    	String nomAct = act.getNombre();
        actividades.put(nomAct, act);
        }
    
    public DataProveedor getDataUsuario(){
    	
    	Set<DataActividad> dAct = new HashSet<DataActividad>();
    	for (Map.Entry<String, Actividad> entry : actividades.entrySet()) { 
    		Actividad act = entry.getValue();
    		dAct.add(act.getDataAT());
    	}
    	DataProveedor dProv = new DataProveedor(getNickname(), getNombre(), getApellido(), getMail(), getNacimiento(), descripcion, link, dAct);
    	return dProv;
    }

	@Override
	public DataUsuario getDataUsuarioComp() {
		Set<DataActividad> dAct = new HashSet<DataActividad>();
    	for (Map.Entry<String, Actividad> entry : actividades.entrySet()) { 
    		Actividad act = entry.getValue();
    		dAct.add(act.getDataAT());
    	}
    	DataProveedor dProv = new DataProveedor(getNickname(), getNombre(), getApellido(), getMail(), getNacimiento(), descripcion, link, dAct, getPassword(), getImagen(), this.getSeguidores().keySet(), this.getSeguidos().keySet());
    	return dProv;
	}

}
