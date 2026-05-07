package org.example.labo02.repository;

import org.example.labo02.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends  JpaRepository<Wizard, UUID> {
    List<Wizard> findByIsDeatheaterTrue();
    List<Wizard> findByPatronus(String patronus);
}

