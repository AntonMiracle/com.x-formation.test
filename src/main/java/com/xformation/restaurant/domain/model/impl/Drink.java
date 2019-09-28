package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Additive;
import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.Meal;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Drink implements Meal {
    private BigDecimal price;
    private String name;
    private Map<Additive, Integer> additives;
    private Cuisine cuisine;

    public Drink(BigDecimal price, String name, Cuisine cuisine) {
        this.price = price;
        this.name = name;
        this.additives = new HashMap<>();
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (price != null ? !price.equals(drink.price) : drink.price != null) return false;
        if (name != null ? !name.equals(drink.name) : drink.name != null) return false;
        if (additives != null ? !additives.equals(drink.additives) : drink.additives != null) return false;
        return cuisine == drink.cuisine;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (additives != null ? additives.hashCode() : 0);
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

    @Override
    public Map<Additive, Integer> getAdditives() {
        return additives;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", additives=" + additives +
                ", cuisine=" + cuisine +
                '}';
    }
}
