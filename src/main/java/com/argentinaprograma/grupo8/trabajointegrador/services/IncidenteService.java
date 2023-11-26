package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Incidente;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.IncidenteRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenteService {

    private IncidenteRepository incidenteRepository;
    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    public List<Incidente> obtenerIncidentes(){
        return incidenteRepository.findAll();

    }

    public Optional<Incidente> obtenerProblemaPorId(Integer id){
        return incidenteRepository.findById(id);

    }

    public Incidente guardarIncidente(Incidente incidente){
        return incidenteRepository.save(incidente);

    }

//    public List<TipoDeProblema> buscarProblemaPorDescripcion(String descripcion){
//
//        return tipoDeProblema.findByDescripcionProblema(descripcion);
//    }
}
