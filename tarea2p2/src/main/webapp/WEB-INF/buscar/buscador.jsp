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
<body onload="ocuDesocu()">
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
                
                <%
                Set<DataPaquete> paqs;
                paqs = (Set<DataPaquete>) request.getAttribute("paquetes");
                Set<DataActividad> acts;
                acts = (Set<DataActividad>) request.getAttribute("actividades");
                int cantRes = paqs.size()+acts.size();%>
                <div class="col-lg-9">
                	<div class="sidebar__item">
                		<div style="display: flex;justify-content: space-between;">
                			<div>
                				<p><%= cantRes %> Resultados</p>
                			</div>
                			<div class="dropdown">
							  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" onclick="ocuDesocu()" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Ordenar por
							  </button>
							  <div class="dropdown-menu" id="menuOrden">
							    <a class="dropdown-item" href="#">Alfabéticamente (A-Z a-z)</a>
							    <a class="dropdown-item" href="#">Año (descendente)</a>
							  </div>
							</div>
                		</div>
                        <div class="latest-product__text">
                            
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	
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
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    <script>
    function ocuDesocu(){
    	var x = document.getElementById("menuOrden");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }</script>
</body>
</html>