package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Turista extends Usuario{

    private String nacionalidad;
    private Set<CompraGeneral> comprasG;
    private Map<String,CompraPaquete> comprasP;

    public Turista(String nick,String nom, String apellido,String mail, Date fechaN, String nac) {
        super(nick,nom,apellido,mail,fechaN);
    	this.nacionalidad = nac;
    	this.comprasG = new HashSet<CompraGeneral>();
    	this.comprasP = new HashMap<String,CompraPaquete>();
    }
    
    public Turista(String nick,String nom, String apellido,String mail, Date fechaN, String nac,String pass) {
        super(nick,nom,apellido,mail,fechaN,pass);
    	this.nacionalidad = nac;
    	this.comprasG = new HashSet<CompraGeneral>();
    	this.comprasP = new HashMap<String,CompraPaquete>();
    }
    
    public Turista(String nick,String nom, String apellido,String mail, Date fechaN, String nac,String pass,byte[] imagen) {
        super(nick,nom,apellido,mail,fechaN,pass,imagen);
    	this.nacionalidad = nac;
    	this.comprasG = new HashSet<CompraGeneral>();
    	this.comprasP = new HashMap<String,CompraPaquete>();
    }
    
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    

    public Map<String,CompraPaquete> getComprasP() {
		return comprasP;
	}

	public void setComprasP(Map<String,CompraPaquete> comprasP) {
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
    	while(itr.hasNext()) {
    		res = res || itr.next().esSalida(sal);
    	}
    	return res;
    }
    
    public void agregarCompraPaquete(String nomPaq, CompraPaquete compraP) {
    	comprasP.put(nomPaq,compraP);
    }

    public boolean paqueteComprado(String paq) {
    	return comprasP.get(paq) != null;
    }
    
    public CompraPaquete getCompraPaquete(String paq) {
    	return comprasP.get(paq);
    }
    
    public DataTurista getDataUsuario()
    {
    	Iterator<CompraGeneral> itr = comprasG.iterator();
    	Set<DataSalida> dSal = new HashSet<DataSalida>();
    	while(itr.hasNext()) 
    	{
    		CompraGeneral compraGen = itr.next();
    		dSal.add(compraGen.getSalida().getDataST());
    	}
    	DataTurista dTur = new DataTurista(getNickname(),getNombre(),getApellido(),getMail(),getNacimiento(),nacionalidad,dSal);
    	return dTur;
    }

	@Override
	public DataUsuario getDataUsuarioComp() {
		Iterator<CompraGeneral> itr = comprasG.iterator();
    	Set<DataSalida> dSal = new HashSet<DataSalida>();
    	while(itr.hasNext()) 
    	{
    		CompraGeneral compraGen = itr.next();
    		dSal.add(compraGen.getSalida().getDataST());
    	}
    	DataTurista dTur = new DataTurista(getNickname(),getNombre(),getApellido(),getMail(),getNacimiento(),nacionalidad,dSal,getPassword(),getImagen(),comprasP.keySet());
    	return dTur;
	}


}
