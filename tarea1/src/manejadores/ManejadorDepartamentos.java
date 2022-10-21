package manejadores;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import logica.DataDepartamento;
import logica.Departamento;

public class ManejadorDepartamentos {
	
	private static ManejadorDepartamentos instancia = null;
	
	private Map<String, Departamento> colDep;
	
	private ManejadorDepartamentos() {
		colDep = new HashMap<String, Departamento>();
	}
	
	public static ManejadorDepartamentos getInstance() {
        if (instancia == null) {
            instancia = new ManejadorDepartamentos();
        }
        return instancia;
    }
	
	public Departamento getDepartamento(String clave){
		return colDep.get(clave);
	}
	
    public void addDepartamento(Departamento usu) {
        String nom = usu.getNombre();
        colDep.put(nom, usu);
    }

    public DataDepartamento[] obtenerDataDepartamentos() {
        if (colDep.isEmpty())
            return null;
        else {
            Collection<Departamento> dep = colDep.values();
            Object[] obj =  dep.toArray();
            DataDepartamento[] dataDep = new DataDepartamento[obj.length];
            for (int i = 0; i < obj.length; i++) {
                dataDep[i] = ((Departamento) obj[i]).obtenerDataDepartamento();
            }
            return dataDep;
        }
    }
}
