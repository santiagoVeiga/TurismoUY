<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="logica.estadoAct,java.util.Base64,logica.DataUsuario,logica.DataTurista,logica.DataProveedor,logica.DataActividad,java.util.Set,logica.DataDepartamento,controllers.EstadoSesion,java.text.SimpleDateFormat" %>
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
                <div class="col-lg-9">
                <% DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
                Set<DataActividad> actIndex = dptos[4].getColAct(); 
                for(DataDepartamento iter : dptos){
                	if(iter.getColAct().size()!=0){
                		actIndex = iter.getColAct();
                	}
                }
                boolean addRow = true;
                if (usr == null || usr instanceof DataTurista) {
                	if(actIndex!=null)
	                for (DataActividad iter : actIndex){
	                	if(iter.getEstado() == estadoAct.confirmada){
	                	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	                	String date = format.format(iter.getFechaAlta());
	                	String imagen = Base64.getEncoder().encodeToString(iter.getImagen());
                		if (addRow){
                		%>
                    <div class="row">
                    <%} %>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="data:image/jpg;base64,<%= imagen %>" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> <%= date%></li>
                                    </ul>
                                    <h5><a href="?actividad=<%= iter.getNombre() %>" ><%= iter.getNombre() %></a></h5>
                                    <p><%=iter.getDescripcion() %></p>
                                    <a href="?actividad=<%= iter.getNombre() %>" class="blog__btn">LEER MÁS <span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        
                    <%if (addRow){
                		addRow = false;
                		%>    
                    
                <%} else {addRow = true; // esta para arreglar %>
                </div> 
                  <%   }}}} else{
                  
                  if(actIndex!=null)
	                for (DataActividad iter : actIndex){
	                	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	                	String date = format.format(iter.getFechaAlta());
	                	String imagen = Base64.getEncoder().encodeToString(iter.getImagen());
                		if (addRow){
                		%>
                    <div class="row">
                    <%} %>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="data:image/jpg;base64,<%= imagen %>" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> <%= date%></li>
                                    </ul>
                                    <h5><a href="?actividad=<%= iter.getNombre() %>" ><%= iter.getNombre() %></a></h5>
                                    <p><%=iter.getDescripcion() %></p>
                                    <a href="?actividad=<%= iter.getNombre() %>" class="blog__btn">LEER MÁS <span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        
                    <%if (addRow){
                		addRow = false;
                		%>    
                    
                <%} else {addRow = true; // esta para arreglar %>
                </div> 
                  
                  <%}}} %>
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
