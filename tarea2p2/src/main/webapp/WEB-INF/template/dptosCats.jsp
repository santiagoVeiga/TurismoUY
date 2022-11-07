<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataActividad,java.util.Set,servidor.DataDepartamento,controllers.EstadoSesion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

	<%DataUsuario usr = null;
    if (session.getAttribute("estado_sesion") != EstadoSesion.NO_LOGIN) {
    	usr = (DataUsuario) session.getAttribute("usuario");
    }
    boolean movil = (boolean) session.getAttribute("esMovil");
    if (!movil){
    %>
      <div class="hero__deps">
         <div class="hero__deps__all">
             <i class="fa fa-bars"  ></i>
             <span>Departamentos</span>
         </div>
         <ul>
         <%DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
         if(dptos!=null)
         for (DataDepartamento it : dptos){
         %>
             <li><a href="?DTDConsultaActividad=<%= it.getNombre() %>"><%= it.getNombre() %></a></li>
         <%} %>
         </ul>
     </div>
     <div class="hero__categories">
         <div class="hero__categories__all">
             <i class="fa fa-bars"></i>
             <span>Categorias</span>
         </div>
         <ul>
        	<%Set<String> cats = (Set<String>) session.getAttribute("categorias");
         if(cats!=null)
         for (String it : cats){
         %>
             <li><a href="?CatConsultaActividad=<%= it  %>"><%= it %></a></li>
         <%} %>
         </ul>
     </div>
	<%} else { %>
	<!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="img/logo.png" alt=""></a>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li><a href="./index.html">Home</a></li>
                <li><a href="#">Consulta Actividad</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="#">Departamentos</a>
                        	<ul class="header__menu__dropdown">
                        		<%
                        		DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
						        if (dptos!=null)
						        	for (DataDepartamento it : dptos){
						        	%>
						        		<li><a href="?DTDConsultaActividad=<%= it.getNombre() %>"><%= it.getNombre() %></a></li>
						        	<%} %>
                   			 </ul>
                        </li>
                        <li><a href="#">Categorias</a>
                        	<ul class="header__menu__dropdown">
						        <%Set<String> cats = (Set<String>) session.getAttribute("categorias");
						        if(cats!=null)
						        	for (String it : cats){
						        	%>
						            	<li><a href="?CatConsultaActividad=<%= it  %>"><%= it %></a></li>
						        	<%} %>
                   			</ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">Consulta Salida</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="#">Departamentos</a>
                        	<ul class="header__menu__dropdown">
                        		<%
                        		DataDepartamento[] dptos2 = (DataDepartamento[]) session.getAttribute("dptos");
						        if (dptos!=null)
						        	for (DataDepartamento it : dptos2){
						        	%>
						        		<li><a href="?DTDConsultaActividad=<%= it.getNombre() %>"><%= it.getNombre() %></a></li>
						        	<%} %>
                   			 </ul>
                        </li>
                        <li><a href="#">Categorias</a>
                        	<ul class="header__menu__dropdown">
						        <%Set<String> cats2 = (Set<String>) session.getAttribute("categorias");
						        if(cats!=null)
						        	for (String it : cats2){
						        	%>
						            	<li><a href="?CatConsultaActividad=<%= it  %>"><%= it %></a></li>
						        	<%} %>
                   			</ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
    </div>
    <!-- Humberger End -->
	<%} %>
     
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