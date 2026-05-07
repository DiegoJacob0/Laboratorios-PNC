package org.example.labo02.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.labo02.domain.entity.Wizard;
import org.example.labo02.repository.ProductRepository;
import org.example.labo02.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Wizard wizard) {
        productRepository.save(wizard);
    }

}
