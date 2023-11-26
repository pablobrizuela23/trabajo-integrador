package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private long cuit;
    private String email;
    private String razonSocial;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    private List<ClienteServicio> clienteServicios;
}

