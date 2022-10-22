<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,controllers.EstadoSesion" %>

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
                        <a href="/tarea2p2/home"><img src="img/logo.png" alt=""></a>
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
                        	<a href="/tarea2p2/AltaUsuario"> Alta Usuario</a>
                            <a href="/tarea2p2/iniciarSesion"><i class="fa fa-user"></i> Iniciar Sesion</a>
                        </div>
                    </div>
                <%} else { %>
                	<div class="row float-right">
                        <div class="header__top__right__Usu" style="cursor: pointer;" onclick="window.location='/tarea2p2/ConsultaUsuario?nick=<%=usr.getNick()%>';">
                            <span><a href="/tarea2p2/ConsultaUsuario?nick=<%=usr.getNick()%>"><img src="data:image/jpg;base64,${imagenUsuario}"> &nbsp; <%= usr.getNombre() %> <%= usr.getApellido() %></a></span>
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