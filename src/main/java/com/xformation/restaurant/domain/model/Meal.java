package com.xformation.restaurant.domain.model;

import java.util.Map;

public interface Meal extends MenuUnit {

    Cuisine getCuisine();

    default Map<Additive, Integer> getAdditives() {
        return null;
    }
}
