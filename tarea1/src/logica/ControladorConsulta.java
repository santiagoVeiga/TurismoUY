package logica;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	public DataUsuario[] listarUsuarios() 
	{
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		return  mu.getUsuarios();
	}

    
    
}
