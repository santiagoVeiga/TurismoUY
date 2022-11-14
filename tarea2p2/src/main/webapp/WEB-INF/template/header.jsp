<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataActividad,java.util.Set,servidor.DataDepartamento,controllers.EstadoSesion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
    if (session.getAttribute("estado_sesion") != EstadoSesion.NO_LOGIN) {
    	usr = (DataUsuario) session.getAttribute("usuario");
    }
    boolean movil = (boolean) session.getAttribute("esMovil");
    if (!movil){
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
                    <br>
                        <a href="/tarea2p2/home"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form method="post" action="/tarea2p2/buscar">
                                <input id="abuscar" name="abuscar" type="text" placeholder="Buscar en turismo.uy">
                                <button type="submit" class="site-btn">BUSCAR</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                <% if (usr == null) {%>
                    <div class="header__top__right">
                        <div class="header__top__right__auth">
                        	<a href="/tarea2p2/AltaUsuario"> Alta Usuario</a>
                            <a href="/tarea2p2/iniciarSesion"><i class="fa fa-user"></i> Iniciar Sesion</a>
                        </div>
                    </div>
                <%} else { %>
                	<div class="row float-right">
                        <div class="header__top__right__Usu" style="cursor: pointer;" onclick="window.location='/tarea2p2/ConsultaUsuario?nick=<%=usr.getNick()%>';">
                            <span><a href="/tarea2p2/ConsultaUsuario?nick=<%=usr.getNick()%>"><img src="/tarea2p2/Imagenes?id=<%= usr.getImagen() %>" alt="<%= usr.getImagen() %>"> &nbsp; <%= usr.getNombre() %> <%= usr.getApellido() %></a></span>
                        </div>
                    </div>
                    <div class="row float-right">
                    	<div class="header__top__right__csesion ">
                           	<a href="/tarea2p2/cerrarSesion"> Cerrar Sesion</a>
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
    <%} else { %><!-- --------------------------------------- -->
        <!-- Header Section Begin -->
    <header class="header" >
        <div class="container">
            <div class="row">
                <div class="col-lg-1">
                    <div class="header__logo">
                        <a href="/tarea2p2/home"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-2">
                	
                        <div class="header__top__right__Usu" style="cursor: pointer;display: flex;flex-direction: row-reverse;">
                        	<a href="/tarea2p2/cerrarSesion" style="background-color: grey ; border-radius:10px;text-align:center; ">Cerrar Sesion</a>
                            <span><img src="/tarea2p2/Imagenes?id=<%= usr.getImagen() %>" style="border-radius: 5px;" alt="<%= usr.getImagen() %>"> &nbsp; <%= usr.getNombre() %> <%= usr.getApellido() %></span>
                        </div>
                   

                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
        <div style="border-top: 1px solid black;height: 2px;max-width: 900px;padding: 0;margin: 20px auto 0 auto;"></div>
    </header>
    <!-- Header Section End -->
    <% }%>
    <!-- Js Plugins 
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>-->
    
</body>
</html>