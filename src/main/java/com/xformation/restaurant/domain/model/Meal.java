package com.xformation.restaurant.domain.model;

import java.math.BigDecimal;

public class Meal {
    private BigDecimal price;
    private String name;
    private Cuisine cuisine;

    public Meal(BigDecimal price, String name, Cuisine cuisine) {
        this.price = price;
        this.name = name;
        this.cuisine = cuisine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }
}
