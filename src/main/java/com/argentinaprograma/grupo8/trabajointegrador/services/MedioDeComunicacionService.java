package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.MedioDeComunicacion;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.MedioDeComunicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedioDeComunicacionService {
    private final MedioDeComunicacionRepository medioDeComunicacionRepository;

    @Autowired
    public MedioDeComunicacionService(MedioDeComunicacionRepository medioDeComunicacionRepository) {
        this.medioDeComunicacionRepository = medioDeComunicacionRepository;
    }

    public List<MedioDeComunicacion> obtenerTodosMediosDeComunicacion() {
        return medioDeComunicacionRepository.findAll();
    }

    public Optional<MedioDeComunicacion> obtenerMedioDeComunicacionPorId(Integer id) {
        return medioDeComunicacionRepository.findById(id);
    }

    public MedioDeComunicacion guardarMedioDeComunicacion(MedioDeComunicacion medioDeComunicacion) {
        return medioDeComunicacionRepository.save(medioDeComunicacion);
    }

    public void eliminarMedioDeComunicacionPorId(Integer id) {
        medioDeComunicacionRepository.deleteById(id);
    }
}
