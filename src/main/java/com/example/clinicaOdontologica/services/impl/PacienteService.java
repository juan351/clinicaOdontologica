package com.example.clinicaOdontologica.services.impl;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.repositories.IPacienteRepository;
import com.example.clinicaOdontologica.services.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public List<PacienteDTO> listarPacientes() {
        List<PacienteDTO> listaPacientesDto = new ArrayList<>();
        List<com.example.clinicaOdontologica.models.Paciente> listaPacientes = pacienteRepository.findAll();
        for (com.example.clinicaOdontologica.models.Paciente paciente : listaPacientes) {
            listaPacientesDto.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return listaPacientesDto;

    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public com.example.clinicaOdontologica.models.Paciente guardarPaciente(com.example.clinicaOdontologica.models.Paciente pacienteNuevo) {
        if (pacienteNuevo != null){
            return pacienteRepository.save(pacienteNuevo);
        }
        return new com.example.clinicaOdontologica.models.Paciente();
    }

    @Override
    public String eliminarPorId(Integer id) {
        if(pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
            return "El paciente con id " + id + " ha sido eliminado.";
        }
        return "El paciente con id " + id + " no existe.";
    }

    @Override
    public com.example.clinicaOdontologica.models.Paciente actualizarPaciente(com.example.clinicaOdontologica.models.Paciente paciente) {
        return pacienteRepository.saveAndFlush(paciente);
    }

}
