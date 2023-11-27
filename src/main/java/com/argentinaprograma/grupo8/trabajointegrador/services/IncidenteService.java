package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Especialidad;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.EstadoEnum;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.IncidenteRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenteService {

    private IncidenteRepository incidenteRepository;
    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    public List<Incidente> obtenerIncidentes(){
        return incidenteRepository.findAll();

    }

    public Optional<Incidente> obtenerProblemaPorId(Integer id){
        return incidenteRepository.findById(id);

    }

    public Incidente guardarIncidente(Incidente incidente){
        return incidenteRepository.save(incidente);

    }

    public List<Incidente> obtenerIncidentesResueltosPorEspecialidadYDias(Optional<Especialidad> especialidad, int ultimosNDias) {
        Date fechaLimite = calcularFechaLimite(ultimosNDias);

        List<Incidente> incidentes = incidenteRepository.findByEstadoAndFechaEstimadaResolucionGreaterThanAndEspecialidad(
                EstadoEnum.FINALIZADO, fechaLimite, especialidad);
        return incidentes;
    }

    public static Date calcularFechaLimite(int ultimosNDias) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Restar el número de días
        LocalDate fechaLimite = fechaActual.minusDays(ultimosNDias);

        // Convertir de LocalDate a Date
        return java.sql.Date.valueOf(fechaLimite);
    }

}
