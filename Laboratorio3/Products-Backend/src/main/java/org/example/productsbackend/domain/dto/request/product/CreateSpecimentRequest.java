package org.example.productsbackend.domain.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.productsbackend.common.Category;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateSpecimentRequest {
    private String name;
    private String region;
    private Integer dangerLevel;
    private Boolean isFriendly;

    }
