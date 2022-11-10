package logica;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class DataTurista extends DataUsuario {
	
    private String nacionalidad;
    
    private Set<DataSalida> salidas;

    private Set<String> paquetes;

    private Set<DataCompraGeneral> inscripcionesSal;

    private Set<DataCompraPaquete> comprasPaq;

    private Set<String> actFavoritas;

    
    
	public DataTurista() {
		
	}
	
    public DataTurista(String nick, String nom, String apellido, String mail, Date nacimiento, String nacionalidad, Set<DataSalida> Salidas) {
        super(nick, nom, apellido, mail, nacimiento);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidas;
    	this.actFavoritas = new HashSet<String>();
    }
    
    public DataTurista(String nick, String nom, String apellido, String mail, Date nacimiento, String nacionalidad, Set<DataSalida> Salidass, String pass, Set<String> paq, Set<DataCompraGeneral> inscripcionesSal, Set<DataCompraPaquete> comprasPaq) {
        super(nick, nom, apellido, mail, nacimiento, pass);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    	this.paquetes = paq;
    	this.setInscripcionesSal(inscripcionesSal);
    	this.setComprasPaq(comprasPaq);
    	this.actFavoritas = new HashSet<String>();
    }
    
    public DataTurista(String nick, String nom, String apellido, String mail, Date nacimiento, String nacionalidad, Set<DataSalida> Salidass, String pass, Set<String> paq, Set<DataCompraGeneral> inscripcionesSal, Set<DataCompraPaquete> comprasPaq, Set<String> seguidores, Set<String> seguidos, Set<String> actFavs) {
        super(nick, nom, apellido, mail, nacimiento, pass, seguidores, seguidos);
    	this.nacionalidad = nacionalidad;
    	this.salidas = Salidass;
    	this.paquetes = paq;
    	this.setInscripcionesSal(inscripcionesSal);
    	this.setComprasPaq(comprasPaq);
    	this.setActFavoritas(actFavs);
    }
    
    public Set<DataSalida> getDataSalidas(){
    	return salidas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String Nacio) {
        nacionalidad = Nacio;
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

	public Set<String> getActFavoritas() {
		return actFavoritas;
	}

    public void setPaquetes(Set<String> set) {
    	this.paquetes = set;
    }
	
	public void setActFavoritas(Set<String> actFavoritas) {
		this.actFavoritas = actFavoritas;
	}

	public void setComprasPaq(Set<DataCompraPaquete> comprasPaq) {
		this.comprasPaq = comprasPaq;
	}

	public void setInscripcionesSal(Set<DataCompraGeneral> inscripcionesSal) {
		this.inscripcionesSal = inscripcionesSal;
	}

}
