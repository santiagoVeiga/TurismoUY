package Controllers;

import java.io.IOException;
import java.util.Date;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadNoExisteException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import logica.DataActividad;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorInsc;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/Inscripcion","/Inscripto","/CompraPaquete"})

public class ServletInsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();;
	private IControladorInsc conInsc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsc() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		switch(req.getServletPath()){
			case "/Inscripcion":
				req.getRequestDispatcher("/WEB-INF/InscripcionSalida.jsp").forward(req,resp);
				break;
			case "/Inscripto":
				conInsc = fab.getIControladorInsc();
				DataActividad da = (DataActividad) req.getAttribute("DataActividad");
				DataSalida ds = (DataSalida) req.getAttribute("DataSalida");
				HttpSession session = req.getSession();
				DataUsuario du = (DataUsuario) session.getAttribute("usuario");
				int cant = (int) req.getAttribute("cantidad");
				DataPaquete dp = (DataPaquete) req.getAttribute("DataPaquete");
				LocalDateTime ld = LocalDateTime.now();
				Date fecha = java.util.Date.from(ld.atZone(ZoneId.systemDefault()).toInstant());
				try {
					if(dp == null) {
						conInsc.inscribir(du.getNick(), ds.getNombre(), cant, fecha, da.getNombre());
					} else {
						conInsc.inscribir(du.getNick(), ds.getNombre(), cant, fecha, da.getNombre(), dp.getNombre());
					}
				} catch (TuristaConSalida | ExcedeTuristas | InscFechaInconsistente | ActividadNoExisteException
						| InscFechaDespSalida | TuristaNoHaNacido | PaqueteRepetidoException
						| NoHayCuposException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/InscripcionSalida.jsp").forward(req,resp);
				}
				resp.sendRedirect("/WEB-INF/iniciar.jsp");
				break;
			case "/CompraPaquete":
				conInsc = fab.getIControladorInsc();
				HttpSession session1 = req.getSession();
				DataUsuario du1 = (DataUsuario) session1.getAttribute("usuario");
				int cant1 = (int) req.getAttribute("cantidad");
				DataPaquete dp1 = (DataPaquete) req.getAttribute("DataPaquete");
				LocalDateTime ld1 = LocalDateTime.now();
				Date fecha1 = java.util.Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
				try {
					conInsc.comprarPaquete(du1.getNick(), fecha1, cant1, dp1.getNombre());
				} catch (PaqueteNoExisteException | PaqueteRepetidoException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete.jsp").forward(req,resp);
				}
				resp.sendRedirect("/WEB-INF/iniciar.jsp");
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
