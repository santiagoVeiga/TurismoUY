<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="java.util.List,logica.DataBuscar,logica.DataPaquete,logica.estadoAct,java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,controllers.EstadoSesion,java.text.SimpleDateFormat" %>

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
<body onload="ocuDesocu(); ocuDesocuD(); ocuDesocuC()">
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
                List<DataBuscar> res;
                res = (List<DataBuscar>) request.getAttribute("resultado");
                int cantRes = res.size();%>
                <div class="col-lg-9">
                	<div class="sidebar__item">
                		<div>
                			<h3>Búsqueda: <%= (String)session.getAttribute("abuscar") %></h3>
                			<br>
                		</div>
                		<div style="display: flex;justify-content: space-between;">
                			<div>
                				<p><%= cantRes %> Resultados</p>
                			</div>
                			<div style="display: inline-flex;">
							<div class="dropdown">
							  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" onclick="ocuDesocuC()" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Categoria
							  </button>
							  <div class="dropdown-menu" id="menuOrdenC">
							    <%Set<String> cats = (Set<String>) session.getAttribute("categorias");
						         if(cats!=null)
						         for (String it : cats){
						         %>
						             <a class="dropdown-item" href="?catg=<%= it  %>"><%= it %></a>
						         <%} %>
							  </div>
							</div>
							 &nbsp;
							<div class="dropdown">
							  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" onclick="ocuDesocuD()" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Departamento
							  </button>
							  <div class="dropdown-menu" id="menuOrdenD">
							    <%DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
						         if(dptos!=null)
						         for (DataDepartamento it : dptos){
						         %>
						             <a class="dropdown-item" href="?dpto=<%= it.getNombre() %>"><%= it.getNombre() %></a>
						         <%} %>
							  </div>
							</div>
							 &nbsp;
                			<div class="dropdown">
							  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" onclick="ocuDesocu()" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Ordenar por
							  </button>
							  <div class="dropdown-menu" id="menuOrden">
							    <button class="dropdown-item" type="button" onclick="ordenAlfa()">Alfabéticamente (A-Z a-z)</button>
							    <button class="dropdown-item"  type="button" onclick="ordenAnio()">Año (descendente)</button>
							  </div>
							</div>
							</div>
                		</div>
                        <div class="latest-product__text">
                            
                                <div class="latest-prdouct__slider__item" >
                                  
                                	<% 
                                	
                                	for(DataBuscar iter : res){
                                		if (iter instanceof DataPaquete){
                                			DataPaquete paq = (DataPaquete) iter;
                                			String imagen = Base64.getEncoder().encodeToString(paq.getImagen());
	                                	%>
	                                	<div class="latest-product__item" data-nombre="<%=paq.getNombre() %>" data-anio="<%= paq.getFechaAlta().getYear() %>">
	                                        <div class="latest-product__item__pic">
	                                            <img src="data:image/jpg;base64,<%= imagen %>" alt="">
	                                        </div>
	                                        <div class="latest-product__item__text">
	                                            <h5> <%= paq.getNombre() %> </h5>
	                                            <h6> <%= paq.getDescripcion() %> </h6>
	                                            <% %>
	                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%= paq.getNombre() %>">
	                                            	<span class="blog__btn" >LEER MÁS </span>
	                                            </a>
	                                        </div>
	                                    </div>
	                                	<% } else{
	                                		DataActividad act = (DataActividad) iter;
                                			String imagen = Base64.getEncoder().encodeToString(act.getImagen());
	                                	%>
	                                		<div class="latest-product__item" data-nombre="<%=act.getNombre() %>" data-anio="<%= act.getFechaAlta().getYear() %>">
		                                        <div class="latest-product__item__pic">
		                                            <img src="data:image/jpg;base64,<%= imagen %>" alt="">
		                                        </div>
		                                        <div class="latest-product__item__text">
		                                            <h5> <%= act.getNombre() %> </h5>
		                                            <h6> <%= act.getDescripcion() %> </h6>
		                                            <% %>
		                                            <a href="/tarea2p2/ConsultaActividad?actividad=<%= act.getNombre() %>">
		                                            	<span class="blog__btn" >LEER MÁS </span>
		                                            </a>
		                                        </div>
		                                    </div>
                                	<%}} %>
                                
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
    <script>
    function ocuDesocuC(){
    	var x = document.getElementById("menuOrdenC");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }</script>
    <script>
    function ocuDesocuD(){
    	var x = document.getElementById("menuOrdenD");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }</script>
   <script>
   function ordenAlfa(){
	   var $wrap = $('.latest-prdouct__slider__item');
	   var res = $wrap.find('.latest-product__item').sort(function (a,b)
			   {
				   if (a.dataset.nombre < b.dataset.nombre) { 
					   return -1;
					 } else if (a.dataset.nombre > b.dataset.nombre) {
					   return 1;
					 } else {
					   return 0;
					 }
			   });
	   $wrap.html("");
	   $wrap.html(res);
   }
   </script>
   <script>
   function ordenAnio(){
	   var $wrap = $('.latest-prdouct__slider__item');
	   var res = $wrap.find('.latest-product__item').sort(function (a,b)
			   {
				   if (a.dataset.anio < b.dataset.anio) { 
					   return -1;
					 } else if (a.dataset.anio > b.dataset.anio) {
					   return 1;
					 } else {
					   return 0;
					 }
			   });
	   $wrap.html("");
	   $wrap.html(res);
   }
   </script>
</body>
</html>