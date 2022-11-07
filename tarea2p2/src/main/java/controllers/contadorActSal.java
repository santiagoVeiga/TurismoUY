package controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Servlet Filter implementation class contadorActSal
 */
@WebFilter(urlPatterns={"/ConsultaActividad","/ConsultaSalida"})
public class contadorActSal extends HttpFilter implements Filter {
       
    private ServletContext context;

    /**
     * @see HttpFilter#HttpFilter()
     */
    public contadorActSal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private String dirIPPort() {
        String ipport = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(getContext().getResourceAsStream("/WEB-INF/data/configIPPort.xml"));
            document.getDocumentElement().normalize();
            NodeList datos = document.getElementsByTagName("datos");
            ipport = datos.item(0).getTextContent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ipport;
    }
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
	    servidor.PublicadorIControladorService service = new servidor.PublicadorIControladorServiceLocator(dirIPPort());
        servidor.PublicadorIControlador port = null;
        try {
            port = service.getPublicadorIControladorPort();
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }
        HttpSession session = request.getSession();
        String actividad = (String) session.getAttribute("actividad_inicio");
        if (actividad == null) {
            actividad = (String) request.getParameter("actividad");
        }
        if (actividad != null) {
            port.sumarVistaAAct(actividad);
            System.out.println("Se sumo a act");
        }
        else {
            String salida = request.getParameter("salida");
            if (salida != null) {
              port.sumarVistaASal(salida);
              System.out.println("Se sumo a sal");
            }
        }
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	    context = fConfig.getServletContext();
	}

    public ServletContext getContext() {
        return context;
    }

}
