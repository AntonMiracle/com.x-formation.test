package com.xformation.restaurant.domain.model;

public class Lunch {
    private Meal meal;
    private Dessert dessert;

    public Lunch(Meal meal, Dessert dessert) {
        this.meal = meal;
        this.dessert = dessert;
    }

    public Meal getMeal() {
        return meal;
    }

    public Dessert getDessert() {
        return dessert;
    }

}
