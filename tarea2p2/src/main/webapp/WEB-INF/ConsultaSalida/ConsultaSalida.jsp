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
				<%! DataSalida dataSalida; %>
                <% dataSalida = (DataSalida) request.getAttribute("SalidaElegida"); 
                String imagen = null;
                if (dataSalida.getImagen() != null ){
                	imagen = Base64.getEncoder().encodeToString(dataSalida.getImagen());
                }
                %>
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
                <!-- Salida -->
                
                <div class="col-lg-9">
                    <div class="row">
                    	<div class="info_salida">
                    		<span> Información de la Salida Seleccionada: </span><br />
                    		<div class="row">
		                    	<div class="col-lg-15">
		                    		<div class="cabezales_salida">
		                    			<span> Nombre: </span><br />
		                    			<span> Fecha: </span><br />
		                    			<span> Hora: </span><br />
		                    			<span> Cantidad Máxima Turistas: </span><br />
		                    			<span> Lugar: </span><br />
		                    			<span> Fecha de Alta: </span><br />
		                    		</div>
		                    	</div>
		                    	<div class="col-lg-15">
		                    		<div class="datos_salida">
		                    			<span> <%= dataSalida.getNombre() %> </span><br />
		                    			<span> <%= dataSalida.getFecha().getDate() + "/" + (dataSalida.getFecha().getMonth()+1) + "/" + (dataSalida.getFecha().getYear()+1900) %> </span><br />
		                    			<span> <%= dataSalida.gethora().getHours() %> </span><br />
		                    			<span> <%= dataSalida.getCant() %> </span><br />
		                    			<span> <%= dataSalida.getLugar() %> </span><br />
		                    			<span> <%= dataSalida.getFechaAlta().getDate() + "/" + (dataSalida.getFechaAlta().getMonth()+1) + "/" + (dataSalida.getFechaAlta().getYear()+1900) %> </span><br />
		                    		</div>
		                    	</div>
		                    </div>
		                    <div class="row">
		                    	<div class="col-lg-15">
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
