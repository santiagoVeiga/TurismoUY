<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64,java.util.Calendar,servidor.DataCompraPaquete,servidor.EstadoAct,servidor.DataCompraGeneral,servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataSalida,java.util.Set,servidor.DataPaquete,servidor.DataActividad" %>

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
	
  	String NickUsuario = DU.getNick();
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
                      
                      
                      	<%//String imagen = Base64.getEncoder().encodeToString(DU.getImagen()); %>
                      	<div class="blog__details__author">
                          <div class="blog__details__author__pic">
                              <img src="/tarea2p2/Imagenes?id=<%= DU.getImagen() %>" alt="<%= DU.getImagen() %>">                               
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
							<% String alert = (String) request.getAttribute("Exception");
			               if(alert != null){%>
			               <div class="alert alert-success" role="alert" style="display: flex;justify-content: space-between;">
							  <%= alert %>
							  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
							</div>
						<%} %>
				  <div style= "width: 800px;" class="tab-container">
				  <div id="tab2" class="tab">
					      <a href="#tab2">Social</a>
					      <div class="tab-content">
					      	<div class="product__discount">
	                                        <div class="section-title product__discount__title">
	                                            
	                                        </div>
	                                        <div class="row">
	                                            <div class="col-lg-4">
								                   	<div class="hero__deps">
												   		<div class="hero__deps__all">
												             <i class="fa fa-bars"  ></i>
												             <span>Seguidores</span>
												         </div>
												         <ul>
												         <%String[] Segui = DU.getSeguidores();
												         if(Segui!=null){
												         for (String it : Segui){
												         %>
												             <li><a href="/tarea2p2/ConsultaUsuario?dataUsuario=<%= it%>"><%= it%></a></li>
												         <%}} %>
												         </ul>
												     </div>
								                   </div>
								                   <div class="col-lg-4">
								                   	<div class="hero__deps">
												   		<div class="hero__deps__all">
												             <i class="fa fa-bars"  ></i>
												             <span>Seguidos</span>
												         </div>
												         <ul>
												         <%String[] Seguidos = DU.getSeguidos();
												         if(Seguidos!=null){
												         for (String it : Seguidos){
												         %>
												             <li><a href="/tarea2p2/ConsultaUsuario?dataUsuario=<%= it%>"><%= it%></a></li>
												         <%} }%>
												         </ul>
												     </div>
								                   </div>
	                                    </div>
					      </div>
					    </div>
					    </div>
				  <div id="tab1" class="tab">
				      <a href="#tab1">Información Básica</a>
				      <div class="tab-content">
					        <li><span>Nombre: </span> <%=DU.getNombre() %></li>
		                    <li><span>Apellido: </span>  <%=DU.getApellido() %></li>
		                    <li><span>EMail: </span>  <%=DU.getMail() %></li>
		                    <li><span>FechaNac: </span>  <%=DU.getNacimiento().get(Calendar.DATE) + "/" + (DU.getNacimiento().get(Calendar.MONTH)+1)+ "/" + (DU.getNacimiento().get(Calendar.YEAR)) %></li>
		                    <%if(tipo == "Turista"){%>
		                    	<li><span>Nacionalidad: </span><%=((DataTurista)DU).getNacionalidad()%></li>
		                    <%}else{%>
		                    	<li><span>Descripcion: </span><%=((DataProveedor)DU).getDescripcion()%></li>
		                    	<li><span>Link: </span><%=((DataProveedor)DU).getLink()%></li>
		                    	
		                    <%}%>
		                    <br>
		                    <% DataUsuario usr = (DataUsuario) session.getAttribute("usuario");
		                    	if (usr != null && !DU.getNick().equals(usr.getNick())){
		                    		
		                    	%>
		                    <form action="SeguirUsuario" method="POST">
		                    	<% //khg
		                    	String[] seguidores = DU.getSeguidores();
		                    	String auxSeguir = null;
		                    	boolean bandera = false;
		                    	if(seguidores==null)
		                    		bandera = false;
		                    	else
			                    	for(String it : seguidores){
			                    		if(it==usr.getNick())
			                    			bandera = true;
			                    	}
		                    	if (bandera){
		                    		auxSeguir = "Dejar de seguir";
		                    	} else {
		                    		auxSeguir = "Seguir";
		                    	}
		                    	%>
                   				<input type="hidden" id="nickUsuASeguir" name="nickUsuASeguir" value="<%=DU.getNick()%>">
							    <input class="btn btn-light" type="submit" value="<%= auxSeguir %>" onclick="submit()">
		                    </form>
		                   <% 
		               
                   	
		                    	}else if(usr != null && DU.getNick().equals(usr.getNick())){
		                    	%>
		                    	<button type="button" class="btn btn-light"><a href="/tarea2p2/ModificarUsuario?dataUsuario=<%= DU.getNick() %>">Modificar datos personales</a></button>
		                    <% 	}
		                   %>
		                   		                    
				      </div> 
				    </div> 
				  
				  	<% 
				  	
				      if(DU instanceof DataTurista){
				    	    DataCompraGeneral[] salidas;
				    	    DataCompraPaquete[] arrDCP = ((DataTurista)DU).getComprasPaq();
				    	    
				    	    
				    	    if (usr != null && DU.getNick().equals(usr.getNick())){
				    	    //DataPaquete[] DP = (DataPaquete[]) request.getAttribute("ArregloPaquetes");
				    	    if (arrDCP != null && arrDCP.length != 0){
				    	    	DataPaquete[] DP = new DataPaquete[arrDCP.length];
					    	    
					    	    for (int i = 0; i < arrDCP.length; i++) {
						        	DP[i] = ((DataCompraPaquete) arrDCP[i]).getPaq();
						        	
						        }	
				      %>
					  	<div id="tab4" class="tab">
					      <a href="#tab4">Paquetes</a>
					      <div class="tab-content">
					      	<div class="product__discount">
	                                        <br>
	                                        <br>
	                                        <br>
	                                        <div class="section-title product__discount__title">
	                                            <h2>Paquetes</h2>
	                                        </div>
	                                        <div class="row">
	                                            <div id="carouselExampleControls2" class="carousel slide" data-ride="carousel">
					                            <div class="carousel-inner">
					                              <div class="carousel-item active">
					                                <div class="card" >
					                                    <a style= "width: 700px;" href="/tarea2p2/ConsultaPaquete?paquete=<%= DP[0].getNombre() %>"> 
					                                    	<img src="/tarea2p2/Imagenes?id=<%= DP[0].getImagen() %>" alt="<%= DP[0].getImagen() %>">
					                                    </a>
					                                    <div class="card-body">
					                                        <p class="card-text"> <%= DP[0].getNombre() %></p>
					                                        <%	if (usr != null && DU.getNick().equals(usr.getNick())){ 
					                                        %>
					                                        
					                                        <p class="card-text">cantidad: <%= ((DataCompraPaquete)arrDCP[0]).getCantidad()%></p> 
					                                        <p class="card-text">costo: <%= Math.round(arrDCP[0].getCosto())%></p> 
					                                        <p class="card-text">fecha: <%=arrDCP[0].getFecha().get(Calendar.DATE) + "/" + (arrDCP[0].getFecha().get(Calendar.MONTH)+1)+ "/" + (arrDCP[0].getFecha().get(Calendar.YEAR)) %> </p> 
					                                        <p class="card-text">vencimiento: <%= arrDCP[0].getVencimiento().get(Calendar.DATE) + "/" + (arrDCP[0].getVencimiento().get(Calendar.MONTH)+1)+ "/" + (arrDCP[0].getVencimiento().get(Calendar.YEAR)) %></p>                                  
					                                    
					                                    	<%}
					                                    	%>
					                                    </div>
					                                  </div>
					                                </div>
					                              <%
							                          	for(int i = 1; i < DP.length; i++){
							                          		//String imagenp1 = Base64.getEncoder().encodeToString(DP[i].getImagen());
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a style= "width: 700px;" href="/tarea2p2/ConsultaPaquete?paquete=<%= DP[i].getNombre() %>"> 
							                                    	<img src="/tarea2p2/Imagenes?id=<%= DP[i].getImagen() %>" alt="<%= DP[i].getImagen() %>"> 
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"> <%= DP[i].getNombre() %></p>
							                                %>
							                                        <p class="card-text">cantidad: <%= ((DataCompraPaquete)arrDCP[i]).getCantidad()%></p> 
							                                        <p class="card-text">costo: <%= Math.round(arrDCP[i].getCosto())%></p> 
							                                        <p class="card-text">fecha: <%=arrDCP[i].getFecha().get(Calendar.DATE) + "/" + (arrDCP[i].getFecha().get(Calendar.MONTH)+1)+ "/" + (arrDCP[i].getFecha().get(Calendar.YEAR)) %> </p> 
							                                        <p class="card-text">vencimiento: <%= arrDCP[i].getVencimiento().get(Calendar.DATE) + "/" + (arrDCP[i].getVencimiento().get(Calendar.MONTH)+1)+ "/" + (arrDCP[i].getVencimiento().get(Calendar.YEAR)) %></p>                                  
							                                
							                                    </div>
							                                 </div>
							                            </div>
							                              <%} %>  
					                              
					                            <%
							                          	if(DP.length!=1){
							                          	%>
							                          	<a class="carousel-control-prev" href="#carouselExampleControls2" role="button" data-slide="prev">
							                              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							                              <span class="sr-only">Previous</span>
							                            </a>
							                            <a class="carousel-control-next" href="#carouselExampleControls2" role="button" data-slide="next">
							                              <span class="carousel-control-next-icon" aria-hidden="true"></span>
							                              <span class="sr-only">Next</span>
							                            </a>
							                              <%} 
							                      %>  
					                          </div>
	                                        </div>
	                                    </div>
					      </div>
					    </div>
					    </div>
					    
					      
						<%
				    	    }
				    	    }
						salidas = ((DataTurista) DU).getInscripcionesSal();
				        DataSalida[] arrDS = new DataSalida[salidas.length];
				        DataCompraGeneral[] arrDCG = new DataCompraGeneral[salidas.length]; 
				        for (int i = 0; i < salidas.length; i++) {
				        	arrDS[i] = ((DataCompraGeneral) salidas[i]).getSalida();
				        	arrDCG[i] = (DataCompraGeneral) salidas[i];
				        }
				        if (salidas.length != 0){
				        //String imagen1 = Base64.getEncoder().encodeToString(arrDS[0].getImagen());
						%>
					    <div id="tab3" class="tab">
					      <a href="#tab3">Salidas</a>
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
					                                    <a style= "width: 700px;" href="/tarea2p2/ConsultaSalida?salida=<%= arrDS[0].getNombre() %>"> 
					                                    	<img src="/tarea2p2/Imagenes?id=<%= arrDS[0].getImagen() %>" alt="<%= arrDS[0].getImagen() %>">
					                                    </a>
					                                    <div class="card-body">
					                                        <p class="card-text"><%= arrDS[0].getNombre() %></p>
					                                              <%	if (usr != null && DU.getNick().equals(usr.getNick())){ 
					                                        %>
					                                        <p class="card-text">Costo: <%= arrDCG[0].getCosto() %></p>
					                                        <p class="card-text">Fecha:<%=arrDCG[0].getFecha().get(Calendar.DATE) + "/" + (arrDCG[0].getFecha().get(Calendar.MONTH)+1)+ "/" + (arrDCG[0].getFecha().get(Calendar.YEAR)) %></p>
					                                        <p class="card-text">Cantidad:<%= arrDCG[0].getCantidad() %></p>
					                                        <p class="card-text">Es de un paquete:<%if(arrDCG[0].isPorPaquete()){%>Si<%}else{%>No<%}%></p> 
					                                    	<%} %>
					                                    </div>
					                                  </div>
					                                </div>
					                              <%
							                          	for(int i = 1; i < arrDS.length; i++){
							                          		//String imagen2 = Base64.getEncoder().encodeToString(arrDS[i].getImagen());
							                          		
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a style= "width: 700px;" href="/tarea2p2/ConsultaSalida?salida=<%= arrDS[i].getNombre() %>">  
							                                    	<img src="/tarea2p2/Imagenes?id=<%= arrDS[i].getImagen() %>" alt="<%= arrDS[i].getImagen() %>">
					                                    		</a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= arrDS[i].getNombre() %></p>
							                                            <%	if (usr != null && DU.getNick().equals(usr.getNick())){ 
					                                        %>
							                                        <p class="card-text">Costo: <%= arrDCG[i].getCosto() %></p>
							                                        <p class="card-text">Fecha:<%=arrDCG[i].getFecha().get(Calendar.DATE) + "/" + (arrDCG[i].getFecha().get(Calendar.MONTH)+1)+ "/" + (arrDCG[i].getFecha().get(Calendar.YEAR)) %></p>
							                                        <p class="card-text">Cantidad:<%= arrDCG[i].getCantidad() %></p>
							                                        <p class="card-text">Es de un paquete:<%if(arrDCG[i].isPorPaquete()){%>Si<%}else{%>No<%}%></p>                                    
							                                      <%} 
					                                        %>
					                                       		 </div>
							                                    </div>
							                                 </div>
							                            
							                              <%} %>  
					                              <%
							                          	if(arrDS.length!=1){
							                          	%>
							                          	<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
							                              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							                              <span class="sr-only">Previous</span>
							                            </a>
							                            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
							                              <span class="carousel-control-next-icon" aria-hidden="true"></span>
							                              <span class="sr-only">Next</span>
							                            </a>
							                              <%} 
							                      %>  					                            
					                            </div>
	                                        </div>
	                                    
	                                    	
					                          </div>
	                                    
	                                    </div>
					      </div>
				      <%}}
				      else
				      {
				    	  
				    	  if (!(usr != null && DU.getNick().equals(usr.getNick()))){
					        DataActividad[] arrDS1 = ((DataProveedor) DU).getActividades();
					        DataActividad[] arrDS = new DataActividad[arrDS1.length];
					       	
					        	int cont = 1;
					        	while(arrDS1[0].getEstado() != EstadoAct.confirmada && (cont<arrDS1.length))
			        			{
			        				if(arrDS1[cont].getEstado() == EstadoAct.confirmada)
			        				{
			        					DataActividad aux = arrDS1[cont];
				        				arrDS1[cont] = arrDS1[0];
				        				arrDS1[0] = aux;				        					
			        				}else
			        					cont++;
			        			}
					        	
					        	arrDS = arrDS1;
					        	if (arrDS.length != 0) {
						        	//String imagenProv = Base64.getEncoder().encodeToString(arrDS[0].getImagen());
						        
                      	%>
	                      	<div id="tab3" class="tab">
					      	<a href="#tab3">Actividades</a>
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
					                                    <a style= "width: 700px;" href="/tarea2p2/ConsultaActividad?actividad=<%= arrDS[0].getNombre() %>">  
					                                    		<img src="/tarea2p2/Imagenes?id=<%= arrDS[0].getImagen() %>" alt="<%= arrDS[0].getImagen() %>">
					                                    
					                                    </a>
					                                    <div class="card-body">
					                                      <p class="card-text" ><%= arrDS[0].getNombre() %></p>
					                                    </div>
					                                  </div>
					                                </div>         
					                           
					                              <%
							                          	for(int i = 1; i < arrDS.length; i++){
							                          		if(arrDS[i]!=null && arrDS[i].getEstado() == EstadoAct.confirmada){
							                          		//String imagenProv1 = Base64.getEncoder().encodeToString(arrDS[i].getImagen());
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a style= "width: 700px;" href="/tarea2p2/ConsultaActividad?actividad=<%= arrDS[i].getNombre() %>"> 
							                                    		<img src="/tarea2p2/Imagenes?id=<%= arrDS[i].getImagen() %>" alt="<%= arrDS[i].getImagen() %>">
					                                    
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= arrDS[i].getNombre() %></p>                                    
							                                    </div>
							                                    </div>
							                                 </div>
							                              <%}} %>  
					                              
					                           
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
	                                    <br>
	                                    <button type="button" class="btn btn-light"><a>Descargar PDF</a></button>
					      </div>
					    </div> 
                      <%}}
				    	  
				    	  
				    	  else{
				    		  DataActividad[] arrDS = ((DataProveedor) DU).getActividades();
				    		  if (arrDS.length != 0) {
						        	//String imagenProv = Base64.getEncoder().encodeToString(arrDS[0].getImagen());
						        	DataSalida[] arrDSA = arrDS[0].getSalidas();
	                    	  %>
						    <div id="tab3" class="tab">
					      	<a href="#tab3">Actividades</a>
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
					                                    <a style= "width: 700px;" href="/tarea2p2/ConsultaActividad?actividad=<%= arrDS[0].getNombre() %>">  
					                                    		<img src="/tarea2p2/Imagenes?id=<%= arrDS[0].getImagen() %>" alt="<%= arrDS[0].getImagen() %>">
					                                    
					                                    </a>
					                                    <div class="card-body">
					                                      <p class="card-text" ><%= arrDS[0].getNombre() %></p>                                    
							                              <p class="card-text">Estado : <%= arrDS[0].getEstado() %></p>
					                                      <br>
					                                      
					                                      <!-- Finalizar Tarea -->
					                                       
					                                      <%if(arrDS[0].getEstado() == EstadoAct.confirmada){%>
					                                      	<button type="button" class="btn btn-light"><a href="/tarea2p2/FinalizarActividad=<%=arrDS[0].getNombre()%>">Finalizar Actividad</a></button>
					                                      <%} %>
					                                      
					                                      <p align="center" class="card-text">Salidas Asociadas:</p>                              
				                                    	  
				                                    	  <%for(int x = 0; x < arrDSA.length; x++) {%>
				                                    	  <a href="/tarea2p2/ConsultaSalida?salida=<%= arrDSA[x].getNombre() %>"> 
							                                    	   <p align="center" class="card-text" ><%= arrDSA[x].getNombre() %></p>
							                                    	  </a>
							                                    	  
				                                    	  <%} %>
				                                    	  
					                                    </div>
					                                  </div>
					                                </div>         
					                           
					                              <%
							                          	for(int i = 1; i < arrDS.length; i++){
							                          		
							                          		arrDSA = arrDS[i].getSalidas();
							                          		if(arrDS[i]!=null){
							                          		//String imagenProv1 = Base64.getEncoder().encodeToString(arrDS[i].getImagen());
							                          	%>
							                            <div class="carousel-item">
							                                <div class="card">
							                                	<a style= "width: 700px;" href="/tarea2p2/ConsultaActividad?actividad=<%= arrDS[i].getNombre() %>"> 
							                                    	<img src="/tarea2p2/Imagenes?id=<%= arrDS[i].getImagen() %>" alt="<%= arrDS[i].getImagen() %>">
							                                    </a>
							                                    <div class="card-body">
							                                        <p class="card-text"><%= arrDS[i].getNombre() %></p>                                    
							                                        <p class="card-text">Estado : <%= arrDS[i].getEstado() %></p>
							                                        <br>
							                                        
							                                        <!-- Finalizar Tarea -->
							                                        
							                                        <%if(arrDS[i].getEstado() == EstadoAct.confirmada){%>
					                                      				<button type="button" class="btn btn-light"><a href="/tarea2p2/FinalizarActividad?actividad=<%= arrDS[i].getNombre() %>">Finalizar Actividad</a></button>
					                                      			<%} %>
							                                        <p align="center" class="card-text">Salidas Asociadas:</p>                                    
							                                    	<%for(int x = 0; x < arrDSA.length; x++) {%>
							                                    	<a href="/tarea2p2/ConsultaSalida?salida=<%= arrDSA[x].getNombre() %>"> 
							                                    	   <p align="center" class="card-text" ><%= arrDSA[x].getNombre() %></p>
							                                    	  </a>
							                                    	  <%} %>
							                                    </div>
							                                    </div>
							                                 </div>
							                              <%}} %>  
					                              
					                           
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
	                                    <br>
	                                    <button type="button" class="btn btn-light"><a>Descargar PDF</a></button>
					      </div>
					    </div>   
						      
						      
						      
						      <%}}}
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


