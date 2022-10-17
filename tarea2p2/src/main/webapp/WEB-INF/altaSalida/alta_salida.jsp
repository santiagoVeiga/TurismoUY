<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="logica.DataUsuario,logica.DataDepartamento,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,Controllers.EstadoSesion,logica.DataPaquete,logica.DataActividad" %>

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
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    
<!-- Page Preloder -->
	<!-- Header Section Begin -->
	<jsp:include page="/WEB-INF/template/header.jsp"/>
    
    <!-- Header Section End -->

    <%DataUsuario usr = null;
    if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
    	usr = (DataUsuario) session.getAttribute("usuario");
    }
      %>
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
                    	<div class="hero__perfil">
                    	<% if (usr == null) {%>
                    		<ul>
                                <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                                <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                            </ul>
                    	<% } else if (usr instanceof DataTurista){ %>
                    		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuarioT.html';">
                    			<span>Mi Perfil</span>
                    			<div class="ax float-right">
                    				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
                    			</div>
                    		</div>
                    		<ul>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Inscripcion a Salida Turistica</a></li>
                                <li><a href="./ListaPaquetesT.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Comprar Paquete</a></li>
                                <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                                <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                            </ul>
                    	<% } else if (usr instanceof DataProveedor){%>
                    		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuarioP.html';">
                    			<span>Mi Perfil</span>
                    			<div class="ax float-right">
                    				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
                    			</div>
                    		</div>
                    		<ul>
                                <li><a href="./AltaActividad"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Turistica</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Turistica</a></li>
                                <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                               <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                               <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                            </ul>
                    	<% } %>
                    		
                    	</div>
                        
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>
                        
                        
                    </div>
                </div>
                <!-- Alta Salida -->
                <div class="col-lg-9" style="border-radius: 25px; padding: 20px; padding-top:30px">
                    <div class="container">
                        <div class="text-center p-4">
                          <% String actNombre = (String) request.getParameter("actNombre");%>
                          <% String actDepto = (String) request.getParameter("actDepto");%>
                          <% String actCiudad = (String) request.getParameter("actCiudad");%>
                          <h2>Alta Salida Turística</h2>
                          <p class="lead">Ingresa los datos de la Salida asociada a la Actividad: <%=actNombre %></p>
                        </div>
                        <div class="row justify-content-md-center">
                          <div class="col-md-8 order-md-1">
                            <h4 class="mb-3">Información de la Salida</h4>
                            <form class="needs-validation" action="/tarea2p2/SalidaCreada" id="sell-info">

                                <!-- Nombre y Departamento -->                                
                                <div class="row">
                                    <!-- Nombre -->
                                    <div class="col-md-6 mb-3">
                                        <label for="productName">Nombre</label>
                                        <input type="text" class="form-control" id="salidaNombre" required=""placeholder="" value="" >
                                        <!-- <div class="invalid-feedback">
                                        Ingresa un nombre
                                        </div> -->
                                    </div>
                                    <!-- Departamento -->
                                    <div class="col-md-6 mb-3">
                                        <label for="salidaDepartamento">Departamento</label>
                                        <input class="form-control" id="salidaDepartamento" value="<%=actDepto %>" readonly>  
                                        
                                    </div>
                                </div>
                              	
                              	<!-- Ciudad -->
                              	<div class="row">
                                    <div class="col-md-12 mb-3">
                                        <label for="salidaCiudad">Ciudad</label>
                                        <input class="form-control" id="salidaCiudad" value="<%=actCiudad %>" readonly >
                                    </div>
                                </div>
                              	
                              	<!-- Lugar -->
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <label for="salidaLugar">Lugar</label>
                                        <input class="form-control" id="salidaLugar" required="">
                                    </div>
                                </div>
                                
                                <!-- Cant Max -->
                                <div class="row">
                                    <div class="col-md-12 mb-3">
	                                    <label for="salidaCantidadMax">Cantidad maxima de turistas</label>
	                                    <input type="number" class="form-control" id="salidaCantidadMax" placeholder="" required="" value="" min="1">
	                                    <div class="invalid-feedback">
	                                        La cantidad es requerida.
	                                    </div>
                                    </div>
                                </div>
                                
                                <!-- Imagenes -->
                                <div class="row">
	                                <hr class="mb-4">
	                                    <div class="col-md-12 order-md-1">
	                                        <label for="zip">Imágenes</label>
	                                        <div class=" " id="file-upload">
	                                            <input type="file" class="form-control" id="customFile" />
	                                        </div>
	                                    </div>
	                                <hr class="mb-4">
	                                <br>
                                </div>
                                
                                <!-- Fecha y Hora -->
                                <div class="row">
                                	<div class="col-md-6 mb-3">
	                                    <label for="salidaFecha">Fecha</label>
	                                    <input class="form-control" type="date" id="salidaFecha" name="trip-start" >
	                                </div>
	                                
	                                <div class="col-md-6 mb-3">
	                                    <label for="salidaHora">Hora</label>
                                    	<input class="form-control" type="time" id="salidaHora" name="hora" min="1:00" max="24:00" step="3600" />
                                    </div>
                                    
                                </div>
                                        
                                
                                <!-- Imagenes opcionales-->
                                
                                <!-- Botones -->
                                <button type="button" class="btn btn-secondary btn-lg">Cancelar</button>
                                <button type="submit" class="btn btn-lg btn-primary">Confirmar</button>
                            </form>
                          </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    <!-- Js Plugins -->
    <!-- Js Plugins -->
    <script src="js/altaActividad.js"></script>
    <script src="js/main.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</body>

</html>