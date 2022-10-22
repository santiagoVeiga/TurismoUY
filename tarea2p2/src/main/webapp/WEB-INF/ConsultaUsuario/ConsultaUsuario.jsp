<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,logica.DataPaquete,logica.DataActividad" %>

<!DOCTYPE html>
<html lang="zxx">
	<!-- Google Font -->
<!-- Google Font -->
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
    <link rel="stylesheet" href="css/style_consulta_paqute.css" type="text/css">
    <link rel="stylesheet" href="css/style_pestanias.css" type="text/css">
    
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
	<jsp:include page="/WEB-INF/template/header.jsp"/>
	<%
  	DataUsuario DU;
  	String tipo;
  	DU = (DataUsuario) request.getAttribute("UsuarioElegido"); 
  	if(DU instanceof DataTurista)
		  tipo="Turista";
	  else
		  tipo="Proveedor";
	
	
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
                      <div class="row">
                      
                      
                      	<%String imagen = Base64.getEncoder().encodeToString(DU.getImagen()); %>
                      	<div class="blog__details__author">
                          <div class="blog__details__author__pic">
                              <img src="data:image/jpg;base64,<%= imagen %>" alt="">                                   
                          	</div>
                          	<div class="blog__details__author__text">
                              	<h6><%=DU.getNombre()%></h6>
                              	<span><%=tipo%></span>
                          	</div>
                      	</div>
                      </div>
                      <div class="row2">
                      	<div class="container">
            	<div class="row">
            		<div class="col-lg-9">
            			<div class="tabs" margin-left="100px">
				
					
				  <div class="tab-container">
				  <div id="tab1" class="tab">
				      <a href="#tab1">Informacion Basica</a>
				      <div class="tab-content">
					        <li><span>Nombre:</span> <%=DU.getNombre() %></li>
		                    <li><span>Apellido:</span>  <%=DU.getApellido() %></li>
		                    <li><span>EMail:</span>  <%=DU.getMail() %></li>
		                    <li><span>FechaNac:</span>  <%=DU.getNacimiento().getDate() + "/" + (DU.getNacimiento().getMonth()+1)+ "/" + (DU.getNacimiento().getYear()+1900) %></li>
				      </div> 
				    </div> 
				  
				  	<% 
				      if(DU instanceof DataTurista){
				    	    Set<DataSalida> salidas;  
				    	    DataPaquete[] DP = (DataPaquete[]) request.getAttribute("ArregloPaquetes");
				    	    String imagenp = Base64.getEncoder().encodeToString(DP[0].getImagen());
				      %>
					  	<div id="tab3" class="tab">
					      <a href="#tab3">Paquetes</a>
					      <div class="tab-content">
					      	<div class="product__discount">
	                                        <br>
	                                        <br>
	                                        <br>
	                                        <div class="section-title product__discount__title">
	                                            <h2>Paquetes</h2>
	                                        </div>
	                                        <div class="row">
	                                            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					                            <div class="carousel-inner">
					                              <div class="carousel-item active">
					                                <div class="card" >
					                                    <a href=""> 
					                                    	<img class="card-img-top" src="data:image/jpg;base64,<%= imagenp %>"  alt="Card image cap"> 
					                                    </a>
					                                    <div class="card-body">
					                                      <p class="card-text" ><%= DP[0].getNombre() %></p>
					                                    </div>
					                                  </div>
					                                </div>
					                              <%
							                          	for(int i = 1; i < DP.length; i++){
							                          		String imagenp1 = Base64.getEncoder().encodeToString(DP[i].getImagen());
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a href="consulta_actividad_Turista.html"> 
							                                    	<img class="card-img-top" src="data:image/jpg;base64,<%= imagenp1 %>"  alt="Card image cap"> 
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= DP[i].getNombre() %></p>                                  
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
					    </div>
					    </div>
					    <div id="tab2" class="tab">
					      
						<%
						salidas = ((DataTurista) DU).getDataSalidas();
						Object[] u = salidas.toArray();
				        DataSalida[] arrDS = new DataSalida[u.length];
				        for (int i = 0; i < u.length; i++) {
				        	arrDS[i] = (DataSalida) u[i];
				        }
				        String imagen1 = Base64.getEncoder().encodeToString(arrDS[0].getImagen());
						%>
					      
					      <a href="#tab2">Salidas</a>
					      <div class="tab-content">
					      	<div class="product__discount">
	                                        <br>
	                                        <br>
	                                        <br>
	                                        <div class="section-title product__discount__title">
	                                            <h2>Salidas</h2>
	                                        </div>
	                                        <div class="row">
	                                            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					                            <div class="carousel-inner">
					                              <div class="carousel-item active">
					                                <div class="card" >
					                                    <a href="consulta_actividad_Turista.html"> 
					                                    	<img class="card-img-top" src="data:image/jpg;base64,<%= imagen1 %> " alt="Card image cap"> 
					                                    </a>
					                                    <div class="card-body">
					                                      <p class="card-text" ><%= arrDS[0].getNombre() %></p>
					                                    </div>
					                                  </div>
					                                </div>
					                              <%
							                          	for(int i = 1; i < arrDS.length; i++){
							                          		String imagen2 = Base64.getEncoder().encodeToString(arrDS[i].getImagen());
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a href="consulta_actividad_Turista.html"> 
							                                    	<img class="card-img-top" src="data:image/jpg;base64,<%= imagen2 %>"  alt="Card image cap"> 
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= arrDS[i].getNombre() %></p>                                    </div>
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
				      <%}
				      else
				      {
				    	  Object[] p= ((DataProveedor) DU).getActividades().toArray();
					        DataActividad[] arrDS = new DataActividad[p.length];
					        for (int i = 0; i < p.length; i++) {
					        	arrDS[i] = (DataActividad) p[i];
					        }
                      	%>
	                      	<div id="tab2" class="tab">
					      	<a href="#tab2">Actividades</a>
					      	<div class="tab-content">
					      	<div class="product__discount">
	                                        <br>
	                                        <br>
	                                        <br>
	                                        <div class="section-title product__discount__title">
	                                            <h2>Actividades</h2>
	                                        </div>
	                                        <div class="row">
	                                            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					                            <div class="carousel-inner">
					                              <div class="carousel-item active">
					                                <div class="card" >
					                                    <a href="consulta_actividad_Turista.html"> 
					                                    	<img class="card-img-top" src=<%= arrDS[0].getImagen() %>  alt="Card image cap"> 
					                                    </a>
					                                    <div class="card-body">
					                                      <p class="card-text" ><%= arrDS[0].getNombre() %></p>
					                                    </div>
					                                  </div>
					                                </div>
					                              <%
							                          	for(int i = 1; i < arrDS.length; i++){
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a href="consulta_actividad_Turista.html"> 
							                                    	<img class="card-img-top" src=<%= arrDS[i].getImagen() %>  alt="Card image cap"> 
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= arrDS[i].getNombre() %></p>                                    </div>
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
					    </div> 
                      <%}
				      %>
				    </div> 
				    
				  </div>
				</div>
            		</div>
            	</div>
            </div>
                      </div>
                      
                  </div>
    <!-- l -->  
                <!-- Paquete -->
                
                
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



