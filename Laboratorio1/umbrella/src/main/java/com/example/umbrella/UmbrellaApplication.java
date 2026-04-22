package com.example.umbrella;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.umbrella.service.BowService;
import com.example.umbrella.domain.model.Bow;

@SpringBootApplication
public class UmbrellaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmbrellaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BowService service) {
        return args -> {

            System.out.println("=== FILTRO POR VIRUS (T-Virus) ===");
            service.filtrarPorVirus("T-Virus")
                    .forEach(this::print);

            System.out.println("\n=== FILTRO POR ESTADO (En libertad) ===");
            service.filtrarPorEstado("En libertad")
                    .forEach(this::print);

            System.out.println("\n=== VIRUS ACTIVOS SIN REPETIR ===");
            service.virusActivosSinRepetir()
                    .forEach(v -> System.out.println("[S.T.A.R.S-REPORT] Virus activo: " + v));
        };
    }

    private void print(Bow b) {
        System.out.println("[S.T.A.R.S-REPORT] Nombre: " + b.getNombre()
                + " | Nivel de Peligro: " + b.getNivelPeligro()
                + " | Punto Débil: " + b.getPuntoDebil());
    }
}