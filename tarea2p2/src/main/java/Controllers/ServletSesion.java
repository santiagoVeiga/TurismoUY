package Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opencsv.CSVReader;

import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import logica.DataDepartamento;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;

/**
 * Servlet implementation
 */
@WebServlet (urlPatterns={"/iniciarSesion","/cerrarSesion","/sesionCerrada","/sesionIniciada","/home"})
public class ServletSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**
 * @see HttpServlet#HttpServlet()
 */
public ServletSesion() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * inicializa la sesión si no estaba creada 
 * @param request 
 */
public static void initSession(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if (session.getAttribute("estado_sesion") == null) {
		session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		
	}
	Fabrica f = Fabrica.getInstance();
	IControladorAlta ca = f.getIControladorAlta();
	try {
		ServletContext servletContext = request.getServletContext();
		InputStream input = servletContext.getResourceAsStream("/WEB-INF/data/Departamentos.csv");
	    CSVReader reader = new CSVReader(new InputStreamReader(input));
		ca.cargarDptos(reader);
		// dptos listos
		input = servletContext.getResourceAsStream("/WEB-INF/data/Usuarios.csv");
	    reader = new CSVReader(new InputStreamReader(input));
	    BufferedImage img = ImageIO.read(servletContext.getResourceAsStream("/WEB-INF/data/u1.jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        byte[] imgBytes = baos.toByteArray();
        ca.cargarUsuarios(reader,imgBytes);
        // usus listos
        input = servletContext.getResourceAsStream("/WEB-INF/data/Actividades.csv");
	    reader = new CSVReader(new InputStreamReader(input));
	    img = ImageIO.read(servletContext.getResourceAsStream("/WEB-INF/data/a1.jpg"));
        baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        imgBytes = baos.toByteArray();
        ca.cargarActs(reader,imgBytes);
        // acts listas
        input = servletContext.getResourceAsStream("/WEB-INF/data/Salidas.csv");
	    reader = new CSVReader(new InputStreamReader(input));
	    img = ImageIO.read(servletContext.getResourceAsStream("/WEB-INF/data/s1.jpg"));
        baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        imgBytes = baos.toByteArray();
        ca.cargarSalidas(reader,imgBytes);
	} catch (Exception e) {
		
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
		throws ServletException, IOException, DepartamentoYaExisteExeption, UsuarioNoExisteException {
	initSession(req);
	String solicitud = req.getServletPath();
	Fabrica f = Fabrica.getInstance();
	IControladorAlta ca = f.getIControladorAlta();
	IControladorConsulta cc = f.getIControladorConsulta();
	HttpSession ses = req.getSession();
	switch(solicitud) {
		case "/home":
			// hace que se ejecute el jsp sin cambiar la url
			DataDepartamento[] aux = null;
			try {
				aux = cc.obtenerDataDepartamentos();
			} catch (DepartamentoNoExisteException e) {
				System.out.println("no hay deptos");
			}
			String nomDpto = req.getParameter("DTDConsultaActividad");
			if(nomDpto != null) {
				for(DataDepartamento it : aux) {
					if(it.getNombre().equals(nomDpto)) {
						ses.setAttribute("DTDConsultaActividad", it);
					}
				}
				resp.sendRedirect("/tarea2p2/ConsultaActividad");
				break;
			}
			String nomCat = req.getParameter("CatConsultaActividad");
			if(nomCat!=null) {
				ses.setAttribute("CatConsultaActividad", nomCat);
				resp.sendRedirect("/tarea2p2/ConsultaActividad");
				break;
			}
			ses.setAttribute("dptos", aux);
			Set<String> cats = cc.obtenerNombreCategorias();
			ses.setAttribute("categorias", cats);
			req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
			break;
		case "/iniciarSesion":
			req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
			break;
		case "/cerrarSesion":
			ses.setAttribute("usuario", null);
			ses.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
			req.getRequestDispatcher("/WEB-INF/home/cerrarSesion.jsp").forward(req, resp);
			break;
		case "/sesionIniciada":
			DataUsuario[] ususSistema = ca.getUsuariosComp();
			String nickOrEmail = (String) req.getParameter("emailnick_inicioSesion");
			for (DataUsuario it : ususSistema) {
				if(it.getMail().equals(nickOrEmail)) {
					String password = (String) req.getParameter("pass_iniSesion");
					if (it.getPassword().equals(password)) { 
						//Sesion iniciada correctamente
						ses.setAttribute("usuario", it);
						// Setear imagen
						InputStream is = new ByteArrayInputStream(it.getImagen());
				        BufferedImage bi = ImageIO.read(is);
				        ByteArrayOutputStream output = new ByteArrayOutputStream();
						ImageIO.write(bi, "jpg", output);
						String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
				        ses.setAttribute("imagenUsuario", imageAsBase64);
				        //
				        ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
						req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
						return;
					}
					else {
						req.setAttribute("error_contrasena","error");
						req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
						return;
					}
				}
				else if(it.getNick().equals(nickOrEmail)) {
					String password = (String) req.getParameter("pass_iniSesion");
					if (it.getPassword().equals(password)) { 
						//Sesion iniciada correctamente
						ses.setAttribute("usuario", it);
						// Setear imagen
						InputStream is = new ByteArrayInputStream(it.getImagen());
				        BufferedImage bi = ImageIO.read(is);
				        ByteArrayOutputStream output = new ByteArrayOutputStream();
						ImageIO.write(bi, "jpg", output);
						String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
				        ses.setAttribute("imagenUsuario", imageAsBase64);
				        //
						ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
						resp.sendRedirect("/tarea2p2/home");
						return;
					}
					else {
						req.setAttribute("error_contrasena","error");
						req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
						return;
					}
				}
			}
			req.setAttribute("error_emailnick","error");
			req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
			break;
		case "/sesionCerrada":
			break;
	}
	
	
	
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		processRequest(request, response);
	} catch (DepartamentoYaExisteExeption e) {
		System.out.println("no hay dptos get");
	} catch (UsuarioNoExisteException e) {
		
	} 
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		processRequest(request, response);
	} catch (DepartamentoYaExisteExeption e) {
		System.out.println("no hay depntos post");
		} catch (UsuarioNoExisteException e) {
			
		}
	}

}