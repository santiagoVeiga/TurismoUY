<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controllers.EstadoSesion,java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,logica.DataDepartamento" %>

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
    <link rel="stylesheet" href="css/style_consulta_salida.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="img/logo.png" alt=""></a>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="#">Consulta Actividad</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="#">Departamentos</a>
                        	<ul class="header__menu__dropdown">
                        		<%
                        		DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
						        if (dptos!=null)
						        	for (DataDepartamento it : dptos){
						        	%>
						        		<li><a href="?DTDConsultaActividad=<%= it.getNombre() %>"><%= it.getNombre() %></a></li>
						        	<%} %>
                   			 </ul>
                        </li>
                        <li><a href="#">Categorias</a>
                        	<ul class="header__menu__dropdown">
						        <%Set<String> cats = (Set<String>) session.getAttribute("categorias");
						        if(cats!=null)
						        	for (String it : cats){
						        	%>
						            	<li><a href="?CatConsultaActividad=<%= it  %>"><%= it %></a></li>
						        	<%} %>
                   			</ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
    </div>
    <!-- Humberger End -->
    
				<%! DataSalida dataSalida; %>
                <% dataSalida = (DataSalida) request.getAttribute("SalidaElegida"); 
                String imagen = null;
                if (dataSalida.getImagen() != null ){
                	imagen = Base64.getEncoder().encodeToString(dataSalida.getImagen());
                }
                %>
    <jsp:include page="/WEB-INF/template/header.jsp"/>
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
                    	<%DataUsuario usr = null;
   if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
   	usr = (DataUsuario) session.getAttribute("usuario");
   }
     %>
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
           <li><a href="/tarea2p2/Inscripcion?salida=<%= dataSalida.getNombre()%>" ><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Inscripcion a Salida Turistica</a></li>
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
           <li><a href="/tarea2p2/AltaActividad"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Turística</a></li>
           <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Turística</a></li>
           <li><a href="/tarea2p2/ConsultaPaquete"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
          <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
          <li><a href="/tarea2p2/ConsultaUsuario"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
       </ul>
<% } %>
	
</div>
                        <jsp:include page="/WEB-INF/template/dptosCats.jsp"/>
                    </div>
                </div>
                <!-- Salida -->
                
                <div class="col-lg-9">
                    <div class="row">
                    	<div class="info_salida">
                    		<span> Información de la Salida Seleccionada: </span><br />
                    		<div class="row justify-content-center">
		                    	<div class="col-lg-12">
		                    		<div class="cabezales_salida">
		                    			<table class="table">
											<thead>
			                    			</thead>
						  					<tbody>
											    <tr>
											      <th scope="row">Nombre:</th>
											      <td><%= dataSalida.getNombre() %></td>
											    </tr>
											    <tr>
											      <th scope="row">Fecha:</th>
											      <td><%= dataSalida.getFecha().getDate() + "/" + (dataSalida.getFecha().getMonth()+1) + "/" + (dataSalida.getFecha().getYear()+1900)%></td>
											    </tr>
											    <tr>
											      <th scope="row">Hora:</th>
											      <td><%= dataSalida.gethora().getHours() %></td>
											    </tr>
											    <tr>
											      <th scope="row">Cantidad Máxima Turistas:</th>
											      <td><%= dataSalida.getCant() %></td>
											    </tr>
											    <tr>
											      <th scope="row">Lugar:</th>
											      <td><%= dataSalida.getLugar() %></td>
											    </tr>
   											    <tr>
											      <th scope="row">Fecha de Alta:</th>
											      <td><%= dataSalida.getFechaAlta().getDate() + "/" + (dataSalida.getFechaAlta().getMonth()+1) + "/" + (dataSalida.getFechaAlta().getYear()+1900) %></td>
											    </tr>
											</tbody>
										</table>
		                    		</div>
		                    	</div>
		                    </div>
		                    <div class="row">
		                    	<div class="col-lg-12">
		                    		<div class="imagen_salida">
		                    			<img src="data:image/jpg;base64,<%= imagen %>" alt="">
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
