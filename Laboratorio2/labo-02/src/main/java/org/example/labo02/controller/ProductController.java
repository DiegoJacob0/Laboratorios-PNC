package org.example.labo02.controller;

import lombok.AllArgsConstructor;
import org.example.labo02.domain.entity.Wizard;
import org.example.labo02.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor

public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/create")
    public ResponseEntity<Wizard> createProduct(@RequestBody Wizard wizard){
        productService.createProduct(wizard);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wizard);

    }

}