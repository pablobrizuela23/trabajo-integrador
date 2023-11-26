package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeProblemaService {
    private TipoDeProblema tipoDeProblema;
    @Autowired
    public TipoDeProblemaService(TipoDeProblema tipoDeProblema) {
        this.tipoDeProblema = tipoDeProblema;
    }

    public List<TipoDeProblema> obtenerTipoDeProblemas(){
        return tipoDeProblema.findAll();

    }

    public Optional<TipoDeProblema> obtenerProblemaPorId(Integer id){
        return tipoDeProblema.findById(id);

    }

    public TipoDeProblema guardarTipoDeProblema(TipoDeProblema tipoDeProblema){
    return tipoDeProblema.save(tipoDeProblema);

    }

//    public List<TipoDeProblema> buscarProblemaPorDescripcion(String descripcion){
//
//        return tipoDeProblema.findByDescripcionProblema(descripcion);
//    }
}
