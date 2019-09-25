package com.xformation.restaurant.domain.model;

import java.math.BigDecimal;
import java.util.Map;

public interface Meal {
    BigDecimal getPrice();

    String getName();

    Cuisine getCuisine();

    default Map<Additive, Integer> getAdditives() {
        return null;
    }
}
