package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.TecnicoEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TecnicoEspecialidadRepository extends JpaRepository<TecnicoEspecialidad, Integer> {
    @Query("SELECT te.tecnico FROM TecnicoEspecialidad te " +
            "JOIN te.tecnico t " +
            "JOIN te.especialidad e " +
            "JOIN t.incidentes i " +
            "WHERE e.idEspecialidad = :especialidadId " +
            "AND i.estado = 'FINALIZADO' " +
            "AND i.fechaEstimadaResolucion >= :startDate " +
            "AND i.fechaEstimadaResolucion <= :endDate " +
            "GROUP BY te.tecnico.idTecnico " +
            "ORDER BY COUNT(i.idIncidente) DESC")
    Tecnico findTecnicoConMasIncidentesResueltosDeEspecialidadEnUltimosNDias(@Param("especialidadId") int especialidadId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
