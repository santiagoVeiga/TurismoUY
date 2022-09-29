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

import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorConsulta;
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
				if(dp == null) {
					// conInsc.inscribir(du.getNicK(), ds.getNombre(), cant, fecha, da.getNombre());
				} else {
					// conInsc.inscribir(du.getNicK(), ds.getNombre(), cant, fecha, da.getNombre(), dp.getNombre());
				}
				resp.sendRedirect("/WEB-INF/iniciar.jsp");
				break;
			case "/CompraPaquete":
				conInsc = fab.getIControladorInsc();
				DataActividad da1 = (DataActividad) req.getAttribute("DataActividad");
				DataSalida ds1 = (DataSalida) req.getAttribute("DataSalida");
				HttpSession session1 = req.getSession();
				DataUsuario du1 = (DataUsuario) session1.getAttribute("usuario");
				int cant1 = (int) req.getAttribute("cantidad");
				DataPaquete dp1 = (DataPaquete) req.getAttribute("DataPaquete");
				LocalDateTime ld1 = LocalDateTime.now();
				Date fecha1 = java.util.Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
				// conInsc.comprarPaquete(du.getNick(), fecha1, cant1, dp1.getNombre());
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
