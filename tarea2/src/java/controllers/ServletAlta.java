package java.controllers;

import java.io.IOException;
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
@WebServlet ("/servletAlta")
public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * inicializa la sesión si no estaba creada 
	 * @param request 
	 */
	public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("paginas_navegadas") == null) {
			session.setAttribute("paginas_navegadas", 0);
		}
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
	
	/**
	 * Devuelve el estado de la sesión
	 * @param request
	 * @return 
	 */
	public static EstadoSesion getEstado(HttpServletRequest request)
	{
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		initSession(req);
		
		switch(getEstado(req)){
			case NO_LOGIN:
				// hace que se ejecute el jsp sin cambiar la url
				req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").
						forward(req, resp);
				break;
			case LOGIN_INCORRECTO:
				// hace que se ejecute el jsp sin cambiar la url
				req.getRequestDispatcher("/WEB-INF/home/inicioErroneo.jsp").
						forward(req, resp);
				break;
			case LOGIN_CORRECTO:
				// manda una redirección a otra URL (cambia la URL)
				resp.sendRedirect("/gamebook/perfil");
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
