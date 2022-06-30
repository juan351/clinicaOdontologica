package com.example.clinicaOdontologica.services;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.models.Turno;

import java.util.List;

public interface ITurnoService {

    Turno reservarTurno(Turno turno);
    List<TurnoDTO> listarTurnos();
    TurnoDTO buscarTurnoPorId(Integer id);
    String eliminarTurnoPorId(Integer id);
    Turno actualizarTurno(Turno turno);
}
