package com.example.clinicaOdontologica.services.impl;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.models.Turno;
import com.example.clinicaOdontologica.repositories.ITurnoRepository;
import com.example.clinicaOdontologica.services.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
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
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        for (Turno turno : listaTurnos) {
            listaTurnosDto.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return listaTurnosDto;
    }

    @Override
    public ResponseEntity<?> buscarTurnoPorId(Integer id) {
        TurnoDTO turnoEncontrado = mapper.convertValue(turnoRepository.findById(id).get(), TurnoDTO.class);
        if (turnoEncontrado != null){
            return new ResponseEntity<TurnoDTO>(turnoEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity("No se ha encontrado ningún turno", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> eliminarTurnoPorId(Integer id) {
        if(turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
            return new ResponseEntity("El turno ha sido eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity("El turno no se encuentra registrado.", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }
}
