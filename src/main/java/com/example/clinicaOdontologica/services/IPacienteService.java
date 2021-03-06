package com.example.clinicaOdontologica.services;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.models.Paciente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPacienteService {
    List<PacienteDTO> listarPacientes();

    Paciente buscarPorId(Integer id);

    com.example.clinicaOdontologica.models.Paciente guardarPaciente(com.example.clinicaOdontologica.models.Paciente pacienteNuevo);

    ResponseEntity<?> eliminarPorId(Integer id);


    com.example.clinicaOdontologica.models.Paciente actualizarPaciente(com.example.clinicaOdontologica.models.Paciente paciente);
}
