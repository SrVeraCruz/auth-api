package com.veracruz.auth.domain.category;

import com.veracruz.auth.domain.product.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "category")
@Entity(name = "category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private Date createdAt = new Date();

    public Category(CategoryRequestDTO data){
        this.name = data.name();
        this.description = data.description();
    }
}