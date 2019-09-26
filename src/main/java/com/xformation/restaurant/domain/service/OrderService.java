package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> add(Order orderToAdd);

    boolean remove(Order orderToRemove);

    Optional<Order> findById(Long orderId);

    List<Order> findAll();
}
