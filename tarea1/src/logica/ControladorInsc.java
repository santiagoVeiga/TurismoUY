package logica;

import java.util.Date;
import java.util.Set;

import excepciones.ExcedeTuristas;
import excepciones.TuristaConSalida;
import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorUsuario;

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
	
	public void inscribir(String correo, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas {
		ManejadorActividad m = ManejadorActividad.getInstance();
		Actividad a = m.getActividad(nombreAct);
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Usuario t = mu.obtenerUsuarioMail(correo);
		int c = a.getCosto();
		int costo = c*cantTuristas;
		Salida s = a.getSalida(nomSalida);
		// Chequeo de condiciones
		if (((Turista) t).yaTieneSalida(s)) { // Sabemos por precondicion que se puede hacer el downcast
			throw new TuristaConSalida("El turista ya pertenece a la salida");
		}
		if(s.excedeTuristas(cantTuristas)) {
			throw new ExcedeTuristas("La salida no cuenta con capacidad para la cantidad de turistas solicitados");
		}
		// Se realiza la inscripcion
		CompraGeneral cg = new CompraGeneral(fecha,cantTuristas,costo);
		cg.setSalida(s);
		((Turista) t).agregarCompraGeneral(cg);
	}
}
