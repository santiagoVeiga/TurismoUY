

let categorias = document.getElementsByClassName('catSelecc')

    for(let c of categorias) {
      c.addEventListener("click", function(e){
        //console.log(e.target.value)
        let categoriaNueva = e.target.value
        if (chequearRepetidas(categoriaNueva)){
            htmlContentToAppend = ""
            htmlContentToAppend += `
                    <div class="row">
                        <p class="catActual">` + (categoriaNueva) + `</p>
                    </div>
                    `
            document.getElementById("categoriasBox").innerHTML += htmlContentToAppend;
        }
    });
}

function chequearRepetidas(categoriaNueva){
    let categoriasActualesAux = document.getElementsByClassName("catActual")
    let categoriasActuales = []
    
    console.log(categoriasActualesAux)
    for (let i = 0; i < categoriasActualesAux.length; i++) {
        categoriasActuales[i] = categoriasActualesAux[i].textContent;
    }
    console.log(categoriasActuales)

    if (categoriasActuales.includes(categoriaNueva)){
        return false
    }else return true

}
//FALTA CHEQUEAR CATEGORIAS REPETIDAS