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
    @NotBlank(message = "The specimen name cannot be empty.")
    private String name;

    @NotBlank(message = "The region of Hyrule must be specified.")
    private String region;

    @NotNull(message = "Danger level is required.")
    private Integer dangerLevel;

    @NotNull(message = "You must specify if the specimen is friendly.")
    private Boolean isFriendly;
}

