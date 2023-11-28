package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Especialidad;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.EstadoEnum;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente,Integer> {
    List<Incidente> findByFechaEstimadaResolucionAfter(Date fecha);

    List<Incidente> findByEstadoAndFechaEstimadaResolucionGreaterThan(String estado, Date fechaEstimadaResolucion);

    List<Incidente> findByEstadoAndFechaEstimadaResolucionGreaterThanAndEspecialidad(
            EstadoEnum estado, Date fechaEstimadaResolucion, Optional<Especialidad> especialidad);
}
