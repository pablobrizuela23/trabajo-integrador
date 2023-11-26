package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeProblema extends JpaRepository<TipoDeProblema,Integer> {
}
