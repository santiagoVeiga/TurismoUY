<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="logica.DataUsuario,logica.DataTurista,logica.DataActividad,logica.DataSalida,java.util.Set,logica.DataDepartamento" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="turismo.uy">
    <meta name="keywords" content="turismo, uruguay">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado Actividades</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

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
                    <div class="header__top__right">
                        <div class="header__top__right__auth">
                        	<a href="./alta_usuario.html"> Alta Usuario</a>
                            <a href="./login.html"><i class="fa fa-user"></i> Iniciar Sesion</a>
                        </div>
                    </div>
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
                    		<ul>
                                <li><a href="./listar_usuariosV.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Usuario</a></li>
                                <li><a href="./ListaPaquetesV.html"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Paquete</a></li>
                                <li><a href="#" onclick="return seleccionarAct();"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp; Consultar Actividad</a></li>
                            </ul>
                    	</div>
                        <div class="hero__deps">
                            <div class="hero__deps__all">
                                <i class="fa fa-bars"  ></i>
                                <span>Departamentos</span>
                            </div>
                            <ul>
                                <li><a href="./ListaActividadV.html">Rocha</a></li>
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
                <div class="col-lg-9 col-md-7">
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Lista De Actividades</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                	<% 
                                	DataActividad[] acts;
                                	acts = (DataActividad[]) request.getAttribute("ArregloActividades");
                                	for(int i = 0; i < acts.length; i++){
                                	%>
                                		<a class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="../img/degusta.jpg" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h5> <%= acts[i].getNombre() %> </h5>
                                            <h6> <%= acts[i].getDescripcion() %> </h6>
                                            <a href="?actividad=<%= acts[i].getNombre() %>">
                                            	<span class="blog__btn" >LEER MÁS </span>
                                            </a>
                                        </div>
                                    </a>
                                	<% } %>
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
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>



</body>

</html>
