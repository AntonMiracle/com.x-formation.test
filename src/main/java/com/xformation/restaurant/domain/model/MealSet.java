package com.xformation.restaurant.domain.model;

import java.util.Map;

public interface MealSet extends MenuUnit{
    Map<Meal,Integer> getMeals();
}
