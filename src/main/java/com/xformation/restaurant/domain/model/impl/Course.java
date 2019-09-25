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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (price != null ? !price.equals(course.price) : course.price != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        return cuisine == course.cuisine;
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
    public Cuisine getCuisine() {
        return cuisine;
    }

}
