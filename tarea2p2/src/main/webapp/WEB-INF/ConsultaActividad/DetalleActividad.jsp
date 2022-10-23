<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Base64,logica.DataUsuario,logica.DataDepartamento,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,controllers.EstadoSesion,logica.DataPaquete,logica.DataActividad, manejadores.ManejadorPaquete" %>

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
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
 
    <!-- Header -->
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
                
                
                <!-- Actividades -->
                <div class="col-lg-9" border-radius: 25px; padding: 20px; padding-top:30px">
                    <!-- Seccion de Consulta de actividades -->
                    <div class="card border-dark mb-3" style="background-color: rgba(80, 80, 80, 0.229);">
                    
                    	<% DataActividad actividadSeleccionada = (DataActividad) request.getAttribute("ActividadElegida");
                    		String imagen = Base64.getEncoder().encodeToString(actividadSeleccionada.getImagen());%>
                        <div class="card-header"><p><%=actividadSeleccionada.getNombre()%></p></div>
                        <div class="card-body text-dark">
                            <div style="display: flex; justify-content: space-around; padding-bottom: 20px;">
                                <p style="color: black; "><%=actividadSeleccionada.getDescripcion()%></p>
                                <img src="data:image/jpg;base64,<%= imagen %>" style="height: 100px; border-radius: 5px; " alt="">
                            </div>
                            <table class="table">
							  <thead>
						
							  </thead>
							  <tbody>
							    <tr>
							      <th scope="row">Ciudad</th>
							      <td><%=actividadSeleccionada.getCiudad()%></td>
							    </tr>
							    <tr>
							      <th scope="row">Duracion</th>
							      <td><%= actividadSeleccionada.getDuracion()%></td>
							    </tr>
							    <tr>
							      <th scope="row">Fecha de Alta</th>
							      <td><%= actividadSeleccionada.getFechaAlta()%></td>
							    </tr>
							    <tr>
							      <th scope="row">Costo</th>
							      <td><%= actividadSeleccionada.getCosto()%></td>
							    </tr>
							    <tr> 
							      <th scope="row">Categoria/as</th>
							      <td><%= actividadSeleccionada.getCategorias()%></td>
							    </tr>
							    <%if(usr instanceof DataProveedor){%>
                            	<tr>
							      <th scope="row">Alta Salida</th>
							      <td><a href="/tarea2p2/AltaSalida?actividadSal=<%=actividadSeleccionada.getNombre()%>&actDepto=<%=actividadSeleccionada.getDepartamento()%>&actCiudad=<%=actividadSeleccionada.getCiudad()%>">Agregar una Salida</a></td>
							    </tr>
                            <%}%>
							  </tbody>
							</table>
                            
                            
                            <% Set<DataSalida> Salidas = actividadSeleccionada.getSalidas(); %>
                            <% Set<String> Paquetes = actividadSeleccionada.getPaquetes(); %>
                            
                            <div style="display: flex; justify-content:center; align-items: center;">
                                <a style="margin-right:22%; margin-top: 15px; ">Salidas</a>
                       			<a style="margin-left:25%; margin-top: 15px; ">Paquetes</a>
                            </div>
                            <div
                                style="padding-top:20px ; margin-right: 50px; margin-left: 50px; display: flex; justify-content: space-between;">
                                
                                
                                <% if (actividadSeleccionada.haySalidas()){%>
                                 
                                <% DataSalida[] arrSalidas = Salidas.toArray(new DataSalida[Salidas.size()]);%>
                                
                                <%
                                String img = "";
                                if(arrSalidas[0].getImagen() != null){
                                	img = Base64.getEncoder().encodeToString(arrSalidas[0].getImagen()); 
                                }
                                %>
                                
                                
                                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel"
                                    style="margin-right: 70px;">
                                    <div class="carousel-inner">
                                        
                                        <div class="carousel-item active">
                                            <a href="/tarea2p2/ConsultaSalida?salida=<%=arrSalidas[0].getNombre()%>">  
                                                <div class="card" style="width: 18rem;">
                                                    <img class="card-img-top"
                                                        src="data:image/jpg;base64,<%= img %>"
                                                        alt="Card image cap">
                                                    <div class="card-body">
                                                        <p class="card-text" style="text-align: center;"><%=arrSalidas[0].getNombre()%></p>
                                                    </div>
                                                </div>
                                            </a>     
                                        </div>
                                        
                                        
                                        <% for(int i=1; i<arrSalidas.length; i++) { 
                                        	String img2 = "";
                                            if(arrSalidas[i].getImagen() != null){
                                            	img2 = Base64.getEncoder().encodeToString(arrSalidas[i].getImagen()); 
                                            }
                                          	 %>
                                        <div class="carousel-item">
                                            <a href="/tarea2p2/ConsultaSalida?salida=<%=arrSalidas[i].getNombre()%>">  
                                                <div class="card" style="width: 18rem;">
                                                    <img class="card-img-top"
                                                        src="data:image/jpg;base64,<%= img2 %>"
                                                        alt="Card image cap">
                                                    <div class="card-body">
                                                        <p class="card-text" style="text-align: center;"><%=arrSalidas[i].getNombre()%></p>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    	<%}%>
                                       </div>
                                    
                                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                                        data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                                        data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                                    
                                    <%}else {%>
                                  
                                
                                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel"
                                    style="margin-left: 70px;">
                                    <div class="carousel-inner">
                                        
                                        <div class="carousel-item active">
                                                <div class="card" style="width: 18rem;">
                                                    <img class="card-img-top"
                                                        src="https://www.esteba.com/214374-large_default/melamina-mdf-perfectsense-blanco-alpino-laca.jpg"
                                                        alt="Card image cap">
                                                    <div class="card-body">
                                                        <p class="card-text" style="text-align: center;">no hay salidas</p>
                                                    </div>
                                                </div>
                                        </div>
                                       
                                    </div>
                                      <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                                        data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                                        data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                                
                                <%} %>
                                    
                                 
                                
                                
                                <% if (actividadSeleccionada.hayPaquetes()){%>
                                
                                
                                
                                <% DataPaquete[] arrayPaquetes = (DataPaquete[]) request.getAttribute("ArrayPaquetes");%>
                                
                                
                                <div id="carouselExampleControls2" class="carousel slide" data-ride="carousel"
                                    style="margin-left: 70px;">
                                    <div class="carousel-inner">
                                        
                                        <div class="carousel-item active">
                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%=arrayPaquetes[0].getNombre()%>"> 
                                                <div class="card" style="width: 18rem;">
                                                    
                                                    <%if(arrayPaquetes[0].getImagen()!=null){ 
                                					String img = "";
                                					img = Base64.getEncoder().encodeToString(arrayPaquetes[0].getImagen()); %>
                                                    	<img class="card-img-top"
                                                        src="data:image/jpg;base64,<%= img %>"
                                                        alt="Card image cap">
                                                     <%}else{ %>
                                                     	<img class="card-img-top"
                                                        src="https://www.esteba.com/214374-large_default/melamina-mdf-perfectsense-blanco-alpino-laca.jpg"
                                                        alt="Card image cap">
                                                     <%} %>
                                                    <div class="card-body">
                                                        <p class="card-text" style="text-align: center;"><%=arrayPaquetes[0].getNombre()%></p>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                        
                                        <% for(int i=1; i<arrayPaquetes.length; i++) { %>
	                                        <div class="carousel-item">
	                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%=arrayPaquetes[i].getNombre()%>">  
	                                                <div class="card" style="width: 18rem;">
	                                                    <%if(arrayPaquetes[i].getImagen()!=null){
	                                                   		String img = "";
                                							img = Base64.getEncoder().encodeToString(arrayPaquetes[i].getImagen());%>
	                                                    	<img class="card-img-top"
	                                                        src="data:image/jpg;base64,<%= img %>"
	                                                        alt="Card image cap">
	                                                     <%}else{ %>
	                                                     	<img class="card-img-top"
	                                                        src="https://www.esteba.com/214374-large_default/melamina-mdf-perfectsense-blanco-alpino-laca.jpg"
	                                                        alt="Card image cap">
	                                                     <%} %>
	                                                    <div class="card-body">
	                                                        <p class="card-text" style="text-align: center;"><%=arrayPaquetes[i].getNombre()%></p>
	                                                    </div>
	                                                </div>
	                                            </a>
	                                        </div>
                                        <%}%>
                                        
                                        
                                        
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleControls2" role="button"
                                        data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls2" role="button"
                                        data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                                
                                <%}else{ %>
                                
                                <div id="carouselExampleControls2" class="carousel slide" data-ride="carousel"
                                    style="margin-left: 70px;">
                                    <div class="carousel-inner">
                                        
                                        <div class="carousel-item active">
                                         
                                                <div class="card" style="width: 18rem;">
                                                    <img class="card-img-top"
                                                        src="https://www.esteba.com/214374-large_default/melamina-mdf-perfectsense-blanco-alpino-laca.jpg"
                                                        alt="Card image cap">
                                                    <div class="card-body">
                                                        <p class="card-text" style="text-align: center;">no hay paquetes</p>
                                                    </div>
                                                </div>
                                           
                                        </div>
                                       
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleControls2" role="button"
                                        data-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls2" role="button"
                                        data-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                                
                                <%} %>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Js Plugins -->
    <script src="js/altaActividad.js"></script>
    <script src="js/main.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</body>

</html>