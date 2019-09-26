package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.Meal;
import com.xformation.restaurant.domain.model.MealSet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Lunch implements MealSet {
    private BigDecimal price;
    private String name;
    private Map<Meal, Integer> meals;
    private Cuisine cuisine;

    public Lunch(BigDecimal price, String name, Cuisine cuisine) {
        this.price = price;
        this.name = name;
        this.meals = new HashMap<>();
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lunch lunch = (Lunch) o;

        if (price != null ? !price.equals(lunch.price) : lunch.price != null) return false;
        if (name != null ? !name.equals(lunch.name) : lunch.name != null) return false;
        if (meals != null ? !meals.equals(lunch.meals) : lunch.meals != null) return false;
        return cuisine == lunch.cuisine;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (meals != null ? meals.hashCode() : 0);
        result = 31 * result + (cuisine != null ? cuisine.hashCode() : 0);
        return result;
    }

    @Override
    public Map<Meal, Integer> getMeals() {
        return meals;
    }

    @Override
    public BigDecimal getPrice() {
        return price
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
    public String getName() {
        return name;
    }

}
