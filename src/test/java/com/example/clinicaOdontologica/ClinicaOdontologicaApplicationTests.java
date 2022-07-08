package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.models.Domicilio;
import com.example.clinicaOdontologica.models.Odontologo;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.services.impl.OdontologoService;
import com.example.clinicaOdontologica.services.impl.PacienteService;
import com.example.clinicaOdontologica.services.impl.TurnoService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ClinicaOdontologicaApplicationTests {

	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private OdontologoService odontologoService;
	@Autowired
	private TurnoService turnoService;

	@Test
	public void cargarOdontologos() {
		Odontologo odontologo = new Odontologo("Juan", "Pérez", "MA2334");
		odontologoService.guardarOdontologo(odontologo);

		Odontologo odontologo2 = new Odontologo("Martina", "López", "SA2125");
		odontologoService.guardarOdontologo(odontologo2);
	}

	@Test
	public void cargarPaciente() {
		Domicilio domicilio = new Domicilio("Corrientes", "348", "CABA", "CABA");
		Paciente paciente = new Paciente("Ratón", "Pérez", "traficantededientes@gmail.com","30734231", LocalDate.of(2020, 02, 04), domicilio);
		pacienteService.guardarPaciente(paciente);

	}

}
