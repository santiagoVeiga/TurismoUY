<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64, java.util.Date, servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataSalida,java.util.Set,java.util.HashSet, java.util.Collections,servidor.DataPaquete,servidor.DataActividad" %>

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
    <link rel="stylesheet" href="css/style_consulta_paquete.css" type="text/css">
    <link rel="stylesheet" href="css/style_pestanias.css" type="text/css">
 
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

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
                
                <!-- Paquete -->
                <%! DataPaquete dataPaquete; %>
                <% 
                dataPaquete = (DataPaquete) request.getAttribute("PaqueteElegido"); 
                DataActividad[] acts =dataPaquete.getDtAct();	
                
                %>
                <div class="col-lg-9 col-md-7">
                <% String een = (String) request.getAttribute("Exception");
               if(een != null){%>
               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
				  <%= een %>
				  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
				</div>
			<%} %>
	                <div class="tabs">
					  <div class="tab-container">
					    <div id="tab2" class="tab">
					      <a href="#tab2">Actividades</a>
					      <div class="tab-content">
					      	<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					      		<% if(acts != null){%>
	                            <div class="carousel-inner">
	                            	<%
	                            	for(int i=0; i < acts.length; i++){
	                            		if(i==0){
	                            	%>
	                            	<div class="carousel-item active">
	                            	<%
	                            		} else {
	                            	%>
	                               <div class="carousel-item">
	                               <%} 
	                               %>
	                                <div class="card" >
	                                    <a href="/tarea2p2/ConsultaActividad?actividad=<%= acts[i].getNombre() %>"> 
											<img src="/tarea2p2/Imagenes?id=<%= acts[i].getImagen() %>" alt="<%= acts[i].getImagen() %>">
	                                    </a>
	                                    <div class="card-body">
	                                      <p class="card-text" ><%= acts[i].getNombre() %></p>
	                                    </div>
	                                  </div>
	                                </div>
	                                <%} %>
	                            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
	                              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                              <span class="sr-only">Previous</span>
	                            </a>
	                            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
	                              <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                              <span class="sr-only">Next</span>
	                            </a>
	                            
	                          </div>
	                        </div>
					      <% }%>
					      </div>
					    </div> 
					    <div id="tab1" class="tab">
					      <a href="#tab1">Informacion Basica</a>
					      <div class="tab-content">
					        <div class="row">
		                    	<div class="info_paquete">
		                    		<span> Informacion del Paquete Seleccionado: </span><br />
		                    		<div class="row justify-content-center">
				                    	<div class="col-lg-12">
				                    		<div class="cabezales_paquete">
									        <table class="table">
												<thead>
				                    			</thead>
							  					<tbody>
												    <tr>
												      <th scope="row">Nombre:</th>
												      <td><%= dataPaquete.getNombre() %></td>
												    </tr>
												    <tr>
												      <th scope="row">Validez:</th>
												      <td><%= dataPaquete.getValidez() + " días"%></td>
												    </tr>
												    <tr>
												      <th scope="row">Descuento:</th>
												      <td><%= dataPaquete.getDescuento() + "%"%></td>
												    </tr>
												    <tr>
												      <th scope="row">Fecha de Alta:</th>
												      <%Date fechaAlta = dataPaquete.getFechaAlta().getTime(); %>
												      <td><%= fechaAlta.getDate() + "/" + (fechaAlta.getMonth()+1) + "/" + (fechaAlta.getYear()+1900) %></td>
												    </tr>
												    <tr>
												      <th scope="row">Descripción:</th>
												      <td><%= dataPaquete.getDescripcion() %></td>
												    </tr>
												    <tr>
												    
												      <th scope="row">Categorias:</th>
												      <% if(acts != null){%>
												      <% 
												      Set<String> categorias = new HashSet<String>();
												      Collections.addAll(categorias,dataPaquete.getCategorias());
												      %>
												      <td><%=  categorias %></td>
												      <% }%>
												    </tr>
												</tbody>
											</table>
				                    		</div>
				                    	</div>
				                    </div>
				                    <div class="row justify-content-center">
				                    		<div class="imagen_paquete">
        			                           <img src="/tarea2p2/Imagenes?id=<%= dataPaquete.getImagen() %>" alt="<%= dataPaquete.getImagen() %>">
				                    		</div>
				                    </div>
				                    <%! DataUsuario dataUsu; %>
				                    <% 
				                    dataUsu = (DataUsuario) session.getAttribute("usuario");
				                    if( (dataUsu!= null) && (dataUsu instanceof DataTurista) ){
				                    %>
				                    <div class="row">
				                    	<div class="compra_paquete">
		                    				<span> Realizar Compra Paquete: </span><br />
		                    				<form action="CompraPaquete" method="POST">
				                    			<div class="ingreso_datos">
				                    				<input type="hidden" id="nomPaq" name="nomPaq" value="<%=dataPaquete.getNombre()%>">
					                    			<label for="cant">Cantidad de Turistas</label>
												    <input type="number" id="cantTurs" name="cantTurs" min="1" value="1" placeholder="Ingrese un numero" required>
												</div>
												<div class="row justify-content-end" >
												   <input type="submit" value="Realizar Compra" onclick="submit()">
												</div>
				                    		</form>
				                    	</div>
		                    		</div>
				                    <%} %>
		                    	</div>
		                    </div>
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
