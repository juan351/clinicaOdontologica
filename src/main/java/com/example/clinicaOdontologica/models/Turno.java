package com.example.clinicaOdontologica.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Turno {
    @Id
    @SequenceGenerator(name="turno_generator", sequenceName = "turno_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_generator")
    private Integer idTurno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false, referencedColumnName = "id")
    private Odontologo odontologo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id")
    private Paciente paciente;
    private LocalDateTime fechaHora;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fechaHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
