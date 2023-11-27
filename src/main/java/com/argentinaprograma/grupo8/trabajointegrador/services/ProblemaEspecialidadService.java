package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.ProblemaEspecialidad;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.ProblemaEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemaEspecialidadService {
    private final ProblemaEspecialidadRepository problemaEspecialidadRepository;

    @Autowired
    public ProblemaEspecialidadService(ProblemaEspecialidadRepository problemaEspecialidadRepository) {
        this.problemaEspecialidadRepository = problemaEspecialidadRepository;
    }

    public List<ProblemaEspecialidad> obtenerTodosProblemasEspecialidad() {
        return problemaEspecialidadRepository.findAll();
    }

    public Optional<ProblemaEspecialidad> obtenerProblemaEspecialidadPorId(Integer id) {
        return problemaEspecialidadRepository.findById(id);
    }

    public ProblemaEspecialidad guardarProblemaEspecialidad(ProblemaEspecialidad problemaEspecialidad) {
        return problemaEspecialidadRepository.save(problemaEspecialidad);
    }

    public void eliminarProblemaEspecialidadPorId(Integer id) {
        problemaEspecialidadRepository.deleteById(id);
    }
}
