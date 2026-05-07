package org.example.labo02.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.labo02.domain.entity.Wizard;
import org.example.labo02.repository.WizardRepository;
import org.example.labo02.service.WizardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Override
    public Wizard createWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getDeatheaters() {
        return wizardRepository.findByIsDeatheaterTrue();
    }

    @Override
    public List<Wizard> getByPatronus(String patronus) {
        return wizardRepository.findByPatronus(patronus);
    }

    @Override
    public Wizard updateWizard(UUID id, Wizard wizard) {

        Wizard existingWizard = wizardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wizard not found"));

        existingWizard.setName(wizard.getName());
        existingWizard.setHouse(wizard.getHouse());
        existingWizard.setPatronus(wizard.getPatronus());
        existingWizard.setIsDeatheater(wizard.getIsDeatheater());

        return wizardRepository.save(existingWizard);
    }

    @Override
    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}