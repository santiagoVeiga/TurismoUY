<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataActividad,java.util.Set,servidor.DataDepartamento,controllers.EstadoSesion" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>perfil</title>
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

<%
	boolean movil = (boolean) session.getAttribute("esMovil");
	if (!movil){
		DataUsuario usr = null;
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
           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Comprar Paquete</a></li>
           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
           <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
       </ul>
<% } else if (usr instanceof DataProveedor){%>
	<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuario?nick=<%= usr.getNick()%>';">
		<span>Mi Perfil</span>
		<div class="ax float-right">
			<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
		</div>
	</div>
	<ul>
           <li><a href="/tarea2p2/AltaActividad"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Turistica</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Turistica</a></li>
           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
          <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
          <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
       </ul>
<% 	}
}%>
	
</div>
<!-- Js Plugins 
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    $(document).ready(function(){
    

     $('.hero__categories__all').on('click', function(){
         $('.hero__categories ul').slideToggle();
     });

     
     $('.hero__deps__all').on('click', function(){
         $('.hero__deps ul').slideToggle();
     });
     });-->
</body>
</html>