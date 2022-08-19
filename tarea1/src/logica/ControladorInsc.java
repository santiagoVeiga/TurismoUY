package logica;

import java.util.Set;

import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;

public class ControladorInsc implements IControladorInsc {
	public Set<DataActividad> selecDepartamento(String dep){
		ManejadorDepartamentos m = ManejadorDepartamentos.getInstance();
		Departamento d = m.getDepartamento(dep);
		return d.getActividades();
	}
	
	public Set<DataSalida> salidas(String nombreAct){
		ManejadorActividad m = ManejadorActividad.getInstance();
		Actividad a = m.getActividad(nombreAct);
		return a.getSalidas();
	}
}
