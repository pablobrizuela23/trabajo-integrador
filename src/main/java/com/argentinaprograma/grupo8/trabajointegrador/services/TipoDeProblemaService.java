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

    // Método para guardar un tipo de problema
    public TipoDeProblema guardarTipoDeProblema(TipoDeProblema tipoDeProblema) {
        return tipoDeProblemaRepository.save(tipoDeProblema);
    }

    // Método para obtener todos los tipos de problema
    public List<TipoDeProblema> obtenerTodosLosTiposDeProblema() {
        return tipoDeProblemaRepository.findAll();
    }

}