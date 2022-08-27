package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.DataProveedor;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorConsulta;

class ControladorConsultaTest {

	private static IControladorConsulta ccon;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Fabrica fabrica = Fabrica.getInstance();
		ccon = fabrica.getIControladorConsulta();
	}
	
	@Test
	void test() {
		fail("no");
	}

	@Test
	void testListarUsuarios() {
		DataUsuario[] aux = ccon.listarUsuarios();
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

}
