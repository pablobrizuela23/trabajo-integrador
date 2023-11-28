package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.DetalleIncidente;
import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.DetalleIncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleIncidenteService {
    private final DetalleIncidenteRepository detalleIncidenteRepository;
    @Autowired
    public DetalleIncidenteService(DetalleIncidenteRepository detalleIncidenteRepository) {
        this.detalleIncidenteRepository = detalleIncidenteRepository;
    }
    public List<DetalleIncidente> obtenerTodosDetallesIncidente() {
        return detalleIncidenteRepository.findAll();
    }
    public Optional<DetalleIncidente> obtenerDetalleIncidentePorId(Integer id) {
        return detalleIncidenteRepository.findById(id);
    }
    public DetalleIncidente guardarDetalleIncidente(DetalleIncidente detalleIncidente) {
        return detalleIncidenteRepository.save(detalleIncidente);
    }
    public void eliminarDetalleIncidentePorId(Integer id) {
        detalleIncidenteRepository.deleteById(id);
    }
}
