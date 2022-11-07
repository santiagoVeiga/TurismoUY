package controllers;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class Imagenes
 */
@WebServlet("/Imagenes")
public class ServletImagenes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImagenes() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String id = (String) request.getParameter("id");
        
        byte[] img = null;
        
        
            servidor.PublicadorIControladorService service = new servidor.PublicadorIControladorServiceLocator(dirIPPort());
            servidor.PublicadorIControlador port = null;
            try {
                port = service.getPublicadorIControladorPort();
            } catch (ServiceException e1) {
                e1.printStackTrace();
            }
          
          try {
          
          img = port.getFile(id);
          response.setContentType("image/jpg");
          response.setContentLength((int) img.length);
          OutputStream out = response.getOutputStream();
          //ImageIO.write(img, "png", out);
          out.write(img);
          out.close();
          
          } catch (Exception ex) {
          
          }
         
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
