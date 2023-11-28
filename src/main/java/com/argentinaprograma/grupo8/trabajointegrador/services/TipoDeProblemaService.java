package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.TipoDeProblema;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeProblemaService {

    private final TipoDeProblemaRepository tipoDeProblemaRepository;

    @Autowired
    public TipoDeProblemaService(TipoDeProblemaRepository tipoDeProblemaRepository) {
        this.tipoDeProblemaRepository = tipoDeProblemaRepository;
    }

    public TipoDeProblema guardarTipoDeProblema(TipoDeProblema tipoDeProblema) {
        return tipoDeProblemaRepository.save(tipoDeProblema);
    }

    public List<TipoDeProblema> obtenerTodosLosTiposDeProblema() {
        return tipoDeProblemaRepository.findAll();
    }

}