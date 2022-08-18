package Manejadores;
import java.util.Collection;
import java.util.Map;
import logica.Departamento;

public class ManejadorDepartamentos {
	
	private static ManejadorDepartamentos instancia = null;
	
	private Map<String,Departamento> colDep;
	
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

    public Departamento[] getDepartamentos() {
        if (colDep.isEmpty())
            return null;
        else {
            Collection<Departamento> usrs = colDep.values();
            Object[] o = usrs.toArray();
            Departamento[] usuarios = new Departamento[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Departamento) o[i];
            }
            return usuarios;
        }
    }
}
