package com.xformation.restaurant.domain.model;

import java.util.List;

public class Lunch {
    private List<Meal> meals;

    public Lunch(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }
}
