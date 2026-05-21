package org.example.productsbackend.common.mappers;

import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.request.product.UpdateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.product.SpecimentResponse;
import org.example.productsbackend.domain.entities.Speciment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpecimentMapper {

    public Speciment toEntityCreate(CreateSpecimentRequest request) {

        return Speciment.builder()
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public Speciment toEntityUpdate(UpdateSpecimentRequest request, UUID id) {

        return Speciment.builder()
                .id(id)
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public SpecimentResponse toDto(Speciment speciment) {

        return SpecimentResponse.builder()
                .id(speciment.getId())
                .name(speciment.getName())
                .region(speciment.getRegion())
                .dangerLevel(speciment.getDangerLevel())
                .isFriendly(speciment.getIsFriendly())
                .build();
    }

    public Page<SpecimentResponse> toDtoPage(Page<Speciment> speciments) {

        return speciments.map(this::toDto);
    }
}