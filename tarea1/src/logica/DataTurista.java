package logica;
import java.util.Date;
import java.util.Set;

public class DataTurista extends DataUsuario {

    private String nacionalidad;
    private Set<DataSalida> salidas;
    private Set<String> paquetes;
    private Set<DataCompraGeneral> inscripcionesSal;
    private Set<DataCompraPaquete> comprasPaq;

    public DataTurista(String nick, String nom, String apellido, String mail, Date nacimiento, String nacionalidad, Set<DataSalida> Salidas) {
        super(nick, nom, apellido, mail, nacimiento);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidas;
    }
    
    public DataTurista(String nick, String nom, String apellido, String mail, Date nacimiento, String nacionalidad, Set<DataSalida> Salidass, String pass, byte[] imagen, Set<String> paq, Set<DataCompraGeneral> inscripcionesSal, Set<DataCompraPaquete> comprasPaq) {
        super(nick, nom, apellido, mail, nacimiento, pass, imagen);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    	this.paquetes = paq;
    	this.setInscripcionesSal(inscripcionesSal);
    	this.setComprasPaq(comprasPaq);
    }
    
    public Set<DataSalida> getDataSalidas(){
    	return salidas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public Set<String> getPaquetes(){
    	return paquetes;
    }

	public Set<DataCompraGeneral> getInscripcionesSal() {
		return inscripcionesSal;
	}

	public Set<DataCompraPaquete> getComprasPaq() {
		return comprasPaq;
	}

	public void setComprasPaq(Set<DataCompraPaquete> comprasPaq) {
		this.comprasPaq = comprasPaq;
	}

	public void setInscripcionesSal(Set<DataCompraGeneral> inscripcionesSal) {
		this.inscripcionesSal = inscripcionesSal;
	}

}
