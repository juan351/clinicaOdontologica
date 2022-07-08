package com.example.clinicaOdontologica.controllers;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/* Indicamos a Spring que esta clase es un controlador */
@RestController
/* Agregamos el path /pacientes antes de cada ruta */
@RequestMapping("/pacientes")
public class PacienteController {

    /* Utilizamos Autowired para inyectar IPacienteService en lugar de usar un constructor */
    @Autowired
    private IPacienteService pacienteService;

    /* Ruta: /pacientes/todos. Solicita el listado completo de pacientes. */
    @GetMapping("/todos")
    public List<PacienteDTO> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    /* Ruta: /pacientes/{id}. Recibe la variable id en el path y la pasa al service para que
     * busque el paciente correspondiente en la base de datos. */
    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable int id){
       return pacienteService.buscarPorId(id);
    }

    /* Ruta: /pacientes/{id}. Recibe la variable id en el path y solicita al service que elimine
     * el paciente de id correspondiente en la base de datos. */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable int id){
        return  pacienteService.eliminarPorId(id);

    }
    /* Ruta: /pacientes/agregar. Usamos esta ruta para enviar solicitudes POST con un objeto Paciente
     * en el body. El controlador solicita al service que lo guarde en la base de datos. */
    @PostMapping("/agregar")
    public Paciente agregarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    /* Ruta: /odontologos/actualizar. Usamos esta ruta para solicitar la actualización de un objeto Paciente. */
    @PutMapping("/actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }
}
