package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
import excepciones.SalidasNoExisteException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorConsulta;
import logica.IControladorInsc;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/Inscripcion", "/Inscripto", "/CompraPaquete", "/SeguirUsuario"})

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
			throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    String nomDpto = req.getParameter("DTDConsultaActividad");
        String nomCat = req.getParameter("CatConsultaActividad");
        if (nomDpto != null) {
            selecDep(req, resp, nomDpto);
        } else if (nomCat != null) {
            selecCat(req, resp, nomCat);
        } else {
    		switch (req.getServletPath()){
    			case "/Inscripcion":
    			    conInsc = fab.getIControladorInsc();
    			    String sal = req.getParameter("salida");
    			    DataUsuario usu = (DataUsuario) session.getAttribute("usuario");
    			    String[] paquetes = conInsc.obtenerPaquetesComprados(usu.getNick());
                    req.setAttribute("SalidaElegida", sal);
    			    req.setAttribute("PaquetesComprados", paquetes);
    				req.getRequestDispatcher("/WEB-INF/ConsultaSalida/InscripcionSalida.jsp").forward(req, resp);
    				break;
    			case "/Inscripto":
    				conInsc = fab.getIControladorInsc();
    				String salInsc = req.getParameter("nomSal");
    				DataUsuario dataUsu = (DataUsuario) session.getAttribute("usuario");
    				int cant = Integer.parseInt(req.getParameter("cantTur"));
    				String paqInsc = req.getParameter("paqDisp");
    				String act = null;
                    try {
                        act = conInsc.obtenerNomActPorSalida(salInsc);
                    } catch (SalidasNoExisteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
    				LocalDateTime horaLocal = LocalDateTime.now();
    				Date fecha = java.util.Date.from(horaLocal.atZone(ZoneId.systemDefault()).toInstant());
    				try {
    					if (paqInsc == null) {
    						conInsc.inscribir(dataUsu.getNick(), salInsc, cant, fecha, act);
    					} else {
    						conInsc.inscribir(dataUsu.getNick(), salInsc, cant, fecha, act, paqInsc);
    					}
    					req.setAttribute("Inscrip", "La inscripcion fue realizada con exito!");
                        req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
    				} catch (TuristaConSalida | ExcedeTuristas | InscFechaInconsistente | ActividadNoExisteException
    						| InscFechaDespSalida | TuristaNoHaNacido | PaqueteRepetidoException
    						| NoHayCuposException e) {
    					req.setAttribute("Exception", e.getMessage());
    					req.getRequestDispatcher("/home").forward(req, resp);
    				}
    				break;
    			case "/CompraPaquete":
    				conInsc = fab.getIControladorInsc();
    				HttpSession session1 = req.getSession();
    				DataUsuario du1 = (DataUsuario) session1.getAttribute("usuario");
    				int cant1 = Integer.parseInt(req.getParameter("cantTurs"));
    				String nomPaquete = (String) req.getParameter("nomPaq");
    				LocalDateTime ld1 = LocalDateTime.now();
    				Date fecha1 = java.util.Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
    				IControladorConsulta conCons = fab.getIControladorConsulta();
    				try {
    					conInsc.comprarPaquete(du1.getNick(), fecha1, cant1, nomPaquete);
    					req.setAttribute("CompraPaq", "La compra fue realizada con exito!");
    					req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp); //lo cambie
    				} catch (PaqueteNoExisteException | PaqueteRepetidoException e) {
    					req.setAttribute("Exception", e.getMessage());
                        DataPaquete dataPaq = conCons.obtenerDataPaquete(nomPaquete);
                        req.setAttribute("PaqueteElegido", dataPaq);
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete/DetallePaquete.jsp").forward(req, resp);
    				}
    				break;
    			case "/SeguirUsuario":
    			    conInsc = fab.getIControladorInsc();
    			    HttpSession session2 = req.getSession();
                    DataUsuario du2 = (DataUsuario) session2.getAttribute("usuario");
                    String nickUsu = req.getParameter("nickUsuASeguir");
                    try {

                        conInsc.seguirDejarDeSeguirUsuario(du2.getNick(), nickUsu, false);
                        req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp); //lo cambie
                    } catch (UsuarioNoExisteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (UsuarioRepetidoException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
    		}
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
