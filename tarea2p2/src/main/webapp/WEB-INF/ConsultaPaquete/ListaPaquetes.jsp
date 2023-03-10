<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controllers.EstadoSesion, java.util.Base64, servidor.DataUsuario, servidor.DataProveedor, servidor.DataTurista,servidor.DataActividad,servidor.DataSalida,java.util.Set,servidor.DataDepartamento,servidor.DataPaquete" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="turismo.uy">
    <meta name="keywords" content="turismo, uruguay">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado Paquetes</title>

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
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
	<jsp:include page="/WEB-INF/template/header.jsp"/>
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
<%DataUsuario usr = null;
   if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
   	usr = (DataUsuario) session.getAttribute("usuario");
   }
     %>
<div class="hero__perfil">
<% if (usr == null) {%>
	<ul>
           <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
       </ul>
<% } else if (usr instanceof DataTurista){ %>
	<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuario?nick=<%=usr.getNick()%>';">
		<span>Mi Perfil</span>
		<div class="ax float-right">
			<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
		</div>
	</div>
	<ul>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Inscripcion a Salida Turistica</a></li>
           <li><a href="#" onclick="return seleccionarPaq();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Comprar Paquete</a></li>
           <li><a href="#" onclick="return seleccionarPaq();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
           <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
       </ul>
<% } else if (usr instanceof DataProveedor){%>
	<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuario?nick=<%=usr.getNick()%>';">
		<span>Mi Perfil</span>
		<div class="ax float-right">
			<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
		</div>
	</div>
	<ul>
           <li><a href="/tarea2p2/AltaActividad"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Tur??stica</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Tur??stica</a></li>
           <li><a href="#" onclick="return seleccionarPaq();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
          <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
          <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
       </ul>
<% } %>
	
</div>
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>

                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Lista De Paquetes</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	DataPaquete[] paqs;
                                	paqs = (DataPaquete[]) request.getAttribute("ArregloPaquetes");
                                	for(int i = 0; i < paqs.length; i++){
                                	%>
                                	<div class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="/tarea2p2/Imagenes?id=<%= paqs[i].getImagen() %>" alt="<%= paqs[i].getImagen() %>">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h5> <%= paqs[i].getNombre() %> </h5>
                                            <h6> <%= paqs[i].getDescripcion() %> </h6>
                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%= paqs[i].getNombre() %>">
                                            	<span class="blog__btn" >LEER M??S </span>
                                            </a>
                                        </div>
                                    </div>
                                	<% } %>
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
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>
