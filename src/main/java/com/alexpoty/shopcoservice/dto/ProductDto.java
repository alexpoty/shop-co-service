package com.alexpoty.shopcoservice.dto;

import com.alexpoty.shopcoservice.model.enums.Currency;
import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Currency currency;
}
