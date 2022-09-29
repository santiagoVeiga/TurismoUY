package Controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorConsulta;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/DetalleUsuario","/ConsultaUsuario","/ConsultaActividad","/DetalleActividad"})

public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();;
	private IControladorConsulta conCons;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		switch(req.getServletPath()){
			case "/ConsultaUsuario":
				conCons = fab.getIControladorConsulta();
				DataUsuario[] usuarios = conCons.listarUsuarios();
				req.setAttribute("ArregloUsuarios", usuarios);
				req.getRequestDispatcher("/WEB-INF/ListaUsuario.jsp").forward(req,resp);
				break;
			case "/DetalleUsuario":
				req.getRequestDispatcher("/WEB-INF/ConsultaUsuario.jsp").forward(req,resp);
				break;
			case "/ConsultaActividad":
				// manda una redirección a otra URL (cambia la URL)
				if(req.getAttribute("DataDepartamento")!= null) {
					DataActividad[] actividades = ((DataDepartamento) req.getAttribute("DataDepartamento")).getColAct().toArray(new DataActividad[0]);
				} else {
					String categoria = (String) req.getAttribute("Categoria");
					DataActividad[] actividades = conCons.obtenerActividadCategoria(categoria);
				}
				req.getRequestDispatcher("/WEB-INF/ListaActividad.jsp").forward(req,resp);
				break;
			case "/DetalleActividad":
				req.getRequestDispatcher("/WEB-INF/ConsultaActividad.jsp").forward(req,resp);
				break;
			case "/ConsultaSalida":
				req.getRequestDispatcher("/WEB-INF/ConsultaActividad.jsp").forward(req,resp); //Ver si entregar el set de salidas o no, por ahora se devuelve el DataActividad que viene desde la lista.
				break;
			case "/ConsultaPaquete":
				// manda una redirección a otra URL (cambia la URL)
				conCons = fab.getIControladorConsulta();
				String[] nombresPaq = conCons.listarPaquetes();
				DataPaquete[] dps = new DataPaquete[nombresPaq.length];
				for(int i=0;i<nombresPaq.length;i++) {
					dps[i] = conCons.obtenerDataPaquete(nombresPaq[i]);
				}
				req.getRequestDispatcher("/WEB-INF/ListaPaquetes.jsp").forward(req,resp);
				break;
			case "/DetallePaquete":
				req.getRequestDispatcher("/WEB-INF/ConsultaPaquete.jsp").forward(req,resp);
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
