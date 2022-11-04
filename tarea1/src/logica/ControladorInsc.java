package logica;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVReader;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.SalidasNoExisteException;
import excepciones.SalidasVigentesException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import excepciones.estadoActividadIncorrecto;
import manejadores.ManejadorActividad;
import manejadores.ManejadorDepartamentos;
import manejadores.ManejadorPaquete;
import manejadores.ManejadorUsuario;

public class ControladorInsc implements IControladorInsc {
	public Set<DataActividad> selecDepartamento(String dep){
		ManejadorDepartamentos manDep = ManejadorDepartamentos.getInstance();
		Departamento depIns = manDep.getDepartamento(dep);
		return depIns.getActividades();
	}
	
	public Set<DataSalida> salidas(String nombreAct) throws ActividadNoExisteException{
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		Actividad act = mAct.getActividad(nombreAct);
		return act.getSalidas();
	}
	
	
	public void cargarInsc() throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException {
		  CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/Inscripciones.csv"));
	      String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  if (cont<=10) { // general
		    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
		    		  Date fecha = formato.parse(nextLine[5].strip());
		    		  inscribir(nextLine[2].strip(), nextLine[1].strip(), Integer.parseInt(nextLine[3]), fecha, nextLine[6].strip());
		    	  }
		    	  else if (cont<=22) { // paquete
		    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
		    		  Date fecha = formato.parse(nextLine[5].strip());
		    		  inscribir(nextLine[2].strip(), nextLine[1].strip(), Integer.parseInt(nextLine[3]), fecha, nextLine[6].strip(), nextLine[8].strip());
		    	  }
	    	  }
	    	  cont++;
	      }
	}
	
	public void cargarInsc(CSVReader reader) throws NumberFormatException, IOException, ParseException, TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException {
		
	      String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  if (cont<=10) { // general
		    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
		    		  Date fecha = formato.parse(nextLine[5].strip());
		    		  inscribir(nextLine[2].strip(), nextLine[1].strip(), Integer.parseInt(nextLine[3]), fecha, nextLine[6].strip());
		    	  }
		    	  else if (cont<=22) { // paquete
		    		  SimpleDateFormat formato = new SimpleDateFormat("dd–MM--yyyy");
		    		  Date fecha = formato.parse(nextLine[5].strip());
		    		  inscribir(nextLine[2].strip(), nextLine[1].strip(), Integer.parseInt(nextLine[3]), fecha, nextLine[6].strip(), nextLine[8].strip());
		    	  }
	    	  }
	    	  cont++;
	      }
	}
	
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		Actividad act = mAct.getActividad(nombreAct);
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Turista tur = (Turista) mUsu.obtenerUsuarioNick(nick);
		int costo = act.getCosto();
		costo = costo*cantTuristas;
		Salida sal = act.getSalida(nomSalida);
		// Chequeo de condiciones
		if (tur.yaTieneSalida(sal)) { // Sabemos por precondicion que se puede hacer el downcast
			throw new TuristaConSalida("El turista ya pertenece a la salida");
		}
		if (sal.excedeTuristas(cantTuristas)) {
			throw new ExcedeTuristas("La salida no cuenta con capacidad para la cantidad de turistas solicitados");
		}
		if (fecha.before(sal.getFechaAlta())) {
			throw new InscFechaInconsistente("La fecha de inscripcion debe ser igual o posterior a la fecha de alta de salida");
		}
		if (fecha.after(sal.getFecha())) {
			throw new InscFechaDespSalida("La fecha de inscripcion es posterior a la fecha de salida");
		}
		if (((Turista) tur).getNacimiento().after(sal.getFecha())) {
			throw new TuristaNoHaNacido("El turista aun no ha nacido");
		}
		// Se realiza la inscripcion
		CompraGeneral compraGen = new CompraGeneral(fecha, cantTuristas, costo);
		compraGen.setSalida(sal);
		sal.setCantRestante(sal.getCantRestante()-cantTuristas);
		((Turista) tur).agregarCompraGeneral(compraGen);
	}
	
	public void inscribir(String nick, String nomSalida, int cantTuristas, Date fecha, String nombreAct, String nombrePaq) throws TuristaConSalida, ExcedeTuristas, InscFechaInconsistente, ActividadNoExisteException, InscFechaDespSalida, TuristaNoHaNacido, PaqueteRepetidoException, NoHayCuposException {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		Actividad act = mAct.getActividad(nombreAct);
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Turista tur = (Turista) mUsu.obtenerUsuarioNick(nick);
		Salida sal = act.getSalida(nomSalida);
		CompraPaquete compraPaq = ((Turista) tur).getCompraPaquete(nombrePaq);
		// Chequeo de condiciones
		if (tur.yaTieneSalida(sal)) { // Sabemos por precondicion que se puede hacer el downcast
			throw new TuristaConSalida("El turista ya pertenece a la salida");
		}
		if (sal.excedeTuristas(cantTuristas)) {
			throw new ExcedeTuristas("La salida no cuenta con capacidad para la cantidad de turistas solicitados");
		}
		if (fecha.before(sal.getFechaAlta())) {
			throw new InscFechaInconsistente("La fecha de inscripcion debe ser igual o posterior a la fecha de alta de salida");
		}
		if (fecha.after(sal.getFecha())) {
			throw new InscFechaDespSalida("La fecha de inscripcion es posterior a la fecha de salida");
		}
		if (((Turista) tur).getNacimiento().after(sal.getFecha())) {
			throw new TuristaNoHaNacido("El turista aun no ha nacido");
		}
		if (!((Turista) tur).paqueteComprado(nombrePaq)) {
			throw new PaqueteRepetidoException("El paquete: " + nombrePaq + " no ha sido comprado por el turista: " + nick);
		}
		if (fecha.after(compraPaq.getVencimiento())) {
			throw new InscFechaInconsistente("La fecha de inscripcion debe ser anterior a la fecha del vencimiento del paquete");
		}
		compraPaq.reducirCuposAct(nombreAct, cantTuristas);
		float costo = act.getCosto();
		costo = costo*cantTuristas*(1 - ((float) (compraPaq.getDescuento())/100));
		int cost = Math.round(costo);
		// Se realiza la inscripcion
		CompraGeneral compraGen = new CompraGeneral(fecha, cantTuristas, cost, true);
		compraGen.setSalida(sal);
		sal.setCantRestante(sal.getCantRestante()-cantTuristas);
		((Turista) tur).agregarCompraGeneral(compraGen);
	}

	@Override
	public Set<DataDepartamento> listarDepartamentos() {
		ManejadorDepartamentos manDep = ManejadorDepartamentos.getInstance();
		Set<DataDepartamento> res = new HashSet<DataDepartamento>();
		if (manDep.obtenerDataDepartamentos()!=null)
		for (DataDepartamento iter:manDep.obtenerDataDepartamentos()) {
			res.add(iter);
		}
		return res;
	}

	@Override
	public String[] listarPaquetes() {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		return mPaq.getPaquetesN();
	}

	@Override
	public Set<DataActividad> actividadesPorDepartamentoNoEnPaquete(String depN, String paquete) {
		ManejadorDepartamentos mDep = ManejadorDepartamentos.getInstance();
		Departamento dep = mDep.getDepartamento(depN);
		Actividad[] auxi = dep.getActividadesDep();
		Set<DataActividad> res = new HashSet<DataActividad>();
		for (int i = 0; i<auxi.length; i++) {
			if (!auxi[i].pertenecePaquete(paquete)) {
				res.add(auxi[i].getDataAT());
			}
		}
		return res;
	}
	
	public void cargarActsPaqs() throws IOException {
		CSVReader reader = null;
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("./src/data/ActividadesPaquetes.csv"));
	      String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  confirmar(nextLine[1].strip(), nextLine[2].strip());
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
	}
	
	@Override
	public void confirmar(String paq, String act) {
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		try {
			Actividad actIns = mAct.getActividad(act);
			Paquete paqIns = mPaq.getPaquete(paq);
			paqIns.agregarActividad(actIns);
			actIns.addPaquete(paqIns);
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public DataUsuario[] listarUsuarios() {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		return  mUsu.getUsuarios();
	}

	@Override
	public Set<String> listarActividadesAgregadas() {
		Set<String> res = new HashSet<String>();
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		for (DataActividad it : mAct.getDAct()) {
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
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		mAct.getActividad(nomAct).setEstado(estado);
	}
	
	@Override
	public String[] listarPaquetesNoComprados() {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		return mPaq.getPaquetesNoComp();
		
	}
	
	public String[] obtenerPaquetesComprados(String nickTurista) {
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Turista tur = (Turista) mUsu.obtenerUsuarioNick(nickTurista);
		return tur.getComprasP().keySet().toArray(new String[0]);
	}
	
	public void comprarPaquete(String nick, Date fecha, int cant, String paqString) throws PaqueteNoExisteException, PaqueteRepetidoException {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstance();
		Paquete paq = mPaq.getPaqueteIns(paqString);
		ManejadorUsuario mUsu = ManejadorUsuario.getinstance();
		Turista tur = (Turista) mUsu.obtenerUsuarioNick(nick);
		if (tur.paqueteComprado(paqString)) {
			throw new PaqueteRepetidoException("El paquete: " + paqString + " ya ha sido comprado por el turista: " + nick);
		}
		CompraPaquete compraPaq = new CompraPaquete(fecha, cant, paq);
		tur.agregarCompraPaquete(paqString, compraPaq);
	}
	
	public String obtenerNomActPorSalida(String salida) throws SalidasNoExisteException{
		ManejadorActividad mAct = ManejadorActividad.getInstance();
		return mAct.obtenerNomActvidiadDeSalida(salida);
	}

	
	public void seguirDejarDeSeguirUsuario(String nickSeguidor, String nickSeguido, boolean seguir) throws UsuarioNoExisteException, UsuarioRepetidoException{
		ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
		Usuario seguidor = manUsu.obtenerUsuarioNick(nickSeguidor);
		Usuario seguido = manUsu.obtenerUsuarioNick(nickSeguido);
		if (seguidor == null) {
			throw new UsuarioNoExisteException("No existe un usuario con el nick " + nickSeguidor);
		}
		if (seguido == null) {
			throw new UsuarioNoExisteException("No existe un usuario con el nick " + nickSeguido);
		}
		if (seguir) {
			seguidor.seguirUsuario(seguido);
			seguido.agregarSeguidor(seguidor);
		} else {
			seguidor.dejarDeSeguirUsuario(seguido);
			seguido.eliminarSeguidor(seguidor);
		}
	}
	
	public void agregarQuitarActividadFavorita(String nickTurista, String nombreAct, boolean agregar) throws UsuarioNoExisteException, ActividadNoExisteException, ActividadRepetidaException {
		ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
		Usuario usuAux = manUsu.obtenerUsuarioNick(nickTurista);
		if (usuAux ==null || !(usuAux instanceof Turista)) {
			throw new UsuarioNoExisteException("El nick " + nickTurista + " no coincide con un turista registrado en el sistema");
		}
		Turista tur = (Turista) usuAux;
		ManejadorActividad manAct = ManejadorActividad.getInstance();
		Actividad act = manAct.getActividad(nombreAct);
		tur.agregarQuitarActividadFavorita(act, agregar);
	}
	
	@Override
	public void cargarActsPaqs(CSVReader reader) throws IOException {
		String[] nextLine;
	      int cont = 0;
	      //reads one line at a time  
	      while ((nextLine = reader.readNext()) != null) {
	    	  if (cont!=0) {
	    		  confirmar(nextLine[1].strip(), nextLine[2].strip());
	    	  }
	    	  else {
	    		  cont++;
	    	  }
	      }
		
	}
	
	public void finalizarActividad(String nombreActividad) throws ActividadNoExisteException, SalidasVigentesException {
		ManejadorActividad manAct = ManejadorActividad.getInstance();
			Actividad act = manAct.getActividad(nombreActividad);
			Map<String, Salida> salidasAct = act.getColSal();
			boolean salidasTerminadas = true;
			Date fechaActualS = new Date();
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            String str2 = formatter2.format(fechaActualS);
			for (Map.Entry<String, Salida> entry : salidasAct.entrySet()) {
				Salida salida = entry.getValue();
				if(salida.getFecha().after(fechaActualS)) {
					salidasTerminadas = false;
				}
			}
			if(salidasTerminadas) {
				act.setEstado(estadoAct.finalizada);
			}else {
				throw new SalidasVigentesException("La actividad cuenta con salidas Vigentes");
			}
		
		
	}

}
