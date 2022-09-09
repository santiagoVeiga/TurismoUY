package manejadores;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import logica.DataDepartamento;
import logica.Departamento;
import logica.Usuario;

public class ManejadorDepartamentos {
	
	private static ManejadorDepartamentos instancia = null;
	
	private Map<String,Departamento> colDep;
	
	private ManejadorDepartamentos() {
		colDep = new HashMap<String, Departamento>();
	}
	
	public static ManejadorDepartamentos getInstance() {
        if (instancia == null) {
            instancia = new ManejadorDepartamentos();
        }
        return instancia;
    }
	
	public Departamento getDepartamento(String clave)
	{
		return colDep.get(clave);
	}
	
    public void addDepartamento(Departamento usu) {
        String ci = usu.getNombre();
        colDep.put(ci, usu);
    }

    public DataDepartamento[] obtenerDataDepartamentos() {
        if (colDep.isEmpty())
            return null;
        else {
            Collection<Departamento> dep = colDep.values();
            Object[] o =  dep.toArray();
            DataDepartamento[] dataDep = new DataDepartamento[o.length];
            for (int i = 0; i < o.length; i++) {
                dataDep[i] = ((Departamento) o[i]).obtenerDataDepartamento();
            }
            return dataDep;
        }
    }
}
