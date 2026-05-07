package org.example.labo02.service;

import org.example.labo02.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {

    Wizard createWizard(Wizard wizard);

    List<Wizard> getAllWizards();

    List<Wizard> getDeatheaters();

    List<Wizard> getByPatronus(String patronus);

    Wizard updateWizard(UUID id, Wizard wizard);

    void deleteWizard(UUID id);

}
