package com.argentinaprograma.grupo8.trabajointegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioDeComunicacionRepository extends JpaRepository<com.argentinaprograma.grupo8.trabajointegrador.modelo.MedioDeComunicacion,Integer> {
}
