package org.example.productsbackend.services;

import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.request.product.UpdateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.PageableResponse;
import org.example.productsbackend.domain.dto.response.product.SpecimentResponse;
import org.example.productsbackend.domain.entities.Speciment;

import java.util.List;
import java.util.UUID;

public interface SpecimentService {

    SpecimentResponse createSpeciment(CreateSpecimentRequest speciment);

    PageableResponse<SpecimentResponse> getAllSpeciment(
            int page,
            int size,
            String sortBy,
            String sortDirection
    );

    Speciment getSpecimentById(UUID id);

    SpecimentResponse updateSpeciment(UUID id, UpdateSpecimentRequest speciment);

    Speciment deleteSpeciment(UUID id);
}