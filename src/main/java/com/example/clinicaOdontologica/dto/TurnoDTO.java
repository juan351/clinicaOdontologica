package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private OdontologoDTO odontologo;
    private PacienteDTO paciente;
    private String fechaHora;

    public TurnoDTO() {
    }

    public TurnoDTO(OdontologoDTO odontologo, PacienteDTO paciente, String fechaHora) {
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

    public String getFechaHora() {
        return fechaHora;
    }


}
