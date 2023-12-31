package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<Incidente> incidentes;
}
