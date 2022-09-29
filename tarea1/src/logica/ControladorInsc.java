package logica;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opencsv.CSVReader;

import excepciones.ActividadNoExisteException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.estadoActividadIncorrecto;
import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorPaquete;
import manejadores.ManejadorUsuario;

public class ControladorInsc implements IControladorInsc {
	public Set<DataActividad> selecDepartamento(String dep){
		ManejadorDepartamentos m = ManejadorDepartamentos.getInstance();
		Departamento d = m.getDepartamento(dep);
		return d.getActividades();
	}
	
	public Set<DataSalida> salidas(String nombreAct) throws ActividadNoExisteException{
		ManejadorActividad m = ManejadorActividad.getInstance();
		Actividad a = m.getActividad(nombreAct);
		return a.getSalidas();
	}
	
	
	public void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido {
		  CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Inscripciones.csv"));
	      String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
	    		  Date f = formato.parse(nextLine[5].strip());
	    		  inscribir(nextLine[2].strip(),nextLine[1].strip(),Integer.parseInt(nextLine[3]),f,nextLine[6].strip());
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}
	
	
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido {
		ManejadorActividad m = ManejadorActividad.getInstance();
		Actividad a = m.getActividad(nombreAct);
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Usuario t = mu.obtenerUsuarioNick(nick);
		int c = a.getCosto();
		int costo = c*cantTuristas;
		Salida s = a.getSalida(nomSalida);
		// Chequeo de condiciones
		if (((Turista) t).yaTieneSalida(s)) { // Sabemos por precondicion que se puede hacer el downcast
			throw new TuristaConSalida("El turista ya pertenece a la salida");
		}
		if(s.excedeTuristas(cantTuristas)) {
			throw new ExcedeTuristas("La salida no cuenta con capacidad para la cantidad de turistas solicitados");
		}
		if(fecha.before(s.getFechaAlta())) {
			throw new InscFechaInconsistente("La fecha de inscripcion debe ser igual o posterior a la fecha de alta de salida");
		}
		if(fecha.after(s.getFecha())) {
			throw new InscFechaDespSalida();
		}
		if(((Turista) t).getNacimiento().after(s.getFecha())) {
			throw new TuristaNoHaNacido();
		}
		// Se realiza la inscripcion
		CompraGeneral cg = new CompraGeneral(fecha,cantTuristas,costo);
		cg.setSalida(s);
		s.setCantRestante(s.getCantRestante()-cantTuristas);
		((Turista) t).agregarCompraGeneral(cg);
	}
	
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct, String nombrePaq) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException {
		ManejadorActividad m = ManejadorActividad.getInstance();
		Actividad a = m.getActividad(nombreAct);
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Usuario t = mu.obtenerUsuarioNick(nick);
		Salida s = a.getSalida(nomSalida);
		CompraPaquete cp = ((Turista) t).getCompraPaquete(nombrePaq);
		// Chequeo de condiciones
		if (((Turista) t).yaTieneSalida(s)) { // Sabemos por precondicion que se puede hacer el downcast
			throw new TuristaConSalida("El turista ya pertenece a la salida");
		}
		if(s.excedeTuristas(cantTuristas)) {
			throw new ExcedeTuristas("La salida no cuenta con capacidad para la cantidad de turistas solicitados");
		}
		if(fecha.before(s.getFechaAlta())) {
			throw new InscFechaInconsistente("La fecha de inscripcion debe ser igual o posterior a la fecha de alta de salida");
		}
		if(fecha.after(s.getFecha())) {
			throw new InscFechaDespSalida();
		}
		if(((Turista) t).getNacimiento().after(s.getFecha())) {
			throw new TuristaNoHaNacido();
		}
		if(!((Turista) t).paqueteComprado(nombrePaq)) {
			throw new PaqueteRepetidoException("El paquete: " + nombrePaq + " no ha sido comprado por el turista: " + nick);
		}
		cp.reducirCuposAct(nombreAct, cantTuristas);
		int c = a.getCosto();
		int costo = c*cantTuristas*(1 - (cp.getDescuento()/100));
		// Se realiza la inscripcion
		CompraGeneral cg = new CompraGeneral(fecha,cantTuristas,costo);
		cg.setSalida(s);
		s.setCantRestante(s.getCantRestante()-cantTuristas);
		((Turista) t).agregarCompraGeneral(cg);
	}

	@Override
	public Set<DataDepartamento> listarDepartamentos() {
		ManejadorDepartamentos m = ManejadorDepartamentos.getInstance();
		Set<DataDepartamento> res = new HashSet<DataDepartamento>();
		if(m.obtenerDataDepartamentos()!=null)
		for(DataDepartamento iter:m.obtenerDataDepartamentos()) {
			boolean u = res.add(iter);
		}
		return res;
	}

	@Override
	public String[] listarPaquetes() {
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		return mp.getPaquetesN();
	}

	@Override
	public Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String Dep, String paquete) {
		ManejadorDepartamentos md = ManejadorDepartamentos.getInstance();
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		Date fecha = mp.getPaquete(paquete).getFechaAlta();
		Departamento dep = md.getDepartamento(Dep);
		Actividad[] auxi = dep.getActividadesDep();
		Set<DataActividad> res = new HashSet<DataActividad>();
		for(int i = 0; i<auxi.length; i++) {
			if(!auxi[i].pertenecePaquete(paquete)) {
				res.add(auxi[i].getDataAT());
			}
		}
		return res;
	}
	
	public void cargarActsPaqs() throws Exception {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/ActividadesPaquetes.csv"));
	      String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if(cont!=0) {
	    		  confirmar(nextLine[1].strip(),nextLine[2].strip());
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}
	
	@Override
	public void confirmar(String paq, String act) {
		ManejadorActividad ma = ManejadorActividad.getInstance();
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		try {
			Actividad actIns = ma.getActividad(act);
			Paquete paqIns = mp.getPaquete(paq);
			paqIns.agregarActividad(actIns);
			actIns.addPaquete(paqIns);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public DataUsuario[] listarUsuarios() {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		return  mu.getUsuarios();
	}

	@Override
	public Set<String> listarActividadesAgregadas() {
		Set<String> res = new HashSet<String>();
		ManejadorActividad ma = ManejadorActividad.getInstance();
		for (DataActividad it : ma.getDAct()) {
			if (it.getEstado().name() == estadoAct.agregada.name() ) {
				res.add(it.getNombre());
			}
		}
		return res;
	}

	@Override
	public void aceptarRechazarAct(String nomAct, estadoAct estado) throws estadoActividadIncorrecto, ActividadNoExisteException {
		if (estado.name() != estadoAct.confirmada.name() && estado.name() != estadoAct.rechazada.name()) {
			throw new estadoActividadIncorrecto();
		}
		ManejadorActividad ma = ManejadorActividad.getInstance();
		ma.getActividad(nomAct).setEstado(estado);
	}
	
	@Override
	public String[] listarPaquetesNoComprados() {
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		return mp.getPaquetesNoComp();
		
	}
	
	public void comprarPaquete(String nick, Date fecha, int cant, String paqString) throws PaqueteNoExisteException, PaqueteRepetidoException {
		ManejadorPaquete mp = ManejadorPaquete.getInstance();
		Paquete paq = mp.getPaqueteIns(paqString);
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Turista t = ((Turista) mu.obtenerUsuarioNick(nick));
		if(t.paqueteComprado(paqString)) {
			throw new PaqueteRepetidoException("El paquete: " + paqString + " ya ha sido comprado por el turista: " + nick);
		}
		CompraPaquete cp = new CompraPaquete(fecha, cant, paq);
		t.agregarCompraPaquete(paqString,cp);
	}
}
