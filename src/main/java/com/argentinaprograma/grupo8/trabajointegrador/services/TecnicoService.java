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
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public List<Tecnico> obtenerTecnicosConMasIncidentesResueltosUltimosNDias(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -dias);
        Date fecha = cal.getTime();
        return tecnicoRepository.findTecnicosConMasIncidentesResueltosUltimosNDias(fecha, PageRequest.of(0,1));
    }

    public Tecnico obtenerTecnicoConResolucionMasRapida() {
        return null;
    }

  /*  public List<Tecnico> obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(int especialidadId, int ultimosNDias) {
        // Obtener la especialidad por su ID


        Optional<Especialidad> especialidad = especialidadService.obtenerEspecialidadPorId(especialidadId);
        if (especialidad == null) {
            // Manejar el caso cuando la especialidad no existe
            return Collections.emptyList(); // O cualquier otro manejo de error que necesites
        }

        // Obtener los incidentes resueltos para la especialidad en los últimos N días
       // List<Incidente> incidentesResueltos = incidenteService.obtenerIncidentesResueltosPorEspecialidadYDias(especialidad, ultimosNDias);

        // Crear un mapa para contar la cantidad de incidentes resueltos por técnico
        Map<Tecnico, Integer> mapaIncidentesPorTecnico = new HashMap<>();

        // Iterar sobre los incidentes y contar la cantidad por técnico
        for (Incidente incidente : incidentesResueltos) {
            Tecnico tecnico = incidente.getTecnico();
            mapaIncidentesPorTecnico.put(tecnico, mapaIncidentesPorTecnico.getOrDefault(tecnico, 0) + 1);
        }

        // Encontrar el máximo número de incidentes resueltos
        int maxIncidentes = Collections.max(mapaIncidentesPorTecnico.values());

        // Filtrar los técnicos que tienen el máximo número de incidentes resueltos
        List<Tecnico> tecnicosConMasIncidentes = mapaIncidentesPorTecnico.entrySet().stream()
                .filter(entry -> entry.getValue() == maxIncidentes)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return tecnicosConMasIncidentes;
    }*/

    public List<Tecnico> obtenerTecnicos(){
        return tecnicoRepository.findAll();

    }

    public Optional<Tecnico> obtenerTecnicoPorId(Integer id){
        return tecnicoRepository.findById(id);

    }

    public Tecnico guardarTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);

    }

//    public List<TipoDeProblema> buscarProblemaPorDescripcion(String descripcion){
//
//        return tipoDeProblema.findByDescripcionProblema(descripcion);
//    }

    public Tecnico obtenerTecnicoConMasIncidentesEnUltimosNDias(Date startDate, Date endDate) {
        return tecnicoRepository.findTecnicoConMasIncidentesResueltosEnUltimosNDias(startDate, endDate);
    }
}
