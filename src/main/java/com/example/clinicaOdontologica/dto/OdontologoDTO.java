package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* OdontologoDTO devuelve los mismos datos que el objeto Odontologo, pero se deja abierta la posibilidad de que no retorne
 * datos nuevos en caso de que se agreguen nuevos atributos al objeto Odontologo. Con ignoreUnknown
 * se le indica que ignore los atributos no mapeados desde el objeto Paciente.*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    public OdontologoDTO() {
    }

    public OdontologoDTO(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }
}
