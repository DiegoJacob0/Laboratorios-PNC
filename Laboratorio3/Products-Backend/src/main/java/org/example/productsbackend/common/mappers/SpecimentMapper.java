package org.example.productsbackend.common.mappers;

import org.example.productsbackend.domain.dto.request.product.CreateSpecimentRequest;
import org.example.productsbackend.domain.dto.response.product.SpecimentResponse;
import org.example.productsbackend.domain.entities.Speciment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class SpecimentMapper {

    public Speciment toEntityCreate(CreateSpecimentRequest createSpecimentRequest) {

        return Speciment.builder()
                .name(createSpecimentRequest.getName())
                .region(createSpecimentRequest.getRegion())
                .dangerLevel(createSpecimentRequest.getDangerLevel())
                .isFriendly(createSpecimentRequest.getIsFriendly())
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