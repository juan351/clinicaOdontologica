package com.example.clinicaOdontologica.controllers;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    //Inyectamos la dependencia de PacienteService acá
    @Autowired
    private IPacienteService pacienteService;


    @GetMapping("/todos")
    public List<PacienteDTO> listarPacientes() {
        return pacienteService.listarPacientes();
    }


    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable int id){
       return pacienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable int id){
        return  pacienteService.eliminarPorId(id);

    }

    @PostMapping("/agregar")
    public com.example.clinicaOdontologica.models.Paciente agregarPaciente(@RequestBody com.example.clinicaOdontologica.models.Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PostMapping("/actualizar")
    public com.example.clinicaOdontologica.models.Paciente actualizarPaciente(@RequestBody com.example.clinicaOdontologica.models.Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }
}
