package com.example.clinicaOdontologica.repositories;

import com.example.clinicaOdontologica.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
