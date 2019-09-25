package com.xformation.restaurant.domain.model.impl;

import com.xformation.restaurant.domain.model.MealSet;
import com.xformation.restaurant.domain.model.Meal;

import java.util.List;

public class Lunch implements MealSet {
    private List<Meal> meals;

    public Lunch(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public List<Meal> getMeals() {
        return null;
    }
}
