package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedioDeComunicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedioComunicacion;

    @Enumerated(EnumType.STRING)
    private MedioEnum medio;

    private String contacto;
}
