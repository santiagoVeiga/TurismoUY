package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excepciones.ActividadNoExisteException;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Proveedores")
@DiscriminatorValue("2")
public class Proveedor extends Usuario {

	@Column(nullable = false)
    private String descripcion;
    private String link;
    @Transient
    private boolean hayLink;
    @Transient
    private Set<String> actividadesPersistir;
    @Transient
    private Map<String, Actividad> actividades;
    
    public Proveedor() {
    	
    }
    
    public Proveedor(String nick, String nom, String apellido, String mail, Date nacimiento, String desc, String link, boolean hayl, String pass) {
        super(nick, nom, apellido, mail, nacimiento, pass);
    	this.descripcion = desc;
    	this.link = link;
    	this.hayLink = hayl;
    	this.actividades = new HashMap<String, Actividad>();
    	this.actividadesPersistir = new HashSet<String>();
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
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
    	EntityManager em = emf.createEntityManager();
    	List<Actividad> listaCG = em.createQuery("SELECT a FROM Actividad a join Proveedor p WHERE p.nickname = '" + this.getNickname() + "'").getResultList();
    	for (Actividad acts : listaCG) {
    		dAct.add(acts.getDataAT());
    	}
    	DataProveedor dProv = new DataProveedor(getNickname(), getNombre(), getApellido(), getMail(), getNacimiento(), descripcion, link, dAct, getPassword(), this.getSeguidores().keySet(), this.getSeguidos().keySet());
    	return dProv;
	}

	public void finalizarAct(String nomAct) throws ActividadNoExisteException {
		if (actividades.get(nomAct) == null) {
			throw new ActividadNoExisteException("No existe una actividad con nombre: " + nomAct);
		}
		actividadesPersistir.add(nomAct);
		actividades.remove(nomAct);
	}
	
}
