package com.veracruz.auth.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        @NotBlank
        String name,
        String description,
        @NotNull
        Integer price
) {
}
