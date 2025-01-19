package com.alexpoty.shopcoservice.model;

import com.alexpoty.shopcoservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "orders-table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Product> products;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comment;
}
