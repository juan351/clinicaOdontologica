package com.example.clinicaOdontologica.controllers;


import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.models.Odontologo;
import com.example.clinicaOdontologica.services.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Indicamos a Spring que esta clase es un controlador */
@RestController

@RequestMapping("/odontologos")
public class OdontologoController {

    /* Utilizamos Autowired para inyectar IOdontologoService en lugar de usar un constructor */
    @Autowired
    public IOdontologoService odontologoService;

    /* Ruta: /odontologos/todos. Solicita el listado completo de odontólogos. */
    @GetMapping("/todos")
    public List<OdontologoDTO> getTodos() {
        return odontologoService.listarOdontologos();
    }

    /* Ruta: /odontologos/{id}. Recibe la variable id en el path y la pasa al service para que
    * busque el odontólogo correspondiente en la base de datos. */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id){
        return odontologoService.buscarPorId(id);
    }

    /* Ruta: /odontologos/{id}. Recibe la variable id en el path y solicita al service que elimine
    * el odontólogo de id correspondiente en la base de datos. */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable int id){
        return  odontologoService.eliminarPorId(id);

    }

    /* Ruta: /ondontologos/agregar. Usamos esta ruta para enviar solicitudes POST con un objeto Odontologo
    * en el body. El controlador solicita al service que lo guarde en la base de datos. */
    @PostMapping("/agregar")
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }


    /* Ruta: /odontologos/actualizar. Usamos esta ruta para solicitar la actualización de un objeto Odontologo. */
    @PutMapping("/actualizar")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo);
    }

}
