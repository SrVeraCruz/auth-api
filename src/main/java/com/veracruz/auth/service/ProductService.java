package com.veracruz.auth.service;

import com.veracruz.auth.domain.category.Category;
import com.veracruz.auth.domain.category.exceptions.CategoryNotFoundException;
import com.veracruz.auth.domain.product.Product;
import com.veracruz.auth.domain.product.ProductRequestDTO;
import com.veracruz.auth.domain.product.ProductResponseDTO;
import com.veracruz.auth.domain.product.exceptions.ProductNotFoundException;
import com.veracruz.auth.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;


    public List<ProductResponseDTO> findAll() {
        List<Product> products = this.repository.findAll();

        return products.stream().map(product -> new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory(),
            product.getCreatedAt()
        )).toList();
    }

    public ProductResponseDTO findById(UUID id) {
        Product newProduct = this.repository.findById(id)
            .orElseThrow(ProductNotFoundException::new);

        return new ProductResponseDTO(
            newProduct.getId(),
            newProduct.getName(),
            newProduct.getDescription(),
            newProduct.getPrice(),
            newProduct.getCategory(),
            newProduct.getCreatedAt()
        );
    }

    public ProductResponseDTO insertOne(UUID categoryId, ProductRequestDTO productRequestDTO) {
        Category category = this.categoryService.findById(categoryId)
            .orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product(productRequestDTO);
        newProduct.setCategory(category);
        this.repository.save(newProduct);

        return new ProductResponseDTO(
            newProduct.getId(),
            newProduct.getName(),
            newProduct.getDescription(),
            newProduct.getPrice(),
            newProduct.getCategory(),
            newProduct.getCreatedAt()
        );
    }
}
