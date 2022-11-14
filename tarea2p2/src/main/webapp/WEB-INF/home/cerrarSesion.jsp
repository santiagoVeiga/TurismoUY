<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%boolean esMovil = (boolean) session.getAttribute("esMovil"); 
   if (!esMovil){%>
<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

   

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
        </div>
        <div class="container">
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

	<section class="vh-100">
  <div class="cont-csesion align-items-center justify-content-center">
    <div class="row align-items-center justify-content-center" >
      <div class="col-sm-12 text-black align-items-center ">

        <div class="d-flex align-items-center ">
			
          <form style="width: 23rem; ">
			<a href="/tarea2p2/home"><img alt="" src="img/logo.png"></a>
			
            <p>Se ha cerrado la sesion</p>
            <br>
			<div class="pt-1 mb-4" >
              <a href="/tarea2p2/home"> <button class="btn btn-info btn-lg btn-block" style="background : #4bb1ff;" type="button">Volver al Inicio</button> </a>
            </div>            

          </form>

        </div>

      </div>
    </div>
  </div>
</section>
<%} else{ %>
  <div class="cont-csesion align-items-center justify-content-center">
    <div class="row align-items-center justify-content-center" >
      <div class="col-lg-12 text-black align-items-center ">

        <div class="d-flex align-items-center ">
			
          <form style="width: 35rem; ">
			<a href="/tarea2p2/home"><img alt="" src="img/logo.png"></a>
			
            <p>Se ha cerrado la sesion</p>
            <br>
			<div class="pt-1 mb-4" >
              <a href="/tarea2p2/home"> <button class="btn btn-info btn-lg btn-block" style="background : #4bb1ff;" type="button">Volver al Inicio</button> </a>
            </div>            

          </form>

        </div>

      </div>
    </div>
  </div>
<%} %>
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