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
}
