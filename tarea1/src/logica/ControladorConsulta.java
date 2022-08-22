package logica;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	public Usuario[] listarUsuarios() 
	{
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario[] u = mu.getUsuarios();
		return u;
	}
	
    public DataUsuario ingresarDatos(String ci)
    {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Turista u = mu.obtenerUsuarioNick(ci);
    	return u.getDataT();
    }
    
    
}
