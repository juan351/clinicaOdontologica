package com.example.clinicaOdontologica.controllers;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.models.Turno;
import com.example.clinicaOdontologica.services.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Indicamos a Spring que esta clase es un controlador */
@RestController
/* Agregamos el path /turnos antes de cada ruta */
@RequestMapping("/turnos")
public class TurnoController {

    /* Utilizamos Autowired para inyectar ITurnoService en lugar de usar un constructor */
    @Autowired
    public ITurnoService turnoService;

    /* Ruta: /turnos/todos. Solicita el listado completo de turnos. */
    @GetMapping("/todos")
    public List<TurnoDTO> listarTurnos(){
        return turnoService.listarTurnos();
    }

    /* Ruta: /turnos/{id}. Recibe la variable id en el path y la pasa al service para que
     * busque el turno correspondiente en la base de datos. */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){

        return turnoService.buscarTurnoPorId(id);

    }

    /* Ruta: /turnos/{id}. Recibe la variable id en el path y solicita al service que elimine
     * el turno de id correspondiente en la base de datos. */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable int id){
        return turnoService.eliminarTurnoPorId(id);
    }

    /* Ruta: /turnos/agregar. Usamos esta ruta para enviar solicitudes POST con un objeto Turno
     * en el body. El controlador solicita al service que lo guarde en la base de datos. */
    @PostMapping(path = "/agregar")
    public Turno agregar(@RequestBody Turno turno) {
        return turnoService.actualizarTurno(turno);
    }

    /* Ruta: /turnos/actualizar. Usamos esta ruta para solicitar la actualización de un objeto Turno. */
    @PutMapping(path = "/actualizar")
    public Turno actualizar(@RequestBody Turno turno) {
        return turnoService.actualizarTurno(turno);
    }
}
