<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,Controllers.EstadoSesion" %>
<!doctype html>
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

    <%DataUsuario usr = null;
    if (session.getAttribute("estado_sesion") != EstadoSesion.NO_LOGIN) {
    	usr = (DataUsuario) session.getAttribute("usuario");
    }
      %>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        
                    </div>
                    <div class="col-lg-6 col-md-6">
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="../img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <input type="text" placeholder="Buscar en turismo.uy">
                                <button type="submit" class="site-btn">BUSCAR</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                <% if (usr == null) {%>
                    <div class="header__top__right">
                        <div class="header__top__right__auth">
                        	<a href="/turismo.uy/alta_usuario"> Alta Usuario</a>
                            <a href="/turismo.uy/iniciarSesion"><i class="fa fa-user"></i> Iniciar Sesion</a>
                        </div>
                    </div>
                <%} else if (usr instanceof DataTurista){ %>
                	<div class="row float-right">
                        <div class="header__top__right__Usu" style="cursor: pointer;" onclick="window.location='./ConsultaUsuarioT.html';">
                            <span><a href="/turismo.uy/ConsultaUsuario"><img src="https://pbs.twimg.com/media/EOHAP9zWoAsnkiM?format=jpg&name=small"> &nbsp; <% usr.getNombre(); %></a></span>
                        </div>
                    </div>
                    <div class="row float-right">
                    	<div class="header__top__right__csesion ">
                           	<a href="/turismo.uy/logout"> Cerrar Sesion</a>
                        </div>
                    </div>
                <% } else if (usr instanceof DataProveedor) {%>
                	<div class="row float-right">
                        <div class="header__top__right__Usu">
                            <span><a href="/turismo.uy/ConsultaUsuario"><img src="https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d"> &nbsp; Washington Rocha</a></span>
                        </div>
                    </div>
                    <div class="row float-right">
                    	<div class="header__top__right__csesion ">
                           	<a href="/turismo.uy/logout"> Cerrar Sesion</a>
                        </div>
                    </div>
                <%} %>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="row">
                    	<div class="hero__perfil">
                    	<% if (usr == null) {%>
                    		<ul>
                                <li><a href="./listar_usuariosV.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                                <li><a href="./ListaPaquetesV.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                            </ul>
                    	<% } else if (usr instanceof DataTurista){ %>
                    		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuarioT.html';">
                    			<span>Mi Perfil</span>
                    			<div class="ax float-right">
                    				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
                    			</div>
                    		</div>
                    		<ul>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Inscripcion a Salida Turistica</a></li>
                                <li><a href="./ListaPaquetesT.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Comprar Paquete</a></li>
                                <li><a href="./ListaPaquetesT.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                                <li><a href="./listar_usuariosT.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                            </ul>
                    	<% } else if (usr instanceof DataProveedor){%>
                    		<div class="hero__perfil__all" style="cursor: pointer;" onclick="window.location='./ConsultaUsuarioP.html';">
                    			<span>Mi Perfil</span>
                    			<div class="ax float-right">
                    				<i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
                    			</div>
                    		</div>
                    		<ul>
                                <li><a href="./alta_actividad.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Actividad Turistica</a></li>
                                <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Alta de Salida Turistica</a></li>
                                <li><a href="./ListaPaquetesP.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                               <li><a href="#" onclick="return consSalidaIndexV();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                               <li><a href="./listar_usuariosP.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                            </ul>
                    	<% } %>
                    		
                    	</div>
                        <div class="hero__deps">
                            <div class="hero__deps__all">
                                <i class="fa fa-bars"  ></i>
                                <span>Departamentos</span>
                            </div>
                            <ul>
                            <%DataDepartamento[] dptos = (DataDepartamento[]) request.getAttribute("dptos");
                            if(dptos!=null)
                            for (DataDepartamento it : dptos){
                            %>
                                <li><a href="#"><%=it.getNombre()%></a></li>
                                
                            <%} %>
                            </ul>
                        </div>
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>Categorias</span>
                            </div>
                            <ul>
                                <li><a href="./ListaActividadV.html">Gastronomia</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Actividades -->
                <div class="col-lg-9">
                <% Set<DataActividad> actIndex = (Set<DataActividad>) request.getAttribute("actividades_index");
                boolean addRow = true;
                if(actIndex!=null)
                for (DataActividad iter : actIndex){
                %>
                	<%if (addRow){
                		%>
                    <div class="row">
                    <%} %>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> <% iter.getFechaAlta();%></li>
                                    </ul>
                                    <h5><a href="./consulta_actividad_Visitante.html"><% iter.getNombre(); %></a></h5>
                                    <p><%iter.getDescripcion(); %></p>
                                    <a href="./consulta_actividad_Visitante.html" class="blog__btn">LEER MÁS <span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        
                    <%if (addRow){
                		addRow = false;
                		%>    
                    </div> 
                <%} else addRow = true;
                    }%>
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
