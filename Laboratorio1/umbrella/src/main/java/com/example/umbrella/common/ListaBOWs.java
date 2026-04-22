package com.example.umbrella.common;

import com.example.umbrella.domain.model.Bow;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaBOWs {

    private final List<Bow> bows;

    public ListaBOWs() {
        this.bows = new ArrayList<>();

        this.bows.add(Bow.builder()
                .nombre("Licker")
                .virusBase("T-Virus")
                .nivelPeligro(4)
                .puntoDebil("Cabeza")
                .estado("En libertad")
                .ubicacion("Comisaría")
                .posibleOrigen("Laboratorio de Redes")
                .build());

        this.bows.add(Bow.builder()
                .nombre("Hunter")
                .virusBase("T-Virus")
                .nivelPeligro(3)
                .puntoDebil("Cuello")
                .estado("Contenido")
                .ubicacion("Mansión")
                .posibleOrigen("Lab de Programación")
                .build());

        this.bows.add(Bow.builder()
                .nombre("Tyrant")
                .virusBase("G-Virus")
                .nivelPeligro(5)
                .puntoDebil("Corazón expuesto")
                .estado("En libertad")
                .ubicacion("Laboratorio")
                .posibleOrigen("Lab de Electrónica")
                .build());

        this.bows.add(Bow.builder()
                .nombre("Ganado")
                .virusBase("Las Plagas")
                .nivelPeligro(2)
                .puntoDebil("Cabeza")
                .estado("Eliminado")
                .ubicacion("Pueblo")
                .posibleOrigen("Área de Biología")
                .build());

        this.bows.add(Bow.builder()
                .nombre("Lady Dimitrescu")
                .virusBase("Cadou")
                .nivelPeligro(5)
                .puntoDebil("Mutación corporal")
                .estado("En libertad")
                .ubicacion("Castillo")
                .posibleOrigen("Lab de Química")
                .build());
    }

    public List<Bow> getBows() {
        return bows;
    }
}