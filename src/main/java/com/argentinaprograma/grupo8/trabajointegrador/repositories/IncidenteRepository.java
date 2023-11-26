package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente,Integer> {
    List<Incidente> findByFechaEstimadaResolucionAfter(Date fecha);
}
