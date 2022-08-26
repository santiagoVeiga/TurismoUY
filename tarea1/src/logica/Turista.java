package logica;
import java.util.*;

public class Turista extends Usuario{

    private String nacionalidad;
    private Set<CompraGeneral> comprasG;

    public Turista(String nick,String nom, String ap,String mail, Date fechaN, String nac) {
        super(nick,nom,ap,mail,fechaN);
    	this.nacionalidad = nac;
    	this.comprasG = new HashSet<CompraGeneral>();
    }
    
    /* Getters */
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    /* Setters */

    public void setNacionalidad(String n) {
    	nacionalidad = n;
    }
    
    /* Agrega CompraGeneral al set de compras del Turista*/
    public void agregarCompraGeneral(CompraGeneral compraG) {
    	comprasG.add(compraG);
    }

    public boolean yaTieneSalida(Salida s) {
    	Iterator<CompraGeneral> itr = comprasG.iterator();
    	boolean res = false;
    	while(itr.hasNext()) {
    		res = res || itr.next().esSalida(s);
    	}
    	return res;
    }
    
    public DataTurista getDataUsuario()
    {
    	Iterator<CompraGeneral> itr = comprasG.iterator();
    	Set<DataSalida> DS = new HashSet<DataSalida>();
    	while(itr.hasNext()) 
    	{
    		CompraGeneral S = itr.next();
    		DS.add(S.getSalida().getDataST());
    	}
    	DataTurista DT = new DataTurista(getNickname(),getNombre(),getApellido(),getMail(),getNacimiento(),nacionalidad,DS);
    	return DT;
    }


}
