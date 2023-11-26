package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.MedioDeComunicacion;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.MedioDeComunicacionRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedioDeComunicacionService {

    private MedioDeComunicacionRepository medioDeComunicacionRepository;
    @Autowired
    public MedioDeComunicacionService(MedioDeComunicacionService medioDeComunicacionService) {
        this.medioDeComunicacionRepository = medioDeComunicacionRepository;
    }

    public List<MedioDeComunicacion> obtenerMedioDeComunicacion(){
        return medioDeComunicacionRepository.findAll();

    }

    public Optional<MedioDeComunicacion> obtenerMedioDeComunicacionPorId(Integer id){
        return medioDeComunicacionRepository.findById(id);

    }

    public MedioDeComunicacion guardarTipoDeProblema(MedioDeComunicacion medioDeComunicacion){
        return medioDeComunicacionRepository.save(medioDeComunicacion);

    }

//    public List<MedioDeComunicacion> buscarMedioDeComunicacionPorDescripcion(String descripcion){
//
//        return medioDeComunicacion.findByDescripcionMedioDeComunicacion(descripcion);
//    }
}
