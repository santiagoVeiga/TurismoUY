<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<%@page import="servidor.EstadoAct,java.util.Base64, java.util.Calendar,servidor.DataUsuario,servidor.DataTurista,servidor.DataProveedor,servidor.DataActividad,java.util.Set,servidor.DataDepartamento,controllers.EstadoSesion,java.text.SimpleDateFormat" %>
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
   <%boolean esMovil = (boolean) session.getAttribute("esMovil"); 
   if (!esMovil){%>
   
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
                <% String een = (String) request.getAttribute("Exception");
               if(een != null){%>
               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
				  <%= een %>
				  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
				</div>
			<%} %>
			
			<% String compraP = (String) request.getAttribute("CompraPaq");
               if(compraP != null){%>
               <div class="alert alert-success" role="alert" style="display: flex;justify-content: space-between;">
				  <%= compraP %>
				  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
				</div>
			<%} %>
			
			<% String insc = (String) request.getAttribute("Inscrip");
               if(insc != null){%>
               <div class="alert alert-success" role="alert" style="display: flex;justify-content: space-between;">
				  <%= insc %>
				  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
				</div>
			<%} %>
                <% DataDepartamento[] dptos = (DataDepartamento[]) session.getAttribute("dptos");
                DataActividad[] actIndex = dptos[4].getColAct(); 
                for(DataDepartamento iter : dptos){
                	if (iter.getColAct() != null && iter.getColAct().length!=0){
                		actIndex = iter.getColAct();
                	}
                }
                boolean addRow = true;
                	if(actIndex!=null)
	                for (DataActividad iter : actIndex){
	                	if(iter.getEstado() == EstadoAct.confirmada){
	                		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	                		String date = format.format(iter.getFechaAlta().getTime());
                		if (addRow){
                		%>
                    <div class="row">
                    <%} %>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
									<img src="/tarea2p2/Imagenes?id=<%= "src/data/Actvs/" + iter.getNombre() + ".jpg" %>" alt="<%= "src/data/Actvs/" + iter.getNombre() + ".jpg" %>">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> <%= date%></li>
                                    </ul>
                                    <h5><a href="/tarea2p2/home?actividad=<%= iter.getNombre() %>" ><%= iter.getNombre() %></a></h5>
                                    <p><%=iter.getDescripcion() %></p>
                                    <a href="/tarea2p2/home?actividad=<%= iter.getNombre() %>" class="blog__btn">LEER MÁS <span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        
                    <%if (addRow){
                		addRow = false;
                		%>    
                    
                <%} else {addRow = true; // esta para arreglar %>
                </div> 
                  <%   }}} %>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    <%} else { %>
    	<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    
    <section class="vh-100">
	  <div class="container-fluid">
	    <div class="row" >
	      <div class="col-sm-12 text-black">
	
	        <div class="d-flex align-items-center">
				
	          <form id="iniSesM" style="width: 23rem;" action = "sesionIniciada" method="post">
				<a href="/tarea2p2/home"><img alt="" src="img/logo.png"></a>
				<br>
	            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Inicio de Sesion</h3>
	            
	            <% String ec = (String) request.getAttribute("error_contrasena"); 
	               String een = (String) request.getAttribute("error_emailnick");
	               if(een != null && een.equals("error")){%>
	               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
					  Email o nickname incorrecto
					  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
					</div>
				<%} else if (ec != null && ec.equals("error")){ %>
					<div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
					  Contraseña incorrecta
					  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
					</div>
				<%} %>
			<fieldset>
	            <div class="form-outline mb-4">
	            	<label class="form-label" for="emailnick_inicioSesion">Email address or nickname</label>
	              <input type="text" id="emailnick_inicioSesionM" name="emailnick_inicioSesionM" class="form-control form-control-lg" required/>
	            </div>
	
	            <div class="form-outline mb-4">
	              <label class="form-label" for="pass_iniSesion">Password</label>
	              <input type="password" id="pass_iniSesionM" name="pass_iniSesionM" class="form-control form-control-lg" required/>
	            </div>
	         </fieldset>   
				
				<div class="pt-1 mb-4" >
	              <button class="btn btn-info btn-lg btn-block" id="btn-iniSM" onclick="inicioSesionM();" style="background : #4bb1ff;" type="button">Iniciar Sesion</button>
	            </div>            
	
	
	          </form>
	
	        </div>
	
	      </div>
	    </div>
	  </div>
	</section>
	
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
	
	<script src="js/jquery.validate.js"></script>
    
	<script> function inicioSesionM(){
		$("#iniSesM").validate({
			rules:{
				emailnick_inicioSesionM: "required",
				pass_iniSesionM: "required"
			},
			messages:{
				emailnick_inicioSesionM: "Por favor ingrese email o nick",
				pass_iniSesionM: "Por favor ingrese contraseña"
			},
			errorElement: 'span'
		});
		if($("#iniSesM").valid()){
			document.getElementById("iniSesM").submit();
		}
	}
	</script>
	

	
</body>
</html>
