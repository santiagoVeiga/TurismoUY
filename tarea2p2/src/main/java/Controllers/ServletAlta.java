package Controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadRepetidaException;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataActividad;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.DataProveedor;
import logica.Fabrica;
import logica.IControladorAlta;

/**
 * Servlet implementation class Home
 */

@WebServlet (urlPatterns={"/ModificarUsuario","/SalidaCreada","/UsuarioCreado","/ActividadCreada","/AltaSalida","/AltaActividad","/AltaUsuario"})

public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();;
	private IControladorAlta conAlta;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		switch(req.getServletPath()){
			case "/AltaUsuario":
				req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req,resp);
				break;
			case "/AltaActividad":
				// manda una redirección a otra URL (cambia la URL)
				resp.sendRedirect("/WEB-INF/alta_actividad.jsp");
				break;
			case "/AltaSalida":
				req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				break;
			case "/UsuarioCreado":
				DataUsuario du = (DataUsuario) req.getAttribute("DataUsuario");
				conAlta = fab.getIControladorAlta();
				try {
					if(du instanceof DataTurista) {
						conAlta.confirmarAltaTurista(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataTurista) du).getNacionalidad());
					} else {
						conAlta.confirmarAltaProveedor(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataProveedor) du).getDescripcion(),((DataProveedor) du).getLink(),true); //((DataProveedor) du).getHayLink());
					}
					HttpSession session = req.getSession();
					session.setAttribute("usuario",du);
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (UsuarioRepetidoException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_usuario.jsp").forward(req,resp);
				}
				break;
			case "/ActividadCreada":
				DataActividad da = (DataActividad) req.getAttribute("DataActividad");
				HttpSession session1 = req.getSession();
				DataUsuario aux = (DataUsuario) session1.getAttribute("usuario");
				String proveedor = aux.getNick();
				conAlta = fab.getIControladorAlta();
				try {
					//da.getDepartamento()
					conAlta.registrarActividad("Rocha", da.getNombre() , da.getDescripcion(), da.getDuracion() ,da.getCosto() ,da.getCiudad(),da.getFechaAlta(),proveedor, da.getCategorias());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_actividad.jsp").forward(req,resp);
				}
				break;
			case "/SalidaCreada":
				DataSalida ds = (DataSalida) req.getAttribute("DataSalida");
				String actividad = (String) req.getAttribute("Actividad");
				conAlta = fab.getIControladorAlta();
				try {
					conAlta.confirmarAltaSalida(actividad, ds.getNombre() ,ds.getFecha(), ds.gethora(), ds.getLugar(), ds.getCant() ,ds.getFechaAlta());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				}	
				break;
			case "/ModificarUsuario":
				DataUsuario du1 = (DataUsuario) req.getAttribute("DataUsuario");
				conAlta = fab.getIControladorAlta();
				if(du1 instanceof DataTurista) {
					conAlta.actualizarDatosTurista(du1.getNick(), du1.getNombre() , du1.getApellido(), du1.getMail() ,du1.getNacimiento() ,((DataTurista) du1).getNacionalidad());
				} else {
					conAlta.actualizarDatosProveedor(du1.getNick(), du1.getNombre() , du1.getApellido(), du1.getMail() ,du1.getNacimiento() ,((DataProveedor) du1).getDescripcion(),((DataProveedor) du1).getLink(), true);//((DataProveedor) du1).getHayLink());
				}
				req.setAttribute("DataUsuario", du1);
				req.getRequestDispatcher("/WEB-INF/ConsultaUsuario.jsp").forward(req,resp);
				break;
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
