package com.example.clinicaOdontologica.services.impl;


import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.models.Odontologo;
import com.example.clinicaOdontologica.repositories.IOdontologoRepository;
import com.example.clinicaOdontologica.services.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public List<OdontologoDTO> listarOdontologos() {
        List<OdontologoDTO> listaOdontologosDto = new ArrayList<>();
        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        for (Odontologo odontologo : listaOdontologos) {
            listaOdontologosDto.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return listaOdontologosDto;
    }

    @Override
    public OdontologoDTO buscarPorId(Integer id) {
        OdontologoDTO odontologoEncontrado = mapper.convertValue(odontologoRepository.findById(id).get(), OdontologoDTO.class);
        return odontologoEncontrado;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologoNuevo) {
        return odontologoRepository.save(odontologoNuevo);
    }

    @Override
    public String eliminarPorId(Integer id) {
        if(odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
            return "El odontólogo con id " + id + " ha sido eliminado.";
        }
        return "El odontólogo con id " + id + " no existe.";
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
}
