package com.alexpoty.shopcoservice.model;

import com.alexpoty.shopcoservice.model.enums.Currency;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    @JoinColumn
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
