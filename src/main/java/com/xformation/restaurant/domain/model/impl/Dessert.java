package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.Meal;

import java.math.BigDecimal;

public class Dessert implements Meal {
    private BigDecimal price;
    private String name;
    private Cuisine cuisine;

    public Dessert(BigDecimal price, String name, Cuisine cuisine) {
        this.price = price;
        this.name = name;
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dessert dessert = (Dessert) o;

        if (price != null ? !price.equals(dessert.price) : dessert.price != null) return false;
        if (name != null ? !name.equals(dessert.name) : dessert.name != null) return false;
        return cuisine == dessert.cuisine;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cuisine != null ? cuisine.hashCode() : 0);
        return result;
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
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Cuisine getCuisine() {
        return cuisine;
    }

    @Override
    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

}
