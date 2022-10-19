package controllers;

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

    public void selecDep(HttpServletRequest req, HttpServletResponse resp, String nomDpto) {
        HttpSession session = req.getSession();
        DataDepartamento[] aux = (DataDepartamento[]) session.getAttribute("dptos");
        for(DataDepartamento it : aux) {
            if(it.getNombre().equals(nomDpto)) {
                session.setAttribute("DTDConsultaActividad", it);
            }
        }
        try {
            resp.sendRedirect("/tarea2p2/ConsultaActividad");
        } catch (IOException e) {
        }
    }
    
    public void selecCat(HttpServletRequest req, HttpServletResponse resp, String nomCat) {
        HttpSession session = req.getSession();
        session.setAttribute("CatConsultaActividad", nomCat);
        try {
            resp.sendRedirect("/tarea2p2/ConsultaActividad");
        } catch (IOException e) {
        }
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    String nomDpto = req.getParameter("DTDConsultaActividad");
        String nomCat = req.getParameter("CatConsultaActividad");
        if(nomDpto != null) {
            selecDep(req,resp,nomDpto);
        } else if (nomCat != null) {
            selecCat(req,resp,nomCat);
        } else {
    		switch(req.getServletPath()){
    			case "/Inscripcion":
    			    conInsc = fab.getIControladorInsc();
    			    String sal = req.getParameter("salida");
    			    DataUsuario usu = (DataUsuario) session.getAttribute("usuario");
    			    String[] paquetes = conInsc.obtenerPaquetesComprados(usu.getNick());
                    req.setAttribute("salida", sal);
    			    req.setAttribute("PaquetesComprados", paquetes);
    				req.getRequestDispatcher("/WEB-INF/InscripcionSalida.jsp").forward(req,resp);
    				break;
    			case "/Inscripto":
    				conInsc = fab.getIControladorInsc();
    				String salInsc = req.getParameter("salida");
    				DataUsuario dataUsu = (DataUsuario) session.getAttribute("usuario");
    				int cant = Integer.parseInt(req.getParameter("cantidad"));
    				String paqInsc = req.getParameter("paquete");
    				String act = null; // String act = conInsc.obtenerNomActPorSalida(salInsc);
    				LocalDateTime horaLocal = LocalDateTime.now();
    				Date fecha = java.util.Date.from(horaLocal.atZone(ZoneId.systemDefault()).toInstant());
    				try {
    					if(paqInsc == null) {
    						conInsc.inscribir(dataUsu.getNick(), salInsc, cant, fecha, act);
    					} else {
    						conInsc.inscribir(dataUsu.getNick(), salInsc, cant, fecha, act, paqInsc);
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
    				int cant1 = Integer.parseInt(req.getParameter("cantTur"));
    				String nomPaq = (String) req.getParameter("nomPaq");
    				LocalDateTime ld1 = LocalDateTime.now();
    				Date fecha1 = java.util.Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
    				try {
    					conInsc.comprarPaquete(du1.getNick(), fecha1, cant1, nomPaq);
    				} catch (PaqueteNoExisteException | PaqueteRepetidoException e) {
    					req.setAttribute("Exception", e.getMessage());
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete.jsp").forward(req,resp);
    				}
    				resp.sendRedirect("/WEB-INF/iniciar.jsp");
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
