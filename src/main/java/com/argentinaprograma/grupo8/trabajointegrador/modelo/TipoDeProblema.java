package com.argentinaprograma.grupo8.trabajointegrador.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoDeProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoProblema;

    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;
}
