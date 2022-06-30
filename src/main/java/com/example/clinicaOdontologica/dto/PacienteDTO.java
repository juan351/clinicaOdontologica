package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Integer id;
    private String apellido;
    private String nombre;

    private String email;


    public PacienteDTO() {
    }

    public PacienteDTO(Integer id, String apellido, String nombre, String email) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;

    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
