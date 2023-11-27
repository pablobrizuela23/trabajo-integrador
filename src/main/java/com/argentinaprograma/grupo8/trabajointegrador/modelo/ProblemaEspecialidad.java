package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemaEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProblemaEspecialidad;

    @ManyToOne
    @JoinColumn(name = "idTipoDeProblema")
    private TipoDeProblema tipoDeProblema;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;
}