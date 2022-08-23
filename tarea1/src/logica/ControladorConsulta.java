package logica;
import excepciones.DepartamentoNoExisteException;
import manejadores.ManejadorDepartamentos;
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
    	Usuario u = mu.obtenerUsuarioNick(ci);
    	return u.getDataUsuario(u);
    }

    public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
    	ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();
    	DataDepartamento[] res = md.obtenerDataDepartamentos();
    	if (res == null) {
    		throw new DepartamentoNoExisteException("No existen departamentos");
    	} else {
    	return res;
    	}
    }
    
}
