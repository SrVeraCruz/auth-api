package com.veracruz.auth.domain.product;

import com.veracruz.auth.domain.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Integer price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();

    private Date createdAt = new Date();

    public Product(ProductRequestDTO data){
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
    }
}