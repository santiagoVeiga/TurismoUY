<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64,servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataSalida,java.util.Set,servidor.DataPaquete,servidor.DataActividad,controllers.EstadoSesion" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="turismo.uy">
    <meta name="keywords" content="turismo, uruguay">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>turismo.uy</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/style_consulta_paqute.css" type="text/css">
    <link rel="stylesheet" href="../css/style_pestanias.css" type="text/css">
    
</head>

<body>
    <!-- Page Preloder -->
	<!-- Header Section Begin -->
	<jsp:include page="/WEB-INF/template/header.jsp"/>
    
    <!-- Header Section End -->

    <%DataUsuario usuario = null;
    if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
    	usuario = (DataUsuario) session.getAttribute("usuario");
    	System.out.println("Apellido"+ usuario.getApellido());
    }
      %>
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
                    	<jsp:include page="/WEB-INF/template/miPerfil.jsp"/>
                        
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>
                        
                        
                    </div>
                </div>
   				<div class="col-lg-9">
                      <div class="row">
                      	<div class="text-center p-4">
                          <h2>Modifica tus datos personales</h2>
                          <p class="lead">Ingresa tus nuevos datos personales</p>
                        </div>
                      </div>
                      <div class="row">
                      <%
                      	String tipoUsuario;
                      	if(usuario instanceof DataProveedor){
                            	tipoUsuario = "Proveedor";
                        }else{
                            	tipoUsuario = "Turista";
                        }%>
                      	<div class="blog__details__author">
                          <div class="blog__details__author__pic">
                          	<img src="/tarea2p2/Imagenes?id=<%= usuario.getImagen() %>" alt="<%= usuario.getImagen() %>"> 
                          	</div>
                          	<div class="blog__details__author__text">
                              	<h6><%=usuario.getNick()%></h6>
                              	<span><%=tipoUsuario%></span>
                          	</div>
                      	</div>
                      </div>
                      
                      <div class="row">
                      	<div class="container">
			            	<div class="row">
			            		<div class="col-lg-9">
			            		
				            		<form method="post"class="needs-validation" enctype="multipart/form-data" action="/tarea2p2/UsuarioModificado">
											<% String error = (String) request.getAttribute("Exception"); 
								               if(error != null){%>
								               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
												  <%= error %>
												  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
												</div>
											<%} %>
				            		
				            		
					            			<div class="tabs" margin-left="100px">
												  <div class="tab-container">
														      <div class="tab-content">
															        <div class="form-outline mb-4">
														              	<label class="form-label" for="nombreNuevo">Nombre</label>
														              	<input type="text"  class="form-control form-control-lg" id="nombreNuevo" name="nombreNuevo" value="<%=usuario.getNombre()%>" required/>
														            </div>
												                    <div class="form-outline mb-4">
												                    	<label class="form-label" for="apellidoNuevo">Apellido</label>
														              	<input type="text" class="form-control form-control-lg" id="apellidoNuevo" name="apellidoNuevo" value="<%=usuario.getApellido()%>"  required/>
														            </div>
											                        <div class="form-outline mb-4">
											                        	<label class="form-label" for="fechaNueva">Fecha de Nacimiento</label>
														              <div class="cont-fechaNac">
														              	<input type="date" class="form-control form-control-lg" id="fechaNueva" name="fechaNueva" value=""/>
																	  </div>
														            </div>
														            <!-- Si es Turista -->
														            <%if(usuario instanceof DataTurista){%>
												                        <div class="form-outline mb-4">
													                    	<label class="form-label" for="nacionalidadNueva">Nacionalidad</label>
															              	<input type="text" class="form-control form-control-lg" id="nacionalidadNueva" name="nacionalidadNueva" value="<%=((DataTurista) usuario).getNacionalidad()%>"  required/>
															            </div>
											                        <%}else{%>
											                        		<div class="form-outline mb-4">
														                    	<label class="form-label" for="descripcionNueva">Descripcion</label>
																              	<input type="text" class="form-control form-control-lg" id="descripcionNueva" name="descripcionNueva" value="<%=((DataProveedor) usuario).getDescripcion()%>"  required/>
															            	</div>
											                            	<div class="form-outline mb-4">
														                    	<label class="form-label" for="linkNuevo">Link (opcional)</label>
																              	<input type="text" class="form-control form-control-lg" id="linkNuevo" name="linkNuevo" value="<%=((DataProveedor) usuario).getLink()%>"/>
															            	</div>
											                        <%}%>
														            
														            <div>
														            	<label class="form-label" for="nuevaFotoPerfil">Foto De Perfil</label>
														            	<br>
														            	<input type="file" accept="image/jpg, image/jpeg" class="form-control-file" id="nuevaFotoPerfil" name="nuevaFotoPerfil">
														            </div>
														            
														            <br>
														            <br>
														            <div class="form-outline mb-4">
														              <p>Si desea cambiar su contrasena complete los siguientes campos:</p>
														            </div>
														            
														            <div class="form-outline mb-4">
														              <label class="form-label" for="form2Example28">Contraseña actual</label>
														              <input type="password" id="actual_password" name="passwordActual" class="form-control form-control-lg" />
														            </div>
														            
														            <div class="form-outline mb-4">
														              <label class="form-label" for="form2Example28">Nueva Contraseña</label>
														              <input type="password" id="password" name="passwordNueva" class="form-control form-control-lg" />
														              
														            </div>
														
														            <div class="form-outline mb-4">
														              <label class="form-label" for="form2Example28">Confirmar Nueva Contraseña</label>
														              <input type="password" id="confirm_password" name="confirmPasswordNueva" class="form-control form-control-lg" />
														              
														            </div>
														            
														            
														            <!-- Botones -->
									                                <button type="submit" class="btn btn-info btn-lg btn-block">Confirmar</button>
														      </div> 
												  </div>
											</div>
									</form>
			            		</div>
			            	</div>
            			</div>
                      </div>
                      
                  </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Js Plugins -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>



</body>

</html>




