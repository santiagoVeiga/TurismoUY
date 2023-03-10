package logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import com.opencsv.CSVReader;

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
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.estadoActividadIncorrecto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import manejadores.ManejadorActividad;
import manejadores.ManejadorCategoria;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorPaquete;
import manejadores.ManejadorUsuario;

/**
 * Controlador de altas.
 * @author TProg2017
 *
 */
public class ControladorAlta implements IControladorAlta {
	
	public void cargarDptos(CSVReader reader) throws IOException, DepartamentoYaExisteExeption {

	      String[] nextLine;
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont>0)
	    		  confirmarAltaDepartamento(nextLine[1].strip(), nextLine[2].strip(), nextLine[3].strip());
	    	  cont++;
	      }
	 }
	
	

    public ControladorAlta(){
    }
    
    public void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat, String link, boolean hayLink) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException {
    	ManejadorActividad mAct = ManejadorActividad.getInstance();
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
        ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
        ManejadorCategoria mCat = ManejadorCategoria.getInstance();
        Usuario usu =  manUsu.obtenerUsuarioNick(proveedor);
    	Actividad act = null;
		try {
			act = mAct.getActividad(nom);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
		}
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);
        if (usu == null) {
        	throw new UsuarioNoExisteException("No existe el Usuario identificado como " + proveedor);
        }
        if (usu.getNacimiento().after(fecha)) {
        	throw new ProveedorNoNacidoException();
        }
        Departamento insDep = mDep.getDepartamento(dep);
        
        Map<String, Categoria> categorias = new HashMap<String, Categoria>();
        if (cat!=null) {
        	for (String stringCat : cat){
            	Categoria categ = mCat.getCategoria(stringCat);
            	categorias.put(categ.getCategoria(), categ);
            }
        }
        
        act = new Actividad(nom, desc, fecha, ciudad, costo, dur, insDep, categorias, link, hayLink);
        if (usu instanceof Proveedor) {
        	((Proveedor) usu).agregarActividad(act);
        }
        for (Categoria catAux : categorias.values()) {
        	catAux.agregarAct(act);
        }
        mAct.addActividad(act);
        // if agregado por si Departamento no esta cargado da errror VER SI QUITAR
        if (insDep != null)
        	insDep.agregarActividad(act);
    }
    
    
    public void registrarCategoria(String Categoria) throws CategoriaYaExiste{
    	//si existe una categoria con nombre categoria tiro exepcion 
    	ManejadorCategoria mCat = ManejadorCategoria.getInstance();
    	if (mCat.pertenece(Categoria)) {
    		throw new CategoriaYaExiste("Ya existe una categoria registrada con nombre:" + Categoria);
    	} else {
    		Categoria cat = new Categoria(Categoria) ; 
    		mCat.addCategoria(cat);
    	}
    }
    
    public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
    	DataDepartamento[] res = mDep.obtenerDataDepartamentos();
    	if (res == null) {
    		throw new DepartamentoNoExisteException("No existen departamentos");
    	} else {
    	return res;
    	}
    }
    
    public Set<String> obtenerNombreCategorias() throws NoExisteCategoriaException{
    	ManejadorCategoria mCat = ManejadorCategoria.getInstance();
    	Set<String> res = mCat.obtenerNombreCategorias();
    	if (res.size() == 0){
    		throw new NoExisteCategoriaException("No existen categorias registradas en el sistema");
    	}
    	return res;
    }
    
    
    
    
    public DataUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException {
        ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        Usuario usu = mUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            return usu.getDataUsuario();
        else
            throw new UsuarioNoExisteException("El usuario " + nick + " no existe");

    }

    public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        DataUsuario[] usrs = mUsu.getUsuarios();

        if (usrs != null) {
            return usrs;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");

    }

    

    public void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption {
        ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();

        Departamento deptoprueba = mDep.getDepartamento(nombre);
        if (deptoprueba != null)
            throw new DepartamentoYaExisteExeption("Ya existe un departamento registrado con el nombre:  " + nombre);

        Departamento dpto = new Departamento(nombre, descripcion, URL) ;
        mDep.addDepartamento(dpto) ;
    }


    public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad{
        ManejadorActividad mAct = ManejadorActividad.getInstance();
        Actividad act = null;
		try {
			act = mAct.getActividad(nombreActividad);
			mAct.verificarSalida(nombreSalida);
			if (fecha.before(fechaAlta)) {
				throw new FechaAltaSalidaInvalida("La fecha de salida debe ser posterior a la fecha actual");
			}
			if (fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad("La fecha de salida debe ser posterior a la de alta de Actividad");
			} 

	        act.altaSalida(nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta);
		} catch (ActividadNoExisteException e) {
			e.printStackTrace();
		}
    }
    
    public void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException {
    	ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
        Paquete paq = mPaq.getPaquete(nombre);
        if (paq != null)
            throw new PaqueteRepetidoException("Ya existe un paquete registrado con el nombre:  " + nombre);
        paq = new Paquete(nombre, descripcion, descuento, fechaAlta, validez);
        mPaq.addPaquete(paq);
    }

    public void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad) {
    	ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
    	Usuario usu = mUsu.obtenerUsuarioNick(nick);
    	if (usu!=null) {
    		if (usu instanceof Turista) {
    			usu.setNombre(nombre);
    			usu.setApellido(apellido);
    			usu.setNacimiento(fechaN);
    			((Turista) usu).setNacionalidad(nacionalidad);
    		}
    	}
    }
    
    public void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink) {
    	ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
    	Usuario usu = mUsu.obtenerUsuarioNick(nick);
    	if (usu!=null) {
    		if (usu instanceof Proveedor) {
        		usu.setNombre(nombre);
        		usu.setApellido(apellido);
        		usu.setNacimiento(fechaN);
        		((Proveedor) usu).setDescripcion(descripcion);
        		((Proveedor) usu).setLink(link);
        		((Proveedor) usu).setHayLink(hayLink);
        	}
    	}
    }

    public void actualizarDatosTurista(String nick, String mail, String nombre, String apellido, Date fechaN, String nacionalidad, String password, byte[] imagen) {
    	ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
    	FileOutputStream output = null;
        InputStream inputStream = null;
	       try {
	    	File nuevaImg = new File("./src/data/Users/" + nick + ".jpg");
	    	nuevaImg.createNewFile();
	        output = new FileOutputStream(nuevaImg);
	        inputStream = new ByteArrayInputStream(imagen); 
	        int leido = 0;
	        leido = inputStream.read();
	        while (leido != -1) {
	            output.write(leido);
	            leido = inputStream.read();
	        }
	      } catch (IOException ioe) {
	        ioe.printStackTrace();
	      } finally {
	        try {
	            output.flush();
	            output.close();
	            inputStream.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
    	Usuario usu = mUsu.obtenerUsuarioNick(nick);
    	if (usu!=null) {
    		if (usu instanceof Turista) {
    			usu.setNombre(nombre);
    			usu.setApellido(apellido);
    			usu.setNacimiento(fechaN);
    			usu.setPassword(password);
    			usu.setImagen(imagen);
    			((Turista) usu).setNacionalidad(nacionalidad);
    		}
    	}
    }
    
    public void actualizarDatosProveedor(String nick, String mail, String nombre, String apellido, Date fechaN, String descripcion, String link, boolean hayLink, String password, byte[] imagen) {
    	ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
    	Usuario usu = mUsu.obtenerUsuarioNick(nick);
    	FileOutputStream output = null;
        InputStream inputStream = null;
	       try {
	    	File nuevaImg = new File("./src/data/Users/" + nick + ".jpg");
	    	nuevaImg.createNewFile();
	        output = new FileOutputStream(nuevaImg);
	        inputStream = new ByteArrayInputStream(imagen); 
	        int leido = 0;
	        leido = inputStream.read();
	        while (leido != -1) {
	            output.write(leido);
	            leido = inputStream.read();
	        }
	      } catch (IOException ioe) {
	        ioe.printStackTrace();
	      } finally {
	        try {
	            output.flush();
	            output.close();
	            inputStream.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
    	if (usu!=null) {
    		if (usu instanceof Proveedor) {
        		usu.setNombre(nombre);
        		usu.setApellido(apellido);
        		usu.setNacimiento(fechaN);
        		usu.setPassword(password);
        		usu.setImagen(imagen);
        		((Proveedor) usu).setDescripcion(descripcion);
        		((Proveedor) usu).setLink(link);
        		((Proveedor) usu).setHayLink(hayLink);
        	}
    	}
    }



	private void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta, byte[] imgBytes) throws PaqueteRepetidoException {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
        Paquete paq = mPaq.getPaquete(nombre);
        if (paq != null)
            throw new PaqueteRepetidoException("Ya existe un paquete registrado con el nombre:  " + nombre);
	      if (imgBytes == null) {
	    	  try {
	    	      BufferedImage img;
	    	      img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	      ImageIO.write(img, "jpg", baos);
	    	      imgBytes = baos.toByteArray();
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}  
	      }
	      FileOutputStream output = null;
          InputStream inputStream = null;
	       try {
    	    File nuevaImg = new File("./src/data/Paqs/" + nombre + ".jpg");
	    	nuevaImg.createNewFile();
            output = new FileOutputStream(nuevaImg);
            inputStream = new ByteArrayInputStream(imgBytes); 
            int leido = 0;
            leido = inputStream.read();
            while (leido != -1) {
                output.write(leido);
                leido = inputStream.read();
            }
        } catch (IOException ioe) {
          ioe.printStackTrace();
        } finally {
          try {
              output.flush();
              output.close();
              inputStream.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
        paq = new Paquete(nombre, descripcion, descuento, fechaAlta, validez);
        mPaq.addPaquete(paq);
	}


	@Override
	public void confirmarAltaTurista(String nick, String nom, String apellido, String mail, Date nacimiento,
			String nacionalidad, String pass) throws UsuarioRepetidoException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        Usuario usu = mUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = mUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        try {
			usu = mUsu.obtenerUsuarioFinalizadoNick(nick);
			usu.setNombre(nom);
			usu.setApellido(apellido);
			usu.setNacimiento(nacimiento);
			Turista tur = (Turista) usu;
			usu.setPassword(pass);
	        usu.setSeguidores(new HashMap<String, Usuario>());
	        usu.setSeguidos(new HashMap<String, Usuario>());
	    	tur.setComprasG(new HashSet<CompraGeneral>());
	    	tur.setComprasP(new HashMap<String, CompraPaquete>());
	    	tur.setFavoritas(new HashMap<String, Actividad>());
	    	Set<String> salidasCGFinalizadas = new HashSet<String>();
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
        	EntityManager entM = emf.createEntityManager();
        	Query query = entM.createQuery("SELECT cg.salida.nombre FROM CompraGeneral cg JOIN cg.turista t WHERE t.nickname = :nick");
        	query.setParameter("nick", usu.getNickname());
        	List<String> listaCG = query.getResultList();
        	entM.close();
        	emf.close();
        	for (String iter: listaCG) {
        		salidasCGFinalizadas.add(iter);
        	}
        	tur.setSalidasCGFinalizadas(salidasCGFinalizadas);;
		} catch (UsuarioNoExisteException e) {
			usu = new Turista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
		}
        mUsu.addUsuario(usu);
		
	}


	@Override
	public void confirmarAltaTurista(String nick, String nom, String apellido, String mail, Date nacimiento,
			String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        Usuario usu = mUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = mUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        try {
			usu = mUsu.obtenerUsuarioFinalizadoNick(nick);
			usu.setNombre(nom);
			usu.setApellido(apellido);
			usu.setNacimiento(nacimiento);
			Turista tur = (Turista) usu;
			usu.setPassword(pass);
	        usu.setSeguidores(new HashMap<String, Usuario>());
	        usu.setSeguidos(new HashMap<String, Usuario>());
	    	tur.setComprasG(new HashSet<CompraGeneral>());
	    	tur.setComprasP(new HashMap<String, CompraPaquete>());
	    	tur.setFavoritas(new HashMap<String, Actividad>());
	    	Set<String> salidasCGFinalizadas = new HashSet<String>();
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
        	EntityManager entM = emf.createEntityManager();
        	Query query = entM.createQuery("SELECT cg.salida.nombre FROM CompraGeneral cg JOIN cg.turista t WHERE t.nickname = :nick");
        	query.setParameter("nick", usu.getNickname());
        	List<String> listaCG = query.getResultList();
        	entM.close();
        	emf.close();
        	for (String iter: listaCG) {
        		salidasCGFinalizadas.add(iter);
        	}
        	tur.setSalidasCGFinalizadas(salidasCGFinalizadas);;
		} catch (UsuarioNoExisteException e) {
		    if (imagen == null) {
		  	  try {
		  	      BufferedImage img;
		    	  img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	      ImageIO.write(img, "jpg", baos);
	    	      imagen = baos.toByteArray();
	  		  } catch (IOException e1) {
	  			  e1.printStackTrace();
	  		  }
		    }
	            FileOutputStream output = null;
	            InputStream inputStream = null;
		       try {
		    	File nuevaImg = new File("./src/data/Users/" + nick + ".jpg");
		    	nuevaImg.createNewFile();
	            output = new FileOutputStream(nuevaImg);
	            inputStream = new ByteArrayInputStream(imagen); 
	            int leido = 0;
	            leido = inputStream.read();
	            while (leido != -1) {
	                output.write(leido);
	                leido = inputStream.read();
	            }
	          } catch (IOException ioe) {
	            ioe.printStackTrace();
	          } finally {
	            try {
	                output.flush();
	                output.close();
	                inputStream.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        usu = new Turista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
		}
        mUsu.addUsuario(usu);
	}


	@Override
	public void confirmarAltaProveedor(String nick, String nom, String apellido, String mail, Date nacimiento,
			String descripcion, String link, boolean hayLink, String pass) throws UsuarioRepetidoException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        Usuario usu = mUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = mUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        try {
			usu = mUsu.obtenerUsuarioFinalizadoNick(nick);
			usu.setNombre(nom);
			usu.setApellido(apellido);
			usu.setNacimiento(nacimiento);
			Proveedor prov = (Proveedor) usu;
			prov.setDescripcion(descripcion);
			prov.setLink(link);
			prov.setHayLink(hayLink);
			prov.setPassword(pass);
	        usu.setSeguidores(new HashMap<String, Usuario>());
	        usu.setSeguidos(new HashMap<String, Usuario>());
	    	Map<String, Actividad> actividades = new HashMap<String, Actividad>();
	    	Set<String> actividadesPersistir = new HashSet<String>();
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
        	EntityManager entM = emf.createEntityManager();
        	Query query = entM.createQuery("SELECT a.nombre FROM Actividad a JOIN a.proveedor p WHERE p.nickname = :nick");
        	query.setParameter("nick", usu.getNickname());
        	List<String> listaActs = query.getResultList();
        	entM.close();
        	emf.close();
        	for (String iter: listaActs) {
        		actividadesPersistir.add(iter);
        	}
        	prov.setActividades(actividades);
        	prov.setActividadesPersistir(actividadesPersistir);
		} catch (UsuarioNoExisteException e) {
	        usu = new Proveedor(nick, nom, apellido, mail, nacimiento, descripcion, link, hayLink, pass);
		}
        mUsu.addUsuario(usu);
	}


	@Override
	public void confirmarAltaProveedor(String nick, String nom, String apellido, String mail, Date nacimiento,
			String descripcion, String link, boolean hayLink, String pass, byte[] imagen)
			throws UsuarioRepetidoException {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        Usuario usu = mUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = mUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        try {
			usu = mUsu.obtenerUsuarioFinalizadoNick(nick);
			usu.setNombre(nom);
			usu.setApellido(apellido);
			usu.setNacimiento(nacimiento);
			Proveedor prov = (Proveedor) usu;
			prov.setDescripcion(descripcion);
			prov.setLink(link);
			prov.setHayLink(hayLink);
			prov.setPassword(pass);
	        usu.setSeguidores(new HashMap<String, Usuario>());
	        usu.setSeguidos(new HashMap<String, Usuario>());
	    	Map<String, Actividad> actividades = new HashMap<String, Actividad>();
	    	Set<String> actividadesPersistir = new HashSet<String>();
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
        	EntityManager entM = emf.createEntityManager();
        	Query query = entM.createQuery("SELECT a.nombre FROM Actividad a JOIN a.proveedor p WHERE p.nickname = :nick");
        	query.setParameter("nick", usu.getNickname());
        	List<String> listaActs = query.getResultList();
        	entM.close();
        	emf.close();
        	for (String iter: listaActs) {
        		actividadesPersistir.add(iter);
        	}
        	prov.setActividades(actividades);
        	prov.setActividadesPersistir(actividadesPersistir);
		} catch (UsuarioNoExisteException e) {
			if (imagen == null) {
	  	  	  try {
	  	  	      BufferedImage img;
	  	    	  img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
	      	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      	      ImageIO.write(img, "jpg", baos);
	      	      imagen = baos.toByteArray();
	    		  } catch (IOException e1) {
	    			  e1.printStackTrace();
	    		  }
	  	    }
	        FileOutputStream output = null;
	        InputStream inputStream = null;
	       try {
	    	File nuevaImg = new File("./src/data/Users/" + nick + ".jpg");
	    	nuevaImg.createNewFile();
	        output = new FileOutputStream(nuevaImg);
	        inputStream = new ByteArrayInputStream(imagen); 
	        int leido = 0;
	        leido = inputStream.read();
	        while (leido != -1) {
	            output.write(leido);
	            leido = inputStream.read();
	        }
	      } catch (IOException ioe) {
	        ioe.printStackTrace();
	      } finally {
	        try {
	            output.flush();
	            output.close();
	            inputStream.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	        usu = new Proveedor(nick, nom, apellido, mail, nacimiento, descripcion, link, hayLink, pass);
		}
        mUsu.addUsuario(usu);
	}


	@Override
	public void cargarDatos() throws FileNotFoundException, IOException, UsuarioRepetidoException, ParseException, NumberFormatException, DepartamentoYaExisteExeption, ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException, SalidaYaExisteExeption, PaqueteRepetidoException, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, NoHayCuposException, PaqueteNoExisteException {
		cargarCategorias();
		CSVReader reader = null;
	    reader = new CSVReader(new FileReader("./src/data/Usuarios.csv"));
	    Map<String, byte[]> imagenes = new HashMap<String, byte[]>();
        for (int i=1; i<=13; i++ ) {
            BufferedImage img = ImageIO.read(new File("./src/data/Users/u"+String.valueOf(i)+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imgBytes = baos.toByteArray();
            imagenes.put(Integer.toString(i), imgBytes);
        }
		cargarUsuarios(reader, imagenes);
		reader = new CSVReader(new FileReader("./src/data/Usuarios-Seguidores.csv"));
		cargarSeguidos(reader);
		reader = new CSVReader(new FileReader("./src/data/Departamentos.csv"));
		cargarDptos(reader);
		reader = new CSVReader(new FileReader("./src/data/Actividades.csv"));
	    imagenes.clear();
        for (int i=1; i<=10; i++ ) {
            BufferedImage img = ImageIO.read(new File("./src/data/Actvs/a"+String.valueOf(i)+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imgBytes = baos.toByteArray();
            imagenes.put(Integer.toString(i), imgBytes);
        }
        try {
        	cargarActs(reader, imagenes);
        } catch (ActividadRepetidaException e) {
        	;
        }
		reader = new CSVReader(new FileReader("./src/data/Paquetes.csv"));
	    imagenes.clear();
        for (int i=1; i<=3; i++ ) {
            BufferedImage img = ImageIO.read(new File("./src/data/Paqs/p"+String.valueOf(i)+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imgBytes = baos.toByteArray();
            imagenes.put(Integer.toString(i), imgBytes);
        }
        imagenes.put(Integer.toString(4), null);
		cargarPaquetes(reader, imagenes);
		reader = new CSVReader(new FileReader("./src/data/Favoritas.csv"));
	    imagenes.clear();
	    try {
	    	cargarFavoritas(reader);
	    } catch (ActividadNoExisteException e) {
	    	;
	    }
		reader = new CSVReader(new FileReader("./src/data/Salidas.csv"));
	    imagenes.clear();
        for (int i=1; i<=6; i++ ) {
            BufferedImage img = ImageIO.read(new File("./src/data/Salidas/s"+String.valueOf(i)+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imgBytes = baos.toByteArray();
            if (imgBytes.length == 0) {
                img = null;
                baos = new ByteArrayOutputStream();
                img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
                ImageIO.write(img, "jpg", baos);
                imgBytes = baos.toByteArray();
            }
            imagenes.put(Integer.toString(i), imgBytes);
        }
        for (int i=11; i<=14; i++ ) {
        	if (i!=12) {
	            BufferedImage img = ImageIO.read(new File("./src/data/Salidas/s"+String.valueOf(i)+".jpg"));
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ImageIO.write(img, "jpg", baos);
	            byte[] imgBytes = baos.toByteArray();
	            if (imgBytes.length == 0) {
	                img = null;
	                baos = new ByteArrayOutputStream();
	                img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
	                ImageIO.write(img, "jpg", baos);
	                imgBytes = baos.toByteArray();
	            }
	            imagenes.put(Integer.toString(i), imgBytes);
        	}
        }
        for (int i=16; i<=17; i++ ) {
            BufferedImage img = ImageIO.read(new File("./src/data/Salidas/s"+String.valueOf(i)+".jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imgBytes = baos.toByteArray();
            if (imgBytes.length == 0) {
                img = null;
                baos = new ByteArrayOutputStream();
                img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
                ImageIO.write(img, "jpg", baos);
                imgBytes = baos.toByteArray();
            }
            imagenes.put(Integer.toString(i), imgBytes);
        }
        BufferedImage img = ImageIO.read(new File("./src/data/Salidas/s19.jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        byte[] imgBytes = baos.toByteArray();
        if (imgBytes.length == 0) {
            img = null;
            baos = new ByteArrayOutputStream();
            img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
            ImageIO.write(img, "jpg", baos);
            imgBytes = baos.toByteArray();
        }
        imagenes.put(Integer.toString(19), imgBytes);
        try {
    		cargarSalidas(reader, imagenes);
        } catch (SalidaYaExisteExeption e) {
        	;
        }
		Fabrica fabr = Fabrica.getInstance();
		IControladorInsc conIns = fabr.getIControladorInsc();
		conIns.cargarActsPaqs();
		cargarCompPaq();
		try {
			conIns.cargarInsc();
		} catch (ActividadNoExisteException e) {
			;
		}
	}


	private void cargarFavoritas(CSVReader reader) throws IOException, UsuarioNoExisteException, UsuarioRepetidoException, ActividadNoExisteException, ActividadRepetidaException {
		String[] nextLine;
	      int cont = 0;
	      Fabrica fabr = Fabrica.getInstance();
		  IControladorInsc conIns = fabr.getIControladorInsc();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  conIns.agregarQuitarActividadFavorita(nextLine[1].strip(), nextLine[2].strip(), true);
	    	  }
	    	  cont++;
	      }
		
	}



	public void cargarSeguidos(CSVReader reader) throws NumberFormatException, IOException, ParseException, PaqueteNoExisteException, PaqueteRepetidoException, UsuarioNoExisteException, UsuarioRepetidoException {
		String[] nextLine;
	      int cont = 0;
	      Fabrica fabr = Fabrica.getInstance();
		  IControladorInsc conIns = fabr.getIControladorInsc();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  conIns.seguirDejarDeSeguirUsuario(nextLine[1].strip(), nextLine[2].strip(), true);
	    	  }
	    	  cont++;
	      }
		
	}



	@Override
	public void registrarActividad(String dep, String nom, String desc, int dur, int costo, String ciudad, Date fecha,
			String proveedor, Set<String> cat, String link, boolean hayLink, byte[] imagen)
			throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
        ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        ManejadorCategoria mCat = ManejadorCategoria.getInstance();
        Usuario usu =  mUsu.obtenerUsuarioNick(proveedor);
    	Actividad act = null;
		try {
			act = mAct.getActividad(nom);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
		}
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);
        if (usu == null) {
        	throw new UsuarioNoExisteException("No existe el Usuario identificado como " + proveedor);
        }
        if (usu.getNacimiento().after(fecha)) {
        	throw new ProveedorNoNacidoException();
        }
        Departamento insDep = mDep.getDepartamento(dep);
        
        Map<String, Categoria> categorias = new HashMap<String, Categoria>();
        for (String stringCat : cat){
        	Categoria categ = mCat.getCategoria(stringCat);
        	categorias.put(categ.getCategoria(), categ);
        }
        if (imagen == null) {
  	  	  try {
  	  	      BufferedImage img;
  	    	  img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
      	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      	      ImageIO.write(img, "jpg", baos);
      	      imagen = baos.toByteArray();
    		  } catch (IOException e) {
    			  e.printStackTrace();
    		  }
  	    }
            FileOutputStream output = null;
            InputStream inputStream = null;
	       try {
	    	File nuevaImg = new File("./src/data/Actvs/" + nom + ".jpg");
	    	nuevaImg.createNewFile();
            output = new FileOutputStream(nuevaImg);
            inputStream = new ByteArrayInputStream(imagen); 
            int leido = 0;
            leido = inputStream.read();
            while (leido != -1) {
                output.write(leido);
                leido = inputStream.read();
            }
          } catch (IOException ioe) {
            ioe.printStackTrace();
          } finally {
            try {
                output.flush();
                output.close();
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        act = new Actividad(nom, desc, fecha, ciudad, costo, dur, insDep, categorias, link, hayLink);
        for (Categoria catAux : categorias.values()) {
        	catAux.agregarAct(act);
        }
        if (usu instanceof Proveedor) {
        	((Proveedor) usu).agregarActividad(act);
        }
        
        mAct.addActividad(act);
        // if agregado por si Departamento no esta cargado da errror VER SI QUITAR
        insDep.agregarActividad(act);
        
	}


	@Override
	public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar,
			int maxCantTuristas, Date fechaAlta, byte[] imagen)
			throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
        Actividad act = null;
		try {
			act = mAct.getActividad(nombreActividad);
			mAct.verificarSalida(nombreSalida);
			if (fecha.before(fechaAlta)) {
				throw new FechaAltaSalidaInvalida("La fecha de salida debe ser posterior a la fecha actual");
			}
			if (fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad("La fecha de salida debe ser posterior a la de alta de Actividad");
			} 

			if (imagen == null) {
			  	  try {
			  	      BufferedImage img;
			    	  img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
		    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    	      ImageIO.write(img, "jpg", baos);
		    	      imagen = baos.toByteArray();
		  		  } catch (IOException e) {
		  			  e.printStackTrace();
		  		  }
			 }
	            FileOutputStream output = null;
	            InputStream inputStream = null;
		       try {
		    	File nuevaImg = new File("./src/data/Salidas/" + nombreSalida + ".jpg");
		    	nuevaImg.createNewFile();
	            output = new FileOutputStream(nuevaImg);
	            inputStream = new ByteArrayInputStream(imagen); 
	            int leido = 0;
	            leido = inputStream.read();
	            while (leido != -1) {
	                output.write(leido);
	                leido = inputStream.read();
	            }
	          } catch (IOException ioe) {
	            ioe.printStackTrace();
	          } finally {
	            try {
	                output.flush();
	                output.close();
	                inputStream.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        act.altaSalida(nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta);
		} catch (ActividadNoExisteException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void cargarUsuarios(CSVReader reader, Map<String, byte[]> imgs)
			throws IOException, UsuarioRepetidoException, ParseException {
		CSVReader usu = reader;
	      String[] nextLineusu;
	      //Obtener ruta de ejecucion
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLineusu = usu.readNext()) != null) {
	    	  if (cont>0) {
	    	      byte[] imgBytes = imgs.get(Integer.toString(cont));
	    		  if (nextLineusu[1].equals(" T")) {
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6].strip());
	    			  confirmarAltaTurista(nextLineusu[2].strip(), nextLineusu[3].strip(), nextLineusu[4].strip(), nextLineusu[5].strip(), fecha, nextLineusu[7].strip(), nextLineusu[10].strip(), imgBytes);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaProveedor(nextLineusu[2].strip(), nextLineusu[3].strip(), nextLineusu[4].strip(), nextLineusu[5].strip(), fecha, nextLineusu[8].strip(), nextLineusu[9].strip(), true, nextLineusu[10].strip(), imgBytes);
	    		  }
	    	  }
	    		  
	    	  cont++;
	      }
		
	}


	@Override
	public void cargarActs(CSVReader reader, Map<String, byte[]> imgBytes)
			throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException,
			ParseException, UsuarioNoExisteException, ProveedorNoNacidoException {
		
	      String[] nextLine;
	      int cont = 0;
	     
	      Map<String, Set<String>> categos = new HashMap<String, Set<String>>();
	      Set<String> act1 = new HashSet<String>();
	      act1.add("Gastronomia");
	      Set<String> act8 = new HashSet<String>();
	      act8.add("Gastronomia");
	      categos.put(Integer.toString(1), act8); 
	      categos.put(Integer.toString(4), act8); 
	      act1.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(2), act1); 	
	      Set<String> act3 = new HashSet<String>();
	      act3.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(3), act3);
	      categos.put(Integer.toString(7), act3);
	      categos.put(Integer.toString(8), act3);
	      categos.put(Integer.toString(10), act3);
	      Set<String> act4 = new HashSet<String>();
	      act4.add("Campo y Naturaleza");
	      categos.put(Integer.toString(6), act4);
	      Set<String> act5 = new HashSet<String>();
	      act5.add("Campo y Naturaleza");
	      act5.add("Gastronomia");
	      categos.put(Integer.toString(5), act5);
	      Set<String> act9 = new HashSet<String>();
	      act9.add("Aventura y Deporte");
	      act9.add("Turismo Playas");
	      categos.put(Integer.toString(9), act9);
	      
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    		  Date fecha = formato.parse(nextLine[7].strip());
	    		  if (cont == 8 || cont == 10) {
	    			  registrarActividad(nextLine[6].strip(), nextLine[1].strip(), nextLine[2].strip(), Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[4]), nextLine[5].strip(), fecha, nextLine[9].strip(), categos.get(Integer.toString(cont)), null, false, imgBytes.get(Integer.toString(cont)));
	    		  }
	    		  else {
	    			  registrarActividad(nextLine[6].strip(), nextLine[1].strip(), nextLine[2].strip(), Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[4]), nextLine[5].strip(), fecha, nextLine[9].strip(), categos.get(Integer.toString(cont)), nextLine[11].strip(), true, imgBytes.get(Integer.toString(cont)));
	    		  }
	    		  if (cont<=6) {
	    			  Fabrica fabr = Fabrica.getInstance();
	    			  IControladorInsc conIns = fabr.getIControladorInsc();
	    			  try {
						conIns.aceptarRechazarAct(nextLine[1].strip(), estadoAct.confirmada);
					} catch (estadoActividadIncorrecto e) {
						e.printStackTrace();
					} catch (ActividadNoExisteException e) {
						e.printStackTrace();
					}
	    		  }
	    		  else if (cont == 8 || cont == 10) {
	    			  Fabrica fabr = Fabrica.getInstance();
	    			  IControladorInsc conIns = fabr.getIControladorInsc();
	    			  try {
						conIns.aceptarRechazarAct(nextLine[1].strip(), estadoAct.rechazada);
					} catch (estadoActividadIncorrecto e) {
						e.printStackTrace();
					} catch (ActividadNoExisteException e) {
						e.printStackTrace();
					}
	    		  }
	    	  }
	    	  cont++;
	      }
	}


	@Override
	public void cargarSalidas(CSVReader reader, Map<String, byte[]> imgBytes) throws NumberFormatException, IOException,
			ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {

	      String[] nextLine;
	      int cont = 0;
	      
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    		  SimpleDateFormat formato1 = new SimpleDateFormat("dd???MM--yyyy");
	    		  Date fecha = formato.parse(nextLine[3].strip());
	    		  Date fechaA = formato1.parse(nextLine[7].strip());
	    		  int hora = Integer.parseInt(nextLine[4].strip());
	    		  Date horaS = new Date(0 , 0, 0, hora, 0);
	    		  confirmarAltaSalida(nextLine[1].strip(), nextLine[2].strip(), fecha, horaS, nextLine[6].strip(), Integer.parseInt(nextLine[5]), fechaA, imgBytes.get(Integer.toString(cont)));
	    	  }
	    	  cont++;
	      }
		
	}


	@Override
	public DataUsuario[] getUsuariosComp() throws UsuarioNoExisteException {
		// TODO Auto-generated method stub
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
        DataUsuario[] usrs = mUsu.getUsuariosComp();

        if (usrs != null) {
            return usrs;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados"); 
	}


	@Override
	public void cargarCategorias() {
		ManejadorCategoria mCat = ManejadorCategoria.getInstance();
		mCat.addCategoria(new Categoria("Aventura y Deporte"));
		mCat.addCategoria(new Categoria("Campo y Naturaleza"));
		mCat.addCategoria(new Categoria("Cultura y Patrimonio"));
		mCat.addCategoria(new Categoria("Gastronomia"));
		mCat.addCategoria(new Categoria("Turismo Playas"));
	}


	@Override
	public void cargarPaquetes(CSVReader reader, Map<String, byte[]> imagenes) throws FileNotFoundException,
			NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException {
		  String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    		  Date fechaA = formato.parse(nextLine[4].strip());
	    		  altaPaquete(nextLine[1].strip(), nextLine[5].strip(), Integer.parseInt(nextLine[3].strip()), Integer.parseInt(nextLine[2].strip()), fechaA, imagenes.get(Integer.toString(cont)));
	    	  }
	    	  cont++;
	      }
		
	}


	@Override
	public void cargarCompPaq() throws IOException, ParseException, NumberFormatException, PaqueteNoExisteException, PaqueteRepetidoException {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/ComprasPaquetes.csv"));
		String[] nextLine;
	      int cont = 0;
	      Fabrica fabr = Fabrica.getInstance();
		  IControladorInsc conIns = fabr.getIControladorInsc();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    		  Date fechaA = formato.parse(nextLine[4].strip());
	    		  conIns.comprarPaquete(nextLine[1].strip(), fechaA, Integer.parseInt(nextLine[3].strip()), nextLine[2].strip());
	    	  }
	    	  cont++;
	      }
	}


	@Override
	public void cargarCompPaq(CSVReader reader) throws IOException, ParseException, PaqueteNoExisteException, PaqueteRepetidoException {
		String[] nextLine;
	      int cont = 0;
	      Fabrica fabr = Fabrica.getInstance();
		  IControladorInsc conIns = fabr.getIControladorInsc();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd???MM--yyyy");
	    		  Date fechaA = formato.parse(nextLine[4].strip());
	    		  conIns.comprarPaquete(nextLine[1].strip(), fechaA, Integer.parseInt(nextLine[3].strip()), nextLine[2].strip());
	    	  }
	    	  cont++;
	      }
		
		
	}
}
