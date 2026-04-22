package com.example.umbrella.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Bow {

    private String nombre;
    private String virusBase;
    private int nivelPeligro;
    private String puntoDebil;
    private String estado;
    private String ubicacion;
    private String posibleOrigen;
}
