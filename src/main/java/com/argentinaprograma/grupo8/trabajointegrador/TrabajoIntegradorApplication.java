package com.argentinaprograma.grupo8.trabajointegrador;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.*;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.*;
import com.argentinaprograma.grupo8.trabajointegrador.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TrabajoIntegradorApplication implements CommandLineRunner {

	private final TecnicoService tecnicoService;
	private final IncidenteService incidenteService;
	private final ClienteService clienteService;
	private final ServicioService servicioService;
	private final DetalleIncidenteService detalleIncidenteService;
	private final EspecialidadService especialidadService;
	private final TipoDeProblemaService tipoDeProblemaService;
	private final ClienteServicioService clienteServicioService;
	private final MedioDeComunicacionService medioDeComunicacionService;
	private final TecnicoEspecialidadService tecnicoEspecialidadService;
	private final ProblemaEspecialidadService problemaEspecialidadService;

	@Autowired
	public TrabajoIntegradorApplication(TecnicoService tecnicoService,
										IncidenteService incidenteService,
										ClienteService clienteService,
										ServicioService servicioService,
										DetalleIncidenteService detalleIncidenteService,
										EspecialidadService especialidadService,
										TipoDeProblemaService tipoDeProblemaService,
										ClienteServicioService clienteServicioService,
										MedioDeComunicacionService medioDeComunicacionService,
										TecnicoEspecialidadService tecnicoEspecialidadService,
										ProblemaEspecialidadService problemaEspecialidadService) {
		this.tecnicoService = tecnicoService;
		this.incidenteService = incidenteService;
		this.clienteService = clienteService;
		this.servicioService = servicioService;
		this.detalleIncidenteService = detalleIncidenteService;
		this.especialidadService = especialidadService;
		this.tipoDeProblemaService = tipoDeProblemaService;
		this.clienteServicioService = clienteServicioService;
		this.medioDeComunicacionService = medioDeComunicacionService;
		this.tecnicoEspecialidadService = tecnicoEspecialidadService;
		this.problemaEspecialidadService = problemaEspecialidadService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
		System.out.println("anda");
	}

	@Override
	public void run(String... args) {
		// Crear instancias de cada clase con sus atributos

		// Crear tres instancias de Cliente
		Cliente cliente1 = new Cliente();
		cliente1.setCuit(12345678901L);
		cliente1.setEmail("cliente1@example.com");
		cliente1.setRazonSocial("Razón Social Cliente 1");
		cliente1.setNombre("Nombre Cliente 1");
		cliente1.setApellido("Apellido Cliente 1");

		Cliente cliente2 = new Cliente();
		cliente2.setCuit(98765432109L);
		cliente2.setEmail("cliente2@example.com");
		cliente2.setRazonSocial("Razón Social Cliente 2");
		cliente2.setNombre("Nombre Cliente 2");
		cliente2.setApellido("Apellido Cliente 2");

		Cliente cliente3 = new Cliente();
		cliente3.setCuit(1357924680L);
		cliente3.setEmail("cliente3@example.com");
		cliente3.setRazonSocial("Razón Social Cliente 3");
		cliente3.setNombre("Nombre Cliente 3");
		cliente3.setApellido("Apellido Cliente 3");

		// Guardar clientes en la base de datos utilizando el servicio ClienteService
		clienteService.guardarCliente(cliente1);
		clienteService.guardarCliente(cliente2);
		clienteService.guardarCliente(cliente3);

		// Crear tres instancias de Especialidad con todos sus atributos
		Especialidad especialidad1 = new Especialidad();
		especialidad1.setNombre("Especialidad 1");
		especialidad1.setDescripcion("Descripción de la especialidad 1");

		Especialidad especialidad2 = new Especialidad();
		especialidad2.setNombre("Especialidad 2");
		especialidad2.setDescripcion("Descripción de la especialidad 2");

		Especialidad especialidad3 = new Especialidad();
		especialidad3.setNombre("Especialidad 3");
		especialidad3.setDescripcion("Descripción de la especialidad 3");

		// Guardar las instancias de Especialidad en la base de datos
		especialidadService.guardarEspecialidad(especialidad1);
		especialidadService.guardarEspecialidad(especialidad2);
		especialidadService.guardarEspecialidad(especialidad3);


		// Crear tres instancias de TipoDeProblema con todos sus atributos
		TipoDeProblema tipoDeProblema1 = new TipoDeProblema();
		tipoDeProblema1.setTipo("Tipo 1");
		tipoDeProblema1.setTiempoEstimado(30);
		tipoDeProblema1.setTiempoMaximo(60);

		TipoDeProblema tipoDeProblema2 = new TipoDeProblema();
		tipoDeProblema2.setTipo("Tipo 2");
		tipoDeProblema2.setTiempoEstimado(45);
		tipoDeProblema2.setTiempoMaximo(90);

		TipoDeProblema tipoDeProblema3 = new TipoDeProblema();
		tipoDeProblema3.setTipo("Tipo 3");
		tipoDeProblema3.setTiempoEstimado(60);
		tipoDeProblema3.setTiempoMaximo(120);

		// Guardar las instancias de TipoDeProblema en la base de datos
		tipoDeProblemaService.guardarTipoDeProblema(tipoDeProblema1);
		tipoDeProblemaService.guardarTipoDeProblema(tipoDeProblema2);
		tipoDeProblemaService.guardarTipoDeProblema(tipoDeProblema3);

		// Crear tres instancias de Servicio con todos sus atributos
		Servicio servicio1 = new Servicio();
		servicio1.setNombre("Servicio 1");
		servicio1.setDescripcion("Descripción del Servicio 1");

		Servicio servicio2 = new Servicio();
		servicio2.setNombre("Servicio 2");
		servicio2.setDescripcion("Descripción del Servicio 2");

		Servicio servicio3 = new Servicio();
		servicio3.setNombre("Servicio 3");
		servicio3.setDescripcion("Descripción del Servicio 3");

		servicioService.guardarServicio(servicio1);
		servicioService.guardarServicio(servicio2);
		servicioService.guardarServicio(servicio3);

		// Crear tres instancias de ClienteServicio con todos sus atributos
		ClienteServicio clienteServicio1 = new ClienteServicio();
		clienteServicio1.setCliente(cliente1); // Suponiendo que tienes un objeto Cliente llamado cliente1
		clienteServicio1.setServicio(servicio1); // Suponiendo que tienes un objeto Servicio llamado servicio1

		ClienteServicio clienteServicio2 = new ClienteServicio();
		clienteServicio2.setCliente(cliente2); // Suponiendo que tienes un objeto Cliente llamado cliente2
		clienteServicio2.setServicio(servicio2); // Suponiendo que tienes un objeto Servicio llamado servicio2

		ClienteServicio clienteServicio3 = new ClienteServicio();
		clienteServicio3.setCliente(cliente3); // Suponiendo que tienes un objeto Cliente llamado cliente3
		clienteServicio3.setServicio(servicio3); // Suponiendo que tienes un objeto Servicio llamado servicio3

		clienteServicioService.guardarClienteServicio(clienteServicio1);
		clienteServicioService.guardarClienteServicio(clienteServicio2);
		clienteServicioService.guardarClienteServicio(clienteServicio3);

		// Crear tres instancias de Tecnico
		Tecnico tecnico1 = new Tecnico();
		tecnico1.setNombre("Nombre Técnico 1");
		tecnico1.setApellido("Apellido Técnico 1");

		Tecnico tecnico2 = new Tecnico();
		tecnico2.setNombre("Nombre Técnico 2");
		tecnico2.setApellido("Apellido Técnico 2");

		Tecnico tecnico3 = new Tecnico();
		tecnico3.setNombre("Nombre Técnico 3");
		tecnico3.setApellido("Apellido Técnico 3");

		tecnicoService.guardarTecnico(tecnico3);
		tecnicoService.guardarTecnico(tecnico2);
		tecnicoService.guardarTecnico(tecnico1);

		// Crear tres instancias de MedioDeComunicacion
		MedioDeComunicacion medioDeComunicacion1 = new MedioDeComunicacion();
		medioDeComunicacion1.setMedio(MedioEnum.EMAIL);
		medioDeComunicacion1.setContacto("contacto1@ejemplo.com");

		MedioDeComunicacion medioDeComunicacion2 = new MedioDeComunicacion();
		medioDeComunicacion2.setMedio(MedioEnum.WHATSAPP);
		medioDeComunicacion2.setContacto("123456789"); // Número de WhatsApp de ejemplo

		MedioDeComunicacion medioDeComunicacion3 = new MedioDeComunicacion();
		medioDeComunicacion3.setMedio(MedioEnum.EMAIL);
		medioDeComunicacion3.setContacto("contacto3@ejemplo.com");

		medioDeComunicacionService.guardarMedioDeComunicacion(medioDeComunicacion1);
		medioDeComunicacionService.guardarMedioDeComunicacion(medioDeComunicacion2);
		medioDeComunicacionService.guardarMedioDeComunicacion(medioDeComunicacion3);

		// Crear tres instancias de TecnicoEspecialidad con los objetos previamente creados
		TecnicoEspecialidad tecnicoEspecialidad1 = new TecnicoEspecialidad();
		tecnicoEspecialidad1.setTecnico(tecnico1);
		tecnicoEspecialidad1.setEspecialidad(especialidad1);

		TecnicoEspecialidad tecnicoEspecialidad2 = new TecnicoEspecialidad();
		tecnicoEspecialidad2.setTecnico(tecnico2);
		tecnicoEspecialidad2.setEspecialidad(especialidad2);

		TecnicoEspecialidad tecnicoEspecialidad3 = new TecnicoEspecialidad();
		tecnicoEspecialidad3.setTecnico(tecnico3);
		tecnicoEspecialidad3.setEspecialidad(especialidad3);

		tecnicoEspecialidadService.guardarTecnicoEspecialidad(tecnicoEspecialidad1);
		tecnicoEspecialidadService.guardarTecnicoEspecialidad(tecnicoEspecialidad2);
		tecnicoEspecialidadService.guardarTecnicoEspecialidad(tecnicoEspecialidad3);

		// Suponiendo que tienes instancias de TipoDeProblema y Especialidad previamente creadas: tipoDeProblema1, tipoDeProblema2, tipoDeProblema3, especialidad1, especialidad2, especialidad3

		ProblemaEspecialidad problemaEspecialidad1 = new ProblemaEspecialidad();
		problemaEspecialidad1.setTipoDeProblema(tipoDeProblema1);
		problemaEspecialidad1.setEspecialidad(especialidad1);

		ProblemaEspecialidad problemaEspecialidad2 = new ProblemaEspecialidad();
		problemaEspecialidad2.setTipoDeProblema(tipoDeProblema2);
		problemaEspecialidad2.setEspecialidad(especialidad2);

		ProblemaEspecialidad problemaEspecialidad3 = new ProblemaEspecialidad();
		problemaEspecialidad3.setTipoDeProblema(tipoDeProblema3);
		problemaEspecialidad3.setEspecialidad(especialidad3);

		problemaEspecialidadService.guardarProblemaEspecialidad(problemaEspecialidad1);
		problemaEspecialidadService.guardarProblemaEspecialidad(problemaEspecialidad2);
		problemaEspecialidadService.guardarProblemaEspecialidad(problemaEspecialidad3);

		// Crear tres instancias de Incidente
		Incidente incidente1 = new Incidente();
		incidente1.setTitulo("Incidente 1");
		incidente1.setDescripcion("Descripción del incidente 1");
		incidente1.setFechaIngreso(new Date()); // Aquí asignamos la fecha actual, puedes usar la que corresponda
		incidente1.setEstado(EstadoEnum.INCOMPLETO);
		incidente1.setConsideraciones("Consideraciones del incidente 1");
		incidente1.setCliente(cliente1);
		incidente1.setServicio(servicio1);
		incidente1.setTecnico(tecnico1);

		Incidente incidente2 = new Incidente();
		incidente2.setTitulo("Incidente 2");
		incidente2.setDescripcion("Descripción del incidente 2");
		incidente2.setFechaIngreso(new Date()); // Aquí asignamos la fecha actual, puedes usar la que corresponda
		incidente2.setEstado(EstadoEnum.EN_PROCESO);
		incidente2.setConsideraciones("Consideraciones del incidente 2");
		incidente2.setCliente(cliente2);
		incidente2.setServicio(servicio2);
		incidente2.setTecnico(tecnico2);

		Incidente incidente3 = new Incidente();
		incidente3.setTitulo("Incidente 3");
		incidente3.setDescripcion("Descripción del incidente 3");
		incidente3.setFechaIngreso(new Date()); // Aquí asignamos la fecha actual, puedes usar la que corresponda
		incidente3.setEstado(EstadoEnum.FINALIZADO);
		incidente3.setConsideraciones("Consideraciones del incidente 3");
		incidente3.setCliente(cliente3);
		incidente3.setServicio(servicio3);
		incidente3.setTecnico(tecnico3);

		incidenteService.guardarIncidente(incidente1);
		incidenteService.guardarIncidente(incidente2);
		incidenteService.guardarIncidente(incidente3);

		// Crear tres instancias de DetalleIncidente
		DetalleIncidente detalleIncidente1 = new DetalleIncidente();
		detalleIncidente1.setDescripcion("Detalle del incidente 1");
		detalleIncidente1.setIncidente(incidente1);
		detalleIncidente1.setServicio(servicio1);
		detalleIncidente1.setTipoProblema(tipoDeProblema1);

		DetalleIncidente detalleIncidente2 = new DetalleIncidente();
		detalleIncidente2.setDescripcion("Detalle del incidente 2");
		detalleIncidente2.setIncidente(incidente2);
		detalleIncidente2.setServicio(servicio2);
		detalleIncidente2.setTipoProblema(tipoDeProblema2);

		DetalleIncidente detalleIncidente3 = new DetalleIncidente();
		detalleIncidente3.setDescripcion("Detalle del incidente 3");
		detalleIncidente3.setIncidente(incidente3);
		detalleIncidente3.setServicio(servicio3);
		detalleIncidente3.setTipoProblema(tipoDeProblema3);

		detalleIncidenteService.guardarDetalleIncidente(detalleIncidente1);
		detalleIncidenteService.guardarDetalleIncidente(detalleIncidente2);
		detalleIncidenteService.guardarDetalleIncidente(detalleIncidente3);

		// Realizar las consultas solicitadas

		int ultimosNDias = 30; // Definir el número de días

		// a. Quién fue el técnico con más incidentes resueltos en los últimos N días
		List<Tecnico> tecnicosMasIncidentesUltimosNDias = tecnicoService.obtenerTecnicosConMasIncidentesResueltosUltimosNDias(ultimosNDias);
		if (!tecnicosMasIncidentesUltimosNDias.isEmpty()) {
			Tecnico tecnicoMasIncidentes = tecnicosMasIncidentesUltimosNDias.get(0);
			System.out.println("Técnico con más incidentes resueltos en los últimos " + ultimosNDias + " días: " + tecnicoMasIncidentes.getNombre());
		} else {
			System.out.println("No se encontraron técnicos con incidentes resueltos en los últimos " + ultimosNDias + " días.");
		}

		// b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
		int especialidadId = 1; // Reemplazar con el ID de la especialidad deseada
		List<Tecnico> tecnicosMasIncidentesEspecialidadUltimosNDias = tecnicoService.obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(especialidadId, ultimosNDias);
		if (!tecnicosMasIncidentesEspecialidadUltimosNDias.isEmpty()) {
			Tecnico tecnicoMasIncidentesEspecialidad = tecnicosMasIncidentesEspecialidadUltimosNDias.get(0);
			System.out.println("Técnico con más incidentes resueltos de la especialidad en los últimos " + ultimosNDias + " días: " + tecnicoMasIncidentesEspecialidad.getNombre());
		} else {
			System.out.println("No se encontraron técnicos con incidentes resueltos de la especialidad en los últimos " + ultimosNDias + " días.");
		}

		// c. Quién fue el técnico que más rápido resolvió los incidentes
		Tecnico tecnicoMasRapido = tecnicoService.obtenerTecnicoConResolucionMasRapida();
		if (tecnicoMasRapido != null) {
			System.out.println("Técnico que más rápido resolvió los incidentes: " + tecnicoMasRapido.getNombre());
		} else {
			System.out.println("No se encontraron técnicos con incidentes resueltos.");
		}
	}
}
