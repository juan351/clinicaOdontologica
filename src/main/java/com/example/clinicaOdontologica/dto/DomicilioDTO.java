package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* DomicilioDTO devuelve unicamente localidad y provincia de cada paciente. El mapeo con la clase Domicilio se
* produce desde el servicio de Paciente, junto con el mapeo de Paciente a PacienteDTO. El ignoreUnknown solicita
* que se ignoren los atributos no mapeados desde Domiclio. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {

    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }

    public DomicilioDTO(String localidad, String provincia) {

        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
