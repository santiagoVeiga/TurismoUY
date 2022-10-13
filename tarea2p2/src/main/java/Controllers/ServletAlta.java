package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import excepciones.ActividadRepetidaException;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataActividad;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.DataProveedor;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;

/**
 * Servlet implementation class Home
 */

@WebServlet (urlPatterns={"/ModificarUsuario","/SalidaCreada","/UsuarioCreado","/ActividadCreada","/AltaSalida","/AltaActividad","/AltaUsuario"})
@MultipartConfig(maxFileSize = 16177215) 
public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();;
	private IControladorAlta conAlta;
	private IControladorConsulta conCons;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		switch(req.getServletPath()){
			case "/AltaUsuario":
				req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req,resp);
				break;
			case "/AltaActividad":
				// manda una redirecciÃ³n a otra URL (cambia la URL)
			    
                req.getRequestDispatcher("/WEB-INF/altaActividad/alta_actividad.jsp").forward(req,resp);
				break;
			case "/AltaSalida":
				req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				break;
			case "/ActividadCreada":
                String nombreAct = (String) req.getParameter("actividadNombre");
                String departamentoAct = (String) req.getParameter("actividadDepartamento"); //Corregir agarrar el seleccionado del combo 
                String descripcionAct = (String) req.getParameter("actividadDescripcion");
                String costoAct = (String) req.getParameter("actividadCosto");
                String duracionAct = (String) req.getParameter("actividadDuracion");
                String ciudadAct = (String) req.getParameter("actividadCiudad");
                //obtengo categorias añadidas
                //String[] auxCategorias = (String[]) req.getParameterValues("catActual"); //Corregir agarrar las seleccionadas
                //Set<String> categoriasAct = new HashSet<>(Arrays.asList(auxCategorias));
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.now();
                Date fechaAct = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());              
                
                //FALTA TRAER IMAGENES
                
                HttpSession sessionAct = req.getSession();
                DataProveedor dtProveedor = (DataProveedor) sessionAct.getAttribute("usuario");
                String proveedorAct = dtProveedor.getNick();
                
                conAlta = fab.getIControladorAlta();
                try {
                    conAlta.registrarActividad(departamentoAct,nombreAct, descripcionAct, Integer.parseInt(duracionAct), Integer.parseInt(costoAct),ciudadAct,fechaAct,proveedorAct, null);
                    resp.sendRedirect("/tarea2p2/home");

                } catch (NumberFormatException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (ActividadRepetidaException e2) {
                    req.setAttribute("Exception", e2.getMessage());
                    req.getRequestDispatcher("/WEB-INF/altaActividad/alta_actividad.jsp").forward(req,resp);
                } catch (UsuarioNoExisteException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (ProveedorNoNacidoException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                resp.sendRedirect("/tarea2p2/home");

                break;
			case "/UsuarioCreado":
				String nick = (String) req.getParameter("username");
				String nombre = (String) req.getParameter("firstname");
				String apellido = (String) req.getParameter("lastname");
				String mail = (String) req.getParameter("email");
				String password = (String) req.getParameter("password");
				String nacionalidad = (String) req.getParameter("nacionalidad");
				String descripcion = (String) req.getParameter("descripcion");
				String linkProv = (String) req.getParameter("linkProv");
				String date = (String) req.getParameter("input_date");
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				InputStream inputStream = null; // input stream of the upload file
		        // obtains the upload file part in this multipart request
		        Part filePart = req.getPart("imgUsuario");
		        conAlta = fab.getIControladorAlta();
		        conCons = fab.getIControladorConsulta();
		        if (filePart != null) {
		             
		            // obtains input stream of the upload file
		            inputStream = filePart.getInputStream();
		            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		            int reads = inputStream.read();
		            while(reads != -1){ 
		            	baos.write(reads); 
		            	reads = inputStream.read(); 
		            } 
		            byte[] imgBytes = baos.toByteArray();
		            try {
						Date fechaNac = format.parse(date);
						if(nacionalidad != null) {
							conAlta.confirmarAltaTurista(nick, nombre , apellido, mail ,fechaNac ,nacionalidad,password,imgBytes);
						} else if (linkProv != null && descripcion != null) {
							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail ,fechaNac ,descripcion,linkProv,true,password,imgBytes); 
						}
						else if (descripcion!= null) {
							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail ,fechaNac ,descripcion,"",false,password,imgBytes); 
						}else {
							// no deberia pasar
							break;
						}
						HttpSession session = req.getSession();
						DataUsuario du = conCons.obtenerDataUsuarioNick(nick);
						session.setAttribute("usuario",du);
						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
						resp.sendRedirect("/tarea2p2/home");
					} catch (UsuarioRepetidoException e) {
						req.setAttribute("Exception", e.getMessage());
						req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req,resp);
					}catch (ParseException e1) {
					} catch (UsuarioNoExisteException e) {
					}
		        }
				else {
					try {
						Date fechaNac = format.parse(date);
						if(nacionalidad != null) {
							conAlta.confirmarAltaTurista(nick, nombre , apellido, mail ,fechaNac ,nacionalidad,password);
						} else if (linkProv != null && descripcion!= null) {
							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail ,fechaNac ,descripcion,linkProv,true,password); 
						}
						else if (descripcion!= null) {
							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail ,fechaNac ,descripcion,"",false,password); 
						}else {
							// no deberia pasar
							break;
						}
						HttpSession session = req.getSession();
						DataUsuario du = conCons.obtenerDataUsuarioNick(nick);
						session.setAttribute("usuario",du);
						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
						resp.sendRedirect("/tarea2p2/home");
					} catch (UsuarioRepetidoException e) {
						req.setAttribute("Exception", e.getMessage());
						req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req,resp);
					}catch (ParseException e1) {
					} catch (UsuarioNoExisteException e) {
					}
				}
				break;
			case "/ ":
				DataActividad da = (DataActividad) req.getAttribute("DataActividad");
				HttpSession session1 = req.getSession();
				DataUsuario aux = (DataUsuario) session1.getAttribute("usuario");
				String proveedor = aux.getNick();
				conAlta = fab.getIControladorAlta();
				try {
					//da.getDepartamento()
					conAlta.registrarActividad("Rocha", da.getNombre() , da.getDescripcion(), da.getDuracion() ,da.getCosto() ,da.getCiudad(),da.getFechaAlta(),proveedor, da.getCategorias());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_actividad.jsp").forward(req,resp);
				}
				break;
			case "/SalidaCreada":
				DataSalida ds = (DataSalida) req.getAttribute("DataSalida");
				String actividad = (String) req.getAttribute("Actividad");
				conAlta = fab.getIControladorAlta();
				try {
					conAlta.confirmarAltaSalida(actividad, ds.getNombre() ,ds.getFecha(), ds.gethora(), ds.getLugar(), ds.getCant() ,ds.getFechaAlta());
					resp.sendRedirect("/WEB-INF/iniciar.jsp");
				} catch (SalidaYaExisteExeption | FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad e) {
					req.setAttribute("Exception", e.getMessage());
					req.getRequestDispatcher("/WEB-INF/alta_salida.jsp").forward(req,resp);
				}	
				break;
			case "/ModificarUsuario":
				DataUsuario du1 = (DataUsuario) req.getAttribute("DataUsuario");
				conAlta = fab.getIControladorAlta();
				if(du1 instanceof DataTurista) {
					conAlta.actualizarDatosTurista(du1.getNick(), du1.getNombre() , du1.getApellido(), du1.getMail() ,du1.getNacimiento() ,((DataTurista) du1).getNacionalidad());
				} else {
					conAlta.actualizarDatosProveedor(du1.getNick(), du1.getNombre() , du1.getApellido(), du1.getMail() ,du1.getNacimiento() ,((DataProveedor) du1).getDescripcion(),((DataProveedor) du1).getLink(), true);//((DataProveedor) du1).getHayLink());
				}
				req.setAttribute("DataUsuario", du1);
				req.getRequestDispatcher("/WEB-INF/ConsultaUsuario.jsp").forward(req,resp);
				break;
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
