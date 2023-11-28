package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnicoEspecialidad;

    @ManyToOne
    @JoinColumn(name = "idTecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;
}