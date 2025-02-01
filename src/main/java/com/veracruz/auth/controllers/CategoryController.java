package com.veracruz.auth.controllers;

import com.veracruz.auth.domain.category.CategoryRequestDTO;
import com.veracruz.auth.domain.category.CategoryResponseDTO;
import com.veracruz.auth.domain.product.ProductRequestDTO;
import com.veracruz.auth.domain.product.ProductResponseDTO;
import com.veracruz.auth.service.CategoryService;
import com.veracruz.auth.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> postCategory(
        @RequestBody @Valid CategoryRequestDTO categoryRequestDTO
    ){
        CategoryResponseDTO newCategory = this.service.insertOne(categoryRequestDTO);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<CategoryResponseDTO> categories = this.service.findAll();

        return ResponseEntity.ok(categories);
    }
}
