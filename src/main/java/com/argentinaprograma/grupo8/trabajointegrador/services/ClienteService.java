package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.Cliente;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.ClienteRepository;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.TipoDeProblema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerCliente(){
        return clienteRepository.findAll();

    }

    public Optional<Cliente> obtenerClientePorId(Integer id){
        return clienteRepository.findById(id);

    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);

    }

//    public List<TipoDeProblema> buscarProblemaPorDescripcion(String descripcion){
//
//        return tipoDeProblema.findByDescripcionProblema(descripcion);
//    }
}
