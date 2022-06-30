package com.example.clinicaOdontologica.controllers;


import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.models.Odontologo;
import com.example.clinicaOdontologica.services.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    public IOdontologoService odontologoService;

    @GetMapping("/todos")
    public List<OdontologoDTO> getTodos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable int id){
        return odontologoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable int id){
        return  odontologoService.eliminarPorId(id);

    }

    @PostMapping("/agregar")
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PostMapping("/actualizar")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo);
    }

}
