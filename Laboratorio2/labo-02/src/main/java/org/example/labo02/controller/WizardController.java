package org.example.labo02.controller;

import lombok.RequiredArgsConstructor;
import org.example.labo02.domain.entity.Wizard;
import org.example.labo02.service.impl.WizardServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/wizards")
@RequiredArgsConstructor


public class WizardController {
    private final WizardServiceImpl wizardService;

    @PostMapping
    public ResponseEntity<List<Wizard>> getAllWizards () {
        return ResponseEntity.ok(wizardService.getAllWizards());
    }

    // Obtener mortífagos
    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {

        return ResponseEntity.ok(wizardService.getDeatheaters());
    }


}