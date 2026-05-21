package org.example.productsbackend.repositories;

import org.example.productsbackend.domain.entities.Speciment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecimentRepository extends JpaRepository<Speciment, UUID> {
    static Speciment findSpecimentById(UUID id) {
        return null;
    }
}
