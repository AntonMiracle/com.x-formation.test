package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.MenuUnit;
import com.xformation.restaurant.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    Optional<MenuUnit> addMenuUnit(MenuUnit menuUnitToAdd);

    boolean removeMenuUnit(MenuUnit menuUnitToRemove);

    Optional<MenuUnit> findMenuUnitByName(String name);

    boolean isMenuUnitUnique(MenuUnit menuUnitToCheck);

    List<MenuUnit> findAllMenuUnit();

    Optional<Order> openOrder(Order orderToOpen);

    boolean closeOrder(Order orderToClose);

    Optional<Order> findOrderById(Long orderId);

    List<Order> findAllOrders();

}
