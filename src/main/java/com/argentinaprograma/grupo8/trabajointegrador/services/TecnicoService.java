package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Especialidad;
import com.argentinaprograma.grupo8.trabajointegrador.services.*;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TecnicoRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class TecnicoService {
    private TecnicoRepository tecnicoRepository;
    private EspecialidadService especialidadService;

    private IncidenteService incidenteService;
    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository, EspecialidadService especialidadService,IncidenteService incidenteService) {
        this.tecnicoRepository = tecnicoRepository;
        this.especialidadService = especialidadService;
        this.incidenteService= incidenteService;
    }
    public List<Tecnico> obtenerTecnicosConMasIncidentesResueltosUltimosNDias(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -dias);
        Date fecha = cal.getTime();
        return tecnicoRepository.findTecnicosConMasIncidentesResueltosUltimosNDias(fecha, PageRequest.of(0,1));
    }

    public Tecnico obtenerTecnicoConResolucionMasRapida() {
        // Variables para almacenar la fecha estimada más temprana y el técnico asociado
        Date fechaMasTemprana = null;
        Tecnico tecnicoMasRapido = null;

        // Obtener todos los incidentes (o podrías tener una función para obtenerlos)
        List<Incidente> incidentes = incidenteService.obtenerIncidentes();

        // Iterar a través de todos los incidentes para encontrar el más rápido
        for (Incidente incidente : incidentes) {
            Date fechaEstimada = incidente.getFechaEstimadaResolucion();

            // Verificar si la fecha actual es menor a la almacenada o si es la primera fecha encontrada
            if (fechaEstimada != null && (fechaMasTemprana == null || fechaEstimada.before(fechaMasTemprana))) {
                fechaMasTemprana = fechaEstimada; // Actualizar la fecha más temprana
                tecnicoMasRapido = incidente.getTecnico(); // Obtener el técnico asociado al incidente más rápido
            }
        }

        return tecnicoMasRapido; // Devolver el técnico con la resolución más rápida
    }

    public List<Tecnico> obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(int especialidadId, int ultimosNDias) {
        // Obtener la especialidad por su ID
        Optional<Especialidad> especialidadOptional = especialidadService.obtenerEspecialidadPorId(especialidadId);

        if (especialidadOptional.isEmpty()) {
            // Manejar el caso cuando la especialidad no existe
            return Collections.emptyList(); // O cualquier otro manejo de error que necesites
        }

        Especialidad especialidad = especialidadOptional.get();

        // Obtener los incidentes resueltos para la especialidad en los últimos N días
        List<Incidente> incidentesResueltos = incidenteService.obtenerIncidentesResueltosPorEspecialidadYDias(Optional.of(especialidad), ultimosNDias);

        // Crear un mapa para contar la cantidad de incidentes resueltos por técnico
        Map<Tecnico, Long> mapaIncidentesPorTecnico = incidentesResueltos.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

        if (mapaIncidentesPorTecnico.isEmpty()) {
            // Manejar el caso cuando no hay incidentes resueltos para la especialidad en los últimos N días
            return Collections.emptyList();
        }

        // Encontrar el máximo número de incidentes resueltos
        long maxIncidentes = Collections.max(mapaIncidentesPorTecnico.values());

        // Filtrar los técnicos que tienen el máximo número de incidentes resueltos
        List<Tecnico> tecnicosConMasIncidentes = mapaIncidentesPorTecnico.entrySet().stream()
                .filter(entry -> entry.getValue() == maxIncidentes)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return tecnicosConMasIncidentes;
    }

    public List<Tecnico> obtenerTecnicos(){
        return tecnicoRepository.findAll();

    }

    public Optional<Tecnico> obtenerTecnicoPorId(Integer id){
        return tecnicoRepository.findById(id);

    }

    public Tecnico guardarTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);

    }

}

