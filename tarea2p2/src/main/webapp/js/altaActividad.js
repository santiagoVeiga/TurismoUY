

let categorias = document.getElementsByClassName('catSelecc')

for(let c of categorias) {
    c.addEventListener("click", function(e){
		document.getElementById("categoriasBox").innerHTML = ""
        let categoriaNueva = e.target.value
        chequearRepetidas()
    });
}



function chequearRepetidas(){
	let categoriasActualesAux = document.querySelectorAll('#actividadCategoria option:checked');
	let categoriasActuales = Array.from(categoriasActualesAux).map(el => el.value);
	console.log(categoriasActuales);
	
	for(let i=0; i<categoriasActuales.length;i++){
		let htmlContentToAppend = ""
            htmlContentToAppend += `
                    <div id="`+(categoriasActuales[i])+`Id" class="row">
                    	<p class="catActual">`+(categoriasActuales[i])+`</p>
                	</div>`
            document.getElementById("categoriasBox").innerHTML += htmlContentToAppend;
	}
    

}
