package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnico;

    private String nombre;
    private String apellido;

    @OneToOne
    @JoinColumn(name = "idMedioComunicacion")
    private MedioDeComunicacion medioDeComunicacion;
}
