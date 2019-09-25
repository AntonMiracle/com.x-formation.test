package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Additive;
import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.Meal;

import java.math.BigDecimal;
import java.util.Map;

public class Drink implements Meal {
    private BigDecimal price;
    private String name;
    private Map<Additive, Integer> additives;
    private Cuisine cuisine;

    public Drink(BigDecimal price, String name, Map<Additive, Integer> additives, Cuisine cuisine) {
        this.price = price;
        this.name = name;
        this.additives = additives;
        this.cuisine = cuisine;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Cuisine getCuisine() {
        return cuisine;
    }

    @Override
    public Map<Additive, Integer> getAdditives() {
        return additives;
    }
}
