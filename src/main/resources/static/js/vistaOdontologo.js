window.onload = function(){

    const url = '/odontologos/todos'
    const urlAgregar = '/odontologos/agregar'
    const urlActualizar = '/odontologos/actualizar'
    const urlId = '/odontologos/'
    const form = document.forms[0];
    form.reset();
    fetch(url)
    .then(function(respuesta){

        return respuesta.json();
    })
    .then(function(info){

        for(let i = 0; i < info.length; i++){

            let insertar = document.getElementById("tabla-odontologos-body");
            let odontologoFila = insertar.insertRow( insertar.rowIndex + 1 );
            odontologoFila.insertCell(0).innerHTML = info[i].nombre.toUpperCase();
            odontologoFila.insertCell(1).innerHTML = info[i].apellido.toUpperCase();
            odontologoFila.insertCell(2).innerHTML = info[i].matricula.toUpperCase();
            let botonEditar = document.createElement("button");
            botonEditar.setAttribute("id", info[i].id);
            botonEditar.setAttribute("class", "btnEditar");
            botonEditar.textContent = "Editar";
            botonEditar.addEventListener('click', function(){

                modificarRegistro(this.id);
            })
            odontologoFila.append(botonEditar);

        }

    });

    const botonAgregar = document.getElementById("agregar-odontologo");
    botonAgregar.addEventListener("click", function(e){
        e.preventDefault();


        let odontologo = capturarDatosOdontologo(form);
        let errores = validarOdontologo(odontologo);

        if(errores.length > 0){
            exhibirMensajesErrores(errores);
            return;
        }

        agregarOdontologo(odontologo);
        form.reset();
        let mensajesErrores = document.querySelector("#mensajes-errores");
        mensajesErrores.innerHTML = "";

    });

    function agregarOdontologo(odontologo){
        let odontologoTr = construirTr(odontologo);


                const settings = {
                    headers: {
                          'Accept': 'application/json',
                          'Content-Type': 'application/json'
                        },
                    method: "POST",
                    body: JSON.stringify(odontologo)
                }

        fetch(urlAgregar, settings)
                .then(function (respuesta){
                    return respuesta.json();
                })
                .then(function (info){

                    console.log("Odontólogo guardado: " + info.nombre + " " + info.apellido );
                    let botonEditar = document.createElement("button");
                    botonEditar.setAttribute("id", info.id);
                    botonEditar.setAttribute("class", "btnEditar");
                    botonEditar.textContent = "Editar";
                    botonEditar.addEventListener('click', function(){
                                  modificarRegistro(this.id);
                            })
                    odontologoTr.append(botonEditar);

                    let tabla = document.getElementById("tabla-odontologos-body");
                    tabla.appendChild(odontologoTr);
                })
    }

    function capturarDatosOdontologo(form){
        let odontologo = {
            nombre: form.nombre.value,
            apellido: form.apellido.value,
            matricula: form.matricula.value

        }

        return odontologo;

    }

    function construirTr(odontologo){
        let odontologoTr = document.createElement("tr");
        odontologoTr.classList.add("odontologo");
        let nombreTd = construirTd(odontologo.nombre.toUpperCase(), "nombre");
        let apellidoTd = construirTd(odontologo.apellido.toUpperCase(), "apellido");
        let matriculaTd = construirTd(odontologo.matricula.toUpperCase(), "matricula");


        odontologoTr.appendChild(nombreTd);
        odontologoTr.appendChild(apellidoTd);
        odontologoTr.appendChild(matriculaTd);


        return odontologoTr;
    }

    function construirTd(dato,clase){
        let td = document.createElement("td");
        td.classList.add(clase);
        td.textContent = dato;
        return td;

    }

    function validarOdontologo(odontologo){
        let errores = []
        if(odontologo.nombre.length == 0){
            errores.push("El nombre no puede estar vacío");
        }
        if(odontologo.apellido.length == 0){
            errores.push("El apellido no puede estar vacío");
        }
        if(odontologo.matricula.length == 0){
            errores.push("Debe ingresar una matrícula");
        }
        return errores;
    }

    function exhibirMensajesErrores(mensajesErrores){
        let ul = document.getElementById("mensajes-errores");
        ul.innerHTML = "";
        mensajesErrores.forEach(function(error){
            let li = document.createElement("li");
            li.textContent = error;
            ul.appendChild(li);
        });
    }

    function modificarRegistro(id){
        const tituloForm = document.getElementById("titulo-form");
        const botonModificar = document.getElementById("actualizar-odontologo");
        const botonEliminar = document.getElementById("eliminar-odontologo");
        const botonCancelar = document.getElementById("cancelar");
        tituloForm.textContent = "Modificar datos";
        botonAgregar.classList.toggle("invisible");
        botonModificar.classList.toggle("invisible");
        botonEliminar.classList.toggle("invisible");
        botonCancelar.classList.toggle("invisible");

        let info = null;
        fetch(urlId + id)
        .then(function(respuesta){
            return respuesta.json();
        })
        .then(function(rjson){

            form.nombre.value = rjson.nombre;
            form.apellido.value = rjson.apellido;
            form.matricula.value = rjson.matricula;

            info = rjson;

        })
        botonModificar.addEventListener('click', function(e){
        e.preventDefault();
        let odontologo = {
            id: info.id,
            nombre: form.nombre.value? form.nombre.value : info.nombre,
            apellido: form.apellido.value? form.apellido.value : info.apellido,
            matricula: form.matricula.value? form.matricula.value : info.matricula
            }
        const settings = {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
                },
            method: "PUT",
            body: JSON.stringify(odontologo)
            }

            fetch(urlActualizar, settings)
            .then(function (respuesta){
            return respuesta.json();
            })
            .then(function (rjson){
                console.log("Odontólogo actualizado: " + rjson.nombre + " " + rjson.apellido );
                location.reload();

            })
        })

        botonEliminar.addEventListener('click', function(e){
            e.preventDefault();
            let eleccion = confirm("¿Desea eliminar odontólogo del registro?");
            const settings = { method: 'DELETE' }
            if (eleccion){
                fetch(urlId + id, settings)
                .then(function(){
                    console.log("Odontólogo eliminado del registro");
                    location.reload();
                })
                .catch(function(error){
                    console.log(error);
                })
            }

        })

    }



}







