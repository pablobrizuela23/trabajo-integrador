package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleIncidente;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idIncidente")
    private Incidente incidente;

    @OneToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "idTipoProblema")
    private TipoDeProblema tipoProblema;
}