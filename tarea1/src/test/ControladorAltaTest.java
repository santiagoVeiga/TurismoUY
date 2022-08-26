package test;
//package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.DepartamentoYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;

class ControladorAltaTest {
	
	private static IControladorAlta IctrAlta;
	
	@BeforeAll
	public static void iniciar() throws DepartamentoYaExisteExeption, IOException, UsuarioRepetidoException, ParseException {
		Fabrica fabrica = Fabrica.getInstance();
		IctrAlta = fabrica.getIControladorAlta();
		//IctrAlta.cargarDptos();
		//IctrAlta.cargarUsuarios();
	}
	
	@Test
	void testCargarDptos() {
		fail("Not yet implemented");
	}

	@Test
	void testCargarUsuarios() {
		fail("Not yet implemented");
	}


	@Test
	void testConfirmarAltaTuristaOk() {
		try {
			IctrAlta.confirmarAltaTurista("lucasnick","lucas","pode","lucasmail",null,"uruguaya");
			DataUsuario dusuarios = IctrAlta.verInfoUsuario("nick");
			assertEquals(dusuarios.getNombre(),"lucas");
			assertEquals(dusuarios.getApellido(),"pode");
			assertEquals(dusuarios.getMail(),"lucasmail");
			//assertEquals(dusuarios.getNacionalidad,"uruguaya");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testConfirmarAltaProveedor() {
		fail("Not yet implemented");
	}

	@Test
	void testRegistrarActividad() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerDataDepartamentos() {
		fail("Not yet implemented");
	}

	@Test
	void testVerInfoUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmarAltaDepartamento() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmarAltaSalida() {
		fail("Not yet implemented");
	}

}
