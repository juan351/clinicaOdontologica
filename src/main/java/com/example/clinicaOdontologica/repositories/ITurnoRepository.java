package com.example.clinicaOdontologica.repositories;


import com.example.clinicaOdontologica.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
