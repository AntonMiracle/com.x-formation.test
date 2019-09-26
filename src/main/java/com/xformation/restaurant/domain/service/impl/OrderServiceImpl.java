package com.xformation.restaurant.domain.service.impl;

import com.xformation.restaurant.data.OrderRepository;
import com.xformation.restaurant.data.impl.OrderRepositoryImpl;
import com.xformation.restaurant.domain.model.Order;
import com.xformation.restaurant.domain.service.OrderService;
import com.xformation.restaurant.domain.validator.ModelValidator;
import com.xformation.restaurant.domain.validator.impl.ModelValidatorImpl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderR = new OrderRepositoryImpl();
    private ModelValidator validator = new ModelValidatorImpl();
    private AtomicLong id = new AtomicLong();

    @Override
    public Optional<Order> add(Order orderToAdd) {
        if (orderToAdd.getMenuUnits().size() > 1) {
            orderToAdd.setId(id.incrementAndGet());
            orderR.save(orderToAdd);
            return Optional.of(orderToAdd);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(Order orderToRemove) {
        orderToRemove = findById(orderToRemove.getId()).orElse(null);
        if (orderToRemove != null) {
            orderR.remove(orderToRemove);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        if (validator.isOrderIdValid(orderId)) {
            for (Order order : orderR.findAll()) {
                if (order.getId().equals(orderId)) {
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return orderR.findAll();
    }
}
