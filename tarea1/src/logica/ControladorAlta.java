package logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import com.opencsv.CSVReader;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.NoExisteCategoriaException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.estadoActividadIncorrecto;
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

	public void cargarSalidas() throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Salidas.csv"));
	      String[] nextLine;
	      int cont = 0;
	      BufferedImage img = ImageIO.read(new File("./src/data/s1.jpg"));
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ImageIO.write(img, "jpg", baos);
	      byte[] imgBytes = baos.toByteArray();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fecha = formato.parse(nextLine[3].strip());
	    		  Date fechaA = formato.parse(nextLine[7].strip());
	    		  int hora = Integer.parseInt(nextLine[4].strip());
	    		  Date horaS = new Date(0, 0, 0, hora, 0);
	    		  confirmarAltaSalida(nextLine[1].strip(), nextLine[2].strip(), fecha, horaS, nextLine[6].strip(), Integer.parseInt(nextLine[5]), fechaA, imgBytes);
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}
	
	
	public void cargarActs() throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException, ParseException, UsuarioNoExisteException, ProveedorNoNacidoException {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Actividades.csv"));
	      String[] nextLine;
	      int cont = 0;
	      Map<String, Set<String>> categos = new HashMap<String, Set<String>>();
	      Set<String> act1 = new HashSet<String>();
	      act1.add("Gastronomia");
	      categos.put(Integer.toString(1), act1); 
	      categos.put(Integer.toString(4), act1); 
	      act1.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(2), act1); 	
	      Set<String> act3 = new HashSet<String>();
	      act3.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(3), act3);
	      categos.put(Integer.toString(7), act3);
	      categos.put(Integer.toString(8), act3);
	      categos.put(Integer.toString(10), act3);
	      Set<String> act5 = new HashSet<String>();
	      act5.add("Campo y Naturaleza");
	      categos.put(Integer.toString(6), act5);
	      act5.add("Gastronomia");
	      categos.put(Integer.toString(5), act5);
	      Set<String> act9 = new HashSet<String>();
	      act9.add("Aventura y Deporte");
	      act9.add("Turismo Playas");
	      categos.put(Integer.toString(9), act9);
	      //reads one line at a time    
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  BufferedImage img = ImageIO.read(new File("./src/data/Actvs/a"+String.valueOf(cont)+".jpg"));
	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	      ImageIO.write(img, "jpg", baos);
	    	      byte[] imgBytes = baos.toByteArray();
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fecha = formato.parse(nextLine[7].strip());
	    		  registrarActividad(nextLine[6].strip(), nextLine[1].strip(), nextLine[2].strip(), Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[4]), nextLine[5].strip(), fecha, nextLine[9].strip(), categos.get(Integer.toString(cont)), imgBytes);
	    		  if (cont<=6) {
	    			  Fabrica fabr = Fabrica.getInstance();
	    			  IControladorInsc conIns = fabr.getIControladorInsc();
					  try {
						conIns.aceptarRechazarAct(nextLine[1].strip(), estadoAct.confirmada);
					} catch (estadoActividadIncorrecto | ActividadNoExisteException e) {
						// TODO Auto-generated catch block
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
	
	public void cargarDptos() throws IOException, DepartamentoYaExisteExeption {
	    CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Departamentos.csv"));
	      String[] nextLine;
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont>0)
	    		  confirmarAltaDepartamento(nextLine[1].strip(), nextLine[2].strip(), nextLine[3].strip());
	    	  cont++;
	      }
	 }
	
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
	
	public void cargarUsuarios() throws IOException, UsuarioRepetidoException, ParseException {
	    CSVReader usu = null;
	      //parsing a CSV file into CSVReader class constructor  
	      usu = new CSVReader(new FileReader("./src/data/Usuarios.csv"));
	      
	      String[] nextLineusu;
	      
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLineusu = usu.readNext()) != null) {
	    	  if (cont>0) {
	    		  BufferedImage img = ImageIO.read(new File("./src/data/Users/u"+String.valueOf(cont)+".jpg"));
	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	      ImageIO.write(img, "jpg", baos);
	    	      byte[] imgBytes = baos.toByteArray();
	    		  if (nextLineusu[1].equals(" T")) {
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6].strip());
	    			  confirmarAltaTurista(nextLineusu[2].strip(), nextLineusu[3].strip(), nextLineusu[4].strip(), nextLineusu[5].strip(), fecha, nextLineusu[7].strip(), nextLineusu[10].strip(), imgBytes);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaProveedor(nextLineusu[2].strip(), nextLineusu[3].strip(), nextLineusu[4].strip(), nextLineusu[5].strip(), fecha, nextLineusu[8].strip(), nextLineusu[9].strip(), true, nextLineusu[10].strip(), imgBytes);
	    		  }
	    	  }
	    		  
	    	  cont++;
	      }
	 }

    public ControladorAlta(){
    }

    public void confirmarAltaTurista(String nick, String nom , String apellido, String mail , Date nacimiento , String nacionalidad) throws UsuarioRepetidoException {
    	ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
        Usuario usu = manUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = manUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        usu = new Turista(nick, nom, apellido, mail, nacimiento, nacionalidad);
        manUsu.addUsuario(usu);
    }
    
    public void confirmarAltaProveedor(String nick, String nom , String apellido, String mail , Date nacimiento , String descripcion, String link, boolean hayLink) throws UsuarioRepetidoException {
    	ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
        Usuario usu = manUsu.obtenerUsuarioNick(nick);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        usu = manUsu.obtenerUsuarioMail(mail);
        if (usu != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        usu = new Proveedor(nick, nom, apellido, mail, nacimiento, descripcion, link, hayLink);
        manUsu.addUsuario(usu);
    }
    
    public void registrarActividad(String dep, String nom , String desc, int dur, int costo, String ciudad , Date fecha, String proveedor, Set<String> cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException {
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
        
        act = new Actividad(nom, desc, fecha, ciudad, costo, dur, insDep, categorias);
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
				throw new FechaAltaSalidaInvalida();
			}
			if (fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad();
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


	@Override
	public void cargarPaquetes() throws NumberFormatException, IOException, ParseException, SalidaYaExisteExeption, PaqueteRepetidoException {
		// TODO Auto-generated method stub
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Paquetes.csv"));
	      String[] nextLine;
	      
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  BufferedImage img = ImageIO.read(new File("./src/data/Paqs/p"+String.valueOf(cont)+".jpg"));
	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	      ImageIO.write(img, "jpg", baos);
	    	      byte[] imgBytes = baos.toByteArray();
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fechaA = formato.parse(nextLine[4].strip());
	    		  altaPaquete(nextLine[1].strip(), nextLine[5].strip(), Integer.parseInt(nextLine[3].strip()), Integer.parseInt(nextLine[2].strip()), fechaA, imgBytes);
	    	  }
	    		  cont++;
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
        paq = new Paquete(nombre, descripcion, descuento, fechaAlta, validez, imgBytes);
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
        usu = new Turista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass);
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
        usu = new Turista(nick, nom, apellido, mail, nacimiento, nacionalidad, pass, imagen);
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
        usu = new Proveedor(nick, nom, apellido, mail, nacimiento, descripcion, link, hayLink, pass);
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
        usu = new Proveedor(nick, nom, apellido, mail, nacimiento, descripcion, link, hayLink, pass, imagen);
        mUsu.addUsuario(usu);
	}


	@Override
	public void cargarDatos() throws Exception {
		cargarUsuarios();
		cargarDptos();
		cargarActs();
		cargarSalidas();
		Fabrica fabr = Fabrica.getInstance();
		IControladorInsc conIns = fabr.getIControladorInsc();
		cargarCompPaq();
		conIns.cargarInsc();
		cargarPaquetes();
		conIns.cargarActsPaqs();
	}


	@Override
	public void registrarActividad(String dep, String nom, String desc, int dur, int costo, String ciudad, Date fecha,
			String proveedor, Set<String> cat, byte[] imagen)
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
        act = new Actividad(nom, desc, fecha, ciudad, costo, dur, insDep, categorias, imagen);
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
				throw new FechaAltaSalidaInvalida();
			}
			if (fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad();
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
	        act.altaSalida(nombreSalida, fecha, hora, lugar, maxCantTuristas, fechaAlta, imagen);
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
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6].strip());
	    			  confirmarAltaTurista(nextLineusu[2].strip(), nextLineusu[3].strip(), nextLineusu[4].strip(), nextLineusu[5].strip(), fecha, nextLineusu[7].strip(), nextLineusu[10].strip(), imgBytes);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
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
	      categos.put(Integer.toString(1), act1); 
	      categos.put(Integer.toString(4), act1); 
	      act1.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(2), act1); 	
	      Set<String> act3 = new HashSet<String>();
	      act3.add("Cultura y Patrimonio");
	      categos.put(Integer.toString(3), act3);
	      categos.put(Integer.toString(7), act3);
	      categos.put(Integer.toString(8), act3);
	      categos.put(Integer.toString(10), act3);
	      Set<String> act5 = new HashSet<String>();
	      act5.add("Campo y Naturaleza");
	      categos.put(Integer.toString(6), act5);
	      act5.add("Gastronomia");
	      categos.put(Integer.toString(5), act5);
	      Set<String> act9 = new HashSet<String>();
	      act9.add("Aventura y Deporte");
	      act9.add("Turismo Playas");
	      categos.put(Integer.toString(9), act9);
	      
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fecha = formato.parse(nextLine[7].strip());
	    		  registrarActividad(nextLine[6].strip(), nextLine[1].strip(), nextLine[2].strip(), Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[4]), nextLine[5].strip(), fecha, nextLine[9].strip(), categos.get(Integer.toString(cont)), imgBytes.get(Integer.toString(cont)));
	    		  
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
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  SimpleDateFormat formato1 = new SimpleDateFormat("dd–MM--yyyy");
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
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
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
	      reader = new CSVReader(new FileReader("./src/data/Compras-Paquetes.csv"));
		String[] nextLine;
	      int cont = 0;
	      Fabrica fabr = Fabrica.getInstance();
		  IControladorInsc conIns = fabr.getIControladorInsc();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
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
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fechaA = formato.parse(nextLine[4].strip());
	    		  conIns.comprarPaquete(nextLine[1].strip(), fechaA, Integer.parseInt(nextLine[3].strip()), nextLine[2].strip());
	    	  }
	    	  cont++;
	      }
		
		
	}
}
