package com.argentinaprograma.grupo8.trabajointegrador;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.services.TecnicoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TrabajoIntegradorApplication implements CommandLineRunner {
	private TecnicoService tecnicoService;
	public static void main(String[] args)
	{
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
		System.out.println("anda");

	}

	@Override
	public void run(String... args) {
		int ultimosNDias = 7; // Definir el número de días

		// a. Quién fue el técnico con más incidentes resueltos en los últimos N días
		List<Tecnico> tecnicosMasIncidentesUltimosNDias = tecnicoService.obtenerTecnicosConMasIncidentesResueltosUltimosNDias(ultimosNDias);
		if (!tecnicosMasIncidentesUltimosNDias.isEmpty()) {
			Tecnico tecnicoMasIncidentes = tecnicosMasIncidentesUltimosNDias.get(0);
			System.out.println("Técnico con más incidentes resueltos en los últimos " + ultimosNDias + " días: " + tecnicoMasIncidentes.getNombre() + " " + tecnicoMasIncidentes.getApellido());
		} else {
			System.out.println("No se encontraron técnicos con incidentes resueltos en los últimos " + ultimosNDias + " días.");
		}

		 //b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
		// Suponiendo que tienes la especialidadId de la especialidad deseada y un método en TecnicoService para esta consulta
//		int especialidadId = 1; // Reemplazar con el ID de la especialidad deseada
//		List<Tecnico> tecnicosMasIncidentesEspecialidadUltimosNDias = tecnicoService.obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(especialidadId, ultimosNDias);
//		if (!tecnicosMasIncidentesEspecialidadUltimosNDias.isEmpty()) {
//			Tecnico tecnicoMasIncidentesEspecialidad = tecnicosMasIncidentesEspecialidadUltimosNDias.get(0);
//			System.out.println("Técnico con más incidentes resueltos de la especialidad en los últimos " + ultimosNDias + " días: " + tecnicoMasIncidentesEspecialidad.getNombre() + " " + tecnicoMasIncidentesEspecialidad.getApellido());
//		} else {
//			System.out.println("No se encontraron técnicos con incidentes resueltos de la especialidad en los últimos " + ultimosNDias + " días.");
//		}
//
//		// c. Quién fue el técnico que más rápido resolvió los incidentes
//		Tecnico tecnicoMasRapido = tecnicoService.obtenerTecnicoConResolucionMasRapida();
//		if (tecnicoMasRapido != null) {
//			System.out.println("Técnico que más rápido resolvió los incidentes: " + tecnicoMasRapido.getNombre() + " " + tecnicoMasRapido.getApellido());
//		} else {
//			System.out.println("No se encontraron técnicos con incidentes resueltos.");
//		}
	}
}
