package com.alexpoty.shopcoservice.service;

import com.alexpoty.shopcoservice.exceptions.OrderNotFoundException;
import com.alexpoty.shopcoservice.model.Order;
import com.alexpoty.shopcoservice.model.Product;
import com.alexpoty.shopcoservice.model.enums.Status;
import com.alexpoty.shopcoservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id + " Order not found"));
    }

    public Order createOrder(List<Product> products) {
        return Order.builder()
                .products(products)
                .totalPrice(getTotalPrice(products))
                .status(Status.NEW)
                .build();
    }

    public Order updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) throw new OrderNotFoundException(id + " Order not found");
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) throw new OrderNotFoundException(id + " Order not found");
        orderRepository.deleteById(id);
    }

    private Double getTotalPrice(List<Product> products) {
        double totalPrice = 0d;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
