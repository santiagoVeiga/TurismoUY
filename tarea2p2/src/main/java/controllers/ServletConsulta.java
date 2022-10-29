package controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidasNoExisteException;
import excepciones.UsuarioNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/ConsultaUsuario", "/ConsultaActividad", "/ConsultaSalida", "/ConsultaPaquete", "/perteneceNick", "/perteneceEmail", "/perteneceAct", "/perteneceSal", "/buscar"})

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
    		    case "/buscar":
    		        String input = req.getParameter("abuscar");
    		        conCons = fab.getIControladorConsulta();
    		        String[] nPaqs = conCons.listarPaquetes();
    		        Set<DataPaquete> resPaqs = new HashSet<DataPaquete>();
    		        for (String iter : nPaqs) {
    		            DataPaquete aux = conCons.obtenerDataPaquete(iter);
    		            if (aux.getDescripcion().contains(input) || aux.getNombre().contains(input)) {
    		                resPaqs.add(aux);
    		            }
    		        }
    		        req.setAttribute("paquetes", resPaqs);
    		        IControladorAlta conAlta = fab.getIControladorAlta();
    		        Set<DataActividad> acts = new HashSet<DataActividad>();
    		        try {
                        DataDepartamento[] deps = conAlta.obtenerDataDepartamentos();
                        for (DataDepartamento iterD : deps) {
                            for (DataActividad iterA : iterD.getColAct()) {
                                if (iterA.getNombre().contains(input) || iterA.getDescripcion().contains(input)) {
                                    acts.add(iterA);
                                }
                            }
                        }
                    } catch (DepartamentoNoExisteException e2) {
                        e2.printStackTrace();
                    }
    		        req.setAttribute("actividades", acts);
    		        req.getRequestDispatcher("/WEB-INF/buscar/buscador.jsp").forward(req, resp);
    		        break;
    		    case "/perteneceSal":
                    String text3 = "n";
                    resp.setContentType("text/plain");  
                    resp.setCharacterEncoding("UTF-8");
                    String sReq = req.getParameter("sal");
                    if (!sReq.equals("")) {
                        try {
                            conCons = fab.getIControladorConsulta();
                            DataSalida usu = conCons.obtenerDataSalida(sReq);
                        } catch (SalidasNoExisteException e1) {
                            text3 = "y";
                        }
                    }
                    resp.getWriter().write(text3);
                    break;
    		    case "/perteneceAct":
                    String text2 = "n";
                    resp.setContentType("text/plain");  
                    resp.setCharacterEncoding("UTF-8");
                    String aReq = req.getParameter("act");
                    if (!aReq.equals("")) {
                        try {
                            conCons = fab.getIControladorConsulta();
                            DataActividad usu = conCons.obtenerDataActividad(aReq);
                        } catch (ActividadNoExisteException e1) {
                            text2 = "y";
                        }
                    }
                    resp.getWriter().write(text2);
                    break;
    		    case "/perteneceNick":
    		        String text = "n";
    		        resp.setContentType("text/plain");  
                    resp.setCharacterEncoding("UTF-8");
                    String nReq = req.getParameter("nick");
                    if (!nReq.equals("")) {
                        try {
        		            conCons = fab.getIControladorConsulta();
                            DataUsuario usu = conCons.obtenerDataUsuarioNick(nReq);
                        } catch (UsuarioNoExisteException e1) {
                            text = "y";
                        }
                    }
    		        resp.getWriter().write(text);
    		        break;
    		    case "/perteneceEmail":
                    String text1 = "n";
                    resp.setContentType("text/plain");  
                    resp.setCharacterEncoding("UTF-8"); 
                    String eReq = req.getParameter("email");
                    if (!eReq.equals("")) {
                        try {
                            conCons = fab.getIControladorConsulta();
                            DataUsuario usu = conCons.obtenerDataUsuarioMail(eReq);
                        } catch (UsuarioNoExisteException e1) {
                            text1 = "y";
                        }
                    }
                    resp.getWriter().write(text1);
                    break;
    			case "/ConsultaUsuario":
    				String usuario = (String) req.getParameter("nick");
    				conCons = fab.getIControladorConsulta();
    				if (usuario == null) {
    					DataUsuario[] usuarios = conCons.listarUsuarios();
    					req.setAttribute("ArregloUsuarios", usuarios);
    					req.getRequestDispatcher("/WEB-INF/ConsultaUsuario/ListaUsuario.jsp").forward(req, resp);
    				} else {
    					DataUsuario dataUsu;
                        try {
                            dataUsu = conCons.obtenerDataUsuarioNick(usuario);
                            req.setAttribute("UsuarioElegido", dataUsu);
                            if (dataUsu instanceof DataTurista) {
                                DataPaquete[] arrDataPaquetes = null;
                                DataPaquete DataPaqueteAux ; 
                                arrDataPaquetes = new DataPaquete[((DataTurista) dataUsu).getPaquetes().size()];
                               String[] arrPaquetes = ((DataTurista) dataUsu).getPaquetes().toArray(new String[0]);
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
    					DataPaquete dataPaq = conCons.obtenerDataPaquete(paquete);
    					req.setAttribute("PaqueteElegido", dataPaq);
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
