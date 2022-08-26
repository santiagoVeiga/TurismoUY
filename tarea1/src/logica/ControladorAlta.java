package logica;

import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opencsv.CSVReader;

import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorUsuario;

/**
 * Controlador de altas.
 * @author TProg2017
 *
 */
public class ControladorAlta implements IControladorAlta {
	
	public void cargarActs() throws IOException, DepartamentoYaExisteExeption {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./lib/Actividades.csv"));
	      String[] nextLine;
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLine = reader.readNext()) != null) {
	      }
	}
	
	public void cargarDptos() throws IOException, DepartamentoYaExisteExeption {
	    CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./lib/Departamentos.csv"));
	      String[] nextLine;
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont>0)
	    		  confirmarAltaDepartamento(nextLine[1],nextLine[2],nextLine[3]);
	    	  cont++;
	      }
	 }
	
	public void cargarUsuarios() throws IOException, UsuarioRepetidoException, ParseException {
	    CSVReader usu = null;
	      //parsing a CSV file into CSVReader class constructor  
	      usu = new CSVReader(new FileReader("./lib/Usuarios.csv"));
	      
	      String[] nextLineusu;
	      
	      //reads one line at a time  
	      int cont = 0;
	      while ((nextLineusu = usu.readNext()) != null) {
	    	  if(cont>0) {
	    		  
	    		  if(nextLineusu[1].equals(" T")) {
	    			  
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaTurista(nextLineusu[2],nextLineusu[3],nextLineusu[4],nextLineusu[5],fecha,nextLineusu[7]);
	    		  }
	    		  else if (nextLineusu[1].equals(" P")) {
	    			
	    			  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    			  Date fecha = formato.parse(nextLineusu[6]);
	    			  confirmarAltaProveedor(nextLineusu[2],nextLineusu[3],nextLineusu[4],nextLineusu[5],fecha,nextLineusu[8],nextLineusu[9],true);
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
    
    public void registrarActividad(String dep, String nom , String desc,int dur, int costo, String ciudad ,Date f) throws ActividadRepetidaException {
    	ManejadorActividad mAct = ManejadorActividad.getInstance();
    	ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
    	Actividad act = mAct.getActividad(nom);
        if (act != null)
            throw new ActividadRepetidaException("Ya existe una actividad registrada con el nombre:  " + nom);
        Departamento insDep = mDep.getDepartamento(dep);
        act = new Actividad(nom, desc,f,ciudad, costo, dur, insDep);
        mAct.addActividad(act);
        // if agregado por si Departamento no esta cargado da errror VER SI QUITAR
        if(insDep != null)
        	insDep.agregarActividad(act);
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
    
    public DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuarioNick(ci);
        if (u != null)
            return null; //new DataUsuario(u.getNombre(), u.getApellido(), u.getCedulaIdentidad());
        else
            throw new UsuarioNoExisteException("El usuario " + ci + " no existe");

    }

    public DataUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario[] usrs = mu.getUsuarios();

        if (usrs != null) {
            DataUsuario[] du = new DataUsuario[usrs.length];
            Usuario usuario;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                du[i] = null; //new DataUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCedulaIdentidad());
            }

            return du;
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


    public void confirmarAltaSalida(String nombreActividad, String nombreSalida, Date fecha, Date hora, String lugar, int maxCantTuristas, Date fechaAlta) throws SalidaYaExisteExeption{
        ManejadorActividad ma = ManejadorActividad.getInstance();
        Actividad act = ma.getActividad(nombreActividad);

        //chequeo si existe una salida con el mismo nombre que el ingresado en el sistema, recorriendo las salidas registradas para todas las actividades
        boolean existeSalidaNombre = false ;
        DataActividad setDact = ma.getDAct();
        Map<String,Actividad> coleccionAct = ma.getColAct() ;
        for (Map.Entry<String,Actividad> entry : coleccionAct.entrySet()){
            Actividad acti = entry.getValue() ;
            Map<String,Salida> coleccionSal = acti.getColSal() ;
            for (Map.Entry<String,Actividad> entry2 : coleccionSal.entrySet()){
                if(entry2.getValue().getNombre() == nombreActividad)
                    existeSalidaNombre = true ;
            }
        }
        if (existeSalidaNombre)
            throw new SalidaYaExisteExeption("ya existe una salida registrada para esta actividad con el nombre : " + nombreSalida) ; 

        Salida salida = new Salida(nombreActividad, lugar, hora, fecha, fechaAlta, maxCantTuristas);
        act.addSalida(salida);

    }
}
