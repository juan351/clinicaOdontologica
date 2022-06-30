package com.example.clinicaOdontologica.services;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.models.Odontologo;


import java.util.List;

public interface IOdontologoService {
    List<OdontologoDTO> listarOdontologos();

    OdontologoDTO buscarPorId(Integer id);

    Odontologo guardarOdontologo(Odontologo odontologoNuevo);

    String eliminarPorId(Integer id);


    Odontologo actualizarOdontologo(Odontologo odontologo);
}
