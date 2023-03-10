package test;
//package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoExisteCategoriaException;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.SalidasNoExisteException;
import excepciones.SalidasVigentesException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.Actividad;
import logica.CompAnioDataBuscar;
import logica.CompNomDataBuscar;
import logica.CompVisitas;
import logica.CompraGeneral;
import logica.DataActividad;
import logica.DataCompraGeneral;
import logica.DataCompraPaquete;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataProveedor;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.DataVisitas;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;
import logica.InscripcionesPK;
import logica.Paquete;
import logica.Proveedor;
import logica.Salida;
import logica.Turista;
import logica.Usuario;
import logica.estadoAct;
import manejadores.ManejadorActividad;

class ControladorAltaTest {
	
	private static IControladorAlta IctrAlta;
	private static IControladorConsulta IctrCons;
	private static IControladorInsc IctrInsc;
	private static ManejadorActividad ManejadorActividades ; 
	
	@BeforeAll
	public static void iniciar() throws DepartamentoYaExisteExeption {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager entM = emf.createEntityManager();
		EntityTransaction txn = entM.getTransaction();
		txn.begin();
    	Query query = entM.createQuery("SELECT cg FROM CompraGeneral cg JOIN cg.turista t WHERE t.nickname = :nick");
    	query.setParameter("nick", "TurNickBase");
    	List<CompraGeneral> listaCG = query.getResultList();
    	for (CompraGeneral iter : listaCG) {
			entM.remove(iter);
    	}
		query = entM.createQuery("SELECT t FROM Turista t WHERE t.nickname = :turNick");
		query.setParameter("turNick", "TurNickBase");
		try {
			Turista tur = (Turista) query.getSingleResult();
			entM.remove(tur);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT s FROM Salida s WHERE s.nombre = :salNom");
		query.setParameter("salNom", "SalNombreBase");
		try {
			Salida sal = (Salida) query.getSingleResult();
			entM.remove(sal);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT s FROM Salida s WHERE s.nombre = :salNom");
		query.setParameter("salNom", "SalNombreBase2");
		try {
			Salida sal2 = (Salida) query.getSingleResult();
			entM.remove(sal2);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :actNom");
		query.setParameter("actNom", "ActNombreBase");
		try {
			Actividad act = (Actividad) query.getSingleResult();
			entM.remove(act);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :actNom");
		query.setParameter("actNom", "ActNombreBase2");
		try {
			Actividad act2 = (Actividad) query.getSingleResult();
			entM.remove(act2);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :actNom");
		query.setParameter("actNom", "ActNombreBase3");
		try {
			Actividad act3 = (Actividad) query.getSingleResult();
			entM.remove(act3);
		} catch (NoResultException e) {
			;
		}
		query = entM.createQuery("SELECT p FROM Proveedor p WHERE p.nickname = :provNick");
		query.setParameter("provNick", "ProvNickBase");
		try {
			Proveedor prov = (Proveedor) query.getSingleResult();
			entM.remove(prov);
		} catch (NoResultException e) {
			;
		}
		txn.commit();
		entM.close();
		emf.close();
		Fabrica fabrica = Fabrica.getInstance();
		IctrAlta = fabrica.getIControladorAlta();
		IctrCons = fabrica.getIControladorConsulta();
		IctrInsc = fabrica.getIControladorInsc();
		ManejadorActividades = ManejadorActividad.getInstance();
		assertThrows(DepartamentoNoExisteException.class, ()-> {
			IctrCons.obtenerDataDepartamentos(); });
		assertThrows(NoExisteCategoriaException.class, ()-> {
			IctrAlta.obtenerNombreCategorias(); });
		assertThrows(PaqueteNoExisteException.class, ()-> {
			IctrInsc.comprarPaquete(null, null, 0, ""); });
			try {
				IctrAlta.cargarDatos();
			} catch (NumberFormatException | IOException | UsuarioRepetidoException | ParseException
					| DepartamentoYaExisteExeption | ActividadRepetidaException | UsuarioNoExisteException
					| ProveedorNoNacidoException | SalidaYaExisteExeption | PaqueteRepetidoException
					| FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad | TuristaConSalida | ExcedeTuristas
					| InscFechaInconsistente | ActividadNoExisteException | InscFechaDespSalida | TuristaNoHaNacido
					| NoHayCuposException | PaqueteNoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			Date auxi = new Date(2000, 6, 20);
			IctrAlta.confirmarAltaTurista("lucasnick", "lucas", "pode", "lucasmail", auxi, "uruguaya", "contraLucas");
			DataUsuario dusuarios = IctrAlta.verInfoUsuario("lucasnick");
			assertEquals(dusuarios.getNombre(), "lucas");
			assertEquals(dusuarios.getApellido(), "pode");
			assertEquals(dusuarios.getMail(), "lucasmail");
			assertEquals(((DataTurista) dusuarios).getNacionalidad(), "uruguaya");
			assertEquals(dusuarios.getNacimiento().getDate(), auxi.getDate());
			assertEquals(dusuarios.getNacimiento().getMonth(), auxi.getMonth());
			assertEquals(dusuarios.getNacimiento().getYear(), auxi.getYear());
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		}
		catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testconsincs() {
		DataUsuario[] aux = IctrInsc.listarUsuarios();
		boolean res = aux.length != 0;
		assertEquals(true, res);
		Set<String> elset = IctrInsc. listarActividadesAgregadas();
		res = elset.size() != 0;
		assertEquals(true, res);
		String[] ppaqs =  IctrInsc.listarPaquetesNoComprados();
		res = ppaqs.length != 0;
		assertEquals(true, res);
		String[] paqs =  IctrInsc.obtenerPaquetesComprados("lachiqui") ;
		res = paqs.length != 0;
		assertEquals(true, res);
		try {
			String qwer  = IctrInsc.obtenerNomActPorSalida("Degusta Agosto");
			res = qwer.equals("Degusta");
			assertEquals(true, res);
		} catch (SalidasNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDataActividad() {
		DataActividad aux = new DataActividad();
		aux.setCiudad("");
		aux.setCosto(0);
		aux.setDepartamento("");
		aux.setDescripcion("");
		aux.setDuracion(0);
		aux.setEstado(estadoAct.confirmada);
		aux.setFechaAlta(new Date());
		aux.setImagen(null);
		aux.setNombre("");
		aux.setCategorias(null);
		aux.setPaquetes(null);
		aux.setSalidas(null);
		assertEquals(aux.getNombre(), "");
		assertEquals(aux.getCiudad(), "");
		assertEquals(aux.getDepartamento(), "");
		assertEquals(aux.getDescripcion(), "");
		assertEquals(aux.getCosto(), 0);
		assertEquals(aux.getDuracion(), 0);
		assertEquals(aux.getEstado(), estadoAct.confirmada);
		assertEquals(aux.getImagen(), null);
		assertEquals(aux.getCategorias(), null);
		assertEquals(aux.getPaquetes(), null);
		assertEquals(aux.getSalidas(), null);
	}
	
	@Test
	void testUsusComp() {
		try {
			DataUsuario[] aux = IctrAlta.getUsuariosComp();
			boolean res = aux.length != 0;
			assertEquals(res, true);
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDTDepto() {
		DataDepartamento aux = new DataDepartamento();
		aux.setColAct(null);
		aux.setDescripcion(null);
		aux.setNombre(null);
		aux.setUrl(null);
		assertEquals(aux.getColAct(), null);
		assertEquals(aux.getDescripcion(), null);
		assertEquals(aux.getNombre(), null);
		assertEquals(aux.getUrl(), null);
	}
	
	@Test
	void testNomCat() {
		try {
			Set<String> aux = IctrAlta.obtenerNombreCategorias();
			boolean res = aux.size() != 0;
			assertEquals(res, true);
			IctrAlta.confirmarAltaTurista("", "", "", "", new Date(), "", "");
			DataUsuario auxi = IctrCons.obtenerDataUsuarioMail("");
			res = auxi.getMail().equals("");
			assertEquals(res, true);
		} catch (NoExisteCategoriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDataSalida() {
		Date fecha = new Date();
		DataSalida aux = new DataSalida();
		aux = new DataSalida("", "", fecha, fecha, fecha, 0, 0);
		aux.setCant(0);
		aux.setFecha(fecha);
		aux.setHora(fecha);
		aux.setLugar("");
		aux.setFechaAlta(fecha);
		aux.setNombre("");
		assertEquals(aux.getNombre(), "");
		assertEquals(aux.getLugar(), "");
		assertEquals(aux.getFecha(), fecha);
		assertEquals(aux.getFechaAlta(), fecha);
		assertEquals(aux.getHora(), fecha);
		assertEquals(aux.gethora(), fecha);
	}
	
	@Test
	void testListarUsuarios() {
	
		DataUsuario[] aux = IctrCons.listarUsuarios();
		boolean res1 = false;
		boolean res2 = false;
		for (DataUsuario it:aux) {
			if (it instanceof DataTurista) {
				res1 = res1 || it.getApellido().equals("Windsor")&&it.getMail().equals("isabelita@thecrown.co.uk")&&it.getNombre().equals("Elizabeth")&&it.getNick().equals("isabelita")&&((DataTurista) it).getNacionalidad().equals("inglesa");
			}
			else if (it instanceof DataProveedor) {
				res2 = res2 || it.getApellido().equals("Rocha")&&it.getMail().equals("washington@turismorocha.gub.uy")&&it.getNombre().equals("Washington")&&it.getNick().equals("washington")&&((DataProveedor) it).getLink().equals("http://turismorocha.gub.uy/");
			}
		}
		assertEquals(res1, true);
		assertEquals(res2, true);
	}
	
	@Test
	void testExepcionUsuariosNoExisten() {
		assertThrows(UsuarioNoExisteException.class, ()-> {
			IctrAlta.verInfoUsuario("nickquenoexiste"); });	
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
		assertEquals(((DataProveedor) aux4).getLink(), "http://turismorocha.gub.uy/");
		assertEquals(aux4.getApellido(), "Rocha");
		assertEquals(aux4.getMail(), "washington@turismorocha.gub.uy");
		assertEquals(aux4.getNombre(), "Washington");
		assertEquals(aux4.getNick(), "washington");
		
		
		assertEquals(aux5.getApellido().equals("Bengoechea") && aux5.getMail().equals("eldiez@socfomturriv.org.uy") && aux5.getNombre().equals("Pablo")&&aux5.getNick().equals("eldiez")&&((DataProveedor) aux5).getLink().equals("http://wwww.socfomturriv.org.uy"), true);
		//turista
		assertEquals(aux3.getApellido().equals("Esponja")&&aux3.getMail().equals("bobesponja@nickelodeon.com")&&aux3.getNombre().equals("Bob")&&aux3.getNick().equals("bobesponja")&&((DataTurista) aux3).getNacionalidad().equals("japonesa"), true);
		assertEquals(aux2.getApellido(), "Lecter");
		assertEquals(aux2.getMail(), "anibal@fing.edu.uy");
		assertEquals(aux2.getNombre(), "Anibal");
		assertEquals(aux2.getNick(), "anibal");
		assertEquals(((DataTurista) aux2).getNacionalidad(), "lituana");
		
		assertEquals(((DataTurista) aux).getNacionalidad(), "inglesa");
		assertEquals(aux.getApellido(), "Windsor");
		assertEquals(aux.getMail(), "isabelita@thecrown.co.uk");
		assertEquals(aux.getNombre(), "Elizabeth");
		assertEquals(aux.getNick(), "isabelita");
	
	}


	@Test
	void testConfirmarAltaProveedor() {
		try {
			Date auxi = new Date(2000, 6, 20);
			IctrAlta.confirmarAltaProveedor("agus", "Agustin", "de Leon", "a@mail", auxi, "Un proveedor", "link", true, "contraAgus");
			DataUsuario dusuarios = IctrAlta.verInfoUsuario("agus");
			assertEquals(dusuarios.getNombre(), "Agustin");
			assertEquals(dusuarios.getApellido(), "de Leon");
			assertEquals(dusuarios.getMail(), "a@mail");
			assertEquals(((DataProveedor) dusuarios).getDescripcion(), "Un proveedor");
			assertEquals(((DataProveedor) dusuarios).getLink(), "link");
			assertEquals(dusuarios.getNacimiento().getDate(), auxi.getDate());
			assertEquals(dusuarios.getNacimiento().getMonth(), auxi.getMonth());
			assertEquals(dusuarios.getNacimiento().getYear(), auxi.getYear());
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
	void testDTCompGen() {
		DataSalida sal = new DataSalida();
		Date auxi = new Date(2023, 6, 20);
		DataCompraGeneral aux = new DataCompraGeneral(auxi, 0, 0, sal);
		assertEquals(aux.getCantidad(), 0);
		assertEquals(aux.getCosto(), 0);
		assertEquals(aux.getFecha().compareTo(auxi), 0);
		assertEquals(aux.getSalida(), sal);
		assertEquals(aux.isPorPaquete(), false);
	}
	
	@Test
	void testDTPaq() {
		DataPaquete aux = new DataPaquete(null, null, 0, null, 0, null);
		assertEquals(aux.getDescripcion(), null);
		assertEquals(aux.getNombre(), null);
		assertEquals(aux.getDescuento(), 0);
		assertEquals(aux.getDtAct(), null);
		assertEquals(aux.getValidez(), 0);
		assertEquals(aux.getFechaAlta(), null);
	}
	
	@Test
	void testDTUsu() {
		DataUsuario aux = new DataUsuario(null, null, null, null, null);
		aux.setApellido(null);
		aux.setImagen(null);
		aux.setMail(null);
		aux.setNacimiento(null);
		aux.setNick(null);
		aux.setNombre(null);
		aux.setPassword(null);
		assertEquals(aux.getApellido(), null);
		assertEquals(aux.getNombre(), null);
		assertEquals(aux.getPassword(), null);
		assertEquals(aux.getImagen(), null);
		assertEquals(aux.getNick(), null);
		assertEquals(aux.getMail(), null);
		assertEquals(aux.getNacimiento(), null);
	}
	
	@Test
	void testexceppciionesvarias(){
		assertThrows(UsuarioNoExisteException.class, ()-> {
			IctrCons.obtenerDataUsuarioNick("usuInex"); });
		assertThrows(UsuarioNoExisteException.class, ()-> {
			IctrCons.obtenerDataUsuarioMail("usuInex"); });
		assertThrows(ActividadNoExisteException.class, ()-> {
			IctrCons.obtenerDataActividad("actInex"); });
		assertThrows(SalidasNoExisteException.class, ()-> {
			IctrCons.obtenerDataSalida("salInex"); });
	}
	
	@Test
	void testCategExiste() {
		try {
			IctrAlta.registrarCategoria("CategoriaP");
			Set<String> categs =  IctrCons.obtenerNombreCategorias();
			boolean res = false;
			for  (String iter : categs) {
				res = res || (iter.equals("CategoriaP"));
			}
			assertEquals(res, true);
			DataActividad[] array = IctrCons.obtenerActividadCategoria("CategoriaP");
			assertEquals(array.length, 0);
		} catch (CategoriaYaExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(CategoriaYaExiste.class, ()-> {
			IctrAlta.registrarCategoria("CategoriaP"); });
	}

	@Test
	void testRegistrarActividad() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.registrarCategoria("Categoria");
			Set<String> auxCat = new HashSet<String>();
			auxCat.add("Categoria");
			IctrAlta.confirmarAltaDepartamento("parasaindu", "d", "www.parasaindu.com.uy");
			IctrAlta.registrarActividad("parasaindu", "Bici", "Bici", 1, 200, "Ciudad de la costa", auxi, "eldiez", auxCat, "", false);
			Actividad ActividadRegistrada = ManejadorActividades.getActividad("Bici") ; 
			assertEquals(ActividadRegistrada.getDepartamento().getNombre(), "parasaindu");
			assertEquals(ActividadRegistrada.getNombre(), "Bici");
			assertEquals(ActividadRegistrada.getDescripcion(), "Bici");
			assertEquals(ActividadRegistrada.getFechaAlta().getDate(), auxi.getDate());
			assertEquals(ActividadRegistrada.getFechaAlta().getMonth(), auxi.getMonth());
			assertEquals(ActividadRegistrada.getFechaAlta().getYear(), auxi.getYear());
			assertEquals(ActividadRegistrada.getDuracion(), 1);
			assertEquals(ActividadRegistrada.getCosto(), 200);
			assertEquals(ActividadRegistrada.getCiudad(), "Ciudad de la costa");
			assertEquals(ActividadRegistrada.getLink(), "");
			assertEquals(ActividadRegistrada.getHayLink(), false);
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
		} catch (CategoriaYaExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void registroActividadExcepcionProveedorNoNacido() {
		Date auxi = new Date(2000, 6, 20);
		Date auxi2 = new Date(2023, 6, 20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		try {
			IctrAlta.confirmarAltaProveedor("proveedorNoNacido", "proveedorNoNacido", "proveedorNoNacido", "proveedorNoNacido", auxi2, "proveedorNoNacido", "proveedorNoNacido", true, "proveedorContra");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		}
		assertThrows(ProveedorNoNacidoException.class, ()-> {
			IctrAlta.registrarActividad("Colonia", "ProveedorNoNacidoPruebaAct", "Bici", 1, 200, "Ciudad de la costa", auxi, "proveedorNoNacido", auxCat, null, false);;});
	}
	
	@Test
	void registroActividadExcepcionProveedor() {
		Date auxi = new Date(2000, 6, 20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		assertThrows(UsuarioNoExisteException.class, ()-> {
			IctrAlta.registrarActividad("Colonia", "Bicicleta", "Bici", 1, 200, "Ciudad de la costa", auxi, "nickquenopuedeexister", auxCat, null, false); ;});
	}
	
	@Test
	void registroActividadExcepcionYaExiste() {
		Date auxi = new Date(2000, 6, 20);
		Set<String> auxCat = new HashSet<String>();
		auxCat.add("Categoria");
		assertThrows(ActividadRepetidaException.class, ()-> {
			IctrAlta.registrarActividad("Rocha", "Degusta", "Bici", 1, 200, "Ciudad de la costa", auxi, "eldiez", auxCat, null, false);;});
	}
	
	@Test
	void actualizarDatosTuristaOk() {
		Date auxFecha = new Date(2000, 6, 20);
		IctrAlta.actualizarDatosTurista("chino", "chino@trico.org.uy", "Alexander", "Recoba", auxFecha, "uruguaya");
		DataUsuario dUsuario;
		try {
			dUsuario = IctrAlta.verInfoUsuario("chino");
			assertEquals(dUsuario.getNick(), "chino");
			assertEquals(dUsuario.getMail(), "chino@trico.org.uy");
			assertEquals(dUsuario.getNombre(), "Alexander");
			assertEquals(dUsuario.getApellido(), "Recoba");
			assertEquals(((DataTurista) dUsuario).getNacionalidad(), "uruguaya");
			assertEquals(dUsuario.getNacimiento().getDate(), auxFecha.getDate());
			assertEquals(dUsuario.getNacimiento().getMonth(), auxFecha.getMonth());
			assertEquals(dUsuario.getNacimiento().getYear(), auxFecha.getYear());
		} catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
		}
	}
	/*
	@Test       
	void inscribirExcYaTieneSalida() {
		Date auxFecha = new Date(130,8,20);
		assertThrows(TuristaConSalida.class, ()->{IctrInsc.inscribir("lachiqui", "Degusta Agosto", 1, auxFecha, "Degusta");});
	}
*/
	@Test
	void inscribirExcCantidadTuristas() {
		Date auxFecha = new Date(130, 8, 20);
		assertThrows(ExcedeTuristas.class, ()-> {
			IctrInsc.inscribir("chino", "Degusta Agosto", 1000000, auxFecha, "Degusta"); });
	}
	
	@Test
	void inscribirExcFechaAntAlta() {
		Date auxFecha = new Date(100, 8, 20);
		assertThrows(InscFechaInconsistente.class, ()-> {
			IctrInsc.inscribir("chino", "Degusta Agosto", 1, auxFecha, "Degusta"); });
	}
	
	@Test
	void inscribirExcFechaPostSalida() {
		Date auxFecha = new Date(130, 8, 20);
		assertThrows(InscFechaDespSalida.class, ()-> {
			IctrInsc.inscribir("chino", "Degusta Agosto", 1, auxFecha, "Degusta"); });
	}
	
	@Test
	void inscribirTuristaNoHaNacido() {
		Date auxFecha = new Date(122, 7, 19);
		Date auxFecha2 = new Date(1000, 8, 20);
		try {
			IctrAlta.confirmarAltaTurista("Turista no ha nacido", "Turista no ha nacido", "Turista no ha nacido", "Turista no ha nacido", auxFecha2, "Turista no ha nacido", "Turista no ha nacido");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		}
		assertThrows(TuristaNoHaNacido.class, ()-> {
			IctrInsc.inscribir("Turista no ha nacido", "Degusta Agosto", 1, auxFecha, "Degusta"); });
	}
	
	@Test
	void actualizarDatosProveedorOk() throws UsuarioNoExisteException {
		Date auxFecha = new Date(2010, 8, 20);
		IctrAlta.actualizarDatosProveedor("meche", "meche@colonia.gub.uy", "Carmen", "Venn", auxFecha, "Carmen la proveedora", null, false);
		DataUsuario dUsuario = IctrAlta.verInfoUsuario("meche");
		assertEquals(dUsuario.getNombre(), "Carmen");
		assertEquals(dUsuario.getApellido(), "Venn");
		assertEquals(dUsuario.getMail(), "meche@colonia.gub.uy");
		assertEquals(((DataProveedor) dUsuario).getDescripcion(), "Carmen la proveedora");
		assertEquals(((DataProveedor) dUsuario).getLink(), null);
		//assertEquals(((DataProveedor) dUsuario).getHayLink(),false);
		assertEquals(dUsuario.getNacimiento().getDate(), auxFecha.getDate());
		assertEquals(dUsuario.getNacimiento().getMonth(), auxFecha.getMonth());
		assertEquals(dUsuario.getNacimiento().getYear(), auxFecha.getYear());
	}
	
	@Test
	void testDTComPaq() {
		DataCompraPaquete aux = new DataCompraPaquete(null, 0, 0, null, null, null);
		assertEquals(aux.getFecha(), null);
		assertEquals(aux.getPaq(), null);
		assertEquals(aux.getRestAct(), null);
		assertEquals(aux.getVencimiento(), null);
		assertEquals(aux.getCantidad(), 0);
		assertEquals(aux.getCosto(), 0);
	}

	@Test
	void testGetUsuarios()  {
		DataUsuario[] datosUsuario;
		try {
			Date fechaN = new Date(2002, 6, 4);
			try {
				IctrAlta.confirmarAltaTurista("jorgito", "Jorge", "Perez", "jorgito@mail.com", fechaN, "chilena", "jorgito contra");
			} catch (UsuarioRepetidoException e) {
				// TODO Auto-generated catch block
				fail(e.getMessage());
				e.printStackTrace();
			}
			datosUsuario = IctrAlta.getUsuarios();
			int cont=0;
			boolean encontrado = false;			
			while (cont<datosUsuario.length && !encontrado) {
				if (datosUsuario[cont].getNick() == "jorgito") {
					encontrado=true;
				}else
					cont++;
			}
			assertEquals(datosUsuario[cont].getNick(), "jorgito");
			assertEquals(datosUsuario[cont].getNombre(), "Jorge");
			assertEquals(datosUsuario[cont].getApellido(), "Perez");
			assertEquals(datosUsuario[cont].getMail(), "jorgito@mail.com");
			assertEquals(datosUsuario[cont].getNacimiento(), fechaN);
			assertEquals(((DataTurista) datosUsuario[cont]).getNacionalidad(), "chilena");
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
		Date auxi = new Date(2023, 6, 20);
		Date auxi2 = new Date(2023, 6, 21);
		Date auxi3 = new Date(0, 0, 0, 1, 2);
		try {
			IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha", auxi2, auxi3, "algun lugar", 1, auxi);
		} catch (SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testConfirmarAltaSalidaYaExiste() {
		Date auxi = new Date(2023, 6, 20);
		Date auxi2 = new Date(2023, 6, 21);
		Date auxi3 = new Date(0, 0, 0, 1, 2);
		assertThrows(SalidaYaExisteExeption.class, ()-> {
			IctrAlta.confirmarAltaSalida("Degusta", "Degusta Agosto", auxi2, auxi3, "algun lugar", 1, auxi); });
	}
	
	@Test
	void testConfirmarAltaSalidaFechaAlta() {
		Date auxi = new Date(2023, 6, 20);
		Date auxi2 = new Date(2023, 6, 21);
		Date auxi3 = new Date(0, 0, 0, 1, 2);
		assertThrows(FechaAltaSalidaInvalida.class, ()-> {
			IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha con fecha mal", auxi, auxi3, "algun lugar", 1, auxi2); });
	}
	
	@Test
	void testConfirmarAltaSalidaFechaActividad() {
		Date auxi = new Date(100, 6, 20);
		Date auxi2 = new Date(100, 6, 21);
		Date auxi3 = new Date(0, 0, 0, 1, 2);
		assertThrows(FechaAltaSalidaAnteriorActividad.class, ()-> {
			IctrAlta.confirmarAltaSalida("Degusta", "Salidita por Rocha con fecha anterior a Actividad", auxi2, auxi3, "algun lugar", 1, auxi); });
	}
	
	@Test
	void testListarPaquetes() {
		String[] aux = IctrInsc.listarPaquetes();
		boolean bandera = false;
		for (int i = 0; i<aux.length; i++) {
			bandera = bandera || (aux[i].equals("Disfrutar Rocha"));
		}
		assertEquals(bandera, true);
	}
	
	@Test
	void listarDepartamentos() {
		try {
			DataDepartamento[] aux = IctrAlta.obtenerDataDepartamentos();
			int cont = 0;
			while (cont<aux.length && !(aux[cont].getNombre().equals("Colonia"))){
				cont++;
			}
			assertEquals(aux[cont].getNombre(), "Colonia");
			assertEquals(aux[cont].getUrl(), "https://colonia.gub.uy/turismo/");
		} catch (DepartamentoNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testExepcionRegistrarTuristaRepetido() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.confirmarAltaTurista("elsantive", "elsantive", "sfhuafhbna", "santimail", auxi, "uruguaya", "contra");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()-> {
			IctrAlta.confirmarAltaTurista("elsantive", "elsantive", "sfhuafhbna", "santimail", auxi, "uruguaya", "contra"); });	
	}
	
	@Test
	void testExepcionRegistrarTuristaRepetidoMail() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.confirmarAltaTurista("nickTest", "nombreTest", "apTest", "mailTest", auxi, "uruguaya", "contra");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()-> {
			IctrAlta.confirmarAltaTurista("nickTest", "nombreTest", "apTest", "mailTest", auxi, "uruguaya", "contra"); });	
	}
	
	@Test
	void testExepcionRegistrarProveedorRepetido() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.confirmarAltaProveedor("santi", "santiago", "veiga", "sssaa@mail", auxi, "proveedor", "sv.com", true, "contra");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()-> {
			IctrAlta.confirmarAltaProveedor("santi", "santiago", "veiga", "sssaaa@mail", auxi, "proveedor", "sv.com", true, "contra"); });	
	}
	
	@Test
	void testExepcionRegistrarProveedorRepetidoMail() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.confirmarAltaProveedor("santiOtroNick1", "santiago", "veiga", "sssa@mail", auxi, "proveedor", "sv.com", true, "contra");
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(UsuarioRepetidoException.class, ()-> {
			IctrAlta.confirmarAltaProveedor("santiOtroNick", "santiago", "veiga", "sssa@mail", auxi, "proveedor", "sv.com", true, "contra"); });	
	}
	
	@Test
	void testExepcionDepartamentoRepetido() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.confirmarAltaDepartamento("muertevideo", "d", "www.muertevideo.com.uy");
		} catch (DepartamentoYaExisteExeption e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(DepartamentoYaExisteExeption.class, ()-> {
			IctrAlta.confirmarAltaDepartamento("muertevideo", "d", "www.muertevideo.com.uy"); });	
	}
	
	@Test
	void testExepcionPaqueteRepetido() {
		Date auxi = new Date(2000, 6, 20);
		try {
			IctrAlta.altaPaquete("pakete", "pakete coso", 5, 5, auxi);
		} catch (PaqueteRepetidoException e) {
			fail(e.getMessage());
		};
		//esta es la prueba
		assertThrows(PaqueteRepetidoException.class, ()-> {
			IctrAlta.altaPaquete("pakete", "pakete coso", 5, 5, auxi); });	
	}

	
	@Test
	void testCargarInscSelecDpto()  {
		Set<DataActividad> dataActs = IctrInsc.selecDepartamento("Rocha");
		boolean res = false;
		for (DataActividad it : dataActs) {
			res = res || it.getCiudad().equals("Rocha") && it.getCosto()==800 && it.getNombre().equals("Degusta");
		}
		assertEquals(true, res);
	}
	
	@Test
	void testCargarInscSalidas()  {
		Set<DataSalida> sed;
		try {
			sed = IctrInsc.salidas("Degusta");
			boolean res = false;
			for (DataSalida it : sed) {
				res = res || it.getCant()==20 && it.getNombre().equals("Degusta Agosto");
			}
			assertEquals(true, res);
		} catch (ActividadNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testListarDptos() {
		Set<DataDepartamento> sed = IctrInsc.listarDepartamentos();
		boolean res = false;
		for (DataDepartamento it : sed) {
			res = res || it.getUrl().equals("https://montevideo.gub.uy/areas-tematicas/turismo") && it.getNombre().equals("Montevideo");
		}
		assertEquals(true, res);
	}
	
	@Test
	void testactnoenpaq() {
		Set<DataActividad> aux = IctrInsc.actividadesPorDepartamentoNoEnPaquete("Rocha", "Un d??a en Colonia");
		boolean res = false;
		for (DataActividad it : aux) {
			res = res || (it.getNombre().equals("Degusta"));
		}
		assertEquals(res, true);
	}
	
	@Test
	void testGetusu(){
		DataUsuario dataUsu = IctrCons.ingresarDatos("lachiqui");
		assertEquals(dataUsu.getNick(), "lachiqui");
	}
	
	@Test
	void testGetdptoscons() throws DepartamentoNoExisteException {
		DataDepartamento[] aux = IctrCons.obtenerDataDepartamentos();
		boolean res = false;
		for (DataDepartamento it : aux) {
			res = res || it.getNombre().equals("Canelones")&&it.getDescripcion().equals("Divisi??n Turismo de la Intendencia")&&it.getUrl().equals("https://www.imcanelones.gub.uy/es");
		}
		assertEquals(res, true);
	}
	
	@Test
	void testListPaqs() {
		String[] aux = IctrCons.listarPaquetes();
		boolean res = false;
		for (String it : aux) {
			res = res || (it.equals("Disfrutar Rocha"));
		}
		assertEquals(res, true);
	}
	
	@Test
	void testDatapaq() {
		DataPaquete dataPaq = IctrCons.obtenerDataPaquete("Disfrutar Rocha");
		assertEquals(dataPaq.getNombre().equals("Disfrutar Rocha"), true);
		assertEquals(dataPaq.getDescripcion().equals("Actividades para hacer en familia y disfrutar arte y gastronom??a"), true);
		assertEquals(dataPaq.getDescuento(), 20);
		assertEquals(dataPaq.getValidez(), 60);
	}
	
	@Test
	void testDTAct() {
		Set<DataActividad> aux = IctrInsc.selecDepartamento("Rocha");
		boolean res = false;
		for (DataActividad it : aux) {
			res = res || it.haySalidas()&&it.hayPaquetes()&&it.getCiudad().equals("Rocha");
		}
		assertEquals(res, true);
		
	}
	
	@Test
	void testExtras() {
		CompAnioDataBuscar aux = new CompAnioDataBuscar();
		try {
			assertEquals(aux.compare(IctrCons.obtenerDataActividad("Degusta"), IctrCons.obtenerDataActividad("Degusta")),0);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CompNomDataBuscar aux1 = new CompNomDataBuscar();
		try {
			assertEquals(aux.compare(IctrCons.obtenerDataActividad("Degusta"), IctrCons.obtenerDataActividad("Degusta")),0);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataVisitas aux2 = new DataVisitas(false, 0, null, null);
		assertEquals(aux2.getCantVis(),0);
		assertEquals(aux2.getNombre(),null);
		assertEquals(aux2.getProv(),null);
		assertEquals(aux2.isEsAct(),false);
		InscripcionesPK aux3 = new InscripcionesPK();
		CompVisitas aux4 = new CompVisitas();
		assertEquals(aux4.compare(aux2, aux2),0);
	}
	
	@Test void testObtenerDataActividad() {
		DataActividad dataAct;
		try {
			dataAct = IctrCons.obtenerDataActividad("Degusta");
			assertEquals("Rocha", dataAct.getCiudad());
		} catch (ActividadNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test void testObtenerDataSalida() {
		DataSalida dataSal;
		try {
			dataSal = IctrCons.obtenerDataSalida("Degusta Agosto");
			assertEquals("Sociedad Agropecuaria de Rocha", dataSal.getLugar());
			assertEquals("Degusta", IctrInsc.obtenerNomActPorSalida("Degusta Agosto"));
		} catch (SalidasNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test void dataTurista() {
		DataTurista dtur = new DataTurista(null, null, null, null, null, null, null, null, null, null, null);
		dtur.getActFavoritas();
		dtur.getSeguidores();
		dtur.getInscripcionesSal();
		dtur.getDataSalidas();
		dtur.getComprasPaq();
	}
	
	@Test void dataProveedor() {
		DataProveedor dprov = new DataProveedor(null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Test void dataPaquete() {
		Paquete paq = new Paquete("nombrePaq", null, 0, null, 0, null);
		DataPaquete dataPaq = paq.getDataP();
	}
	
	@Test void comparadorNombres() {
		DataActividad dataAct1 = new DataActividad("nom1", null, null, null, 0, 0, null, null, null, null, false, null, null, 0, 0, null);
		DataActividad dataAct2 = new DataActividad("nom2", null, null, null, 0, 0, null, null, null, null, false, null, null, 0, 0, null);
		DataPaquete dataPaq1 = new DataPaquete("nombrePa1", null, 0, null, 0, null);
		DataPaquete dataPaq2 = new DataPaquete("nombrePa1", null, 0, null, 0, null);
		DataActividad dataAct3 = new DataActividad();
		dataAct3.setCantFavs(0);
		CompNomDataBuscar cndb = new CompNomDataBuscar();
		cndb.compare(dataAct1, dataAct2);
		cndb.compare(dataAct2, dataAct1);
		cndb.compare(dataAct1, dataPaq2);
		cndb.compare(dataPaq1, dataAct2);
		cndb.compare(dataPaq2, dataPaq1);
		cndb.compare(dataPaq1, dataPaq2);
	}
	
	@Test void comparadorAnios() {
		Date fecha1 = new Date(1,1,1);
		Date fecha2 = new Date(2,2,2);
		Date fecha3 = new Date(3,3,3);
		Date fecha4 = new Date(4,4,4);
		DataActividad dataAct1 = new DataActividad("nom1", null, fecha1, null, 0, 0, null, null, null, null, false, null, null, 0, 0, null);
		DataActividad dataAct2 = new DataActividad("nom2", null, fecha2, null, 0, 0, null, null, null, null, false, null, null, 0, 0, null);
		DataPaquete dataPaq1 = new DataPaquete("nombrePa1", null, 0, fecha3, 0, null);
		DataPaquete dataPaq2 = new DataPaquete("nombrePa1", null, 0, fecha4, 0, null);
		DataActividad dataAct3 = new DataActividad();
		dataAct3.setCantFavs(0);
		CompAnioDataBuscar cadb = new CompAnioDataBuscar();
		cadb.compare(dataAct1, dataAct2);
		cadb.compare(dataAct2, dataAct1);
		cadb.compare(dataAct1, dataPaq2);
		cadb.compare(dataPaq1, dataAct2);
		cadb.compare(dataPaq2, dataPaq1);
		cadb.compare(dataPaq1, dataPaq2);
	}
	
	@Test void salidas() {
		Salida sal = new Salida(null, null, null, null, null, 0, null);
		sal.setVisitas(0);
		sal.incrementarVisitas();
	}
	
	@Test void seguirUsu() {
		Turista tur1 = new Turista("tur1", null, null, "tur1", null, null, null);
		Turista tur2 = new Turista("tur2", null, null, "tur2", null, null, null);
		Turista tur3 = new Turista("tur3", null, null, "tur3", null, null, null);
		try {
			tur1.seguirUsuario(tur2);
			tur2.agregarSeguidor(tur1);
			tur1.seguirUsuario(tur3);
			tur3.agregarSeguidor(tur1);
			tur2.eliminarSeguidor(tur1);
			tur1.dejarDeSeguirUsuario(tur2);
		} catch (UsuarioRepetidoException | UsuarioNoExisteException e) {
			fail(e.getMessage());
		}
	}
	
	@Test void modificar() {
		Date provDate = new Date(0,0,0);
		try {
			IctrAlta.confirmarAltaProveedor("ProvNickModificar", "ProvNom", "ProvApellido", "ProvMailModificar", provDate, "ProvDesc", "ProvLink", true, "ProvContra", null);
			Date turDate = new Date(0,0,0);
			IctrAlta.confirmarAltaTurista("TurNickModificar", "TurNom", "TurApellido", "TurMailModificar", turDate, "TurNacion", "TurContra", null);
			IctrAlta.actualizarDatosProveedor("ProvNickModificar", "ProvNom", "ProvApellido", "ProvMailModificar", provDate, "ProvDesc", "ProvLink", true, "ProvContra", new byte[0]);
			IctrAlta.actualizarDatosTurista("TurNickModificar", "TurNom", "TurApellido", "TurMailModificar", turDate, "TurNacion", "TurContra", new byte[0]);
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test void visitas() {
		try {
			IctrAlta.confirmarAltaDepartamento("DepNombreVisitas", "DepDesc", "DepUrl");
			IctrAlta.registrarCategoria("CatNombreVisitas");
			Date provDate = new Date(0,0,0);
			IctrAlta.confirmarAltaProveedor("ProvNickVisitas", "ProvNom", "ProvApellido", "ProvMailVisitas", provDate, "ProvDesc", "ProvLink", true, "ProvContra", null);
			Set<String> categorias = new HashSet<String>();
			categorias.add("CatNombreVisitas");
			Date actDate = new Date(1,0,0);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas2", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas3", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas4", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas5", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			IctrAlta.registrarActividad("DepNombreVisitas", "ActNombreVisitas6", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickVisitas", categorias, null, false);
			Date salDate = new Date(2,0,0);
			Date salDateH = new Date(0,0,0);
			Date salDate2 = new Date(4,0,0);			
			IctrAlta.confirmarAltaSalida("ActNombreVisitas", "SalNombreVisitas", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrAlta.confirmarAltaSalida("ActNombreVisitas2", "SalNombreVisitas2", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrAlta.confirmarAltaSalida("ActNombreVisitas", "SalNombreVisitas3", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrAlta.confirmarAltaSalida("ActNombreVisitas2", "SalNombreVisitas4", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrAlta.confirmarAltaSalida("ActNombreVisitas", "SalNombreVisitas5", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrAlta.confirmarAltaSalida("ActNombreVisitas2", "SalNombreVisitas6", salDate2, salDateH, "SalLugar", 5, salDate);
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas2");
			IctrCons.sumarVistaAAct("ActNombreVisitas2");
			IctrCons.sumarVistaAAct("ActNombreVisitas3");
			IctrCons.sumarVistaAAct("ActNombreVisitas3");
			IctrCons.sumarVistaAAct("ActNombreVisitas3");
			IctrCons.sumarVistaAAct("ActNombreVisitas3");
			IctrCons.sumarVistaAAct("ActNombreVisitas4");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaAAct("ActNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas2");
			IctrCons.sumarVistaASal("SalNombreVisitas2");
			IctrCons.sumarVistaASal("SalNombreVisitas2");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas2");
			IctrCons.sumarVistaASal("SalNombreVisitas3");
			IctrCons.sumarVistaASal("SalNombreVisitas3");
			IctrCons.sumarVistaASal("SalNombreVisitas3");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.sumarVistaASal("SalNombreVisitas4");
			IctrCons.sumarVistaASal("SalNombreVisitas4");
			IctrCons.sumarVistaASal("SalNombreVisitas");
			IctrCons.diezMasVisitadas();
		} catch (DepartamentoYaExisteExeption | UsuarioRepetidoException | CategoriaYaExiste | ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException | SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad | ActividadNoExisteException | SalidasNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testTur() {
		Turista tur = new Turista();
		tur.setNickname("");
		tur.setNombre("");
		tur.setMail("");
	}
	
	@Test
	void testBase() {
		Fabrica fab = Fabrica.getInstance();
		IControladorAlta iConAlta = fab.getIControladorAlta();
		IControladorInsc iConInsc = fab.getIControladorInsc();
		try {
			iConAlta.confirmarAltaDepartamento("DepNombreBase", "DepDesc", "DepUrl");
			iConAlta.registrarCategoria("CatNombreBase");
			Date provDate = new Date(0,0,0);
			iConAlta.confirmarAltaProveedor("ProvNickBase", "ProvNom", "ProvApellido", "ProvMailBase", provDate, "ProvDesc", "ProvLink", true, "ProvContra", null);
			Date turDate = new Date(0,0,0);
			iConAlta.confirmarAltaTurista("TurNickBase", "TurNom", "TurApellido", "TurMailBase", turDate, "TurNacion", "TurContra", null);
			Set<String> categorias = new HashSet<String>();
			categorias.add("CatNombreBase");
			Date actDate = new Date(1,0,0);
			iConAlta.registrarActividad("DepNombreBase", "ActNombreBase", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickBase", categorias, null, false);
			iConAlta.registrarActividad("DepNombreBase", "ActNombreBase2", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickBase", categorias, null, false);
			iConAlta.registrarActividad("DepNombreBase", "ActNombreBase3", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNickBase", categorias, null, false);
			Date salDate = new Date(2,0,0);
			Date salDateH = new Date(0,0,0);
			Date salDate2 = new Date(4,0,0);			
			iConAlta.confirmarAltaSalida("ActNombreBase", "SalNombreBase", salDate2, salDateH, "SalLugar", 5, salDate);
			iConAlta.confirmarAltaSalida("ActNombreBase2", "SalNombreBase2", salDate2, salDateH, "SalLugar", 5, salDate);
			Date inscDate = new Date(3,0,0);
			iConInsc.inscribir("TurNickBase", "SalNombreBase", 1, inscDate, "ActNombreBase");
			iConInsc.finalizarActividad("ActNombreBase", "ProvNickBase");
			iConInsc.finalizarActividad("ActNombreBase2", "ProvNickBase");
			iConInsc.finalizarActividad("ActNombreBase3", "ProvNickBase");
			DataProveedor dataProvBase = (DataProveedor) IctrCons.obtenerDataUsuarioNick("ProvNickBase");
			DataTurista dataTurBase = (DataTurista) IctrCons.obtenerDataUsuarioNick("TurNickBase");
			assertEquals("ProvNom", dataProvBase.getNombre());
			assertEquals("TurNom", dataTurBase.getNombre());
			assertEquals(3, dataProvBase.getActividades().size());
			assertEquals(1, dataTurBase.getInscripcionesSal().size());
		} catch (DepartamentoYaExisteExeption | UsuarioRepetidoException | CategoriaYaExiste | ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException | SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad | TuristaConSalida | ExcedeTuristas | InscFechaInconsistente | ActividadNoExisteException | InscFechaDespSalida | TuristaNoHaNacido | SalidasVigentesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
