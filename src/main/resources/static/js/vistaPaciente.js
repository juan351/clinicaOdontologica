window.onload = function(){

    const url = '/pacientes/todos'
    const urlAgregar = '/pacientes/agregar'
    const urlActualizar = '/pacientes/actualizar'
    const urlId = '/pacientes/'
    const form = document.forms[0];
    form.reset();
    fetch(url)
    .then(function(respuesta){

        return respuesta.json();
    })
    .then(function(info){

        for(let i = 0; i < info.length; i++){

            let insertar = document.getElementById("tabla-pacientes-body");
            let pacienteFila = insertar.insertRow( insertar.rowIndex + 1 );
            pacienteFila.insertCell(0).innerHTML = info[i].nombre.toUpperCase();
            pacienteFila.insertCell(1).innerHTML = info[i].apellido.toUpperCase();
            pacienteFila.insertCell(2).innerHTML = info[i].email.toLowerCase();
            let botonEditar = document.createElement("button");
            botonEditar.setAttribute("id", info[i].id);
            botonEditar.setAttribute("class", "btnEditar");
            botonEditar.textContent = "Editar";
            botonEditar.addEventListener('click', function(){

                modificarRegistro(this.id);
            })
            pacienteFila.append(botonEditar);

        }

    });

    const botonAgregar = document.getElementById("agregar-paciente");
    botonAgregar.addEventListener("click", function(e){
        e.preventDefault();


        let paciente = capturarDatosPaciente(form);
        let errores = validarPaciente(paciente);

        if(errores.length > 0){
            exhibirMensajesErrores(errores);
            return;
        }

        agregarPaciente(paciente);
        form.reset();
        let mensajesErrores = document.querySelector("#mensajes-errores");
        mensajesErrores.innerHTML = "";

    });

    function agregarPaciente(paciente){
        let pacienteTr = construirTr(paciente);


                const settings = {
                    headers: {
                          'Accept': 'application/json',
                          'Content-Type': 'application/json'
                        },
                    method: "POST",
                    body: JSON.stringify(paciente)
                }

        fetch(urlAgregar, settings)
                .then(function (respuesta){
                    return respuesta.json();
                })
                .then(function (info){

                    console.log("Paciente guardado: " + info.nombre + " " + info.apellido );
                    let botonEditar = document.createElement("button");
                    botonEditar.setAttribute("id", info.id);
                    botonEditar.setAttribute("class", "btnEditar");
                    botonEditar.textContent = "Editar";
                    botonEditar.addEventListener('click', function(){
                                  modificarRegistro(this.id);
                            })
                    pacienteTr.append(botonEditar);

                    let tabla = document.getElementById("tabla-pacientes-body");
                    tabla.appendChild(pacienteTr);
                })
    }

    function capturarDatosPaciente(form){
        let paciente = {
            nombre: form.nombre.value,
            apellido: form.apellido.value,
            email: form.email.value,
            dni: form.dni.value,
            fechaIngreso: form.fecha.value

        }

        return paciente;

    }

    function construirTr(paciente){
        let pacienteTr = document.createElement("tr");
        pacienteTr.classList.add("paciente");
        let nombreTd = construirTd(paciente.nombre.toUpperCase(), "nombre");
        let apellidoTd = construirTd(paciente.apellido.toUpperCase(), "apellido");
        let emailTd = construirTd(paciente.email.toLowerCase(), "email");


        pacienteTr.appendChild(nombreTd);
        pacienteTr.appendChild(apellidoTd);
        pacienteTr.appendChild(emailTd);


        return pacienteTr;
    }

    function construirTd(dato,clase){
        let td = document.createElement("td");
        td.classList.add(clase);
        td.textContent = dato;
        return td;

    }

    function validarPaciente(paciente){
        let errores = []
        if(paciente.nombre.length == 0){
            errores.push("El nombre no puede estar vacío");
        }
        if(paciente.apellido.length == 0){
            errores.push("El apellido no puede estar vacío");
        }
        if(paciente.dni.length == 0){
            errores.push("El DNI no puede estar vacío");
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
        const botonModificar = document.getElementById("actualizar-paciente");
        const botonEliminar = document.getElementById("eliminar-paciente");
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
            form.email.value = rjson.email;
            form.dni.value = rjson.dni;

            form.fecha.value = rjson.fechaIngreso;
            form.fecha.disabled = true;

            info = rjson;

        })
        botonModificar.addEventListener('click', function(e){
        e.preventDefault();
        let paciente = {
            id: info.id,
            nombre: form.nombre.value? form.nombre.value : info.nombre,
            apellido: form.apellido.value? form.apellido.value : info.apellido,
            email: form.email.value? form.email.value : info.email,
            dni: form.dni.value? form.dni.value : info.dni,
            fechaIngreso: info.fechaIngreso
            }
        const settings = {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
                },
            method: "POST",
            body: JSON.stringify(paciente)
            }

            fetch(urlActualizar, settings)
            .then(function (respuesta){
            return respuesta.json();
            })
            .then(function (rjson){
                console.log("Paciente actualizado: " + rjson.nombre + " " + rjson.apellido );
                location.reload();

            })
        })

        botonEliminar.addEventListener('click', function(e){
            e.preventDefault();
            let eleccion = confirm("¿Desea eliminar paciente del registro?");
            const settings = { method: 'DELETE' }
            if (eleccion){
                fetch(urlId + id, settings)
                .then(function(){
                    console.log("Paciente eliminado del registro");
                    location.reload();
                })
                .catch(function(error){
                    console.log(error);
                })
            }

        })

    }



}







