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

import excepciones.ActividadRepetidaException;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataProveedor;
import logica.DataTurista;
import logica.DataUsuario;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;

/**
 * Servlet implementation class Home
 */

@WebServlet (urlPatterns={"/ModificarUsuario", "/SalidaCreada", "/UsuarioCreado", "/ActividadCreada", "/AltaSalida", "/AltaActividad", "/AltaUsuario", "/UsuarioModificado"})
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
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    String nomDpto = req.getParameter("DTDConsultaActividad");
        String nomCat = req.getParameter("CatConsultaActividad");
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
                    req.getRequestDispatcher("/WEB-INF/modificarUsuario/modificarUsuario.jsp").forward(req, resp);
                    break;
                case "/ActividadCreada":
    			    String nombreAct = (String) req.getParameter("actividadNombre");
                    String departamentoAct = (String) req.getParameter("actividadDepartamento");
                    String descripcionAct = (String) req.getParameter("actividadDescripcion");
                    String costoAct = (String) req.getParameter("actividadCosto");
                    String duracionAct = (String) req.getParameter("actividadDuracion");
                    String ciudadAct = (String) req.getParameter("actividadCiudad");
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
                        conAlta = fab.getIControladorAlta();
                        
                        //Chequeo imagen cargada
                        InputStream inputStreamAct = null;
                        Part filePartAct = req.getPart("imagenActividad");
                        //Si se subió imagen
                        if (filePartAct.getSize() > 0) {
                            inputStreamAct = filePartAct.getInputStream();
                            FileOutputStream outputAct = null;
                            byte[] imgBytesAct = null;
                            try {
                                File nuevaImgAct = new File(req.getSession().getServletContext().getRealPath("/") + proveedorAct + filePartAct.getSubmittedFileName());
                                if (nuevaImgAct.createNewFile())
                                  System.out.println("El fichero se ha creado correctamente");
                                else
                                  System.out.println("No ha podido ser creado el fichero");
                                outputAct = new FileOutputStream(nuevaImgAct);
                                int leidos = 0;
                                leidos = inputStreamAct.read();
                                while (leidos != -1) {
                                    outputAct.write(leidos);
                                    leidos = inputStreamAct.read();
                                }
                                imgBytesAct = Files.readAllBytes(Paths.get(nuevaImgAct.getAbsolutePath()));
                              } catch (IOException ioeAct) {
                                ioeAct.printStackTrace();
                              } finally {
                                try {
                                    outputAct.flush();
                                    outputAct.close();
                                    inputStreamAct.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                          
                            try {
                                conAlta.registrarActividad(departamentoAct, nombreAct, descripcionAct, Integer.parseInt(duracionAct),
                                        Integer.parseInt(costoAct), ciudadAct, date1, proveedorAct, categoriasAct, imgBytesAct);
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
                                ServletContext servletContextDef = req.getServletContext();
                                BufferedImage imgDef = ImageIO.read(servletContextDef.getResourceAsStream("/WEB-INF/data/default_imagen.jpg"));
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                ImageIO.write(imgDef, "jpg", baos);
                                byte[] imgDefBytes = baos.toByteArray();
                                conAlta.registrarActividad(departamentoAct, nombreAct, descripcionAct, Integer.parseInt(duracionAct), Integer.parseInt(costoAct), ciudadAct, date1, proveedorAct, categoriasAct, imgDefBytes);
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
    				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    				InputStream inputStream = null; // input stream of the upload file
    		        // obtains the upload file part in this multipart request
    		        Part filePart = req.getPart("imgUsuario");
    		        conAlta = fab.getIControladorAlta();
    		        conCons = fab.getIControladorConsulta();
    		        if (filePart.getSize() > 0) {
    		             
    		            // obtains input stream of the upload file
    		            inputStream = filePart.getInputStream();
    		            FileOutputStream output = null;
    		            byte[] imgBytes = null;
    		            try {
    		                // A partir del objeto File creamos el fichero físicamente
    		                File nuevaImg = new File(req.getSession().getServletContext().getRealPath("/") + nick + filePart.getSubmittedFileName());
    		                if (nuevaImg.createNewFile())
    		                  System.out.println("El fichero se ha creado correctamente");
    		                else
    		                  System.out.println("No ha podido ser creado el fichero");
    		                output = new FileOutputStream(nuevaImg);
    		                int leido = 0;
    		                leido = inputStream.read();
    		                while (leido != -1) {
    		                    output.write(leido);
    		                    leido = inputStream.read();
    		                }
    		                imgBytes = Files.readAllBytes(Paths.get(nuevaImg.getAbsolutePath()));
    		              } catch (IOException ioe) {
    		                ioe.printStackTrace();
    		              } finally {
    		                try {
    		                    output.flush();
    		                    output.close();
    		                    inputStream.close();
    		                } catch (IOException ex) {
    		                    ex.printStackTrace();
    		                }
    		            }
    		          
    		            try {
    						Date fechaNac = format.parse(date);
    						if (!nacionalidad.equals("")) {
    							conAlta.confirmarAltaTurista(nick, nombre , apellido, mail, fechaNac , nacionalidad, password, imgBytes);
    						} else if (linkProv != null && descripcion != null) {
    							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail, fechaNac, descripcion, linkProv, true, password, imgBytes); 
    						}
    						else if (descripcion!= null) {
    							conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail , fechaNac, descripcion, "", false, password, imgBytes); 
    						}else {
    							// no deberia pasar
    							break;
    						}
    						HttpSession session = req.getSession();
    						DataUsuario dataUsu = conCons.obtenerDataUsuarioNick(nick);
    						session.setAttribute("usuario", dataUsu);
    						//Setear imagen
    						InputStream inSt = new ByteArrayInputStream(imgBytes);
                            BufferedImage buffIm = ImageIO.read(inSt);
                            ByteArrayOutputStream outputA = new ByteArrayOutputStream();
                            ImageIO.write(buffIm, "jpg", outputA);
                            String imageAsBase64 = Base64.getEncoder().encodeToString(outputA.toByteArray());
    						session.setAttribute("imagenUsuario", imageAsBase64);
    						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
    						resp.sendRedirect("/tarea2p2/home");
    					} catch (UsuarioRepetidoException e) {
    						req.setAttribute("Exception", e.getMessage());
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
                            ServletContext servletContextDef = req.getServletContext();
                            BufferedImage imgDef = ImageIO.read(servletContextDef.getResourceAsStream("/WEB-INF/data/default_imagen.jpg"));
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            ImageIO.write(imgDef, "jpg", baos);
                            byte[] imgDefBytes = baos.toByteArray();
                            if (!nacionalidad.equals("")) {
                                conAlta.confirmarAltaTurista(nick, nombre , apellido, mail, fechaNac, nacionalidad, password, imgDefBytes);
                            } else if (linkProv != null && descripcion!= null) {
                                conAlta.confirmarAltaProveedor(nick, nombre, apellido, mail, fechaNac, descripcion, linkProv, true, password, imgDefBytes); 
                            }
                            else if (descripcion!= null) {
                                conAlta.confirmarAltaProveedor(nick, nombre , apellido, mail, fechaNac, descripcion, "", false, password, imgDefBytes); 
                            }else {
    							// no deberia pasar
    							break;
    						}
    						HttpSession session = req.getSession();
    						DataUsuario dataUsu = conCons.obtenerDataUsuarioNick(nick);
    						session.setAttribute("usuario", dataUsu);
    						session.setAttribute("imagenUsuario", null); // revisar esto
    						session.setAttribute("estado_sesion", EstadoSesion.LOGIN_CORRECTO);
    						resp.sendRedirect("/tarea2p2/home");
    					} catch (UsuarioRepetidoException e) {
    						req.setAttribute("Exception", e.getMessage());
    						req.getRequestDispatcher("/WEB-INF/altaUsuario/alta_usuario.jsp").forward(req, resp);
    					}catch (ParseException e1) {
    		                e1.printStackTrace();
    					} catch (UsuarioNoExisteException e) {
    		                e.printStackTrace();
    					}
    				}
    				break;
    			case "/ ":
    				DataActividad dataAct = (DataActividad) req.getAttribute("DataActividad");
    				HttpSession session1 = req.getSession();
    				DataUsuario aux = (DataUsuario) session1.getAttribute("usuario");
    				String proveedor = aux.getNick();
    				conAlta = fab.getIControladorAlta();
    				try {
    					//da.getDepartamento()
    					conAlta.registrarActividad("Rocha", dataAct.getNombre() , dataAct.getDescripcion(), dataAct.getDuracion(), dataAct.getCosto(), dataAct.getCiudad(), dataAct.getFechaAlta(), proveedor, dataAct.getCategorias());
    					resp.sendRedirect("/WEB-INF/iniciar.jsp");
    				} catch (ActividadRepetidaException | UsuarioNoExisteException | ProveedorNoNacidoException e) {
    					req.setAttribute("Exception", e.getMessage());
    					req.getRequestDispatcher("/WEB-INF/alta_actividad.jsp").forward(req, resp);
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
                    
                    String horaSal = (String) req.getParameter("salidaHora");
                    Date horaSalida = new Date(0, 0, 0, Integer.parseInt(horaSal), 0, 0);
                    
                    // No se esta contrrolando las salidas duplicadas
                                        
    				conAlta = fab.getIControladorAlta();
    				
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
                            Date fechaSalida=new SimpleDateFormat("yyyy-MM-dd").parse(fechaSal);
                            conAlta.confirmarAltaSalida(actividad, salidaNombre, fechaSalida, horaSalida, salidaLugar, Integer.parseInt(salidaCantMax), fechaActualS, imgBytesSal);
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
                        }catch (ParseException e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                            // TODO Auto-generated catch block
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
                            
                            Date fechaSalida=new SimpleDateFormat("yyyy-MM-dd").parse(fechaSal);
                            conAlta.confirmarAltaSalida(actividad, salidaNombre, fechaSalida, horaSalida, salidaLugar, Integer.parseInt(salidaCantMax), fechaActualS, imgDefBytes);
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
                        }catch (ParseException e3) {
                            req.setAttribute("Exception", e3.getMessage());
                            req.getRequestDispatcher("/home").forward(req, resp);
                            // TODO Auto-generated catch block
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
                    conCons = fab.getIControladorConsulta();
    				conAlta = fab.getIControladorAlta();
                    HttpSession session = req.getSession();
                    DataUsuario usuario = (DataUsuario) session .getAttribute("usuario");
                    String contrasenaActual = usuario.getPassword();
                    
                    try {
                        
                        if (usuario instanceof DataTurista) {
                            String nacionalidadNueva = (String) req.getParameter("nacionalidadNueva");
                            if(!contrasenaActualIngresada.equals(null) || !contrasenaActualIngresada.equals("")) {
                                if(contrasenaActualIngresada.equals(contrasenaActual)) {
                                    if(contrasenaNuevaIng.equals(contrasenaNuevaConf) &&  (!contrasenaNuevaIng.equals(null)) && (!contrasenaNuevaIng.equals(""))) {
                                        contrasenaActual = contrasenaNuevaIng;
                                    }
                                }
                            }
                            if (fechaNueva.equals(null) || fechaNueva.equals("")) {
                                conAlta.actualizarDatosTurista(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), nacionalidadNueva, contrasenaActual, usuario.getImagen());
                            } else {
                                Date fechaNuevaNac = formatFecha.parse(fechaNueva);
                                conAlta.actualizarDatosTurista(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNac, nacionalidadNueva, contrasenaActual, usuario.getImagen());
                            }
                        } else if (usuario instanceof DataProveedor){
                            String descripcionNueva = (String) req.getParameter("descripcionNueva");
                            String linkNuevo = (String) req.getParameter("linkNuevo");
                            boolean hayLink = false;
                            if(!contrasenaActualIngresada.equals(null) || !contrasenaActualIngresada.equals("")) {
                                if(contrasenaActualIngresada.equals(contrasenaActual)) {
                                    if(contrasenaNuevaIng.equals(contrasenaNuevaConf) &&  (!contrasenaNuevaIng.equals(null)) && (!contrasenaNuevaIng.equals(""))) {
                                        contrasenaActual = contrasenaNuevaIng;
                                    }
                                }
                            }
                            if (!linkNuevo.equals(null) || !linkNuevo.equals("")) {
                                hayLink = true;
                            }
                            if (fechaNueva.equals(null) || fechaNueva.equals("")) {
                                conAlta.actualizarDatosProveedor(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, usuario.getNacimiento(), descripcionNueva, linkNuevo, hayLink, contrasenaActual, usuario.getImagen());
                            }else {
                                Date fechaNuevaNac = formatFecha.parse(fechaNueva);
                                conAlta.actualizarDatosProveedor(usuario.getNick(), usuario.getMail(), nuevoNombre, apellidoNuevo, fechaNuevaNac, descripcionNueva, linkNuevo, hayLink, contrasenaActual, usuario.getImagen());
                            }
                        }
                        req.setAttribute("DataUsuario", usuario);
                        try {
                            session.setAttribute("usuario", conCons.obtenerDataUsuarioNick(usuario.getNick()));
                        } catch (UsuarioNoExisteException e) {
                            // TODO Auto-generated catch block
                        }
                        req.getRequestDispatcher("/ConsultaUsuario").forward(req, resp);
                    }catch (ParseException e){
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
