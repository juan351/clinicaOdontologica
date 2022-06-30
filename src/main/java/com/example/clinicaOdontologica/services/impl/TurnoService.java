package com.example.clinicaOdontologica.services.impl;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.models.Turno;
import com.example.clinicaOdontologica.repositories.ITurnoRepository;
import com.example.clinicaOdontologica.services.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import java.util.List;


public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Turno reservarTurno(Turno turno) {

        return turnoRepository.save(turno);
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<TurnoDTO> listaTurnosDto = new ArrayList<>();
        List<Turno> listaTurnos = turnoRepository.findAll();
        for (Turno turno : listaTurnos) {
            listaTurnosDto.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return listaTurnosDto;
    }

    @Override
    public TurnoDTO buscarTurnoPorId(Integer id) {
        TurnoDTO turnoEncontrado = mapper.convertValue(turnoRepository.findById(id).get(), TurnoDTO.class);
        return turnoEncontrado;
    }

    @Override
    public String eliminarTurnoPorId(Integer id) {
        if(turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
            return "El turno con id " + id + " ha sido eliminado.";
        }
        return "El turno solicitado no se encuentra registrado.";
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.saveAndFlush(turno);
    }
}
