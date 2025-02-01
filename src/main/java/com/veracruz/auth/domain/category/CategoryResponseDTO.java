package com.veracruz.auth.domain.category;

import com.veracruz.auth.domain.product.Product;

import java.util.Date;
import java.util.UUID;

public record CategoryResponseDTO(
    UUID id,
    String name,
    String description,
    Date createdAt
) { }
