package com.example.clinicaOdontologica.models;


import javax.persistence.*;

/* Indicamos a Spring que estamos trabajando con una Entidad que tiene una tabla correspondiente en la base de datos. */
@Entity
@Table
public class Domicilio {

    /* Indicamos que el atributo id será la Id en la base de datos. Generamos su número automática y secuencialmente
    * a través de su propio SequenceGenerator.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* Según las especificaciones, cada domicilio consta de calle, número, localidad y provincia. */
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    /* Constructor vacío requerido por Hibernate. */
    public Domicilio() {
    }

    /* Constructor del Objeto Domicilio */

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    /* Getters y Setters */

    public Integer getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
