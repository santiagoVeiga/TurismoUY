package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.PaqueteNoExisteException;
import logica.DataDepartamento;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;

class ExcepcionesSinDatosTest {
	
	private static IControladorAlta IctrAlta;
	private static IControladorConsulta IctrCons;
	private static IControladorInsc IctrInsc;
	
	@BeforeAll
	public static void iniciar() throws DepartamentoYaExisteExeption {
		Fabrica fabrica = Fabrica.getInstance();
		IctrAlta = fabrica.getIControladorAlta();
		IctrCons = fabrica.getIControladorConsulta();
		IctrInsc = fabrica.getIControladorInsc();
	}
	@Test
	void testDeps() {
		assertThrows(DepartamentoNoExisteException.class,()->IctrAlta.obtenerDataDepartamentos());
	}

}
