package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.TecnicoEspecialidad;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TecnicoEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoEspecialidadService {
    private final TecnicoEspecialidadRepository tecnicoEspecialidadRepository;

    @Autowired
    public TecnicoEspecialidadService(TecnicoEspecialidadRepository tecnicoEspecialidadRepository) {
        this.tecnicoEspecialidadRepository = tecnicoEspecialidadRepository;
    }

    public List<TecnicoEspecialidad> obtenerTodosTecnicosEspecialidad() {
        return tecnicoEspecialidadRepository.findAll();
    }

    public Optional<TecnicoEspecialidad> obtenerTecnicoEspecialidadPorId(Integer id) {
        return tecnicoEspecialidadRepository.findById(id);
    }

    public TecnicoEspecialidad guardarTecnicoEspecialidad(TecnicoEspecialidad tecnicoEspecialidad) {
        return tecnicoEspecialidadRepository.save(tecnicoEspecialidad);
    }

    public void eliminarTecnicoEspecialidadPorId(Integer id) {
        tecnicoEspecialidadRepository.deleteById(id);
    }
}
