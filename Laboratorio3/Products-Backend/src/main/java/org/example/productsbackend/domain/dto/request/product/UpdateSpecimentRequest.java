package org.example.productsbackend.domain.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSpecimentRequest {

    private String name;

    private String region;

    private Integer dangerLevel;

    private Boolean isFriendly;
}