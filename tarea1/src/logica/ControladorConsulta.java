package logica;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	
	
    public DataTurista ingresarDatos(String ci)
    {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario u = mu.obtenerUsuario(ci);
    	return u.getDataT();
    }

    
}
