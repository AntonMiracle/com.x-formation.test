package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.Meal;

import java.math.BigDecimal;

public class Course implements Meal {
    private BigDecimal price;
    private String name;
    private Cuisine cuisine;

    public Course(BigDecimal price, String name, Cuisine cuisine) {
        this.price = price;
        this.name = name;
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

}
