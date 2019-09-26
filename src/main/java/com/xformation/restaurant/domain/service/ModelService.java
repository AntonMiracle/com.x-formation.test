package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.MenuUnit;
import com.xformation.restaurant.domain.model.Order;

import java.util.List;

public interface ModelService {
    MenuUnit addMenuUnit(MenuUnit menuUnit);

    boolean removeMenuUnit(MenuUnit menuUnit);

    MenuUnit findMenuUnitByName(String name);

    boolean isMenuUnitNameUnique(String name);

    List<MenuUnit> findAllMenuUnit();

    Order openOrder(Order order);

    boolean closeOrder(Order order);

    Order findOrderById(Long id);

    List<Order> findAllOrders();

}
