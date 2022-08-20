package logica;
import manejadores.ManejadorUsuario;

public class ControladorConsulta implements IControladorConsulta {
	
	public Usuario[] listarUsuarios() 
	{
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario[] u = mu.getUsuarios();
		return u;
	}
	
    public DataTurista ingresarDatosT(String ci)
    {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Turista u = (Turista) mu.obtenerUsuarioNick(ci);
    	return u.getDataT();
    }

    public DataProveedor ingresarDatosP(String ci)
    {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Proveedor u = (Proveedor) mu.obtenerUsuarioNick(ci);
    	return u.getDataP();
    }
    
}
