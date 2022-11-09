package logica;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.SalidasVigentesException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import manejadores.ManejadorActividad;
import manejadores.ManejadorUsuario;

public class Prueba {

	public static void main(String[] args) {
		Fabrica fab = Fabrica.getInstance();
		IControladorAlta iConAlta = fab.getIControladorAlta();
		IControladorInsc iConInsc = fab.getIControladorInsc();
		try {
			iConAlta.confirmarAltaDepartamento("DepNombre", "DepDesc", "DepUrl");
			iConAlta.registrarCategoria("CatNombre");
			Date provDate = new Date(0,0,0);
			iConAlta.confirmarAltaProveedor("ProvNick", "ProvNom", "ProvApellido", "ProvMail", provDate, "ProvDesc", "ProvLink", true, "ProvContra", null);
			Date turDate = new Date(0,0,0);
			iConAlta.confirmarAltaTurista("TurNick", "TurNom", "TurApellido", "TurMail", turDate, "TurNacion", "TurContra", null);
			Set<String> categorias = new HashSet<String>();
			categorias.add("CatNombre");
			Date actDate = new Date(1,0,0);
			iConAlta.registrarActividad("DepNombre", "ActNombre", "ActDesc", 5, 5, "ActCiudad", actDate, "ProvNick", categorias, null, false);
			Date salDate = new Date(2,0,0);
			Date salDateH = new Date(0,0,0);
			Date salDate2 = new Date(4,0,0);			
			iConAlta.confirmarAltaSalida("ActNombre", "SalNombre", salDate2, salDateH, "SalLugar", 5, salDate);
			Date inscDate = new Date(3,0,0);
			iConInsc.inscribir("TurNick", "SalNombre", 1, inscDate, "ActNombre");
			iConInsc.finalizarActividad("ActNombre");
			ManejadorUsuario manUsu = ManejadorUsuario.getinstance();
			Proveedor proveedor = (Proveedor) manUsu.obtenerUsuarioNick("ProvNick");
			ManejadorActividad manAct = ManejadorActividad.getInstance();
			manAct.finalizarAct("ActNombre", proveedor);
		} catch (DepartamentoYaExisteExeption | UsuarioRepetidoException | CategoriaYaExiste | ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException | SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad | TuristaConSalida | ExcedeTuristas | InscFechaInconsistente | ActividadNoExisteException | InscFechaDespSalida | TuristaNoHaNacido | SalidasVigentesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
