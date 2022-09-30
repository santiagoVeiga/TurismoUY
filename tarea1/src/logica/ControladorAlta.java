package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
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
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date f = formato.parse(nextLine[3].strip());
	    		  Date fa = formato.parse(nextLine[7].strip());
	    		  int hora = Integer.parseInt(nextLine[4].strip());
	    		  Date h = new Date(0,0,0,hora,0);
	    		  confirmarAltaSalida(nextLine[1].strip(),nextLine[2].strip(),f,h,nextLine[6].strip(),Integer.parseInt(nextLine[5]),fa,imgBytes);
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
	      BufferedImage img = ImageIO.read(new File("./src/data/a1.jpg"));
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ImageIO.write(img, "jpg", baos);
	      byte[] imgBytes = baos.toByteArray();
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date f = formato.parse(nextLine[7].strip());
	    		  Set<String> coso = new HashSet<String>(); 
	    		  registrarActividad(nextLine[6].strip(),nextLine[1].strip(),nextLine[2].strip(),Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]),nextLine[5].strip(),f,nextLine[9].strip(), coso,imgBytes);
	    	  }
	    	  else {
	    		  cont++;
	    	  }
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
	    	  if(cont>0)
	    		  confirmarAltaDepartamento(nextLine[1].strip(),nextLine[2].strip(),nextLine[3].strip());
	    	  cont++;
	      }
	 }
	
	public void cargarDptos(CSVReader reader) throws IOException, DepartamentoYaExisteExeption {

	      String[] nextLine;
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont>0)
	    		  confirmarAltaDepartamento(nextLine[1].strip(),nextLine[2].strip(),nextLine[3].strip());
	    	  cont++;
	      }
	 }
	
	public void cargarUsuarios() throws IOException, UsuarioRepetidoException, ParseException {
	    CSVReader usu = null;
	      //parsing a CSV file into CSVReader class constructor  
	      usu = new CSVReader(new FileReader("./src/data/Usuarios.csv"));
	      
	      String[] nextLineusu;
	      BufferedImage img = ImageIO.read(new File("./src/data/u1.jpg"));
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ImageIO.write(img, "jpg", baos);
	      byte[] imgBytes = baos.toByteArray();
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLineusu = usu.readNext()) != null) {
	    	  if(cont>0) {
	    		  
	    		  if(nextLineusu[1].equals(" T")) {
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6].strip());
	    			  confirmarAltaTurista(nextLineusu[2].strip(),nextLineusu[3].strip(),nextLineusu[4].strip(),nextLineusu[5].strip(),fecha,nextLineusu[7].strip(),"1234",imgBytes);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaProveedor(nextLineusu[2].strip(),nextLineusu[3].strip(),nextLineusu[4].strip(),nextLineusu[5].strip(),fecha,nextLineusu[8].strip(),nextLineusu[9].strip(),true,"1234",imgBytes);
	    		  }
	    	  }
	    		  
	    	  cont++;
	      }
	 }

    public ControladorAlta(){
    }

    public void confirmarAltaTurista(String nick, String nom , String ap, String mail ,Date nacimiento ,String nacionalidad) throws UsuarioRepetidoException {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Turista(nick, nom, ap, mail, nacimiento, nacionalidad);
        mu.addUsuario(u);
    }
    
    public void confirmarAltaProveedor(String nick, String nom , String ap, String mail ,Date nacimiento ,String descripcion, String link, boolean hayLink) throws UsuarioRepetidoException {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Proveedor(nick, nom, ap, mail, nacimiento, descripcion, link, hayLink);
        mu.addUsuario(u);
    }
    
    public void registrarActividad(String dep, String nom , String desc,int dur, int costo, String ciudad ,Date f,String proveedor, Set<String> cat) throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException {
    	ManejadorActividad mAct = ManejadorActividad.getInstance();
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        Usuario u =  mu.obtenerUsuarioNick(proveedor);
    	Actividad act = null;
		try {
			act = mAct.getActividad(nom);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
		}
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);
        if (u == null) {
        	throw new UsuarioNoExisteException("No existe el Usuario identificado como " + proveedor);
        }
        if (u.getNacimiento().after(f)) {
        	throw new ProveedorNoNacidoException();
        }
        Departamento insDep = mDep.getDepartamento(dep);
        
        Map<String,Categoria> categorias = new HashMap<String,Categoria>();
        for(String stringCat : cat){
        	Categoria categ = mc.getCategoria(stringCat);
        	categorias.put(categ.getCategoria(), categ);
        }
        act = new Actividad(nom, desc,f,ciudad, costo, dur, insDep, categorias);
        if(u instanceof Proveedor) {
        	((Proveedor) u).agregarActividad(act);
        }
        
        mAct.addActividad(act);
        // if agregado por si Departamento no esta cargado da errror VER SI QUITAR
        if(insDep != null)
        	insDep.agregarActividad(act);
        
      

    }
    
    
    public void registrarCategoria(String Categoria) throws CategoriaYaExiste{
    	//si existe una categoria con nombre categoria tiro exepcion 
    	ManejadorCategoria mc = ManejadorCategoria.getInstance();
    	if(mc.pertenece(Categoria)) {
    		throw new CategoriaYaExiste("Ya existe una categoria registrada con nombre:" + Categoria);
    	} else {
    		Categoria cat = new Categoria(Categoria) ; 
    		mc.addCategoria(cat);
    	}
    }
    
    public DataDepartamento[] obtenerDataDepartamentos() throws DepartamentoNoExisteException{
    	ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();
    	DataDepartamento[] res = md.obtenerDataDepartamentos();
    	if (res == null) {
    		throw new DepartamentoNoExisteException("No existen departamentos");
    	} else {
    	return res;
    	}
    }
    
    public Set<String> obtenerNombreCategorias() throws NoExisteCategoriaException{
    	ManejadorCategoria mc = ManejadorCategoria.getInstance();
    	Set<String> res = mc.obtenerNombreCategorias();
    	if (res.size() == 0){
    		throw new NoExisteCategoriaException("No existen categorias registradas en el sistema");
    	}
    	return res;
    }
    
    
    
    
    public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(ci);
        if (u != null)
            return u.getDataUsuario();
        else
            throw new UsuarioNoExisteException("El usuario " + ci + " no existe");

    }

    public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        DataUsuario[] usrs = mu.getUsuarios();

        if (usrs != null) {
            return usrs;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");

    }

    

    public void confirmarAltaDepartamento(String nombre, String descripcion, String URL) throws DepartamentoYaExisteExeption {
        ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();

        Departamento deptoprueba = md.getDepartamento(nombre);
        if (deptoprueba != null)
            throw new DepartamentoYaExisteExeption("Ya existe un departamento registrado con el nombre:  " + nombre);

        Departamento dpto = new Departamento(nombre, descripcion, URL) ;
        md.addDepartamento(dpto) ;
    }


    public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad{
        ManejadorActividad ma = ManejadorActividad.getInstance();
        Actividad act = null;
		try {
			act = ma.getActividad(nombreActividad);
			ma.verificarSalida(nombreSalida);
			if(fecha.before(fechaAlta)) {
				throw new FechaAltaSalidaInvalida();
			}
			if(fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad();
			}
	        act.altaSalida(nombreSalida, fecha, hora, lugar, maxCantTuristas,fechaAlta);
		} catch (ActividadNoExisteException e) {
			
		}
    }
    
    public void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta) throws PaqueteRepetidoException {
    	ManejadorPaquete mp = ManejadorPaquete.getInstance();
        Paquete p = mp.getPaquete(nombre);
        if (p != null)
            throw new PaqueteRepetidoException("Ya existe un paquete registrado con el nombre:  " + nombre);
        p = new Paquete(nombre, descripcion, descuento, fechaAlta, validez);
        mp.addPaquete(p);
    }

    public void actualizarDatosTurista(String nick,String mail,String nombre,String apellido,Date fechaN,String nacionalidad) {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario u = mu.obtenerUsuarioNick(nick);
    	if(u!=null) {
    		if(u instanceof Turista) {
    			u.setNombre(nombre);
    			u.setApellido(apellido);
    			u.setNacimiento(fechaN);
    			((Turista) u).setNacionalidad(nacionalidad);
    		}
    	}
    }
    
    public void actualizarDatosProveedor(String nick,String mail,String nombre,String apellido,Date fechaN,String descripcion,String link,boolean hayLink) {
    	ManejadorUsuario mu = ManejadorUsuario.getinstance();
    	Usuario u = mu.obtenerUsuarioNick(nick);
    	if(u!=null) {
    		if(u instanceof Proveedor) {
        		u.setNombre(nombre);
        		u.setApellido(apellido);
        		u.setNacimiento(fechaN);
        		((Proveedor) u).setDescripcion(descripcion);
        		((Proveedor) u).setLink(link);
        		((Proveedor) u).setHayLink(hayLink);
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
	      BufferedImage img = ImageIO.read(new File("./src/data/p1.jpg"));
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ImageIO.write(img, "jpg", baos);
	      byte[] imgBytes = baos.toByteArray();
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date fa = formato.parse(nextLine[4].strip());
	    		  altaPaquete(nextLine[1].strip(),nextLine[5].strip(),Integer.parseInt(nextLine[3].strip()),Integer.parseInt(nextLine[2].strip()),fa,imgBytes);
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}


	private void altaPaquete(String nombre, String descripcion, int descuento, int validez, Date fechaAlta, byte[] imgBytes) throws PaqueteRepetidoException {
		// TODO Auto-generated method stub
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
        Paquete p = mp.getPaquete(nombre);
        if (p != null)
            throw new PaqueteRepetidoException("Ya existe un paquete registrado con el nombre:  " + nombre);
        p = new Paquete(nombre, descripcion, descuento, fechaAlta, validez, imgBytes);
        mp.addPaquete(p);
	}


	@Override
	public void confirmarAltaTurista(String nick, String nom, String ap, String mail, Date nacimiento,
			String nacionalidad, String pass) throws UsuarioRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Turista(nick, nom, ap, mail, nacimiento, nacionalidad,pass);
        mu.addUsuario(u);
		
	}


	@Override
	public void confirmarAltaTurista(String nick, String nom, String ap, String mail, Date nacimiento,
			String nacionalidad, String pass, byte[] imagen) throws UsuarioRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Turista(nick, nom, ap, mail, nacimiento, nacionalidad,pass,imagen);
        mu.addUsuario(u);
		
	}


	@Override
	public void confirmarAltaProveedor(String nick, String nom, String ap, String mail, Date nacimiento,
			String descripcion, String link, boolean hayLink, String pass) throws UsuarioRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Proveedor(nick, nom, ap, mail, nacimiento, descripcion, link, hayLink,pass);
        mu.addUsuario(u);
	}


	@Override
	public void confirmarAltaProveedor(String nick, String nom, String ap, String mail, Date nacimiento,
			String descripcion, String link, boolean hayLink, String pass, byte[] imagen)
			throws UsuarioRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(nick);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el nickname:  " + nick);
        u = mu.obtenerUsuarioMail(mail);
        if (u != null)
            throw new UsuarioRepetidoException("Ya existe un usuario registrado con el mail:" + mail);
        u = new Proveedor(nick, nom, ap, mail, nacimiento, descripcion, link, hayLink,pass,imagen);
        mu.addUsuario(u);
	}


	@Override
	public void cargarDatos() throws Exception {
		cargarUsuarios();
		cargarDptos();
		cargarActs();
		cargarSalidas();
		Fabrica f = Fabrica.getInstance();
		IControladorInsc i = f.getIControladorInsc();
		i.cargarInsc();
		cargarPaquetes();
		i.cargarActsPaqs();
	}


	@Override
	public void registrarActividad(String dep, String nom, String desc, int dur, int costo, String ciudad, Date f,
			String proveedor, Set<String> cat, byte[] imagen)
			throws ActividadRepetidaException, UsuarioNoExisteException, ProveedorNoNacidoException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        Usuario u =  mu.obtenerUsuarioNick(proveedor);
    	Actividad act = null;
		try {
			act = mAct.getActividad(nom);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
		}
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);
        if (u == null) {
        	throw new UsuarioNoExisteException("No existe el Usuario identificado como " + proveedor);
        }
        if (u.getNacimiento().after(f)) {
        	throw new ProveedorNoNacidoException();
        }
        Departamento insDep = mDep.getDepartamento(dep);
        
        Map<String,Categoria> categorias = new HashMap<String,Categoria>();
        for(String stringCat : cat){
        	Categoria categ = mc.getCategoria(stringCat);
        	categorias.put(categ.getCategoria(), categ);
        }
        act = new Actividad(nom, desc,f,ciudad, costo, dur, insDep, categorias,imagen);
        if(u instanceof Proveedor) {
        	((Proveedor) u).agregarActividad(act);
        }
        
        mAct.addActividad(act);
        // if agregado por si Departamento no esta cargado da errror VER SI QUITAR
        if(insDep != null)
        	insDep.agregarActividad(act);
        
	}


	@Override
	public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar,
			int maxCantTuristas, Date fechaAlta, byte[] imagen)
			throws SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {
		ManejadorActividad ma = ManejadorActividad.getInstance();
        Actividad act = null;
		try {
			act = ma.getActividad(nombreActividad);
			ma.verificarSalida(nombreSalida);
			if(fecha.before(fechaAlta)) {
				throw new FechaAltaSalidaInvalida();
			}
			if(fechaAlta.before(act.getFechaAlta())) {
				throw new FechaAltaSalidaAnteriorActividad();
			}
	        act.altaSalida(nombreSalida, fecha, hora, lugar, maxCantTuristas,fechaAlta,imagen);
		} catch (ActividadNoExisteException e) {
			
		}
	}


	@Override
	public void cargarUsuarios(CSVReader reader, byte[] imgBytes)
			throws IOException, UsuarioRepetidoException, ParseException {
		CSVReader usu = reader;
	      String[] nextLineusu;
	      
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLineusu = usu.readNext()) != null) {
	    	  if(cont>0) {
	    		  
	    		  if(nextLineusu[1].equals(" T")) {
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6].strip());
	    			  confirmarAltaTurista(nextLineusu[2].strip(),nextLineusu[3].strip(),nextLineusu[4].strip(),nextLineusu[5].strip(),fecha,nextLineusu[7].strip(),"1234",imgBytes);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaProveedor(nextLineusu[2].strip(),nextLineusu[3].strip(),nextLineusu[4].strip(),nextLineusu[5].strip(),fecha,nextLineusu[8].strip(),nextLineusu[9].strip(),true,"1234",imgBytes);
	    		  }
	    	  }
	    		  
	    	  cont++;
	      }
		
	}


	@Override
	public void cargarActs(CSVReader reader, byte[] imgBytes)
			throws IOException, DepartamentoYaExisteExeption, NumberFormatException, ActividadRepetidaException,
			ParseException, UsuarioNoExisteException, ProveedorNoNacidoException {
		
	      String[] nextLine;
	      int cont = 0;
	     
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date f = formato.parse(nextLine[7].strip());
	    		  Set<String> coso = new HashSet<String>(); 
	    		  registrarActividad(nextLine[6].strip(),nextLine[1].strip(),nextLine[2].strip(),Integer.parseInt(nextLine[3]),Integer.parseInt(nextLine[4]),nextLine[5].strip(),f,nextLine[9].strip(), coso,imgBytes);
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}


	@Override
	public void cargarSalidas(CSVReader reader, byte[] imgBytes) throws NumberFormatException, IOException,
			ParseException, SalidaYaExisteExeption, FechaAltaSalidaInvalida, FechaAltaSalidaAnteriorActividad {

	      String[] nextLine;
	      int cont = 0;
	      
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date f = formato.parse(nextLine[3].strip());
	    		  Date fa = formato.parse(nextLine[7].strip());
	    		  int hora = Integer.parseInt(nextLine[4].strip());
	    		  Date h = new Date(0,0,0,hora,0);
	    		  confirmarAltaSalida(nextLine[1].strip(),nextLine[2].strip(),f,h,nextLine[6].strip(),Integer.parseInt(nextLine[5]),fa,imgBytes);
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
		
	}
}
