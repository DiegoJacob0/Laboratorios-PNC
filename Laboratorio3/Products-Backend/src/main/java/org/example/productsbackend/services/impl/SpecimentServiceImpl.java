package org.example.productsbackend.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.productsbackend.common.mappers.SpecimentMapper;
import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.request.product.UpdateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.product.SpecimentResponse;
import org.example.productsbackend.domain.entities.Speciment;
import org.example.productsbackend.exceptions.ResourceNotFoundException;
import org.example.productsbackend.repositories.SpecimentRepository;
import org.example.productsbackend.services.SpecimentService;
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
    public List<Speciment> getAllSpeciment() {

        List<Speciment> speciments = specimentRepository.findAll();

        if(speciments.isEmpty()) {
            throw new ResourceNotFoundException("No speciments found in records");
        }

        return speciments;
    }

    @Override
    public Speciment getSpecimentById(UUID id) {

        Speciment speciment = SpecimentRepository.findSpecimentById(id);

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