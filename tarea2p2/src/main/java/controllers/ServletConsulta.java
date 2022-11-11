package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.font.PDTypelFont;


//import com.itextpdf.*;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;

import servidor.ActividadNoExisteException;
import servidor.DepartamentoNoExisteException;
import servidor.SalidasNoExisteException;
import servidor.UsuarioNoExisteException;
import logica.CompAnioDataBuscar;
import logica.CompNomDataBuscar;
import servidor.DataActividad;
import servidor.DataBuscar;
import servidor.DataCompraGeneral;
import servidor.DataDepartamento;
import servidor.DataPaquete;
import servidor.DataSalida;
import servidor.DataTurista;
import servidor.DataUsuario;
import servidor.EstadoAct;

/**
 * Servlet implementation class Home
 */
@WebServlet (urlPatterns={"/ConsultaUsuario", "/ConsultaActividad","/DescargarPDF", "/ConsultaSalida", "/ConsultaPaquete", "/perteneceNick", "/perteneceEmail", "/perteneceAct", "/perteneceSal", "/buscar"})

public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
    
    
    private String dirIPPort() {
        String ipport = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(getServletContext().getResourceAsStream("/WEB-INF/data/configIPPort.xml"));
            document.getDocumentElement().normalize();
            NodeList datos = document.getElementsByTagName("datos");
            ipport = datos.item(0).getTextContent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ipport;
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    HttpSession session = req.getSession();
        //Ver si se presiona sobre un dpto
        String nomDpto = req.getParameter("DTDConsultaActividad");
        String nomCat = req.getParameter("CatConsultaActividad");
        servidor.PublicadorIControladorService service = new servidor.PublicadorIControladorServiceLocator(dirIPPort());
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
    		    case "/buscar":
    		        String input = req.getParameter("abuscar"); 
    		        if (input == null) {
    		            input = (String) session.getAttribute("abuscar");
    		        }
    		        else {
    		            session.setAttribute("abuscar", input);
    		        }
    		        String[] nPaqs = Arrays.copyOf(port.listarPaquetes().getArray(), port.listarPaquetes().getArray().length, String[].class);
    		        List<DataBuscar> res = new ArrayList<DataBuscar>();
    		        for (String iter : nPaqs) {
    		            DataPaquete aux = port.obtenerDataPaquete(iter);
    		            if (aux.getDescripcion().contains(input) || aux.getNombre().contains(input)) {
    		                res.add(aux);
    		            }
    		        }
    		        try {
                        DataDepartamento[] deps = Arrays.copyOf(port.obtenerDataDepartamentos().getArray(), port.obtenerDataDepartamentos().getArray().length, DataDepartamento[].class);
                        for (DataDepartamento iterD : deps) {
                            for (DataActividad iterA : iterD.getColAct()) {
                                if ((iterA.getNombre().contains(input) || iterA.getDescripcion().contains(input)) && iterA.getEstado() == EstadoAct.confirmada) {
                                    res.add(iterA);
                                }
                            }
                        }
                    } catch (DepartamentoNoExisteException e2) {
                        e2.printStackTrace();
                    }
                    /*
                     * // Si corresponde ordenar
                     * String ordenarAlfa = req.getParameter("ordenAlfa");
                     * String ordenarAnio = req.getParameter("ordenAnio");
                     * if (ordenarAlfa != null) {
                     * Collections.sort(res, new CompNomDataBuscar());
                     * } else if (ordenarAnio != null) {
                     * Collections.sort(res, new CompAnioDataBuscar());
                     * }
                     */
    		        // Si corresponde filtrar
    		        List<DataBuscar> resMod = new ArrayList<DataBuscar>(res);
    		        String dpto = req.getParameter("dpto");
    		        String categ = req.getParameter("catg");
    		        if (dpto != null) {
    		            for (DataBuscar iter : res) {
    		                if (iter instanceof DataActividad) {
    		                    DataActividad aux = (DataActividad) iter;
    		                    if (!aux.getDepartamento().equals(dpto))
    		                        resMod.remove(aux);
    		                }
    		                else {
    		                    DataPaquete aux = (DataPaquete) iter;
    		                    boolean eliminar = false;
    		                    for (DataActividad itr : aux.getDtAct()) {
    		                        eliminar = eliminar || itr.getDepartamento().equals(dpto);
    		                    }
    		                    if (!eliminar)
                                    resMod.remove(aux);
    		                }
    		            }
    		        }
    		        else if (categ != null) {
    		            for (DataBuscar iter : res) {
    		                Set<String> categorias = new HashSet<String>();
                            if (iter instanceof DataActividad) {
                                DataActividad aux = (DataActividad) iter;
                                Collections.addAll(categorias, aux.getCategorias());
                                if (!categorias.contains(categ))
                                    resMod.remove(aux);
                            }
                            else {
                                DataPaquete aux = (DataPaquete) iter;
                                Collections.addAll(categorias, aux.getCategorias());
                                if (!categorias.contains(categ))
                                    resMod.remove(aux);
                            }
                        }
    		        }
    		        req.setAttribute("resultado", resMod);
    		        req.getRequestDispatcher("/WEB-INF/buscar/buscador.jsp").forward(req, resp);
    		        break;
    		    case "/perteneceSal":
                    String text3 = "n";
                    resp.setContentType("text/plain");  
                    resp.setCharacterEncoding("UTF-8");
                    String sReq = req.getParameter("sal");
                    if (!sReq.equals("")) {
                        try {
                            DataSalida usu = port.obtenerDataSalida(sReq);
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
                            DataActividad usu = port.obtenerDataActividad(aReq);
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
                            DataUsuario usu = port.obtenerDataUsuarioNick(nReq);
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
                            DataUsuario usu = port.obtenerDataUsuarioMail(eReq);
                        } catch (UsuarioNoExisteException e1) {
                            text1 = "y";
                        }
                    }
                    resp.getWriter().write(text1);
                    break;
    		    case "/DescargarPDF":
    		        DataUsuario dataU;
    		        DataSalida dataS;
    		        DataActividad dataA;
    		        DataCompraGeneral dataCG = null;
    		        
    		        String usuario2 = (String) req.getParameter("Usuario");
    		        String salida2 = (String) req.getParameter("Salida");
    		        String actividad2 = port.obtenerNomActPorSalida(salida2);
    		        
    		        
    		        dataU = port.obtenerDataUsuarioNick(usuario2);
    		        dataA = port.obtenerDataActividad(actividad2);
    		        dataS = port.obtenerDataSalida(salida2);
    		        
    		        DataCompraGeneral[] arrDataCG = ((DataTurista) dataU).getInscripcionesSal();
    		        
    		        for (int i = 0; i < arrDataCG.length; i++) {
                        if(arrDataCG[i].getSalida().equals(dataS)) {
                            dataCG = arrDataCG[i];
                            break;
                        }
                    }
    		        
    		        String text11 ="El " + usuario2 + " se inscribio a la salida " + salida2 + " el dia " + dataCG.getFecha().get(Calendar.DATE)   + " del mes " + (dataCG.getFecha().get(Calendar.MONTH)+1)   +" del anio " + dataCG.getFecha().get(Calendar.YEAR)   ;
	                String text22 =salida2 + " Corresponde a la Actividad " + actividad2;
	                String text32=salida2 + " tiene " + dataCG.getCantidad() + " personas inscriptos";
    		        
    		        try {
    		            PDDocument documento = new PDDocument();
    		            PDPage pagina = new PDPage(PDRectangle.A6);
    		            documento.addPage(pagina);
    		            PDPageContentStream contenido = new PDPageContentStream(documento,pagina); 
    		            
    		            contenido.beginText();
    		            contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
    		            
    		            contenido.showText(text11);
    		            contenido.showText(text22);
    		            contenido.showText(text32);
    		            
    		            contenido.close();
    		            
    		            documento.save("/home/eeeeeeeeeeeeee/git/123/tarea2p2/src/main/webapp/WEB-INFSalida.pdf");
    		            
    		        }catch(Exception x) {
    		            System.out.println("error");
    		        }
    		        
    		        /*
    		        com.itextpdf.text.Document documento;
    		        FileOutputStream archivo;
    		        com.itextpdf.text.Paragraph titulo;
    		        
    		        documento = new com.itextpdf.text.Document();
    		        
    		        titulo = new com.itextpdf.text.Paragraph("Iscripcion a " + salida2);
    		        
    		        try {
    		            archivo = new FileOutputStream("IscripcionSalida");
    		            com.itextpdf.text.pdf.PdfWriter.getInstance(documento, archivo);
    		            documento.open();
    		            titulo.setAlignment(1);
    		            documento.add(titulo);
    		            documento.add(new com.itextpdf.text.Paragraph("El " + usuario2 + " se inscribio a la salida " + salida2 + " el dia " + dataCG.getFecha().get(Calendar.DATE)   + " del mes " + (dataCG.getFecha().get(Calendar.MONTH)+1)   +" del anio " + dataCG.getFecha().get(Calendar.YEAR)   ));
    		            documento.add(new com.itextpdf.text.Paragraph(salida2 + " Corresponde a la Actividad " + actividad2));
    		            documento.add(new com.itextpdf.text.Paragraph(salida2 + " tiene " + dataCG.getCantidad() + " personas inscriptos"));
    		            documento.close();
    		            
    		            
    		        } catch(FileNotFoundException e) {
    		            System.out.println(e.getMessage());
    		        } catch(com.itextpdf.text.DocumentException e) {
    		            System.out.println(e.getMessage());
    		        }
                    */
    		        
    		        resp.setContentType("application/pdf");
    		        resp.setHeader("Content-disposition", "attachment; filename=sample.txt");
    		        int ARBITARY_SIZE = 1048;
    		        try(InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/Salida.pdf");
    		          OutputStream out = resp.getOutputStream()) {

    		            byte[] buffer = new byte[ARBITARY_SIZE];
    		        
    		            int numBytesRead;
    		            while ((numBytesRead = in.read(buffer)) > 0) {
    		                out.write(buffer, 0, numBytesRead);
    		            }
    		        }
    		    

                    
                    break;
    		    case "/ConsultaUsuario":
    				String usuario = (String) req.getParameter("nick");
    				System.out.println(usuario);
    				if (usuario == null) {
    					DataUsuario[] usuarios = Arrays.copyOf(port.listarUsuarios().getArray(), port.listarUsuarios().getArray().length, DataUsuario[].class);
    					req.setAttribute("ArregloUsuarios", usuarios);
    					req.getRequestDispatcher("/WEB-INF/ConsultaUsuario/ListaUsuario.jsp").forward(req, resp);
    				}else 
    				    
    				{
    					DataUsuario dataUsu;
                        try {
                            dataUsu = port.obtenerDataUsuarioNick(usuario);
                            req.setAttribute("UsuarioElegido", dataUsu);
                            if (dataUsu instanceof DataTurista) {
                                DataPaquete[] arrDataPaquetes = null;
                                DataPaquete DataPaqueteAux ; 
                                int aux;
                                String[] aux2 = ((DataTurista)dataUsu).getPaquetes(); 
                                if(!(aux2 == null)) {
                                    aux =((DataTurista) dataUsu).getPaquetes().length;
                                }
                                else { 
                                   aux= 0;
                                }
                                arrDataPaquetes = new DataPaquete[aux];
                                String[] arrPaquetes = ((DataTurista) dataUsu).getPaquetes();
                               if(!(arrPaquetes==null)) {
                                for (int i =0 ; i<arrPaquetes.length; i++) {
                                   DataPaqueteAux = port.obtenerDataPaquete(arrPaquetes[i]);
                                   arrDataPaquetes[i] = DataPaqueteAux ; 
                               }
                               req.setAttribute("ArregloPaquetes", arrDataPaquetes);
                               }else
                                   req.setAttribute("ArregloPaquetes", null);
                               }
                            req.getRequestDispatcher("/WEB-INF/ConsultaUsuario/ConsultaUsuario.jsp").forward(req, resp);
                        } catch (UsuarioNoExisteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
    				}				
    				break;
    			case "/ConsultaActividad":
    			    String actividad = (String) session.getAttribute("actividad_inicio");
                    session.setAttribute("actividad_inicio", null);
                    if (actividad == null) {
                        actividad = (String) req.getParameter("actividad");
                    }
    				DataActividad[] actividades = null;
    				if (actividad == null) {
    				    if (session.getAttribute("DTDConsultaActividad")!= null) {
                            actividades = ((DataDepartamento) session.getAttribute("DTDConsultaActividad")).getColAct();
                            session.setAttribute("DTDConsultaActividad", null);
                        } else {
                            String categoria = (String) session.getAttribute("CatConsultaActividad");
                            if (categoria != null) {
                                actividades = Arrays.copyOf(port.obtenerActividadCategoria(categoria).getArray(), port.obtenerActividadCategoria(categoria).getArray().length, DataActividad[].class);
                                session.setAttribute("CatConsultaActividad", null);
                            }
                        }
    					req.setAttribute("ArregloActividades", actividades);
    					session.setAttribute("ArregloActividades", actividades);
    					req.getRequestDispatcher("/WEB-INF/ConsultaActividad/ListaActividad.jsp").forward(req, resp);
    				} else {
                        DataActividad act = null;
                        DataPaquete[] arrDataPaquetes = null ;  

                        try {
                           act = port.obtenerDataActividad(actividad);
                         
                           //genero un array de dataPaquetes para cada actividad que quiero consultar
                           if(!(act.getPaquetes()==null))
                               arrDataPaquetes = new DataPaquete[act.getPaquetes().length];
                           String[] arrPaquetes = act.getPaquetes();
                           if(!(arrPaquetes==null)) {
                               for (int i=0 ; i<arrPaquetes.length; i++) {
                                   arrDataPaquetes[i] = port.obtenerDataPaquete(arrPaquetes[i]);
                               }}
                               
                           
                           
                           
                        } catch (ActividadNoExisteException e) {
                            e.printStackTrace();
                        }
    				    req.setAttribute("ActividadElegida", act);
    				    
    				    req.setAttribute("ArrayPaquetes", arrDataPaquetes);
                        req.getRequestDispatcher("/WEB-INF/ConsultaActividad/DetalleActividad.jsp").forward(req, resp);
    				}
    				break;
    			case "/ConsultaSalida":
    			    String salida = req.getParameter("salida");
    			    try {
                        DataSalida dataSal = port.obtenerDataSalida(salida);
                        req.setAttribute("SalidaElegida", dataSal);
                        req.getRequestDispatcher("/WEB-INF/ConsultaSalida/ConsultaSalida.jsp").forward(req, resp); //Ver si entregar el set de salidas o no, por ahora se devuelve el DataSalida que viene desde la lista.
                    } catch (SalidasNoExisteException e) {
                        req.setAttribute("Exception", e.getMessage());
                        req.getRequestDispatcher("/WEB-INF/home/iniciar.jsp").forward(req, resp);
                    }
    				break;
    			case "/ConsultaPaquete":
    				String paquete = (String) req.getParameter("paquete");
    				if (paquete == null) {
    					String[] nombresPaq = Arrays.copyOf(port.listarPaquetes().getArray(), port.listarPaquetes().getArray().length, String[].class);
    					DataPaquete[] dps = new DataPaquete[nombresPaq.length];
    					for (int i=0; i<nombresPaq.length; i++) {
    						dps[i] = port.obtenerDataPaquete(nombresPaq[i]);
    					}
    					req.setAttribute("ArregloPaquetes", dps);
    					req.getRequestDispatcher("/WEB-INF/ConsultaPaquete/ListaPaquetes.jsp").forward(req, resp);
    				} else {
    					DataPaquete dataPaq = port.obtenerDataPaquete(paquete);
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
