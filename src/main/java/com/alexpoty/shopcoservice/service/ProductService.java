package com.alexpoty.shopcoservice.service;

import com.alexpoty.shopcoservice.dto.ProductDto;
import com.alexpoty.shopcoservice.exceptions.ProductNotFoundException;
import com.alexpoty.shopcoservice.model.Product;
import com.alexpoty.shopcoservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
       return productRepository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public Product createProduct(ProductDto productDto) {
        return productRepository.save(convert(productDto));
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        if (!productRepository.existsById(id)) throw new ProductNotFoundException("Product not found");
        Product product = convert(productDto);
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) throw new ProductNotFoundException("Product not found");
        productRepository.deleteById(id);
    }

    private Product convert(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .imageUrl(productDto.getImageUrl())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .currency(productDto.getCurrency())
                .build();
    }
}
