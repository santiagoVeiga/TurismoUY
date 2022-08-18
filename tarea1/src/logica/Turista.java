package logica;
import java.util.*;

public class Turista extends Usuario{

    private String nacionalidad;
    //private Set<CompraGeneral> comprasG;
    private Set<Salida> colSalidas;

    public Turista(String nick,String nom, String ap,String mail, Date nacimiento, String nacionalidad) {
        super(nick,nom,ap,mail,nacimiento);
    	this.nacionalidad = nacionalidad;
    	//this.comprasG = new HashSet<CompraGeneral>();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String n) {
    	nacionalidad = n;
    }

    public DataTurista getDataT()
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
    }
    
    /*public void agregarCompraG(CompraGeneral cg){
     comprasG.put(cg);
     }
     */

}
