package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Servicio;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.ServicioRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    private ServicioRepository servicioRepository;
    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> obtenerServicios(){
        return servicioRepository.findAll();

    }

    public Optional<Servicio> obtenerServicioPorId(Integer id){
        return servicioRepository.findById(id);

    }

    public Servicio guardarServicio(Servicio servicio){
        return servicioRepository.save(servicio);

    }

//    public List<Servicio> buscarServicioPorDescripcion(String descripcion){
//
//        return servicioRepository.findByDescripcionServicio(descripcion);
//    }
}
