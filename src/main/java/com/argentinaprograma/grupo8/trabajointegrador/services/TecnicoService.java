package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Tecnico;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TecnicoRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    private TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public List<Tecnico> obtenerTecnicosConMasIncidentesResueltosUltimosNDias(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -dias);
        Date fecha = cal.getTime();
        return tecnicoRepository.findTecnicosConMasIncidentesResueltosUltimosNDias(fecha, PageRequest.of(0,1));
    }

    public Tecnico obtenerTecnicoConResolucionMasRapida() {
        return null;
    }

    public List<Tecnico> obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(int especialidadId, int ultimosNDias) {
        return null;
    }

    public List<Tecnico> obtenerTecnicos(){
        return tecnicoRepository.findAll();

    }

    public Optional<Tecnico> obtenerTecnicoPorId(Integer id){
        return tecnicoRepository.findById(id);

    }

    public Tecnico guardarTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);

    }

//    public List<TipoDeProblema> buscarProblemaPorDescripcion(String descripcion){
//
//        return tipoDeProblema.findByDescripcionProblema(descripcion);
//    }
}
