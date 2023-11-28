package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "servicio")
    private List<ClienteServicio> clienteServicios;

    @OneToOne(mappedBy = "servicio")
    private DetalleIncidente detalleIncidente;
}