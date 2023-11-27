package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenteEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidenteEspecialidad;

    @ManyToOne
    @JoinColumn(name = "idIncidente")
    private Incidente incidente;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;
}