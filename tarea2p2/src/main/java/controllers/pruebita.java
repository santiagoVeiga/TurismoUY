package controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.rpc.ServiceException;

import servidor.DataActividad;
import servidor.DataColeccionObject;
import servidor.DataDepartamento;

/**
 * Servlet implementation class Home
 */

@WebServlet (urlPatterns={"/hola"})
@MultipartConfig(maxFileSize = 16177215) 
public class pruebita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pruebita() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
       servidor.PublicadorIControladorService ser = new servidor.PublicadorIControladorServiceLocator();
       try {
        servidor.PublicadorIControlador sere = ser.getPublicadorIControladorPort();
        //String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
        DataDepartamento[] dDep = Arrays.copyOf(sere.obtenerDataDepartamentos().getArray(), sere.obtenerDataDepartamentos().getArray().length, DataDepartamento[].class);
        for(DataDepartamento dDepI : dDep)
            System.out.println(dDepI.getNombre());
    } catch (ServiceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
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
