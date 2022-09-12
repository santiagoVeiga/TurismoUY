package test;
//package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.Actividad;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataProveedor;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;
import manejadores.ManejadorActividad;

class ControladorAltaTest {
	
	private static IControladorAlta IctrAlta;
	private static IControladorConsulta IctrCons;
	private static IControladorInsc IctrInsc;
	private static ManejadorActividad ManejadorActividades ; 
	
	@BeforeAll
	public static void iniciar() throws DepartamentoYaExisteExeption {
		Fabrica fabrica = Fabrica.getInstance();
		IctrAlta = fabrica.getIControladorAlta();
		IctrCons = fabrica.getIControladorConsulta();
		IctrInsc = fabrica.getIControladorInsc();
		ManejadorActividades = ManejadorActividad.getInstance();
		try {
			IctrAlta.cargarUsuarios();
		} catch (IOException e) {
			fail(e.getMessage()); 
		}catch  (UsuarioRepetidoException e) {
			fail(e.getMessage());
		} catch (ParseException e) {
			fail(e.getMessage());
		}
		try {
			IctrAlta.cargarDptos();
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (DepartamentoYaExisteExeption e) {
			fail(e.getMessage());
		} 
		try {
			IctrAlta.cargarActs();
		} catch (NumberFormatException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (DepartamentoYaExisteExeption e) {
			fail(e.getMessage());
		} catch (ActividadRepetidaException e) {
			fail(e.getMessage());
		} catch (ParseException e) {
			fail(e.getMessage());
			// TODO Auto-generated catch block
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
		} catch (ProveedorNoNacidoException e) {
			// TODO Auto-generated catch block
		}
		try {
			IctrAlta.cargarSalidas();
		} catch (NumberFormatException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ParseException e) {
			fail(e.getMessage());
		} catch (SalidaYaExisteExeption e) {
			fail(e.getMessage());
		} catch (FechaAltaSalidaInvalida e) {
			fail(e.getMessage());
		} catch (FechaAltaSalidaAnteriorActividad e) {
			fail(e.getMessage());
		}
		try {
			IctrAlta.cargarPaquetes();
		} catch (NumberFormatException e) {
			fail(e.getMessage());
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ParseException e) {
			fail(e.getMessage());
		} catch (SalidaYaExisteExeption e) {
			fail(e.getMessage());
		} catch (PaqueteRepetidoException e) {
			fail(e.getMessage());
		}
		try {
			IctrInsc.cargarInsc();
		} catch (NumberFormatException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ParseException e) {
			fail(e.getMessage());
		} catch (TuristaConSalida e) {
			fail(e.getMessage());
		} catch (ExcedeTuristas e) {
			fail(e.getMessage());
		} catch (InscFechaInconsistente e) {
			fail(e.getMessage());
		} catch (ActividadNoExisteException e) {
			fail(e.getMessage());
		} catch (InscFechaDespSalida e) {
			fail(e.getMessage());
		} catch (TuristaNoHaNacido e) {
			fail(e.getMessage());
		}
		try {
			IctrInsc.cargarActsPaqs();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	/*

	@Test
	void testExepcionDepartamentosNoExisten() {
		assertThrows(DepartamentoNoExisteException.class, ()->{IctrAlta.obtenerDataDepartamentos();});	

	
	*
	*
	*/
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
			fail(e.getMessage());
		}
		catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
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
	void testExepcionUsuariosNoExisten() {
		assertThrows(UsuarioNoExisteException.class, ()->{IctrAlta.verInfoUsuario("nickquenoexiste");});	
	}
	
	@Test
	void testingresarDatos() {
		//turista
		DataUsuario aux = IctrCons.ingresarDatos("isabelita");
		DataUsuario aux2 = IctrCons.ingresarDatos("anibal");
		DataUsuario aux3 = IctrCons.ingresarDatos("bobesponja");
		//proveedor
		//------------------------------
		DataUsuario aux4 = IctrCons.ingresarDatos("washington");
		DataUsuario aux5 = IctrCons.ingresarDatos("eldiez");
		//proveedor
		assertEquals(((DataProveedor)aux4).getLink(),"http://turismorocha.gub.uy/");
		assertEquals(aux4.getApellido(),"Rocha");
		assertEquals(aux4.getMail(),"washington@turismorocha.gub.uy");
		assertEquals(aux4.getNombre(),"Washington");
		assertEquals(aux4.getNick(),"washington");
		
		
		assertEquals((aux5.getApellido().equals("Bengoechea") && aux5.getMail().equals("eldiez@socfomturriv.org.uy") && aux5.getNombre().equals("Pablo")&&aux5.getNick().equals("eldiez")&&((DataProveedor)aux5).getLink().equals("http://wwww.socfomturriv.org.uy")),true);
		//turista
		assertEquals((aux3.getApellido().equals("Esponja")&&aux3.getMail().equals("bobesponja@nickelodeon.com")&&aux3.getNombre().equals("Bob")&&aux3.getNick().equals("bobesponja")&&((DataTurista)aux3).getNacionalidad().equals("japonesa")),true);
		assertEquals(aux2.getApellido(),"Lecter");
		assertEquals(aux2.getMail(),"anibal@fing.edu.uy");
		assertEquals(aux2.getNombre(),"Aníbal");
		assertEquals(aux2.getNick(),"anibal");
		assertEquals(((DataTurista)aux2).getNacionalidad(),"lituana");
		
		assertEquals(((DataTurista)aux).getNacionalidad(),"inglesa");
		assertEquals(aux.getApellido(),"Windsor");
		assertEquals(aux.getMail(),"isabelita@thecrown.co.uk");
		assertEquals(aux.getNombre(),"Elizabeth");
		assertEquals(aux.getNick(),"isabelita");
	
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
		Date auxi = new Date(2000,6,20);
		try {
			Set<String> auxCat = new HashSet<String>();
			auxCat.add("Categoria");
			IctrAlta.confirmarAltaDepartamento("parasaindu", "d", "www.parasaindu.com.uy");
			IctrAlta.registrarActividad("parasaindu", "Bici", "Bici",1, 200, "Ciudad de la costa" ,auxi,"eldiez", auxCat);
			Actividad ActividadRegistrada = ManejadorActividades.getActividad("Bici") ; 
			assertEquals(ActividadRegistrada.getDepartamento().getNombre(),"parasaindu");
			assertEquals(ActividadRegistrada.getNombre(),"Bici");
			assertEquals(ActividadRegistrada.getDescripcion(),"Bici");
			assertEquals(ActividadRegistrada.getFechaAlta().getDate(),auxi.getDate());
			assertEquals(ActividadRegistrada.getFechaAlta().getMonth(),auxi.getMonth());
			assertEquals(ActividadRegistrada.getFechaAlta().getYear(),auxi.getYear());
			assertEquals(ActividadRegistrada.getDuracion(),1);
			assertEquals(ActividadRegistrada.getCosto(),200);
			assertEquals(ActividadRegistrada.getCiudad(),"Ciudad de la costa");
		} catch (ActividadRepetidaException e) {
			fail(e.getMessage());
		}
		catch (DepartamentoYaExisteExeption e) {
			fail(e.getMessage());
		}
		catch (ActividadNoExisteException e) {
			fail(e.getMessage());
		} catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
		} catch (ProveedorNoNacidoException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void registroActividadExcepcionProveedorNoNacido() {
		Date auxi = new Date(2000,6,20);
		Date auxi2 = new Date(2023,6,20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		try {
			IctrAlta.confirmarAltaProveedor("proveedorNoNacido", "proveedorNoNacido", "proveedorNoNacido", "proveedorNoNacido", auxi2, "proveedorNoNacido", "proveedorNoNacido", true);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		}
		assertThrows(ProveedorNoNacidoException.class, ()->{IctrAlta.registrarActividad("Colonia", "ProveedorNoNacidoPruebaAct", "Bici",1, 200, "Ciudad de la costa" ,auxi,"proveedorNoNacido",auxCat);;});
	}
	
	@Test
	void registroActividadExcepcionProveedor() {
		Date auxi = new Date(2000,6,20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		assertThrows(UsuarioNoExisteException.class, ()->{IctrAlta.registrarActividad("Colonia", "Bicicleta", "Bici",1, 200, "Ciudad de la costa" ,auxi,"nickquenopuedeexister",auxCat);;});
	}
	
	@Test
	void registroActividadExcepcionYaExiste() {
		Date auxi = new Date(2000,6,20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		assertThrows(ActividadRepetidaException.class, ()->{IctrAlta.registrarActividad("Rocha", "Degusta", "Bici",1, 200, "Ciudad de la costa" ,auxi,"eldiez", auxCat);;});
	}
	
	@Test
	void actualizarDatosTuristaOk() {
		Date auxFecha = new Date(2000,6,20);
		IctrAlta.actualizarDatosTurista("chino","chino@trico.org.uy","Alexander","Recoba",auxFecha,"uruguaya");
		DataUsuario dUsuario;
		try {
			dUsuario = IctrAlta.verInfoUsuario("chino");
			assertEquals(dUsuario.getNick(),"chino");
			assertEquals(dUsuario.getMail(),"chino@trico.org.uy");
			assertEquals(dUsuario.getNombre(),"Alexander");
			assertEquals(dUsuario.getApellido(),"Recoba");
			assertEquals(((DataTurista) dUsuario).getNacionalidad(),"uruguaya");
			assertEquals(dUsuario.getNacimiento().getDate(),auxFecha.getDate());
			assertEquals(dUsuario.getNacimiento().getMonth(),auxFecha.getMonth());
			assertEquals(dUsuario.getNacimiento().getYear(),auxFecha.getYear());
		} catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test       
	void inscribirExcYaTieneSalida() {
		Date auxFecha = new Date(130,8,20);
		assertThrows(TuristaConSalida.class, ()->{IctrInsc.inscribir("lachiqui", "Degusta Agosto", 1, auxFecha, "Degusta");});
	}

	@Test
	void inscribirExcCantidadTuristas() {
		Date auxFecha = new Date(130,8,20);
		assertThrows(ExcedeTuristas.class, ()->{IctrInsc.inscribir("chino", "Degusta Agosto", 1000000, auxFecha, "Degusta");});
	}
	
	@Test
	void inscribirExcFechaAntAlta() {
		Date auxFecha = new Date(100,8,20);
		assertThrows(InscFechaInconsistente.class, ()->{IctrInsc.inscribir("chino", "Degusta Agosto", 1, auxFecha, "Degusta");});
	}
	
	@Test
	void inscribirExcFechaPostSalida() {
		Date auxFecha = new Date(130,8,20);
		assertThrows(InscFechaDespSalida.class, ()->{IctrInsc.inscribir("chino", "Degusta Agosto", 1, auxFecha, "Degusta");});
	}
	
	@Test
	void inscribirTuristaNoHaNacido() {
		Date auxFecha = new Date(122,7,19);
		Date auxFecha2 = new Date(1000,8,20);
		try {
			IctrAlta.confirmarAltaTurista("Turista no ha nacido", "Turista no ha nacido", "Turista no ha nacido", "Turista no ha nacido", auxFecha2, "Turista no ha nacido");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		}
		assertThrows(TuristaNoHaNacido.class, ()->{IctrInsc.inscribir("Turista no ha nacido", "Degusta Agosto", 1, auxFecha, "Degusta");});
	}
	
	@Test
	void actualizarDatosProveedorOk() throws UsuarioNoExisteException {
		Date auxFecha = new Date(2010,8,20);
		IctrAlta.actualizarDatosProveedor("meche","meche@colonia.gub.uy","Carmen","Venn",auxFecha,"Carmen la proveedora",null,false);
		DataUsuario dUsuario = IctrAlta.verInfoUsuario("meche");
		assertEquals(dUsuario.getNombre(),"Carmen");
		assertEquals(dUsuario.getApellido(),"Venn");
		assertEquals(dUsuario.getMail(),"meche@colonia.gub.uy");
		assertEquals(((DataProveedor) dUsuario).getDescripcion(),"Carmen la proveedora");
		assertEquals(((DataProveedor) dUsuario).getLink(),null);
		//assertEquals(((DataProveedor) dUsuario).getHayLink(),false);
		assertEquals(dUsuario.getNacimiento().getDate(),auxFecha.getDate());
		assertEquals(dUsuario.getNacimiento().getMonth(),auxFecha.getMonth());
		assertEquals(dUsuario.getNacimiento().getYear(),auxFecha.getYear());
	}

	@Test
	void testGetUsuarios()  {
		DataUsuario[] datosUsuario;
		try {
			Date fechaN = new Date(2002,6,4);
			try {
				IctrAlta.confirmarAltaTurista("jorgito", "Jorge","Perez", "jorgito@mail.com", fechaN, "chilena");
			} catch (UsuarioRepetidoException e) {
				// TODO Auto-generated catch block
				fail(e.getMessage());
				e.printStackTrace();
			}
			datosUsuario = IctrAlta.getUsuarios();
			int i=0;
			boolean encontrado = false;			
			while(i<datosUsuario.length && !encontrado) {
				if(datosUsuario[i].getNick() == "jorgito") {
					encontrado=true;
				}else
					i++;
			}
			assertEquals(datosUsuario[i].getNick(),"jorgito");
			assertEquals(datosUsuario[i].getNombre(),"Jorge");
			assertEquals(datosUsuario[i].getApellido(),"Perez");
			assertEquals(datosUsuario[i].getMail(),"jorgito@mail.com");
			assertEquals(datosUsuario[i].getNacimiento(),fechaN);
			assertEquals(((DataTurista) datosUsuario[i]).getNacionalidad(),"chilena");
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	//VER ESTE TEST quiero que la salida sea la excepcion
		/*@Test
		void registrarSalidaErronea () throws FechaAltaSalidaAnteriorActividad, SalidaYaExisteExeption {
			Date salidaF = new Date(2000,6,30);
			Date altaF = new Date(2000,6,22);
			Date hora = new Date();
			hora.setHours(10);
			hora.setMinutes(0);
			try {
				IctrAlta.confirmarAltaSalida( "Degusta", "salidaNueva", salidaF, hora, "placita", 10, altaF);
			} catch (FechaAltaSalidaInvalida e) {
				fail(e.getMessage());
				e.printStackTrace();
			}

			//Assertions.assertThrows(FechaAltaSalidaAnteriorActividad.class, IctrAlta.confirmarAltaSalida( "Degusta", "salidaNueva", salidaF, hora, "placita", 10, altaF));
		   
			//assertThrows(FechaAltaSalidaAnteriorActividad.class, ()->{IctrAlta.confirmarAltaSalida( "Degusta", "salidaNueva", salidaF, hora, "placita", 10, altaF));});
		}*/
	/*

	@Test
	void testConfirmarAltaDepartamento() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	void testConfirmarAltaSalida() {
		Date auxi = new Date(2023,6,20);
		Date auxi2 = new Date(2023,6,21);
		Date auxi3 = new Date(0,0,0,1,2);
		try {
			IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha", auxi2, auxi3, "algun lugar", 1, auxi);
		} catch (SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testConfirmarAltaSalidaYaExiste() {
		Date auxi = new Date(2023,6,20);
		Date auxi2 = new Date(2023,6,21);
		Date auxi3 = new Date(0,0,0,1,2);
		assertThrows(SalidaYaExisteExeption.class, ()->{IctrAlta.confirmarAltaSalida("Degusta", "Degusta Agosto", auxi2, auxi3, "algun lugar", 1, auxi);});
	}
	
	@Test
	void testConfirmarAltaSalidaFechaAlta() {
		Date auxi = new Date(2023,6,20);
		Date auxi2 = new Date(2023,6,21);
		Date auxi3 = new Date(0,0,0,1,2);
		assertThrows(FechaAltaSalidaInvalida.class, ()->{IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha con fecha mal", auxi, auxi3, "algun lugar", 1, auxi2);});
	}
	
	@Test
	void testConfirmarAltaSalidaFechaActividad() {
		Date auxi = new Date(100,6,20);
		Date auxi2 = new Date(100,6,21);
		Date auxi3 = new Date(0,0,0,1,2);
		assertThrows(FechaAltaSalidaAnteriorActividad.class, ()->{IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha con fecha anterior a Actividad", auxi2, auxi3, "algun lugar", 1, auxi);});
	}
	
	@Test
	void testListarPaquetes() {
		String[] aux = IctrInsc.listarPaquetes();
		boolean bandera = false;
		for (int i = 0; i<aux.length;i++) {
			bandera = bandera || (aux[i].equals("Disfrutar Rocha"));
		}
		assertEquals(bandera, true);
	}
	
	@Test
	void listarDepartamentos() {
		try {
			DataDepartamento[] aux = IctrAlta.obtenerDataDepartamentos();
			int i = 0;
			while(i<aux.length && !(aux[i].getNombre().equals("Colonia"))){
				i++;
			}
			assertEquals(aux[i].getNombre(),"Colonia");
			assertEquals(aux[i].getUrl(),"https://colonia.gub.uy/turismo/");
		} catch (DepartamentoNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testExepcionRegistrarTuristaRepetido() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.confirmarAltaTurista("elsantive","elsantive","sfhuafhbna","santimail",auxi,"uruguaya");
		} catch (UsuarioRepetidoException e) {

		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()->{IctrAlta.confirmarAltaTurista("elsantive","elsantive","sfhuafhbna","santimail",auxi,"uruguaya");});	
	}
	
	@Test
	void testExepcionRegistrarTuristaRepetidoMail() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.confirmarAltaTurista("elsantive","elsantive","sfhuafhbna","santimail",auxi,"uruguaya");
		} catch (UsuarioRepetidoException e) {

		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()->{IctrAlta.confirmarAltaTurista("elsantiv","elsantive","sfhuafhbna","santimail",auxi,"uruguaya");});	
	}
	
	@Test
	void testExepcionRegistrarProveedorRepetido() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.confirmarAltaProveedor("santi","santiago","veiga","sssaa@mail",auxi,"proveedor","sv.com",true);
		} catch (UsuarioRepetidoException e) {
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()->{IctrAlta.confirmarAltaProveedor("santi","santiago","veiga","sssaaa@mail",auxi,"proveedor","sv.com",true);});	
	}
	
	@Test
	void testExepcionRegistrarProveedorRepetidoMail() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.confirmarAltaProveedor("santiOtroNick1","santiago","veiga","sssa@mail",auxi,"proveedor","sv.com",true);
		} catch (UsuarioRepetidoException e) {
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()->{IctrAlta.confirmarAltaProveedor("santiOtroNick","santiago","veiga","sssa@mail",auxi,"proveedor","sv.com",true);});	
	}
	
	@Test
	void testExepcionDepartamentoRepetido() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.confirmarAltaDepartamento("muertevideo", "d", "www.muertevideo.com.uy");
		} catch (DepartamentoYaExisteExeption e) {

		};
		//esta es la prueba
		assertThrows(DepartamentoYaExisteExeption.class, ()->{IctrAlta.confirmarAltaDepartamento("muertevideo", "d", "www.muertevideo.com.uy");});	
	}
	
	@Test
	void testExepcionPaqueteRepetido() {
		Date auxi = new Date(2000,6,20);
		try {
			IctrAlta.altaPaquete("pakete", "pakete coso", 5, 5, auxi);
		} catch (PaqueteRepetidoException e) {

		};
		//esta es la prueba
		assertThrows(PaqueteRepetidoException.class, ()->{IctrAlta.altaPaquete("pakete", "pakete coso", 5, 5, auxi);});	
	}

	
	@Test
	void testCargarInscSelecDpto()  {
		Set<DataActividad> se = IctrInsc.selecDepartamento("Rocha");
		boolean res = false;
		for(DataActividad it : se) {
			res = res || (it.getCiudad().equals("Rocha") && it.getCosto()==800 && it.getNombre().equals("Degusta"));
		}
		assertEquals(true,res);
	}
	
	@Test
	void testCargarInscSalidas()  {
		Set<DataSalida> sed;
		try {
			sed = IctrInsc.salidas("Degusta");
			boolean res = false;
			for(DataSalida it : sed) {
				res = res || (it.getCant()==20 && it.getNombre().equals("Degusta Agosto"));
			}
			assertEquals(true,res);
		} catch (ActividadNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testListarDptos() {
		Set<DataDepartamento> sed = IctrInsc.listarDepartamentos();
		boolean res = false;
		for(DataDepartamento it : sed) {
			res = res || (it.getUrl().equals("https://montevideo.gub.uy/areas-tematicas/turismo") && it.getNombre().equals("Montevideo"));
		}
		assertEquals(true,res);
	}
	
	@Test
	void testactnoenpaq() {
		Set<DataActividad> aux = IctrInsc.actividadesPorDepartamentoNoEnPaquete("Rocha","Un día en Colonia");
		boolean res = false;
		for(DataActividad it : aux) {
			res = res || (it.getNombre().equals("Degusta"));
		}
		assertEquals(res,true);
	}
	
	@Test
	void testGetusu()
	{
		DataUsuario dt = IctrCons.ingresarDatos("lachiqui");
		assertEquals(dt.getNick(),"lachiqui");
	}
	
	@Test
	void testGetdptoscons() throws DepartamentoNoExisteException {
		DataDepartamento[] aux = IctrCons.obtenerDataDepartamentos();
		boolean res = false;
		for(DataDepartamento it : aux) {
			res = res || (it.getNombre().equals("Canelones")&&it.getDescripcion().equals("División Turismo de la Intendencia")&&it.getUrl().equals("https://www.imcanelones.gub.uy/es"));
		}
		assertEquals(res,true);
	}
	
	@Test
	void testListPaqs() {
		String[] aux = IctrCons.listarPaquetes();
		boolean res = false;
		for(String it : aux) {
			res = res || (it.equals("Disfrutar Rocha"));
		}
		assertEquals(res,true);
	}
	
	@Test
	void testDatapaq() {
		DataPaquete dt = IctrCons.obtenerDataPaquete("Disfrutar Rocha");
		assertEquals(dt.getNombre().equals("Disfrutar Rocha"),true);
		assertEquals(dt.getDescripcion().equals("Actividades para hacer en familia y disfrutar arte y gastronomía"),true);
		assertEquals(dt.getDescuento(),20);
		assertEquals(dt.getValidez(),60);
	}
	
	@Test
	void testDTAct() {
		Set<DataActividad> aux = IctrInsc.selecDepartamento("Rocha");
		boolean res = false;
		for(DataActividad it : aux) {
			res = res || (it.HaySalidas()&&it.HayPaquetes()&&it.getCiudad().equals("Rocha"));
		}
		assertEquals(res,true);
	}
	

}
