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
        Date fechaMasTemprana = null;
        Tecnico tecnicoMasRapido = null;

        List<Incidente> incidentes = incidenteService.obtenerIncidentes();

        for (Incidente incidente : incidentes) {
            Date fechaEstimada = incidente.getFechaEstimadaResolucion();
            if (fechaEstimada != null && (fechaMasTemprana == null || fechaEstimada.before(fechaMasTemprana))) {
                fechaMasTemprana = fechaEstimada; // Actualizar la fecha más temprana
                tecnicoMasRapido = incidente.getTecnico(); // Obtener el técnico asociado al incidente más rápido
            }
        }
        return tecnicoMasRapido; // Devolver el técnico con la resolución más rápida
    }
    /*public Tecnico obtenerTecnicoConResolucionMasRapida() {
        return incidenteService.obtenerIncidentes().stream()
                .filter(incidente -> incidente.getFechaEstimadaResolucion() != null)
                .min(Comparator.comparing(Incidente::getFechaEstimadaResolucion))
                .map(Incidente::getTecnico)
                .orElse(null);
    }*/
    public List<Tecnico> obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(int especialidadId, int ultimosNDias) {
        Optional<Especialidad> especialidadOptional = especialidadService.obtenerEspecialidadPorId(especialidadId);
        if (especialidadOptional.isEmpty()) {
            return Collections.emptyList(); // O cualquier otro manejo de error que necesites
        }
        Especialidad especialidad = especialidadOptional.get();
        List<Incidente> incidentesResueltos = incidenteService.obtenerIncidentesResueltosPorEspecialidadYDias(Optional.of(especialidad), ultimosNDias);
        Map<Tecnico, Long> mapaIncidentesPorTecnico = incidentesResueltos.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

        if (mapaIncidentesPorTecnico.isEmpty()) {
            return Collections.emptyList();
        }
        long maxIncidentes = Collections.max(mapaIncidentesPorTecnico.values());
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

