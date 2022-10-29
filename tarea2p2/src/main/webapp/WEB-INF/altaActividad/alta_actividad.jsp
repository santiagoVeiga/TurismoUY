<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="logica.DataUsuario,logica.DataDepartamento,logica.DataTurista,logica.DataProveedor,logica.DataSalida,java.util.Set,controllers.EstadoSesion,logica.DataPaquete,logica.DataActividad" %>

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
</head>

<body>
    <!-- Page Preloder -->
	<!-- Header Section Begin -->
	<jsp:include page="/WEB-INF/template/header.jsp"/>
    
    <!-- Header Section End -->

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
                <!-- Alta Actividad -->
                <div class="col-lg-9" style="border-radius: 25px; padding: 20px; padding-top:30px">
                    <div class="container">
                        <div class="text-center p-4">
                          <h2>Alta Actividad Turística</h2>
                          <p class="lead">Ingresa los datos de la Actividad</p>
                        </div>
                        <div class="row justify-content-md-center">
                          <div class="col-md-8 order-md-1">
                            <h4 class="mb-3">Información de la Actividad</h4>
                            
                            <!-- FORM -->
                            
                            <form method="post"class="needs-validation" enctype="multipart/form-data" action="/tarea2p2/ActividadCreada" id="sell-info">
								<% String error = (String) request.getAttribute("Exception"); 
					               if(error != null){%>
					               <div class="alert alert-danger" role="alert" style="display: flex;justify-content: space-between;">
									  <%= error %>
									  <button id="closei" onclick="this.parentNode.remove(); return false;" >x</button>
									</div>
								<%} %>
                                <!-- Nombre y Departamento -->                                
                                <div class="row">
                                    <!-- Nombre -->
                                    <div class="col-md-6 mb-3">
                                        <label for="productName">Nombre</label>
                                        <input type="text" class="form-control" id="actividadNombre"  name="actividadNombre" onkeyup="actDisp()" required placeholder="" >
                                        <div >
						              	<p id="checkNom"> </p>
						              </div>
                                        <!-- <div class="invalid-feedback">
                                        Ingresa un nombre
                                        </div> -->
                                    </div>
                                    <!-- Departamento -->
                                    <div class="col-md-6 mb-3">
                                        <label for="actividadCategoria">Departamento</label>
                                        <select name="actividadDepartamento" id="actividadDepartamento" required>
                                            <option value="" disabled selected>seleccione departamento</option>
                                            <%DataDepartamento[] departamentos = (DataDepartamento[]) session.getAttribute("dptos");
									         if(departamentos!=null)
									         for (DataDepartamento it : departamentos){
									         %>
									         	<option class="depSelecc"><%= it.getNombre() %></option>
									         <%} %>
                                        </select>
                                        
                                    </div>
                                </div>
                              
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <label for="productDescription">Descripción</label>
                                        <textarea class="form-control" id="actividadDescripcion" name="actividadDescripcion" rows="3" required></textarea>
                                    </div>
                                </div>
                                <!-- Costo y Duracion -->
                                <div class="row">
                                    <!-- Costo -->
                                    <div class="col-md-3 mb-3">
                                        <label for="actividadCosto">Costo</label>
                                        <input type="number" class="form-control" id="actividadCosto" name="actividadCosto" placeholder="" required min="1">
                                        <div class="invalid-feedback">
                                            El costo debe ser mayor que 0.
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label for="">Moneda</label>
                                        <p>Pesos Uruguayos (UYU)</p>
                                    </div>
                                    <!-- Duracion -->
                                    <div class="col-md-3 mb-3">
                                    <label for="actividadDuracion">Duración (horas)</label>
                                    <input type="number" class="form-control" id="actividadDuracion" name="actividadDuracion" placeholder="ingrese la duracion en horas" required min="1">
                                    <div class="invalid-feedback">
                                        La cantidad es requerida.
                                    </div>
                                    </div>
                                </div>
                                
                                <!-- Ciudad -->
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <label for="actividadCiudad">Ciudad</label>
                                        <textarea class="form-control" id="actividadCiudad" name="actividadCiudad" rows="1" required></textarea>
                                    </div>
                                </div>
                                
                                <!-- Categorias-->
                                <div class="col">
                                    <div class="row mb-3">
                                        <label for="actividadCategoria">Categorías</label>
                                        <select class="d-block w-100" id="actividadCategoria" name="actividadCategoria" multiple required>
                                            <option value="" disabled selected>Agregar o quitar categoría</option>
											<%Set<String> categorias = (Set<String>) session.getAttribute("categorias");
											         if(categorias!=null)
											         for (String it : categorias){
											         %>
											             <option value="<%= it %>" class="catSelecc"><%= it %></option>
											<%} %>
                                        </select>
                                        <!-- <div class="invalid-feedback">
                                            Por favor ingresa una categoría válida.
                                        </div> -->
                                    </div>
                                    <div class="col" id="categoriasBox">
                                            <div class="row">
                                                <p class="catActual"></p>
                                            </div>
                                    </div>
                                </div>
                                
                                <!-- Imagenes opcionales-->
                                <hr class="mb-4">
                                <div class="row">
                                    <div class="col-md-8 order-md-1">
                                        <label for="zip">Imágenes</label>
                                        <div class=" " id="file-upload">
                                            <input type="file" accept="image/jpg, image/jpeg" class="form-control" id="imagenActividad" name="imagenActividad" />
                                        </div>
                                    </div>
                                </div>
                                <hr class="mb-4">
                                <!-- Botones -->
                                <button type="button" class="btn btn-secondary btn-lg">Cancelar</button>
                                <button type="submit" class="btn btn-lg btn-primary">Confirmar</button>
                            </form>
                          </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contenido End -->

    <!-- Js Plugins -->
    <script src="js/altaActividad.js"></script>
    <script src="js/main.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script>
	function actDisp() {
		  const xhttp = new XMLHttpRequest();
		  xhttp.onload = function() {
			  var resp = this.responseText;
			  if (resp == "y"){
				  $("#checkNom").empty ();
				  document.getElementById("checkNom").innerHTML = "Nombre disponible";
				  var campo = document.getElementById('checkNom');
				  campo.style.color="#00c109";
			  }
			  else{
				  $("#checkNom").empty ();
				  document.getElementById("checkNom").innerHTML = "Nombre no disponible";
				  var campo = document.getElementById('checkNom');
				  campo.style.color="#ff0000";
			  }
		    }
		  xhttp.open("GET", "/tarea2p2/perteneceAct?act="+document.getElementById("actividadNombre").value, true);
		  xhttp.send();
		}
	</script>
    
</body>

</html>