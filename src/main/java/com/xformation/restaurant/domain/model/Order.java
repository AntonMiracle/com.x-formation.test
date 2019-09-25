package com.xformation.restaurant.domain.model;

import java.util.Map;

public class Order {
    private Long id;
    private Map<MenuUnit, Integer> menuUnits;

    public Order(Long id, Map<MenuUnit, Integer> menuUnits) {
        this.id = id;
        this.menuUnits = menuUnits;
    }

    public Map<MenuUnit, Integer> getMenuUnits() {
        return menuUnits;
    }

    public Long getId() {
        return id;
    }
}
