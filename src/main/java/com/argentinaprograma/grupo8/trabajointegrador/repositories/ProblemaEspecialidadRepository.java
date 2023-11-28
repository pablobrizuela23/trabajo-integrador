package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.ProblemaEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProblemaEspecialidadRepository extends JpaRepository<ProblemaEspecialidad, Integer> {
}
