package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadNoExisteException;
import excepciones.SalidasNoExisteException;
import excepciones.UsuarioNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorConsulta;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/ConsultaUsuario", "/ConsultaActividad", "/ConsultaSalida", "/ConsultaPaquete"})

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
        //Ver si se presiona sobre un dpto
        String nomDpto = req.getParameter("DTDConsultaActividad");
        String nomCat = req.getParameter("CatConsultaActividad");
        if (nomDpto != null) {
            selecDep(req, resp, nomDpto);
        } else if (nomCat != null) {
            selecCat(req, resp, nomCat);
        } else {
    		switch (req.getServletPath()){
    			case "/ConsultaUsuario":
    				String usuario = (String) req.getParameter("nick");
    				conCons = fab.getIControladorConsulta();
    				if (usuario == null) {
    					DataUsuario[] usuarios = conCons.listarUsuarios();
    					req.setAttribute("ArregloUsuarios", usuarios);
    					req.getRequestDispatcher("/WEB-INF/ConsultaUsuario/ListaUsuario.jsp").forward(req, resp);
    				} else {
    					DataUsuario du;
                        try {
                            du = conCons.obtenerDataUsuarioNick(usuario);
                            req.setAttribute("UsuarioElegido", du);
                            if (du instanceof DataTurista) {
                                DataPaquete[] arrDataPaquetes = null;
                                DataPaquete DataPaqueteAux ; 
                                arrDataPaquetes = new DataPaquete[((DataTurista) du).getPaquetes().size()];
                               String[] arrPaquetes = ((DataTurista) du).getPaquetes().toArray(new String[0]);
                               for (int i =0 ; i<arrPaquetes.length; i++) {
                                   DataPaqueteAux = conCons.obtenerDataPaquete(arrPaquetes[i]);
                                   arrDataPaquetes[i] = DataPaqueteAux ; 
                               }
                               req.setAttribute("ArregloPaquetes", arrDataPaquetes);
                            }
                            req.getRequestDispatcher("/WEB-INF/ConsultaUsuario/ConsultaUsuario.jsp").forward(req, resp);
                        } catch (UsuarioNoExisteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
    				}				
    				break;
    			case "/ConsultaActividad":
    			    conCons = fab.getIControladorConsulta();
    			    String actividad = (String) session.getAttribute("actividad_inicio");
                    session.setAttribute("actividad_inicio", null);
                    if (actividad == null) {
                        actividad = (String) req.getParameter("actividad");
                    }
    				DataActividad[] actividades = null;
    				if (actividad == null) {
    				    if (session.getAttribute("DTDConsultaActividad")!= null) {
                            actividades = ((DataDepartamento) session.getAttribute("DTDConsultaActividad")).getColAct().toArray(new DataActividad[0]);
                            session.setAttribute("DTDConsultaActividad", null);
                        } else {
                            String categoria = (String) session.getAttribute("CatConsultaActividad");
                            if (categoria != null) {
                                actividades = conCons.obtenerActividadCategoria(categoria);
                                session.setAttribute("CatConsultaActividad", null);
                            }
                        }
    					req.setAttribute("ArregloActividades", actividades);
    					session.setAttribute("ArregloActividades", actividades);
    					req.getRequestDispatcher("/WEB-INF/ConsultaActividad/ListaActividad.jsp").forward(req, resp);
    				} else {
                        conCons = fab.getIControladorConsulta();
                        DataActividad act = null;
                        DataPaquete[] arrDataPaquetes = null ;  

                        try {
                           act = conCons.obtenerDataActividad(actividad);
                         
                           //genero un array de dataPaquetes para cada actividad que quiero consultar
                           arrDataPaquetes = new DataPaquete[act.getPaquetes().size()];
                           String[] arrPaquetes = act.getPaquetes().toArray(new String[act.getPaquetes().size()]);
                           for (int i=0 ; i<arrPaquetes.length; i++) {
                               arrDataPaquetes[i] = conCons.obtenerDataPaquete(arrPaquetes[i]);
                           }
                           
                           
                           
                           
                        } catch (ActividadNoExisteException e) {
                            e.printStackTrace();
                        }
    				    req.setAttribute("ActividadElegida", act);
                        req.setAttribute("ArrayPaquetes", arrDataPaquetes);
                        req.getRequestDispatcher("/WEB-INF/ConsultaActividad/DetalleActividad.jsp").forward(req, resp);
    				}
    				break;
    			case "/ConsultaSalida":
    			    conCons = fab.getIControladorConsulta();
    			    String salida = req.getParameter("salida");
    			    try {
                        DataSalida dataSal = conCons.obtenerDataSalida(salida);
                        req.setAttribute("SalidaElegida", dataSal);
                        req.getRequestDispatcher("/WEB-INF/ConsultaSalida/ConsultaSalida.jsp").forward(req, resp); //Ver si entregar el set de salidas o no, por ahora se devuelve el DataSalida que viene desde la lista.
                    } catch (SalidasNoExisteException e) {
                        req.setAttribute("Exception", e.getMessage());
                        req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
                    }
    				break;
    			case "/ConsultaPaquete":
    			    conCons = fab.getIControladorConsulta();
    				String paquete = (String) req.getParameter("paquete");
    				if (paquete == null) {
    					conCons = fab.getIControladorConsulta();
    					String[] nombresPaq = conCons.listarPaquetes();
    					DataPaquete[] dps = new DataPaquete[nombresPaq.length];
    					for (int i=0; i<nombresPaq.length; i++) {
    						dps[i] = conCons.obtenerDataPaquete(nombresPaq[i]);
    					}
    					req.setAttribute("ArregloPaquetes", dps);
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete/ListaPaquetes.jsp").forward(req, resp);
    				} else {
    					DataPaquete dp = conCons.obtenerDataPaquete(paquete);
    					req.setAttribute("PaqueteElegido", dp);
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete/DetallePaquete.jsp").forward(req, resp);
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
