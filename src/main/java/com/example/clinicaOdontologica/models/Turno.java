package com.example.clinicaOdontologica.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/* Indicamos a Spring que estamos trabajando con una Entidad que tiene una tabla correspondiente en la base de datos. */
@Entity
@Table
public class Turno {

    /* Indicamos que el atributo id será la Id en la base de datos. Generamos su número automática y secuencialmente
     * a través de su propio SequenceGenerator.*/
    @Id
    @SequenceGenerator(name="turno_generator", sequenceName = "turno_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_generator")
    private Integer idTurno;

    /* Un turno tiene un odontólogo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false, referencedColumnName = "id")
    private Odontologo odontologo;

    /* Un turno tiene un paciente */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id")
    private Paciente paciente;

    /* Un turno tiene fecha y hora */
    private LocalDateTime fechaHora;

    /* Constructor vacío requerido por Hibernate. */
    public Turno() {
    }

    /* Constructor del objeto Turno. */
    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fechaHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }

    /* Getters y setters */
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
