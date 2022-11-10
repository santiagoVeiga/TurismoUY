package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Turistas")
@DiscriminatorValue("1")
public class Turista extends Usuario{

	@Column(nullable = false)
    private String nacionalidad;
	@Transient
    private Set<CompraGeneral> comprasG;
	@Transient
	private Set<String> salidasCGFinalizadas;
	@Transient
    private Map<String, CompraPaquete> comprasP;
	@Transient
    private Map<String, Actividad> favoritas;
    
	public Turista() {
		
	}
	
    public Turista(String nick, String nom, String apellido, String mail, Date fechaN, String nac, String pass) {
        super(nick, nom, apellido, mail, fechaN, pass);
    	this.nacionalidad = nac;
    	this.comprasG = new HashSet<CompraGeneral>();
    	this.comprasP = new HashMap<String, CompraPaquete>();
    	this.favoritas = new HashMap<String, Actividad>();
    	this.salidasCGFinalizadas = new HashSet<String>();
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    

    public Map<String, CompraPaquete> getComprasP() {
		return comprasP;
	}

	public Map<String, Actividad> getFavoritas() {
		return favoritas;
	}

	public void setFavoritas(Map<String, Actividad> favoritas) {
		this.favoritas = favoritas;
	}

	public void setComprasP(Map<String, CompraPaquete> comprasP) {
		this.comprasP = comprasP;
	}

	public void setNacionalidad(String nac) {
    	nacionalidad = nac;
    }
    
    /* Agrega CompraGeneral al set de compras del Turista*/
    public void agregarCompraGeneral(CompraGeneral compraG) {
    	comprasG.add(compraG);
    }

    public boolean yaTieneSalida(Salida sal) {
    	Iterator<CompraGeneral> itr = comprasG.iterator();
    	boolean res = false;
    	while (itr.hasNext() && !res) {
    		res = res || itr.next().esSalida(sal);
    	}
    	return res;
    }
    
    public void agregarCompraPaquete(String nomPaq, CompraPaquete compraP) {
    	comprasP.put(nomPaq, compraP);
    }

    public boolean paqueteComprado(String paq) {
    	return comprasP.get(paq) != null;
    }
    
    public CompraPaquete getCompraPaquete(String paq) {
    	return comprasP.get(paq);
    }
    
    public DataTurista getDataUsuario(){
    	Iterator<CompraGeneral> itr = comprasG.iterator();
    	Set<DataSalida> dSal = new HashSet<DataSalida>();
    	while (itr.hasNext()) {
    		CompraGeneral compraGen = itr.next();
    		dSal.add(compraGen.getSalida().getDataST());
    	}
    	DataTurista dTur = new DataTurista(getNickname(), getNombre(), getApellido(), getMail(), getNacimiento(), nacionalidad, dSal);
    	return dTur;
    }

	@Override
	public DataUsuario getDataUsuarioComp() {
		Iterator<CompraGeneral> itr = comprasG.iterator();
    	Set<DataSalida> dSal = new HashSet<DataSalida>();
    	Set<DataCompraGeneral> dComGen = new HashSet<DataCompraGeneral>();
    	Set<DataCompraPaquete> dComPaq = new HashSet<DataCompraPaquete>();
    	while (itr.hasNext()) {
    		CompraGeneral compraGen = itr.next();
    		dComGen.add(compraGen.getDataCompraGeneral());
    		dSal.add(compraGen.getSalida().getDataST());
    	}
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT cg FROM CompraGeneral cg JOIN cg.turista t WHERE t.nickname = :nick");
    	query.setParameter("nick", this.getNickname());
    	List<CompraGeneral> listaCG = query.getResultList();
    	em.close();
    	emf.close();
    	for (CompraGeneral compG : listaCG) {
    		dComGen.add(compG.getDataCompraGeneral());
    		dSal.add(compG.getSalida().getDataST());
    	}
    	for (CompraPaquete compPaq: comprasP.values())
    		dComPaq.add(compPaq.getDataCompraPaquete());
    	DataTurista dTur = new DataTurista(getNickname(), getNombre(), getApellido(), getMail(), getNacimiento(), nacionalidad, dSal, getPassword(), comprasP.keySet(), dComGen, dComPaq, this.getSeguidores().keySet(), this.getSeguidos().keySet(), this.favoritas.keySet());
    	return dTur;
	}

	public void agregarQuitarActividadFavorita(Actividad act, boolean agregar) throws ActividadRepetidaException, ActividadNoExisteException {
		if (agregar) {
			if (this.getFavoritas().get(act.getNombre()) != null) {
				throw new ActividadRepetidaException("El turista " + this.getNickname() + " ya tiene como favorita a la actividad " + act.getNombre());
			}
			this.favoritas.put(act.getNombre(), act);
		} else {
			if (this.getFavoritas().get(act.getNombre()) == null) {
				throw new ActividadNoExisteException("El turista " + this.getNickname() + " no tiene como favorita a la actividad " + act.getNombre());
			}
			this.favoritas.remove(act.getNombre());
		}
	}
	
	public void finalizarActividad(String act, CompraGeneral compraG) {
		this.comprasG.remove(compraG);
		this.salidasCGFinalizadas.add(compraG.getSalida().getNombre());
		if (this.favoritas.containsKey(act)){
			this.favoritas.remove(act);
		}
	}
}
