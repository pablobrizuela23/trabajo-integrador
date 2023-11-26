package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
    @Query("SELECT i.tecnico FROM Incidente i WHERE i.estado = 'FINALIZADO' AND i.fechaEstimadaResolucion > :fechaIngreso GROUP BY i.tecnico ORDER BY COUNT(i) DESC")
    List<Tecnico> findTecnicosConMasIncidentesResueltosUltimosNDias(@Param("fechaIngreso") Date fechaIngreso, Pageable pageable);
}
