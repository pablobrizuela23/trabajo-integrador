package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.DetalleIncidente;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DetalleIncidenteRepository extends JpaRepository<DetalleIncidente, Integer> {

    @Query("SELECT i.tecnico FROM Incidente i " +
            "WHERE i.estado = 'FINALIZADO' " +
            "AND i.fechaEstimadaResolucion >= :startDate " +
            "AND i.fechaEstimadaResolucion <= :endDate " +
            "ORDER BY TIMESTAMPDIFF(HOUR, i.fechaIngreso, i.fechaEstimadaResolucion) ASC")
    Tecnico findTecnicoQueMasRapidoResolvioIncidentesEnUltimosNDias(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
