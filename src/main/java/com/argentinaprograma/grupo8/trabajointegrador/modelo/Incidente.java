package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidente;

    private String titulo;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaResolucion;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    private String consideraciones;

    @OneToMany(mappedBy = "incidente", cascade = CascadeType.ALL)
    private List<DetalleIncidente> detallesIncidentes;
}
