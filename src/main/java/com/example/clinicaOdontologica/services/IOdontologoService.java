package com.example.clinicaOdontologica.services;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.models.Odontologo;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IOdontologoService {
    List<OdontologoDTO> listarOdontologos();

    ResponseEntity<?> buscarPorId(Integer id);

    Odontologo guardarOdontologo(Odontologo odontologoNuevo);

    ResponseEntity<?> eliminarPorId(Integer id);


    Odontologo actualizarOdontologo(Odontologo odontologo);
}
