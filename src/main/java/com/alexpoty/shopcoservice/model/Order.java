package com.alexpoty.shopcoservice.model;

import com.alexpoty.shopcoservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders-table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn
    private List<Product> products;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comment;
}
