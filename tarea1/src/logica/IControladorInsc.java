package logica;

import java.util.Date;
import java.util.Set;

public interface IControladorInsc {
	public abstract Set<DataDepartamento> listarDepartamentos();
	public abstract void inscribir(String a ,String b ,int c ,Date d ,String e);
	public abstract Set<DataSalida> salidas(String s);
	public abstract Set<DataActividad> selecDepartamento(String s);
	public abstract Set<DataPaquete> listarPaquetes();
	public abstract Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String s);
	public abstract void confirmar(String paq, String act);
}
