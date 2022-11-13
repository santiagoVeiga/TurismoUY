package controllers;

import java.awt.image.BufferedImage;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import servidor.ActividadRepetidaException;
import servidor.DataActividad;
import servidor.DataColeccionObject;
import servidor.DataDepartamento;
import servidor.DataProveedor;
import servidor.DataTurista;
import servidor.DataUsuario;
import servidor.FechaAltaSalidaAnteriorActividad;
import servidor.FechaAltaSalidaInvalida;
import servidor.ProveedorNoNacidoException;
import servidor.SalidaYaExisteExeption;
import servidor.UsuarioNoExisteException;
import servidor.UsuarioRepetidoException;

/**
 * Servlet implementation class Home
 */

@WebServlet (urlPatterns={"/ModificarUsuario", "/SalidaCreada", "/UsuarioCreado", "/ActividadCreada", "/AltaSalida", "/AltaActividad", "/AltaUsuario", "/UsuarioModificado"})
@MultipartConfig(maxFileSize = 16177215) 
public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlta() {
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
                // TODO Auto-generated catch block
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
    			case "/AltaUsuario":
    				req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req, resp);
    				break;
    			case "/AltaActividad":
    				// manda una redirección a otra URL (cambia la URL)
    			    
                    req.getRequestDispatcher("/WEB-INF/altaActividad/alta_actividad.jsp").forward(req, resp);
    				break;
    			case "/AltaSalida":
                    req.getRequestDispatcher("/WEB-INF/altaSalida/alta_salida.jsp").forward(req, resp);
                    break;
    			case "/ModificarUsuario":
    			    HttpSession sessionMod = req.getSession();
    			    String nickMod = (String) req.getParameter("dataUsuario");
    			    DataUsuario usuarioMod = port.obtenerDataUsuarioNick(nickMod);
    			    sessionMod.setAttribute("usuario", usuarioMod);
                    req.getRequestDispatcher("/WEB-INF/modificarUsuario/modificarUsuario.jsp").forward(req, resp);
                    break;
                case "/ActividadCreada":
    			    String nombreAct = (String) req.getParameter("actividadNombre");
                    String departamentoAct = (String) req.getParameter("actividadDepartamento");
                    String descripcionAct = (String) req.getParameter("actividadDescripcion");
                    String costoAct = (String) req.getParameter("actividadCosto");
                    String duracionAct = (String) req.getParameter("actividadDuracion");
                    String ciudadAct = (String) req.getParameter("actividadCiudad");
                    String linkVideo = (String) req.getParameter("linkVideo");
                    boolean hayVideo = false;
                    if(!linkVideo.equals("")) { //!linkVideo.equals(null) && 
                        hayVideo = true;
                    }
                    //obtengo categorias 
                    String[] auxCategorias =  req.getParameterValues("actividadCategoria");
                    Set<String> categoriasAct = null;
                    if (auxCategorias != null) {
                        categoriasAct = new HashSet<>(Arrays.asList(auxCategorias));
                     // Fecha del Sistema
                        Date date1 = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String str = formatter.format(date1);
                         
                        //Usuario logeado
                        HttpSession sessionAct = req.getSession();
                        DataProveedor dtProveedor = (DataProveedor) sessionAct.getAttribute("usuario");
                        String proveedorAct = dtProveedor.getNick();
                        
                        //Chequeo imagen cargada
                        InputStream inputStreamAct = null;
                        Part filePartAct = req.getPart("imagenActividad");
                        //Si se subió imagen
                        if (filePartAct.getSize() > 0) {
                            inputStreamAct = filePartAct.getInputStream();
                            byte[] imgBytesAct = new byte[inputStreamAct.available()];
                            inputStreamAct.read(imgBytesAct);
                            
                            //inputStreamAct = filePartAct.getInputStream();
                            //FileOutputStream outputAct = null;
                            //byte[] imgBytesAct = null;
                            try {
                                //File nuevaImgAct = new File(req.getSession().getServletContext().getRealPath("/") + proveedorAct + filePartAct.getSubmittedFileName());
                                Calendar date1C = Calendar.getInstance();
                                date1C.setTime(date1);
                                port.registrarActividadImagen(departamentoAct, nombreAct, descripcionAct, Integer.parseInt(duracionAct), Integer.parseInt(costoAct), ciudadAct, date1C, proveedorAct, new DataColeccionObject(categoriasAct.toArray(), null), linkVideo, hayVideo, imgBytesAct);
                                resp.sendRedirect("/tarea2p2/home");
            
                            } catch (NumberFormatException e2) {
                                req.setAttribute("Exception", "Formato numerico no aceptado");
                                req.getRequestDispatcher("/AltaActividad").forward(req, resp);
                            } catch (ActividadRepetidaException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/AltaActividad").forward(req, resp);
                            } catch (UsuarioNoExisteException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/AltaActividad").forward(req, resp);
                            } catch (ProveedorNoNacidoException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/AltaActividad").forward(req, resp);
                            }
                        }
                        // No se subió imagen
                        else {
                            try {
                                Calendar date1C = Calendar.getInstance();
                                date1C.setTime(date1);
                                port.registrarActividadImagen(departamentoAct, nombreAct, descripcionAct, Integer.parseInt(duracionAct), Integer.parseInt(costoAct), ciudadAct, date1C, proveedorAct, 
                                        new DataColeccionObject(categoriasAct.toArray(), null), linkVideo, hayVideo,null);
                                resp.sendRedirect("/tarea2p2/home");
            
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            } catch (ActividadRepetidaException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/home").forward(req, resp);
                            } catch (UsuarioNoExisteException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/home").forward(req, resp);
                            } catch (ProveedorNoNacidoException e2) {
                                req.setAttribute("Exception", e2.getMessage());
                                req.getRequestDispatcher("/home").forward(req, resp);
                            }
                        }
                    }else {
                        req.setAttribute("Exception", "La Actividad debe tener al menos una categoría");
                        req.getRequestDispatcher("/home").forward(req, resp);   
                    }
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
    				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    				InputStream inputStream = null; // input stream of the upload file
    		        // obtains the upload file part in this multipart request
    		        Part filePart = req.getPart("imgUsuario");
    		        if (filePart.getSize() > 0) {
    		             
    		            // obtains input stream of the upload file
    		            inputStream = filePart.getInputStream();
    		            byte[] imgBytes = new byte[inputStream.available()];
    		            inputStream.read(imgBytes);
    		            try {
    						Date fechaNac = format.parse(date);
    						Calendar fechaNacC = Calendar.getInstance();
    						fechaNacC.setTime(fechaNac);
    						if (!nacionalidad.equals("")) {
    							port.confirmarAltaTuristaCompleto(nick, nombre , apellido, mail, fechaNacC , nacionalidad, password, imgBytes);
    						} else if (linkProv != null && descripcion != null) {
    							port.confirmarAltaProveedorCompleto(nick, nombre , apellido, mail, fechaNacC, descripcion, linkProv, true, password, imgBytes); 
    						}
    						else if (descripcion!= null) {
    							port.confirmarAltaProveedorCompleto(nick, nombre , apellido, mail , fechaNacC, descripcion, "", false, password, imgBytes); 
    						}else {
    							// no deberia pasar
    							break;
    						}
    						HttpSession session = req.getSession();
    						DataUsuario dataUsu = port.obtenerDataUsuarioNick(nick);
    						session.setAttribute("usuario", dataUsu);
    						session.setAttribute("imagenUsuario", dataUsu.getImagen());
    						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
    						resp.sendRedirect("/tarea2p2/home");
    					} catch (UsuarioRepetidoException e) {
    						req.setAttribute("Exception", e.getMessage1());
    						req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req, resp);
    					}catch (ParseException e1) {
    		                e1.printStackTrace();
    					} catch (UsuarioNoExisteException e) {
    		                e.printStackTrace();
    					}
    		        }
    				else {
    					try {
    						Date fechaNac = format.parse(date);
    						Calendar fechaNacC = Calendar.getInstance();
                            fechaNacC.setTime(fechaNac);
                            if (!nacionalidad.equals("")) {
                                port.confirmarAltaTurista(nick, nombre , apellido, mail, fechaNacC, nacionalidad, password);
                            } else if (linkProv != null && descripcion!= null) {
                                port.confirmarAltaProveedor(nick, nombre, apellido, mail, fechaNacC, descripcion, linkProv, true, password); 
                            }
                            else if (descripcion!= null) {
                                port.confirmarAltaProveedor(nick, nombre , apellido, mail, fechaNacC, descripcion, "", false, password); 
                            }else {
    							// no deberia pasar
    							break;
    						}
    						HttpSession session = req.getSession();
    						DataUsuario dataUsu = port.obtenerDataUsuarioNick(nick);
    						session.setAttribute("usuario", dataUsu);
    						session.setAttribute("imagenUsuario", null); // revisar esto
    						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
    						resp.sendRedirect("/tarea2p2/home");
    					} catch (UsuarioRepetidoException e) {
    						req.setAttribute("Exception", e.getMessage1());
    						req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req, resp);
    					}catch (ParseException e1) {
    		                e1.printStackTrace();
    					} catch (UsuarioNoExisteException e) {
    		                e.printStackTrace();
    					}
    				}
    				break;
    			case "/SalidaCreada":
                    String salidaNombre = (String) req.getParameter("salidaNombre");
                    String salidaLugar = (String) req.getParameter("salidaLugar");
                    String salidaCantMax = (String) req.getParameter("salidaCantidadMax");
    				String actividad = (String) req.getParameter("actividadSal");
    				
    				Date fechaActualS = new Date();
                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
                    String str2 = formatter2.format(fechaActualS);
                    String fechaSal = (String) req.getParameter("salidaFecha");
                    Date fechaSalida = null;
                    try {
                        fechaSalida = new SimpleDateFormat("yyyy-MM-dd").parse(fechaSal);
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                    Calendar fechaActualSC = Calendar.getInstance();
                    fechaActualSC.setTime(fechaActualS);
                    
                    Calendar fechaSalidaC = Calendar.getInstance();
                    fechaSalidaC.setTime(fechaSalida);
                    
                    String horaSal = (String) req.getParameter("salidaHora");
                    Date horaSalida = new Date(0, 0, 0, Integer.parseInt(horaSal), 0, 0);
                    Calendar horaSalidaC = Calendar.getInstance();
                    horaSalidaC.setTime(horaSalida);
                    
    				//Chequeo imagen cargada
                    InputStream inputStreamSal = null;
                    Part filePartSal = req.getPart("salidaFotos");

                    //Si se subió imagen
                    if (filePartSal.getSize() > 0) {
                        inputStreamSal = filePartSal.getInputStream();
                        FileOutputStream outputSal = null;
                        byte[] imgBytesSal = null;
                        try {
                            File nuevaImgSal = new File(req.getSession().getServletContext().getRealPath("/")+ salidaNombre + filePartSal.getSubmittedFileName());
                            if (nuevaImgSal.createNewFile())
                              System.out.println("El fichero se ha creado correctamente");
                            else
                              System.out.println("No ha podido ser creado el fichero");
                            outputSal = new FileOutputStream(nuevaImgSal);
                            int leidoSal = 0;
                            leidoSal = inputStreamSal.read();
                            while (leidoSal != -1) {
                                outputSal.write(leidoSal);
                                leidoSal = inputStreamSal.read();
                            }
                            imgBytesSal = Files.readAllBytes(Paths.get(nuevaImgSal.getAbsolutePath()));
                          } catch (IOException ioeAct) {
                            ioeAct.printStackTrace();
                          } finally {
                            try {
                                outputSal.flush();
                                outputSal.close();
                                inputStreamSal.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                      
                        try {
                            port.confirmarAltaSalidaImagen(actividad, salidaNombre, fechaSalidaC, horaSalidaC, salidaLugar, Integer.parseInt(salidaCantMax), fechaActualSC, imgBytesSal);
                            resp.sendRedirect("/tarea2p2/home");
                        } catch (SalidaYaExisteExeption e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }catch( FechaAltaSalidaAnteriorActividad e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }catch( FechaAltaSalidaInvalida  e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }
                    }
                    // No se subió imagen
                    else {
                        try {
                        	ServletContext servletContextDef = req.getServletContext();
                            BufferedImage imgDef = ImageIO.read(servletContextDef.getResourceAsStream("/WEB-INF/data/default_imagen.jpg"));
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            ImageIO.write(imgDef, "jpg", baos);
                            byte[] imgDefBytes = baos.toByteArray();
                            port.confirmarAltaSalidaImagen(actividad, salidaNombre, fechaSalidaC, horaSalidaC, salidaLugar, Integer.parseInt(salidaCantMax), fechaActualSC, imgDefBytes);
                            resp.sendRedirect("/tarea2p2/home");
                        } catch (SalidaYaExisteExeption e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }catch( FechaAltaSalidaAnteriorActividad e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }catch( FechaAltaSalidaInvalida  e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                        }   
                    }
    				
    				break;
    			case "/UsuarioModificado":
                    String nuevoNombre = (String) req.getParameter("nombreNuevo");
                    String apellidoNuevo = (String) req.getParameter("apellidoNuevo");
                    String fechaNueva = (String) req.getParameter("fechaNueva");
                    SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String contrasenaActualIngresada = (String) req.getParameter("passwordActual");
                    String contrasenaNuevaIng = (String) req.getParameter("passwordNueva");
                    String contrasenaNuevaConf = (String) req.getParameter("confirmPasswordNueva");
                    HttpSession session = req.getSession();
                    DataUsuario usuario = (DataUsuario) session .getAttribute("usuario");
                    String contrasenaActual = usuario.getPassword();
                    
                    InputStream inputNueva = null;
                    Part fileNueva = req.getPart("nuevaFotoPerfil");
                    byte[] imgBytesNueva = null;

                    //Si se subió imagen
                    if (fileNueva.getSize() > 0) {
                        inputStream = fileNueva.getInputStream();
                        imgBytesNueva = new byte[inputStream.available()];
                        inputStream.read(imgBytesNueva);
                    }
                    try {
                        
                        if (usuario instanceof DataTurista) {
                            String nacionalidadNueva = (String) req.getParameter("nacionalidadNueva");
                            if(!contrasenaActualIngresada.equals(null) || !contrasenaActualIngresada.equals("")) {
                                if(contrasenaActualIngresada.equals(contrasenaActual)) {
                                    if(contrasenaNuevaIng.equals(contrasenaNuevaConf) &&  (!contrasenaNuevaIng.equals(null)) && (!contrasenaNuevaIng.equals(""))) {
                                        contrasenaActual = contrasenaNuevaIng;
                                        req.setAttribute("Exception", "Datos y contrasena editados con exito");
                                    }else {
                                        req.setAttribute("Exception", "Datos editados con exito. Nueva contrasena incorrecta");
                                    }
                                }else{
                                    req.setAttribute("Exception", "Datos editados con exito. Contrasena incambiada");
                                }
                            }else {
                                req.setAttribute("Exception", "Datos editados con exito. Contrasena incambiada");
                            }
                            if (fechaNueva.equals(null) || fechaNueva.equals("")) {
                                if(fileNueva.getSize() > 0) {
                                    port.actualizarDatosTuristaCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), nacionalidadNueva, contrasenaActual, imgBytesNueva);
                                }else {
                                    port.actualizarDatosTuristaCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), nacionalidadNueva, contrasenaActual, port.getFile(usuario.getImagen()));
                                }
                            } else {
                                Date fechaNuevaNac = formatFecha.parse(fechaNueva);
                                Calendar fechaNuevaNacC = Calendar.getInstance();
                                fechaNuevaNacC.setTime(fechaNuevaNac);
                                if(fileNueva.getSize() > 0) {
                                    port.actualizarDatosTuristaCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNacC, nacionalidadNueva, contrasenaActual, imgBytesNueva);
                                }else {
                                    port.actualizarDatosTuristaCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNacC, nacionalidadNueva, contrasenaActual, port.getFile(usuario.getImagen()));
                                }
                            }
                        } else if (usuario instanceof DataProveedor){
                            String descripcionNueva = (String) req.getParameter("descripcionNueva");
                            String linkNuevo = (String) req.getParameter("linkNuevo");
                            boolean hayLink = false;
                            if(!contrasenaActualIngresada.equals(null) || !contrasenaActualIngresada.equals("")) {
                                if(contrasenaActualIngresada.equals(contrasenaActual)) {
                                    if(contrasenaNuevaIng.equals(contrasenaNuevaConf) &&  (!contrasenaNuevaIng.equals(null)) && (!contrasenaNuevaIng.equals(""))) {
                                        contrasenaActual = contrasenaNuevaIng;
                                        req.setAttribute("Exception", "Datos y contrasena editados con exito");
                                    }else {
                                        req.setAttribute("Exception", "Datos editados con exito. Nueva contrasena incorrecta");
                                    }
                                }else{
                                    req.setAttribute("Exception", "Datos editados con exito. Contrasena incambiada");
                                }
                            }else {
                                req.setAttribute("Exception", "Datos editados con exito. Contrasena incambiada");
                            }
                            if (!linkNuevo.equals(null) || !linkNuevo.equals("")) {
                                hayLink = true;
                            }
                            if (fechaNueva.equals(null) || fechaNueva.equals("")) {
                                if(fileNueva.getSize() > 0) {
                                    port.actualizarDatosProveedorCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), descripcionNueva, linkNuevo, hayLink, contrasenaActual, imgBytesNueva);
                                }else {
                                    port.actualizarDatosProveedorCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), descripcionNueva, linkNuevo, hayLink, contrasenaActual, port.getFile(usuario.getImagen()));
                                }
                            }else {
                                Date fechaNuevaNac = formatFecha.parse(fechaNueva);
                                Calendar fechaNuevaNacC = Calendar.getInstance();
                                fechaNuevaNacC.setTime(fechaNuevaNac);
                                if(fileNueva.getSize() > 0) {
                                    port.actualizarDatosProveedorCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNacC, descripcionNueva, linkNuevo, hayLink, contrasenaActual, imgBytesNueva);
                                }else {
                                    port.actualizarDatosProveedorCompleto(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNacC, descripcionNueva, linkNuevo, hayLink, contrasenaActual, port.getFile(usuario.getImagen()));
                                }
                            }
                        }
                        DataUsuario dataUsu = port.obtenerDataUsuarioNick(usuario.getNick());
                        session.setAttribute("usuario", dataUsu);
                        session.setAttribute("imagenUsuario", null); // revisar esto
                        
                        req.getRequestDispatcher("/ConsultaUsuario?nick="+usuario.getNick()).forward(req, resp);
                    }catch (ParseException | servidor.IOException e){
                        // TODO Auto-generated catch block
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
