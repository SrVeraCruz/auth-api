package com.veracruz.auth.controllers;

import com.veracruz.auth.domain.product.ProductRequestDTO;
import com.veracruz.auth.domain.product.ProductResponseDTO;
import com.veracruz.auth.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ProductResponseDTO> postProduct(
        @PathVariable("categoryId") UUID categoryId,
        @RequestBody @Valid ProductRequestDTO productRequestDTO
    ){
        ProductResponseDTO newProduct = this.service.insertOne(categoryId, productRequestDTO);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productList = this.service.findAll();

        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable("productId") UUID id) {
        ProductResponseDTO newProduct = this.service.findById(id);
        return ResponseEntity.ok(newProduct);
    }
}
