<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="controllers.EstadoSesion,servidor.EstadoAct,java.util.Date, java.util.Base64,servidor.DataUsuario,servidor.DataDepartamento, servidor.DataProveedor,servidor.DataTurista,servidor.DataTurista,servidor.DataSalida,java.util.Set,controllers.EstadoSesion,servidor.DataPaquete,servidor.DataActividad, manejadores.ManejadorPaquete
,java.util.Base64, java.util.Date, servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataSalida,java.util.Set,java.util.HashSet, java.util.Collections,servidor.DataPaquete,servidor.DataActividad" %>

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
   
   	
   	<%DataUsuario usr = null;
	   if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
	   	usr = (DataUsuario) session.getAttribute("usuario");
	   }
	     %>
   	
   	
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
	 <%boolean esMovil = (boolean) session.getAttribute("esMovil"); 
   	
   	if (!esMovil){%>                   	
	<div class="hero__perfil">
	<% if (usr == null) {%>
		<ul>
	           <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
	           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
	           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
	       </ul>
	<% } else if (usr instanceof DataTurista){ %>
		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuario?nick=<%=usr.getNick()%>';">
			<span>Mi Perfil</span>
			<div class="ax float-right">
				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
			</div>
		</div>
		<ul>
	           <li><a href="#" onclick="return seleccionarSal();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Inscripcion a Salida Turistica</a></li>
	           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Comprar Paquete</a></li>
	           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
	           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
	           <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
	       </ul>
	<% } else if (usr instanceof DataProveedor){%>
		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuario?nick=<%=usr.getNick()%>';">
			<span>Mi Perfil</span>
			<div class="ax float-right">
				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
			</div>
		</div>
		<ul>
	           <li><a href="/tarea2p2/AltaActividad"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Turstica</a></li>
	           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Turstica</a></li>
	           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
	          <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
	          <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
	       </ul>
	<% } %>
		
	</div>
	<%} %>
	                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>
	                        
	             <%if(!esMovil){%>   
	                    </div>
	                </div>
	                <%}%>
	                
	                
	                <!-- Actividades -->
	                <div class="col-lg-9" border-radius: 25px; padding: 20px; padding-top:30px">
	                    <!-- Seccion de Consulta de actividades -->
	                    <div class="card border-dark mb-3" style="background-color: rgba(80, 80, 80, 0.229);">
	                    
	                    	<% DataActividad actividadSeleccionada = (DataActividad) request.getAttribute("ActividadElegida");
	                    		%>
	                        <div class="card-header"><p><%=actividadSeleccionada.getNombre()%></p></div>
	                        <div class="card-body text-dark">
	                            
	                            <%if(!esMovil){ %>
	                            <div style="display: flex; justify-content: space-around; padding-bottom: 20px;">
	                                <p style="color: black; "><%=actividadSeleccionada.getDescripcion()%></p>
	                                
	                                <img src="/tarea2p2/Imagenes?id=<%= actividadSeleccionada.getImagen() %>" style="height: 100px; border-radius: 5px; " alt="<%= actividadSeleccionada.getImagen() %>">
	                                
	                            </div>
	                            <%}else{ %>
	                            <div style=" justify-content: space-around; padding-bottom: 20px;">
	                                <p style="color: black; "><%=actividadSeleccionada.getDescripcion()%></p>
	                                
	                                <img src="/tarea2p2/Imagenes?id=<%= actividadSeleccionada.getImagen() %>" style="height: 100px; border-radius: 5px; " alt="<%= actividadSeleccionada.getImagen() %>">
	                                
	                            </div>
	                            <%}
	                            if (actividadSeleccionada.isHayLink()){ %>
	                                <br>
	                                <div style="display:flex; justify-content:center; width:100%;">
		                                <iframe width="100%" height="300" src="<%= actividadSeleccionada.getLink() %>" title="<%= actividadSeleccionada.getNombre() %>" allowfullscreen>
										</iframe>
	                                </div>
	                                <br>
	                                <% } %>
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
								      <% Date fechaActividad = actividadSeleccionada.getFechaAlta().getTime(); %>
								      <td><%= fechaActividad.getDate() + "/" + (fechaActividad.getMonth()+1) + "/" + (fechaActividad.getYear()+1900) %></td>
								    </tr>
								    <%if (actividadSeleccionada.getEstado()==EstadoAct.finalizada){ %>
								    <tr>
								      <th scope="row">Fecha de Baja</th>
								      <% Date fechaActividadB = actividadSeleccionada.getFechaBaja().getTime(); %>
								      <td><%= fechaActividadB.getDate() + "/" + (fechaActividadB.getMonth()+1) + "/" + (fechaActividadB.getYear()+1900) %></td>
								    </tr>
								    <%}%>
								    <tr>
								      <th scope="row">Costo</th>
								      <td><%= actividadSeleccionada.getCosto()%></td>
								    </tr>
								    <tr> 
								      <th scope="row">Categoria/as</th>
					   
								      <%if (actividadSeleccionada.getCategorias()!=null){ 
								     String[] arrCategorias = actividadSeleccionada.getCategorias();
								      String categoriaString = arrCategorias[0];
								      for (int i=1; i<arrCategorias.length ; i++){
								    	  categoriaString = categoriaString + ", " + arrCategorias[i] ;
								      }%>
								      <td><%= categoriaString %></td>
								      <%}else{ %>
								      <td>sin informacion de categoria</td>
								      <%}%>
								    </tr>
								    <tr> 
								      <th scope="row">Estado</th>
								      <td><%= actividadSeleccionada.getEstado()%></td>
								    </tr>
								    <tr> 
								      <th scope="row">Cantidad de Favs</th>
								      <td><%= actividadSeleccionada.getCantFavs()%></td>
								    </tr>
								    <%if(usr instanceof DataProveedor && actividadSeleccionada.getEstado() == EstadoAct.confirmada){%>
	                            	<tr>
								      <th scope="row">Alta Salida</th>
								      <td><a href="/tarea2p2/AltaSalida?actividadSal=<%=actividadSeleccionada.getNombre()%>&actDepto=<%=actividadSeleccionada.getDepartamento()%>&actCiudad=<%=actividadSeleccionada.getCiudad()%>">Agregar una Salida</a></td>
								    </tr>
	                            	<%}%>
								  </tbody>
								</table>
	                            <%	
				                    if (usr != null && usr instanceof DataTurista && actividadSeleccionada.getEstado()!=EstadoAct.finalizada && !esMovil){
				                    	DataTurista tur = (DataTurista) usr;
										String[] favoritas = tur.getActFavoritas();
				                    	%>
				                    		<form action="AgregarFavs" method="POST">
				                    	<%
				                    	String auxFavs = null;
				                    	boolean flag = false ; 
				                    	int y = 0 ; 
			                    		String act = actividadSeleccionada.getNombre();
			                    		if(favoritas!=null){
					                    	for (int x=0;x<favoritas.length;x++){//checkeo si la actividad esta en las favoritas del turist 
					                    		if (favoritas[x].equals(act)){
					                    			flag = true ; 
					                    			y = x ; 
					                    		}
					                    	}
			                    		}
				                    	if (flag){
				                    		auxFavs = "Sacar de Favoritas";
				                    	} else {
				                    		auxFavs = "Anadir a Favoritas";
				                    	}
				                    	%>
		                   				<input type="hidden" id="nomAct" name="nomAct" value="<%=actividadSeleccionada.getNombre()%>">
									    <input type="submit" value="<%= auxFavs %>" onclick="submit()">
				                    </form>
				                   <% }
				                    	%>
	                            
	                            <% DataSalida[] arrSalidas = actividadSeleccionada.getSalidas(); %>
	                            <% String[] paquetes = actividadSeleccionada.getPaquetes(); %> <!-- se usa para algo? -->
	                            
	                            
	                            
	                            <%if(!esMovil){ %>
	                            <div style="display: flex; justify-content:center; align-items: center;">
	                                <a style="margin-right:22%; margin-top: 15px; ">Salidas</a>
	                       			<a style="margin-left:25%; margin-top: 15px; ">Paquetes</a>
	                            </div>
	                            <div
	                                style="padding-top:20px ; margin-right: 50px; margin-left: 50px; display: flex; justify-content: space-between;">
	                                <% if (actividadSeleccionada.getSalidas()!=null){%>
	                                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel"
	                                    style="margin-right: 70px;">
	                                    <div class="carousel-inner">
	                                        
	                                        <div class="carousel-item active">
	                                            <a href="/tarea2p2/ConsultaSalida?salida=<%=arrSalidas[0].getNombre()%>">  
	                                                <div class="card" style="width: 18rem;">
	                                                    <img class="card-img-top" src="/tarea2p2/Imagenes?id=<%=arrSalidas[0].getImagen()%>" alt="<%= arrSalidas[0].getImagen() %>">
	                                                    <div class="card-body">
	                                                        <p class="card-text" style="text-align: center;"><%=arrSalidas[0].getNombre()%></p>
	                                                    </div>
	                                                </div>
	                                            </a>     
	                                        </div>
	                                       <% for(int i=1; i<arrSalidas.length; i++) { %>
	                                        <div class="carousel-item">
	                                            <a href="/tarea2p2/ConsultaSalida?salida=<%=arrSalidas[i].getNombre()%>">  
	                                                <div class="card" style="width: 18rem;">
	                                                    <img class="card-img-top" src="/tarea2p2/Imagenes?id=<%=arrSalidas[i].getImagen()%>" alt="<%= arrSalidas[i].getImagen() %>">
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
	                                <%}%>
	                                <% if (actividadSeleccionada.getPaquetes()!=null){ %>
	                                <% DataPaquete[] arrayPaquetes = (DataPaquete[]) request.getAttribute("ArrayPaquetes"); %>
	                                <div id="carouselExampleControls2" class="carousel slide" data-ride="carousel"
	                                    style="margin-left: 70px;">
	                                    <div class="carousel-inner">
	                                        
	                                        <div class="carousel-item active">
	                                            <a href="/tarea2p2/ConsultaPaquete?paquete=<%=arrayPaquetes[0].getNombre()%>"> 
	                                                <div class="card" style="width: 18rem;">
	                                                    
	                                                    <%if(arrayPaquetes[0].getImagen()!=null){ %>
	                                                    	<img class="card-img-top" src="/tarea2p2/Imagenes?id=<%=arrayPaquetes[0].getImagen()%>" alt="<%= arrayPaquetes[0].getImagen() %>">

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
		                                                    <%if(arrayPaquetes[i].getImagen()!=null){%>
		                                                    	<img class="card-img-top" src="/tarea2p2/Imagenes?id=<%=arrayPaquetes[i].getImagen()%>" alt="<%= arrayPaquetes[i].getImagen() %>">
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
	                                                   <% if (actividadSeleccionada.getEstado()!=EstadoAct.finalizada){ %>
	                                                        <p class="card-text" style="text-align: center;">no hay paquetes</p>
	                                                   <%}else{ %>
	                                                   <p class="card-text" style="text-align: center;">no existe informacion de paquetes</p>
	                                                   <%}%>
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
	                            <%}else{ %>
	                           	<div style="text-align:center">
	                           	
	                           	<ul>
        						<li>SALIDAS</li>
        							<%if(arrSalidas!=null){
        							for(int i=0; i<arrSalidas.length ; i++){ %>
	        						<li><a href="/tarea2p2/ConsultaSalida?salida=<%=arrSalidas[i].getNombre()%>"><%=arrSalidas[i].getNombre()%></a></li>
							        <%}}else{%>
							        <li>no hay salidas</li>
							        <%}%>
    							</ul>
    							
    							<ul>
    							
        						<li>PAQUETES</li>
        							<%if(paquetes!=null){
        							for(int i=0; i<paquetes.length ; i++){ %>
	        						<li><a> <%=paquetes[i]%></a></li>
							        <%}}else{%>
							        <li>no hay paquetes</li>
							        <%}%>
    							</ul>
	                           	
	                           	
	                           	
	                           	
	                           	
	                           	
	                           	
	                       
	                           	</div>
	                            <%}%>
	                            
	                           
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
