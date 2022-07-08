package com.example.clinicaOdontologica.services;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.models.Turno;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITurnoService {

    Turno reservarTurno(Turno turno);
    List<TurnoDTO> listarTurnos();
    ResponseEntity<?> buscarTurnoPorId(Integer id);
    ResponseEntity<?> eliminarTurnoPorId(Integer id);
    Turno actualizarTurno(Turno turno);
}
