<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


	<section class="vh-100">
  <div class="container-fluid">
    <div class="row" >
      <div class="col-sm-12 text-black">

        <div class="d-flex align-items-center">
			
          <form method="post" action="/tarea2p2/UsuarioCreado" enctype="multipart/form-data" id="registro" style="width: 23rem;">
			<a href="/tarea2p2/home"><img alt="" src="img/logo.png"></a>
			<br>
			<% String error = (String) request.getAttribute("Exception"); 
               if(error != null){%>
               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
				  <%= error %>
				  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
				</div>
			<%} %>
		<fieldset>
			
            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Registro</h3>

            <div class="form-outline mb-4">
            	<label class="form-label" for="form2Example18">Nickname</label>
              <input type="text" id="username" name="username" class="form-control form-control-lg" onkeyup="nickDisp()" required/>
              <div >
              	<p id="checkNick"> </p>
              </div>
            </div>
            
            <div class="form-outline mb-4">
              <label class="form-label" for="form2Example28">Nombre</label>
              <input type="text" id="firstname" name="firstname" class="form-control form-control-lg" required/>
              
            </div>
            
            <div class="form-outline mb-4">
              <label class="form-label" for="form2Example28">Apellido</label>
              <input type="text" id="lastname" name="lastname" class="form-control form-control-lg" required/>
              
            </div>
            
            <div class="form-outline mb-4">
              <label class="form-label" for="form2Example28">Contrase?a</label>
              <input type="password" id="password" name="password" class="form-control form-control-lg" required/>
              
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="form2Example28">Confirmar Contrase?a</label>
              <input type="password" id="confirm_password" name="confirm_password" class="form-control form-control-lg" required/>
              
            </div>
			
			<div class="form-outline mb-4">
			  <label class="form-label" for="form2Example28">Email</label>
              <input type="email" id="email" name="email" class="form-control form-control-lg" onkeyup="emailDisp()" required/>
              <div id="divCheckEmail">
              	<p id="checkEmail"></p>
              </div>
            </div>
            
           <div class="form-outline mb-4">
              <label class="form-label" for="form2Example28">Fecha de Nacimiento</label>
              <div class="cont-fechaNac">
			      <input id="input-date" type="date" name = "input_date"required/>
			  </div>
            </div>
		      
			
            
            <div class="form-outline mb-4">
            	<label class="form-label" for="form2Example28">Imagen (opcional)</label>
			    <input type="file" accept="image/jpg, image/jpeg" class="form-control-file" id="imgUsuario" name="imgUsuario" >
              
            </div>
			
			<nav>
                            <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Turista</a>
                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Proveedor</a>
                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <div class="form-outline mb-4">
                                  <label class="form-label" for="form2Example28"  style="margin-top:5px;">Nacionalidad</label>
					              <input type="text" id="nacionalidad" name="nacionalidad" class="form-control form-control-lg" required/>
					              
					            </div>
					            <div class="pt-1 mb-4" >
					              <a > <button class="btn btn-info btn-lg btn-block" id="btn-tur-reg" style="background : #4bb1ff;" type="button" onclick="enviarRegistro(this.form);">Registrarme</button> </a>
					            </div>   
                            </div>
                            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                <div class="form-outline mb-4">
                                  <label class="form-label" for="form2Example28"  style="margin-top:5px;">Descripcion</label>
					              <input type="text" id="descripcion" name="descripcion" class="form-control form-control-lg" required/>
					              
					            </div>
					            <div class="form-outline mb-4">
					              <label class="form-label" for="form2Example28">Link (opcional)</label>
					              <input type="url" id="linkProv" name="linkProv" class="form-control form-control-lg" />
					              
					            </div>
					            <div class="pt-1 mb-4" >
					              <a > <button class="btn btn-info btn-lg btn-block" id="btn-prov-reg" style="background : #4bb1ff;" type="button" onclick="enviarRegistro(this.form);">Registrarme</button> </a>
					            </div>   
                            </div>
                            
                        </div>         

					</fieldset>
          </form>

        </div>

      </div>
    </div>
  </div>
</section>

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
	<script>
	function nickDisp() {
		  const xhttp = new XMLHttpRequest();
		  xhttp.onload = function() {
			  var resp = this.responseText;
			  if (resp == "y"){
				  $("#checkNick").empty ();
				  document.getElementById("checkNick").innerHTML = "Nick disponible";
				  var campo = document.getElementById('checkNick');
				  campo.style.color="#00c109";
			  }
			  else{
				  $("#checkNick").empty ();
				  document.getElementById("checkNick").innerHTML = "Nick no disponible";
				  var campo = document.getElementById('checkNick');
				  campo.style.color="#ff0000";
			  }
		    }
		  xhttp.open("GET", "/tarea2p2/perteneceNick?nick="+document.getElementById("username").value, true);
		  xhttp.send();
		}
	</script>
	<script>
	function emailDisp() {
		  const xhttp = new XMLHttpRequest();
		  xhttp.onload = function() {
			  var resp = this.responseText;
			  if (resp == "y"){
				  $("#checkEmail").empty ();
				  document.getElementById("checkEmail").textContent = "Email disponible";
				  var campo = document.getElementById('checkEmail');
				  campo.style.color="#00c109";
			  }
			  else{
				  $("#checkEmail").empty ();
				  document.getElementById("checkEmail").textContent = "Email no disponible";
				  var campo = document.getElementById('checkEmail');
				  campo.style.color="#ff0000";
			  }
		    }
		  xhttp.open("GET", "/tarea2p2/perteneceEmail?email="+document.getElementById("email").value, true);
		  xhttp.send();
		}
	</script>


</body>
</html>