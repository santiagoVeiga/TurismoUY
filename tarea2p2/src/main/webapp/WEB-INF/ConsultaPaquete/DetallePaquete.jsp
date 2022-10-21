<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64, logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,logica.DataPaquete,logica.DataActividad" %>

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
                String imagenPaq = Base64.getEncoder().encodeToString(dataPaquete.getImagen());
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
	                            <div class="carousel-inner">
	                            	<%
	                            	for(int i = 0; i < acts.length; i++){
	                            		String imagen = Base64.getEncoder().encodeToString(acts[i].getImagen());
	                            		if(i == 0){
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
	                                    	<img src="data:image/jpg;base64,<%= imagen %>" alt=""> 
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
					      </div>
					    </div> 
					    <div id="tab1" class="tab">
					      <a href="#tab1">Informacion Basica</a>
					      <div class="tab-content">
					        <div class="row">
		                    	<div class="info_paquete">
		                    		<span> Informacion del Paquete Seleccionado: </span><br />
		                    		<div class="row justify-content-center">
				                    	<div class="col-lg-5">
				                    		<div class="cabezales_paquete">
				                    			<span> Nombre: </span><br />
				                    			<span> Validez: </span><br />
				                    			<span> Descuento: </span><br />
				                    			<span> Fecha de Alta: </span><br />
				                    			<span> Descripcion: </span><br />
				                    			<span> </span><br />
				                    		</div>
				                    	</div>
				                    	<div class="col-lg-6">
				                    		<div class="datos_paquete">
				                    			<span> <%= dataPaquete.getNombre() %> </span><br />
				                    			<span> <%= dataPaquete.getValidez() + " dias" %> </span><br />
				                    			<span> <%= dataPaquete.getDescuento() + "%" %> </span><br />
				                    			<span> <%= dataPaquete.getFechaAlta().getDate() + "/" + (dataPaquete.getFechaAlta().getMonth()+1) + "/" + (dataPaquete.getFechaAlta().getYear()+1900) %> </span><br />
				                    			<span> <%= dataPaquete.getDescripcion() %> </span><br />
				                    		</div>
				                    	</div>
				                    </div>
				                    <div class="row justify-content-center">
				                    		<div class="imagen_paquete">
				                    			<img src="data:image/jpg;base64,<%= imagenPaq %>" alt="">
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
