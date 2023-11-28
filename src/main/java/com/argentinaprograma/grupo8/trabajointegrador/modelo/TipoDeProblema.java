package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoProblema;

    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;

    @OneToMany(mappedBy = "tipoProblema", cascade = CascadeType.ALL)
    private List<DetalleIncidente> detallesIncidentes;
}