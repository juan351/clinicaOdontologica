package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/* TurnoDTO devuelve un objeto con una instancia de OdontologoDTO y de PacienteDTO, junto con la fecha y hora
* del turno reservado. Con ignoreUnknown se indica que ignore los atributos no mapeados desde el objeto Turno.*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private OdontologoDTO odontologo;
    private PacienteDTO paciente;
    private LocalDateTime fechaHora;

    public TurnoDTO() {
    }

    public TurnoDTO(OdontologoDTO odontologo, PacienteDTO paciente, LocalDateTime fechaHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }


}
