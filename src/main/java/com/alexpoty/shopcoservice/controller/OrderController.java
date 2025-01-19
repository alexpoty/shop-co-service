package com.alexpoty.shopcoservice.controller;

import com.alexpoty.shopcoservice.model.Order;
import com.alexpoty.shopcoservice.model.Product;
import com.alexpoty.shopcoservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody List<Product> products) {
        return new ResponseEntity<>(orderService.createOrder(products), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return new ResponseEntity<>(orderService.updateOrder(id, order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
