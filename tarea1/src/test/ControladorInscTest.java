package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ExcedeTuristas;
import excepciones.InscFechaInconsistente;
import excepciones.TuristaConSalida;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.Fabrica;
import logica.IControladorInsc;

class ControladorInscTest {
	private static IControladorInsc cin;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Fabrica fabrica = Fabrica.getInstance();
		cin = fabrica.getIControladorInsc();
		cin.cargarInsc();
	}
		
	@Test
	void testCargarInscSelecDpto()  {
		Set<DataActividad> se = cin.selecDepartamento("Rocha");
		boolean res = false;
		for(DataActividad it : se) {
			res = res || (it.getCiudad().equals("Rocha") && it.getCosto()==800 && it.getNombre().equals("Degusta"));
		}
		assertEquals(true,res);
		
	} 
	
	@Test
	void testCargarInscSalidas()  {
		Set<DataSalida> sed = cin.salidas("Degusta");
		boolean res = false;
		for(DataSalida it : sed) {
			res = res || (it.getCant()==20 && it.getNombre().equals("Degusta Agosto"));
		}
		assertEquals(true,res);
	}
	
	@Test
	void testListarDptos() {
		Set<DataDepartamento> sed = cin.listarDepartamentos();
		boolean res = false;
		for(DataDepartamento it : sed) {
			res = res || (it.getUrl().equals("https://montevideo.gub.uy/areas-tematicas/turismo") && it.getNombre().equals("Montevideo"));
		}
		assertEquals(true,res);
	}
	
	
	
}
