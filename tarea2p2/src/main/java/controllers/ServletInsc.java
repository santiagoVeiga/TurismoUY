package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import servidor.ActividadNoExisteException;
import servidor.ActividadRepetidaException;
import servidor.ExcedeTuristas;
import servidor.InscFechaDespSalida;
import servidor.InscFechaInconsistente;
import servidor.NoHayCuposException;
import servidor.PaqueteNoExisteException;
import servidor.PaqueteRepetidoException;
import servidor.SalidasNoExisteException;
import servidor.SalidasVigentesException;
import servidor.TuristaConSalida;
import servidor.TuristaNoHaNacido;
import servidor.UsuarioNoExisteException;
import servidor.UsuarioRepetidoException;
import servidor.DataDepartamento;
import servidor.DataPaquete;
import servidor.DataProveedor;
import servidor.DataTurista;
import servidor.DataUsuario;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/Inscripcion", "/Inscripto", "/CompraPaquete", "/SeguirUsuario", "/AgregarFavs", "/FinalizarActividad"})

public class ServletInsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
        servidor.PublicadorIControladorService service = new servidor.PublicadorIControladorServiceLocator();
        servidor.PublicadorIControlador port = null;
        try {
            port = service.getPublicadorIControladorPort();
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }
        if (nomDpto != null) {
            selecDep(req, resp, nomDpto);
        } else if (nomCat != null) {
            selecCat(req, resp, nomCat);
        } else {
    		switch (req.getServletPath()){
    			case "/Inscripcion":
    			    String sal = req.getParameter("salida");
    			    DataUsuario usu = (DataUsuario) session.getAttribute("usuario");
    			    
    			    String[] paquetes = Arrays.copyOf(port.obtenerPaquetesComprados(usu.getNick()), port.obtenerPaquetesComprados(usu.getNick()).length, String[].class);;
                    req.setAttribute("SalidaElegida", sal);
    			    req.setAttribute("PaquetesComprados", paquetes);
    				req.getRequestDispatcher("/WEB-INF/ConsultaSalida/InscripcionSalida.jsp").forward(req, resp);
    				break;
    			case "/Inscripto":
    				String salInsc = req.getParameter("nomSal");
    				DataUsuario dataUsu = (DataUsuario) session.getAttribute("usuario");
    				int cant = Integer.parseInt(req.getParameter("cantTur"));
    				String paqInsc = req.getParameter("paqDisp");
    				String act = null;
                    try {
                        act = port.obtenerNomActPorSalida(salInsc);
                    } catch (SalidasNoExisteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
    				LocalDateTime horaLocal = LocalDateTime.now();
    				Date fecha = java.util.Date.from(horaLocal.atZone(ZoneId.systemDefault()).toInstant());
    				Calendar fechaC = Calendar.getInstance();
    				fechaC.setTime(fecha);
    				try {
    					if (paqInsc == null) {
    						port.inscribir(dataUsu.getNick(), salInsc, cant, fechaC, act);
    					} else {
    						port.inscribirPaq(dataUsu.getNick(), salInsc, cant, fechaC, act, paqInsc);
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
    				HttpSession session1 = req.getSession();
    				DataUsuario du1 = (DataUsuario) session1.getAttribute("usuario");
    				int cant1 = Integer.parseInt(req.getParameter("cantTurs"));
    				String nomPaquete = (String) req.getParameter("nomPaq");
    				LocalDateTime ld1 = LocalDateTime.now();
    				Date fecha1 = java.util.Date.from(ld1.atZone(ZoneId.systemDefault()).toInstant());
                    Calendar fecha1C = Calendar.getInstance();
                    fecha1C.setTime(fecha1);
    				try {
    					port.comprarPaquete(du1.getNick(), fecha1C, cant1, nomPaquete);
    					req.setAttribute("CompraPaq", "La compra fue realizada con exito!");
    					req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp); //lo cambie
    				} catch (PaqueteNoExisteException | PaqueteRepetidoException e) {
    					req.setAttribute("Exception", e.getMessage());
                        DataPaquete dataPaq = port.obtenerDataPaquete(nomPaquete);
                        req.setAttribute("PaqueteElegido", dataPaq);
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete/DetallePaquete.jsp").forward(req, resp);
    				}
    				break;
    			case "/SeguirUsuario":
    			    HttpSession session2 = req.getSession();
                    DataUsuario du2 = (DataUsuario) session2.getAttribute("usuario");
                    String nickUsu = req.getParameter("nickUsuASeguir");
                    try {
                        Set<String> setSeguir = new HashSet<String>();
                        Collections.addAll(setSeguir, du2.getSeguidos());
                        port.seguirDejarDeSeguirUsuario(du2.getNick(), nickUsu, !setSeguir.contains(nickUsu));
                        session2.setAttribute("usuario", port.obtenerDataUsuarioNick(du2.getNick()));
                        req.getRequestDispatcher("/ConsultaUsuario?nick=" + nickUsu).forward(req, resp); //lo cambie
                    } catch (UsuarioNoExisteException | UsuarioRepetidoException e) {
                        req.setAttribute("Exception", e.getMessage());
                        req.getRequestDispatcher("/home").forward(req, resp);
                    }
                    break;
    			case "/AgregarFavs":
                    HttpSession session3 = req.getSession();
                    DataTurista dTur = (DataTurista) session3.getAttribute("usuario");
                    String nomAct = req.getParameter("nomAct");
                    try {
                        Set<String> setFavs = new HashSet<String>();
                        Collections.addAll(setFavs, dTur.getActFavoritas());
                        port.agregarQuitarActividadFavorita(dTur.getNick(), nomAct, !setFavs.contains(nomAct));
                        session3.setAttribute("usuario", port.obtenerDataUsuarioNick(dTur.getNick()));
                        req.getRequestDispatcher("/ConsultaActividad?actividad=" + nomAct).forward(req, resp); //lo cambie
                    } catch (UsuarioNoExisteException | ActividadNoExisteException | ActividadRepetidaException e) {
                        req.setAttribute("Exception", e.getMessage());
                        req.getRequestDispatcher("/home").forward(req, resp);
                    }
                    break;
    			case "/FinalizarActividad":
    			    String actividadSeleccionada = req.getParameter("actividad");
                    HttpSession session4 = req.getSession();
                    DataProveedor dataProveedor = (DataProveedor) session4.getAttribute("usuario");
                    try {
                        port.finalizarActividad(actividadSeleccionada);
                        session4.setAttribute("usuario", port.obtenerDataUsuarioNick(dataProveedor.getNick()));
                    } catch (Exception e) {
                            System.out.printf("esepsssion \n" + e.getMessage());
                            req.setAttribute("Exception", e.getMessage());
                    }
                    req.getRequestDispatcher("/home").forward(req, resp);
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
