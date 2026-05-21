package org.example.productsbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.request.product.UpdateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.GeneralResponse;
import org.example.productsbackend.domain.entities.Speciment;
import org.example.productsbackend.services.SpecimentService;
import org.example.productsbackend.services.impl.SpecimentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/speciment")
@RequiredArgsConstructor
public class SpecimentController {
    private final SpecimentServiceImpl SpecimentService;
    private final SpecimentService specimentService;

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse> createSpeciment(@RequestBody CreateSpecimentRequest speciment) {
        return buildResponse(
                "Product created successfully",
                HttpStatus.CREATED,
                SpecimentService.createSpeciment(speciment)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllSpeciment(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection

    ) {

        return buildResponse(
                "Specimens obtained successfully",
                HttpStatus.OK,
                specimentService.getAllSpeciment(
                        page,
                        size,
                        sortBy,
                        sortDirection
                )
        );
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Speciment> getSpecimentById(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SpecimentService.getSpecimentById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateSpecimentRequest> updateSpeciment(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimentRequest speciment
    )
    {
        specimentService.updateSpeciment(id, speciment);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(speciment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Speciment> deleteSpeciment(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(specimentService.deleteSpeciment(id));

    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }
}
