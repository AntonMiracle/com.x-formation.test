package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.Meal;
import com.xformation.restaurant.domain.model.MealSet;

import java.util.Map;

public class Lunch implements MealSet {
    private Map<Meal, Integer> meals;

    public Lunch(Map<Meal, Integer> meals) {
        this.meals = meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lunch lunch = (Lunch) o;

        return meals != null ? meals.equals(lunch.meals) : lunch.meals == null;
    }

    @Override
    public int hashCode() {
        return meals != null ? meals.hashCode() : 0;
    }

    @Override
    public Map<Meal, Integer> getMeals() {
        return null;
    }
}
