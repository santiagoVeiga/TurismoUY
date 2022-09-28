package java.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamebook.model.EstadoSesion;

/**
 * Servlet implementation class Home
 */
@WebServlet ("/AltaUsuario")
@WebServlet ("/AltaActividad")
@WebServlet ("/AltaSalida")
@WebServlet ("/ActividadCreada")
@WebServlet ("/UsuarioCreado")
@WebServlet ("/SalidaCreada")
@WebServlet ("/ModificarUsuario")

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
				// manda una redirección a otra URL (cambia la URL)
				resp.sendRedirect("/WEB-INF/alta_usuario.jsp");
				break;
			case "/AltaActividad":
				// manda una redirección a otra URL (cambia la URL)
				resp.sendRedirect("/WEB-INF/alta_actividad.jsp");
				break;
			case "/AltaSalida":
				req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				break;
			case "/UsuarioCreado":
				DataUsuario du = req.getAttribute("DataUsuario");
				conAlta = fab.getIControladorAlta();
				try {
					if(du instanceof DataTurista) {
						conAlta.confirmarAltaTurista(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataTurista) du).getNacionalidad());
					} else {
						conAlta.confirmarAltaProveedor(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataProveedor) du).getDescripcion(),((DataProveedor) du).getLink(),((DataProveedor) du).getHayLink());
					}
					session.setAtributte("usuario",du);
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (UsuarioRepetidoException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_usuario.jsp").forward(req,resp);
				}
				break;
			case "/ActividadCreada":
				DataActividad da = req.getAttribute("DataActividad");
				String proveedor = req.getAttribute("Proveedor");
				conAlta = fab.getIControladorAlta();
				try {
					conAlta.registrarActividad(da.getDepartamento(), da.getNombre() , da.getDescripcion(), da.getDuracion() ,da.getCosto() ,da.getCiudad(),da.getFecha(),proveedor, da.getCategorias());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (ActividadRepetidaException e1) {
					req.setAttribute("Exception", e1.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_actividad.jsp").forward(req,resp);
				} catch (UsuarioNoExisteException e2) {
					req.setAttribute("Exception", e2.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_actividad.jsp").forward(req,resp);
				}
				break;
			case "/ActividadCreada":
				DataSalida ds = req.getAttribute("DataSalida");
				String actividad = req.getAttribute("Actividad");
				conAlta = fab.getIControladorAlta();
				try {
					conAlta.confirmarAltaSalida(actividad, ds.getNombre() ,ds.getFecha(), ds.getHora(), ds.getLugar(), ds.getCant() ,ds.getFechaAlta());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (FechaAltaSalidaInvalida e1) {
					req.setAttribute("Exception", e1.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				} catch (FechaAltaSalidaAnteriorActividad e2) {
					req.setAttribute("Exception", e2.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				}
				break;
			case "/ModificarUsuario":
				DataUsuario du = req.getAttribute("DataUsuario");
				conAlta = fab.getIControladorAlta();
				if(du instanceof DataTurista) {
					conAlta.actualizarDatosTurista(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataTurista) du).getNacionalidad());
				} else {
					conAlta.actualizarDatosProveedor(du.getNick(), du.getNombre() , du.getApellido(), du.getMail() ,du.getNacimiento() ,((DataProveedor) du).getDescripcion(),((DataProveedor) du).getLink(),((DataProveedor) du).getHayLink());
				}
				req.setAttribute("DataUsuario", du);
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
