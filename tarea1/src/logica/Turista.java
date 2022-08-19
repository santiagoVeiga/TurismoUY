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

    
    //VER
    /*public DataTurista getDataT()
    {
    	Iterator itr = colSalidas.iterator();
    	Set<DataSalida> DS;
    	while(itr.hasNext()) 
    	{
    		S = itr.next();
    		DS.add(S.getDataST())
    	}
    	DataTurista DT = new DataTurista(nickname,nombre,apellido,mail,nacimiento,nacionalidad,DS);
    	return DT;
    }*/

}
