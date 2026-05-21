package org.example.productsbackend.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.productsbackend.common.mappers.SpecimentMapper;
import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.request.product.UpdateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.PageableResponse;
import org.example.productsbackend.domain.dto.response.product.SpecimentResponse;
import org.example.productsbackend.domain.entities.Speciment;
import org.example.productsbackend.exceptions.ResourceNotFoundException;
import org.example.productsbackend.repositories.SpecimentRepository;
import org.example.productsbackend.services.SpecimentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecimentServiceImpl implements SpecimentService {

    private final SpecimentRepository specimentRepository;
    private final SpecimentMapper specimentMapper;

    @Override
    public SpecimentResponse createSpeciment(CreateSpecimentRequest speciment) {

        return specimentMapper.toDto(
                specimentRepository.save(
                        specimentMapper.toEntityCreate(speciment)
                )
        );
    }

    @Override
    public PageableResponse<SpecimentResponse> getAllSpeciment(
            int page,
            int size,
            String sortBy,
            String sortDirection
    ) {

        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Speciment> specimentPage = specimentRepository.findAll(pageable);

        Page<SpecimentResponse> responsePage =
                specimentMapper.toDtoPage(specimentPage);

        return PageableResponse.<SpecimentResponse>builder()
                .content(responsePage.getContent())
                .page(responsePage.getNumber())
                .size(responsePage.getSize())
                .totalElements(responsePage.getTotalElements())
                .totalPages(responsePage.getTotalPages())
                .last(responsePage.isLast())
                .build();
    }

    @Override
    public Speciment getSpecimentById(UUID id) {

        Speciment speciment = specimentRepository.findSpecimentById(id);

        if(speciment == null){
            throw new ResourceNotFoundException("Speciment not found in records");
        }

        return speciment;
    }

    @Override
    public SpecimentResponse updateSpeciment(UUID id, UpdateSpecimentRequest speciment) {

        Speciment existSpeciment = this.getSpecimentById(id);

        existSpeciment.setName(speciment.getName());
        existSpeciment.setRegion(speciment.getRegion());
        existSpeciment.setDangerLevel(speciment.getDangerLevel());
        existSpeciment.setIsFriendly(speciment.getIsFriendly());

        return specimentMapper.toDto(
                specimentRepository.save(existSpeciment)
        );
    }

    @Override
    public Speciment deleteSpeciment(UUID id) {
        Speciment existSpeciment = this.getSpecimentById(id);
        specimentRepository.deleteById(id);
        return existSpeciment;
    }
}