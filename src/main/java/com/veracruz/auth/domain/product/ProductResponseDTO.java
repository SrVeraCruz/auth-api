package com.veracruz.auth.domain.product;

import com.veracruz.auth.domain.category.Category;

import java.util.Date;
import java.util.UUID;

public record ProductResponseDTO(
    UUID id,
    String name,
    String description,
    Integer price,
    Category category,
    Date createdAt
) {
    public ProductResponseDTO(Product product){
        this(product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory(),
            product.getCreatedAt()
        );
    }
}
