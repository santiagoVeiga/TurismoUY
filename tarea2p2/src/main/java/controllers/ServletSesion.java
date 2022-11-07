package controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import servidor.DataDepartamento;
import servidor.DataTurista;
import servidor.DataUsuario;
import servidor.DepartamentoNoExisteException;
import servidor.DepartamentoYaExisteExeption;
import servidor.NoExisteCategoriaException;
import servidor.UsuarioNoExisteException;

/**
 * Servlet implementation
 */
@WebServlet (urlPatterns={"/iniciarSesion", "/cerrarSesion", "/sesionCerrada", "/sesionIniciada", "/home"})
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
public void initSession(HttpServletRequest request) {
	HttpSession session = request.getSession();
	if (session.getAttribute("estado_sesion") == null) {
		session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		String userAg = request.getHeader("USER-AGENT");
	    session.setAttribute("esMovil", false); 
	    if (userAg.contains("Mobile")) {
	        session.setAttribute("esMovil", true);
	    }
	}
    
}

/**
 * Devuelve el estado de la sesión
 * @param request
 * @return 
 */
public static EstadoSesion getEstado(HttpServletRequest request){
	return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
}

public void selecDep(HttpServletRequest req, HttpServletResponse resp, String nomDpto) {
    HttpSession session = req.getSession();
    DataDepartamento[] aux = (DataDepartamento[]) session.getAttribute("dptos");
    for (DataDepartamento it : aux) {
        if (it.getNombre().equals(nomDpto)) {
            session.setAttribute("DTDConsultaActividad", it);
        }
    }
    try {
        resp.sendRedirect("/tarea2p2/ConsultaActividad");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void selecCat(HttpServletRequest req, HttpServletResponse resp, String nomCat) {
    HttpSession session = req.getSession();
    session.setAttribute("CatConsultaActividad", nomCat);
    try {
        resp.sendRedirect("/tarea2p2/ConsultaActividad");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


private void processRequest(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException, DepartamentoYaExisteExeption, UsuarioNoExisteException {
	initSession(req);
	String solicitud = req.getServletPath();
	servidor.PublicadorIControladorService service = new servidor.PublicadorIControladorServiceLocator();
	servidor.PublicadorIControlador port = null;
    try {
        port = service.getPublicadorIControladorPort();
    } catch (ServiceException e1) {
        e1.printStackTrace();
    }
	HttpSession ses = req.getSession();
    String nomDpto = req.getParameter("DTDConsultaActividad");
    String nomCat = req.getParameter("CatConsultaActividad");
    if (nomDpto != null) {
        selecDep(req, resp, nomDpto);
    } else if (nomCat != null) {
        selecCat(req, resp, nomCat);
    } else {
    	switch (solicitud) {
    		case "/home":
    		    String act = (String) req.getParameter("actividad");
    		    if (act != null) {
    		        ses.setAttribute("actividad_inicio", act);
    		        resp.sendRedirect("/tarea2p2/ConsultaActividad");
    		    }
    		    else {
    		        DataDepartamento[] aux = null;
        			try {
        			    //String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
        				aux = Arrays.copyOf(port.obtenerDataDepartamentos(), port.obtenerDataDepartamentos().length, DataDepartamento[].class);//(DataDepartamento[]) ;
        			} catch (DepartamentoNoExisteException e) {
        				System.out.println("no hay deptos");
        			}
        			ses.setAttribute("dptos", aux);
        			Set<String> cats = null;
        			try {
        			    cats = new HashSet<String>();
        			    Object[] auxi = port.obtenerNombreCategorias();
                        Collections.addAll(cats, Arrays.copyOf(auxi, auxi.length, String[].class));
        			} catch (NoExisteCategoriaException eee) {
        			    eee.printStackTrace();
        			}
        			ses.setAttribute("categorias", cats);
        			req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
    		    }
    			break;
    		case "/iniciarSesion":
    			req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
    			break;
    		case "/cerrarSesion":
    			ses.setAttribute("usuario", null);
    			ses.setAttribute("imagenUsuario", null);
    			ses.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
    			req.getRequestDispatcher("/WEB-INF/home/cerrarSesion.jsp").forward(req, resp);
    			break;
    		case "/sesionIniciada":
    			DataUsuario[] ususSistema = Arrays.copyOf(port.getUsuariosComp(), port.getUsuariosComp().length, DataUsuario[].class); //conAlta.getUsuariosComp();
    			boolean esMovil = (boolean) ses.getAttribute("esMovil");
    			if(!esMovil) {
    			    String nickOrEmail = (String) req.getParameter("emailnick_inicioSesion");
                    for (DataUsuario it : ususSistema) {
                        if (it.getMail().equals(nickOrEmail)) {
                            String password = (String) req.getParameter("pass_iniSesion");
                            if (it.getPassword().equals(password)) { 
                                //Sesion iniciada correctamente
                                ses.setAttribute("usuario", it);
                                // Setear imagen
                                ses.setAttribute("imagenUsuario", "");
                                //
                                ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
                                req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
                                return;
                            }
                            else {
                                req.setAttribute("error_contrasena", "error");
                                req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
                                return;
                            }
                        }
                        else if (it.getNick().equals(nickOrEmail)) {
                            String password = (String) req.getParameter("pass_iniSesion");
                            if (it.getPassword().equals(password)) { 
                                //Sesion iniciada correctamente
                                ses.setAttribute("usuario", it);
                                // Setear imagen
                                ses.setAttribute("imagenUsuario", "");
                                //
                                ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
                                resp.sendRedirect("/tarea2p2/home");
                                return;
                            }
                            else {
                                req.setAttribute("error_contrasena", "error");
                                req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
                                return;
                            }
                        }
                    }
                    req.setAttribute("error_emailnick", "error");
                    req.getRequestDispatcher("/WEB-INF/home/iniciarSesion.jsp").forward(req, resp);
    			}
    			else {
    			    String nickOrEmail = (String) req.getParameter("emailnick_inicioSesionM");
                    for (DataUsuario it : ususSistema) {
                        if(it instanceof DataTurista) {
                            if (it.getMail().equals(nickOrEmail)) {
                                String password = (String) req.getParameter("pass_iniSesionM");
                                if (it.getPassword().equals(password)) { 
                                    //Sesion iniciada correctamente
                                    ses.setAttribute("usuario", it);
                                    // Setear imagen
                                    ses.setAttribute("imagenUsuario", "");
                                    //
                                    ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
                                    req.getRequestDispatcher("/WEB-INF/home/iniciarMovil.jsp").forward(req, resp);
                                    return;
                                }
                                else {
                                    req.setAttribute("error_contrasena", "error");
                                    req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
                                    return;
                                }
                            }
                            else if (it.getNick().equals(nickOrEmail)) {
                                String password = (String) req.getParameter("pass_iniSesionM");
                                if (it.getPassword().equals(password)) { 
                                    //Sesion iniciada correctamente
                                    ses.setAttribute("usuario", it);
                                    // Setear imagen
                                    ses.setAttribute("imagenUsuario", "");
                                    //
                                    ses.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
                                    req.getRequestDispatcher("/WEB-INF/home/iniciarMovil.jsp").forward(req, resp);
                                    return;
                                }
                                else {
                                    req.setAttribute("error_contrasena", "error");
                                    req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
                                    return;
                                }
                            }
                        }
                        }
                    req.setAttribute("error_emailnick", "error");
                    req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
    			}
    			break;
    		case "/sesionCerrada":
    			break;
    	}
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
        e.printStackTrace();
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
            e.printStackTrace();
		}
	}

}