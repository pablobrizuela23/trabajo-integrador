package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClienteServicio;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;
}
