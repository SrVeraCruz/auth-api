package com.veracruz.auth.service;

import com.veracruz.auth.domain.category.Category;
import com.veracruz.auth.domain.category.CategoryRequestDTO;
import com.veracruz.auth.domain.category.CategoryResponseDTO;
import com.veracruz.auth.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<CategoryResponseDTO> findAll() {
        List<Category> categories = this.repository.findAll();

        return categories.stream().map(category -> new CategoryResponseDTO(
            category.getId(),
            category.getName(),
            category.getDescription(),
            category.getCreatedAt()
        )).toList();
    }

    public Optional<Category> findById(UUID id) {
        return this.repository.findById(id);

    }

    public CategoryResponseDTO insertOne(CategoryRequestDTO categoryRequestDTO) {
        Category newCategory = new Category(categoryRequestDTO);
        this.repository.save(newCategory);

        return new CategoryResponseDTO(
            newCategory.getId(),
            newCategory.getName(),
            newCategory.getDescription(),
            newCategory.getCreatedAt()
        );
    }
}