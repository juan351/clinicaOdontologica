package com.example.clinicaOdontologica.controllers;

import com.example.clinicaOdontologica.services.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


public class TurnoController {

    public ITurnoService turnoService;
    /*
    @DeleteMapping(path = "/turnos/{id}")
    public ResponseEntity eliminarTurno(@PathVariable int id){
        turnoService.generarTurnos();
        boolean resultado = turnoService.eliminar(id);

        if (resultado != false) {
            return new ResponseEntity(turnoService.mostrarTurnos(), null, HttpStatus.OK);
        } else {
            return new ResponseEntity("No se encontró el turno", null, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(path = "/turnos/{id}")
    public ResponseEntity  buscar(@PathVariable int id){
        turnoService.generarTurnos();
        Turno turno = turnoService.buscar(id);
        if (turno != null) {
            return new ResponseEntity<Turno>(turno, null, HttpStatus.OK);
        } else {
            return new ResponseEntity("No se encontró el turno", null, HttpStatus.FORBIDDEN);
        }

    }

    @PutMapping(path = "/turnos")
    public ResponseEntity modificar(@RequestBody Turno turno) {
        turnoService.generarTurnos();
        Turno t = turnoService.modificar(turno);

        if (t != null) {
            return new ResponseEntity<Turno>(t, null, HttpStatus.OK);
        } else {
            return new ResponseEntity("No se encontró el turno", null, HttpStatus.FORBIDDEN);
        }
    }*/
}
