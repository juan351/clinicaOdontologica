package com.example.clinicaOdontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/* Indicamos a Spring que estamos trabajando con una Entidad que tiene una tabla correspondiente en la base de datos. */
@Entity
@Table
public class Odontologo {

    /* Indicamos que el atributo id será la Id en la base de datos. Generamos su número automática y secuencialmente
     * a través de su propio SequenceGenerator.*/
    @Id
    @SequenceGenerator(name="odontologo_generator", sequenceName = "odontologo_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_generator")
    private Integer id;

    /* Cada odontólogo posee nombre, apellido y matrícula */
    private String nombre;
    private String apellido;
    private String matricula;

    /* Cada odontólogo puede tener asignados muchos turnos, que serán recuperados mediente listadoTurnos*/
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> listadoTurnos = new HashSet<>();

    /* Constructor vacío requerido por Hibernate. */
    public Odontologo() {
    }

    /* Constructor del objeto Odontólogo. */
    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    /* Getters y Setters */
    public Set<Turno> getListadoTurnos() {
        return listadoTurnos;
    }

    public void setListadoTurnos(Set<Turno> listadoTurnos) {
        this.listadoTurnos = listadoTurnos;
    }

    public Integer getId() {
        return id;
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
}
