<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataActividad,logica.DataSalida,java.util.Set,logica.DataDepartamento" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="turismo.uy">
    <meta name="keywords" content="turismo, uruguay">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado Actividades</title>

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
                    	<jsp:include page="/WEB-INF/template/miPerfil.jsp"/>
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>

                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Lista De Actividades</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	DataActividad[] acts;
                                	String imagen = null;
                                	acts = (DataActividad[]) request.getAttribute("ArregloActividades");
                                	for(int i = 0; i < acts.length; i++){
                                		if(acts[i].getImagen()!=null) {
                                			imagen = Base64.getEncoder().encodeToString(acts[i].getImagen());
                                		}
                                	%>
                                		<!-- <a href="/tarea2p2/ConsultaActividad?actividad=<%= acts[i].getNombre() %>" class="latest-product__item">  -->
                                	<div class="latest-product__item">
                                		<%
                                		if(acts[i].getImagen()!=null) {
                                		%>
                                		<div class="latest-product__item__pic">
                                        <img src="data:image/jpg;base64,<%= imagen %>" alt="">
                                   		</div>
                                		<% } %>
                                        <div class="latest-product__item__text">
                                            <h5> <%= acts[i].getNombre() %> </h5>
                                            <h6> <%= acts[i].getDescripcion() %> </h6>
                                            <a href="/tarea2p2/ConsultaActividad?actividad=<%= acts[i].getNombre() %>">
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
