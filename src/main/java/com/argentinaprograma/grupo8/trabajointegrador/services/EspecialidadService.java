package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Especialidad;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.EspecialidadRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {
    private EspecialidadRepository especialidadRepository;
    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }
    public List<Especialidad> obtenerEspecialidad(){
        return especialidadRepository.findAll();
    }
    public Optional<Especialidad> obtenerEspecialidadPorId(Integer id){
        return especialidadRepository.findById(id);
    }
    public Especialidad guardarEspecialidad(Especialidad especialidad){
        return especialidadRepository.save(especialidad);
    }
}
