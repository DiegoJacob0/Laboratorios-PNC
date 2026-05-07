package org.example.labo02.controller;

import lombok.RequiredArgsConstructor;
import org.example.labo02.domain.entity.Wizard;
import org.example.labo02.service.impl.WizardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/wizards")
@RequiredArgsConstructor


public class WizardController {
    private final WizardServiceImpl wizardService;

    // Registrar mago
    @PostMapping
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {

        Wizard createdWizard = wizardService.createWizard(wizard);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdWizard);
    }
    //Obtener todos
    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards () {
        return ResponseEntity.ok(wizardService.getAllWizards());
    }

    // Obtener mortífagos
    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {

        return ResponseEntity.ok(wizardService.getDeatheaters());
    }

    // Actualizar mago
    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(
            @PathVariable UUID id,
            @RequestBody Wizard wizard
    ) {

        return ResponseEntity.ok(
                wizardService.updateWizard(id, wizard)
        );
    }

    // Obtener por nombre de patronus
    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getByPatronus(
            @PathVariable String patronus
    )
      {
        return ResponseEntity.ok(wizardService.getByPatronus(patronus));
      }

    // Eliminar mago
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWizard(
            @PathVariable UUID id
    ) {

        wizardService.deleteWizard(id);

        return ResponseEntity.ok("Wizard deleted successfully");
    }
}

