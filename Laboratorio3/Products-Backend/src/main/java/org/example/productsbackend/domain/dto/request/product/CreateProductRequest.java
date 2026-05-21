package org.example.productsbackend.domain.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.productsbackend.common.Category;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateProductRequest {

    @NotBlank (message = "Product name cannot be empty")
    private String name;
    private Category category;
    @NotNull (message = "price can not be empty")
    @Positive(message = "price can not be negative or zero")
    private Double price;
    @NotNull(message = "It must ve specified whether the product is available")
    private Boolean available;

    }
