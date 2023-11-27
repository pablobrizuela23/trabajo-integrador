package com.argentinaprograma.grupo8.trabajointegrador.services;

import com.argentinaprograma.grupo8.trabajointegrador.modelo.ClienteServicio;
import com.argentinaprograma.grupo8.trabajointegrador.repositories.ClienteServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioService {
    private final ClienteServicioRepository clienteServicioRepository;

    @Autowired
    public ClienteServicioService(ClienteServicioRepository clienteServicioRepository) {
        this.clienteServicioRepository = clienteServicioRepository;
    }

    public List<ClienteServicio> obtenerTodosClienteServicios() {
        return clienteServicioRepository.findAll();
    }

    public Optional<ClienteServicio> obtenerClienteServicioPorId(Integer id) {
        return clienteServicioRepository.findById(id);
    }

    public ClienteServicio guardarClienteServicio(ClienteServicio clienteServicio) {
        return clienteServicioRepository.save(clienteServicio);
    }

    public void eliminarClienteServicioPorId(Integer id) {
        clienteServicioRepository.deleteById(id);
    }
}