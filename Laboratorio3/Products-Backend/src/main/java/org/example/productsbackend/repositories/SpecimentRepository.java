package org.example.productsbackend.repositories;

import org.example.productsbackend.domain.entities.Speciment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecimentRepository extends JpaRepository<Speciment, UUID> {

    Speciment findSpecimentById(UUID id);

}