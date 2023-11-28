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
}
