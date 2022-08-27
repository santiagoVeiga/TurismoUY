package test;
//package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaInconsistente;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataProveedor;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;

class ControladorAltaTest {
	
	private static IControladorAlta IctrAlta;
	private static IControladorConsulta IctrCons;
	
	@BeforeAll
	public static void iniciar() throws DepartamentoYaExisteExeption {
		Fabrica fabrica = Fabrica.getInstance();
		IctrAlta = fabrica.getIControladorAlta();
		IctrCons = fabrica.getIControladorConsulta();
	}
	
	@Test
	void testCargarDptos(){
		try {
			IctrAlta.cargarDptos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DepartamentoYaExisteExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCargarUsuarios(){
		try {
			IctrAlta.cargarUsuarios();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testCargarActs() {
		try {
			IctrAlta.cargarActs();
		} catch (NumberFormatException | IOException | DepartamentoYaExisteExeption | ActividadRepetidaException
				| ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCargarSalidas()  {
		try {
			IctrAlta.cargarSalidas();
		} catch (NumberFormatException | IOException | ParseException | SalidaYaExisteExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testConfirmarAltaTuristaOk() {
		try {
			Date auxi = new Date(2000,6,20);
			IctrAlta.confirmarAltaTurista("lucasnick","lucas","pode","lucasmail",auxi,"uruguaya");
			DataUsuario dusuarios = IctrAlta.verInfoUsuario("lucasnick");
			assertEquals(dusuarios.getNombre(),"lucas");
			assertEquals(dusuarios.getApellido(),"pode");
			assertEquals(dusuarios.getMail(),"lucasmail");
			assertEquals(((DataTurista) dusuarios).getNacionalidad(),"uruguaya");
			assertEquals(dusuarios.getNacimiento().getDate(),auxi.getDate());
			assertEquals(dusuarios.getNacimiento().getMonth(),auxi.getMonth());
			assertEquals(dusuarios.getNacimiento().getYear(),auxi.getYear());
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
	void testListarUsuarios() {
		DataUsuario[] aux = IctrCons.listarUsuarios();
		boolean res1 = false;
		boolean res2 = false;
		for(DataUsuario it:aux) {
			if(it instanceof DataTurista) {
				res1 = res1 || (it.getApellido().equals("Windsor")&&it.getMail().equals("isabelita@thecrown.co.uk")&&it.getNombre().equals("Elizabeth")&&it.getNick().equals("isabelita")&&((DataTurista)it).getNacionalidad().equals("inglesa"));
			}
			else if (it instanceof DataProveedor) {
				res2 = res2 || (it.getApellido().equals("Rocha")&&it.getMail().equals("washington@turismorocha.gub.uy")&&it.getNombre().equals("Washington")&&it.getNick().equals("washington")&&((DataProveedor)it).getLink().equals("http://turismorocha.gub.uy/"));
			}
		}
		assertEquals(res1,true);
		assertEquals(res2,true);
	}

	@Test
	void testConfirmarAltaProveedor() {
		try {
			Date auxi = new Date(2000,6,20);
			IctrAlta.confirmarAltaProveedor("agus","Agustin","de Leon","a@mail",auxi,"Un proveedor","link",true);
			DataUsuario dusuarios = IctrAlta.verInfoUsuario("agus");
			assertEquals(dusuarios.getNombre(),"Agustin");
			assertEquals(dusuarios.getApellido(),"de Leon");
			assertEquals(dusuarios.getMail(),"a@mail");
			assertEquals(((DataProveedor) dusuarios).getDescripcion(),"Un proveedor");
			assertEquals(((DataProveedor) dusuarios).getLink(),"link");
			assertEquals(dusuarios.getNacimiento().getDate(),auxi.getDate());
			assertEquals(dusuarios.getNacimiento().getMonth(),auxi.getMonth());
			assertEquals(dusuarios.getNacimiento().getYear(),auxi.getYear());
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
	
	@Test
	void testExcp() {
		try {
			IctrAlta.cargarDptos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DepartamentoYaExisteExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			IctrAlta.cargarUsuarios();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			IctrAlta.cargarActs();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DepartamentoYaExisteExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ActividadRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			IctrAlta.cargarSalidas();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SalidaYaExisteExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}