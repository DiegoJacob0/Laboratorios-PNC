package com.example.umbrella.service;

import com.example.umbrella.domain.model.Bow;
import com.example.umbrella.repository.BowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BowService {
    private final BowRepository repository;

    public BowService(BowRepository repository) {
        this.repository = repository;
    }

    public List<Bow> filtrarPorVirus(String virus) {
        return repository.findAll().stream()
                .filter(b -> b.getVirusBase().equalsIgnoreCase(virus))
                .toList();
    }

    public List<Bow> filtrarPorEstado(String estado) {
        return repository.findAll().stream()
                .filter(b -> b.getEstado().equalsIgnoreCase(estado))
                .toList();
    }

    public List<String> virusActivosSinRepetir() {
        return repository.findAll().stream()
                .filter(b -> b.getEstado().equalsIgnoreCase("En libertad"))
                .map(Bow::getVirusBase)
                .distinct()
                .toList();

    }
}
