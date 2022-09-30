<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,Controllers.EstadoSesion" %>

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
      %>
      <div class="hero__deps">
         <div class="hero__deps__all">
             <i class="fa fa-bars"  ></i>
             <span>Departamentos</span>
         </div>
         <ul>
         <%DataDepartamento[] dptos = (DataDepartamento[]) request.getAttribute("dptos");
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
        	<%Set<String> cats = (Set<String>) request.getAttribute("categorias");
         if(cats!=null)
         for (String it : cats){
         %>
             <li><a href="?CatConsultaActividad=<%= it  %>"><%= it %></a></li>
         <%} %>
         </ul>
     </div>
     
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