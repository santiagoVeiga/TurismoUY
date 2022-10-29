<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="logica.DataPaquete,logica.estadoAct,java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,controllers.EstadoSesion,java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busqueda - turismo.uy</title>
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
   <jsp:include page="/WEB-INF/template/header.jsp"/>
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
                    	<jsp:include page="/WEB-INF/template/miPerfil.jsp"/>
                        
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>
                        
                    </div>
                </div>
                <div class="col-lg-9">
                	<div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Resultados</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	Set<DataPaquete> paqs;
                                	paqs = (Set<DataPaquete>) request.getAttribute("paquetes");
                                	for(DataPaquete iter : paqs){
                                		String imagen = Base64.getEncoder().encodeToString(iter.getImagen());
                                	%>
                                	<div class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="data:image/jpg;base64,<%= imagen %>" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h5> <%= iter.getNombre() %> </h5>
                                            <h6> <%= iter.getDescripcion() %> </h6>
                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%= iter.getNombre() %>">
                                            	<span class="blog__btn" >LEER MÁS </span>
                                            </a>
                                        </div>
                                    </div>
                                	<% } %>
                                </div>
                            </div>
                        </div>
                    
                        <div class="latest-product__text">
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	Set<DataActividad> acts;
                                	acts = (Set<DataActividad>) request.getAttribute("actividades");
                                	for(DataActividad iter : acts){
                                		String imagen = Base64.getEncoder().encodeToString(iter.getImagen());
                                	%>
                                	<div class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="data:image/jpg;base64,<%= imagen %>" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h5> <%= iter.getNombre() %> </h5>
                                            <h6> <%= iter.getDescripcion() %> </h6>
                                            <a href="/tarea2p2/ConsultaActividad?actividad=<%= iter.getNombre() %>">
                                            	<span class="blog__btn" >LEER MÁS </span>
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