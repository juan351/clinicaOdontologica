package com.example.clinicaOdontologica.repositories;


import com.example.clinicaOdontologica.models.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
