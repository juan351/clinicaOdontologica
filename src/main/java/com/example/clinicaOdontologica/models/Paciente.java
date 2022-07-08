package com.example.clinicaOdontologica.models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/* Indicamos a Spring que estamos trabajando con una Entidad que tiene una tabla correspondiente en la base de datos. */
@Entity
@Table(name="paciente")
public class Paciente {

    /* Indicamos que el atributo id será la Id en la base de datos. Generamos su número automática y secuencialmente
     * a través de su propio SequenceGenerator.*/
    @Id
            @SequenceGenerator(name="paciente_generator", sequenceName = "paciente_generator")
            @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_generator")
    private Integer id;

    /* Un paciente tiene apellido, nombre, email, dni y una fecha de ingreso. */
    private String apellido;
    private String nombre;
    private String email;
    private String dni;

    private LocalDate fechaIngreso;

    /* Cada paciente tiene un domicilio, en este caso guardado en una tabla diferente y recuperado mediente
    el atributo domicilio. */

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    /* Un paciente puede tener asignados muchos turnos, que serán recuperados mediente el Set turnos*/
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    /* Constructor vacío requerido por Hibernate. */
    public Paciente() {
    }

    /* Constructor del objeto Paciente. */

    public Paciente(String apellido, String nombre, String email, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    /* Getters y Setters */
    public String getDni() {
        return dni;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
