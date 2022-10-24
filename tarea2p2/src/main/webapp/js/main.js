/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

$(document).ready(function(){
    

     $('.hero__categories__all').on('click', function(){
         $('.hero__categories ul').slideToggle();
     });

     
     $('.hero__deps__all').on('click', function(){
         $('.hero__deps ul').slideToggle();
     });
     });
(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
        --------------------*/
        $('.featured__controls li').on('click', function () {
            $('.featured__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.featured__filter').length > 0) {
            var containerEl = document.querySelector('.featured__filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });
    
   
    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

   

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 3,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 2,
            },

            992: {
                items: 3,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------
		Price Range Slider
	------------------------ */
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
    ----------------------------*/
    $("select").niceSelect();
   
   

    /*------------------
		Single Product
	--------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
	--------------------- */
    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find('input').val(newVal);
    });

})(jQuery);

$().ready(function() {
	
		$("#iniSes").validate({
			rules:{
				emailnick_inicioSesion: "required",
				pass_iniSesion: "required"
			},
			messages:{
				emailnick_inicioSesion: "Por favor ingrese email o nick",
				pass_iniSesion: "Por favor ingrese contraseña"
			},
			errorElement: 'span'
		});
		// validate signup form on keyup and submit
		$("#registro").validate({
			rules: {
				firstname: "required",
				lastname: "required",
				username: {
					required: true
				},
				password: {
					required: true
				},
				confirm_password: {
					required: true,
					equalTo: "#password"
				},
				email: {
					required: true,
					email: true
				},
				input_date:{
					required:true,
					date:true
				},
				nacionalidad:{
					required:true
				},
				descripcion:{
					required:true
				}
				
			},
			messages: {
				firstname: "Por favor ingrese su nombre",
				lastname: "Por favor ingrese su apellido",
				username: {
					required: "Por favor ingrese un nickname",
				},
				password: {
					required: "Por favor ingrese su contraseña"
				},
				confirm_password: {
					required: "Por favor ingrese su contraseña",
					equalTo: "Por favor ingrese la misma contraseña"
				},
				email: "Por favor ingrese un email valido",
				input_date:{
					required: "Por favor ingrese una fecha",
					date: "Ingrese una fecha valida"
				},
				nacionalidad:{
					required:"Por favor ingrese su nacionalidad"
				},
				descripcion:{
					required:"Por favor ingrese una descripcion"
				}
			},
      		errorElement : 'span'
		}); 
		
		
		});
		
function enviarRegistro(formu){
	$("#registro").validate();
    if($("#registro").valid()){
		formu.submit();
	}
}		

function consSalidaIndexV(){
	alert("Elija un departamento o categoria (izquierda de la pantalla)");
	return True;
}

function seleccionarAct(){
	alert("Seleccione una actividad del listado presentado");
	return True;
}

function seleccionarSal(){
	alert("Seleccione una salida perteneciente a la actividad");
	return True;
}

function seleccionarPaq(){
	alert("Seleccione un paquete del listado presentado");
	return True;
}

function enviarSalida() {
	alert("Alta de salida realizada con exito")
	window.location.href='./index_proveedor.html';
}

function altaSActP(){
	alert("Seleccione una de las actividades");
	return True;
}

function compraPaq(){
	var cantidad  = document.getElementById("cant").value;
	if (cantidad !== "" && parseInt(cantidad) > 0){
		alert("Compra realizada con exito");
	}
	return True;
}

function excepciones(exc){
	alert(exc);
	return true;
}
