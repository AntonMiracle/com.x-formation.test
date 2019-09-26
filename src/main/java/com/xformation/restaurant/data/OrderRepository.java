package com.xformation.restaurant.data;

import com.xformation.restaurant.domain.model.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface OrderRepository {
    Set<Order> repository = new HashSet<>();

    default void save(Order order) {
        repository.add(order);
    }

    default Order findById(Long id) {
        for (Order order : repository) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    default void remove(Order order) {
        repository.remove(order);
    }

    default List<Order> findAll() {
        return new ArrayList<>(repository);
    }
}
