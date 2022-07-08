package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* PacienteDTO devuelve una versión reducida de los datos del paciente, excluyendo DNI y domicilio. Con ignoreUnknown
* se le indica que ignore los atributos no mapeados desde el objeto Paciente.*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Integer id;
    private String apellido;
    private String nombre;

    private String email;

    private DomicilioDTO domicilio;


    public PacienteDTO() {
    }

    public PacienteDTO(Integer id, String apellido, String nombre, String email, DomicilioDTO domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.domicilio = domicilio;

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

    public DomicilioDTO getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDTO domicilio) {
        this.domicilio = domicilio;
    }
}
