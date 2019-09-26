package com.xformation.restaurant.domain.model;

import java.math.BigDecimal;

public interface MenuUnit {
    BigDecimal getPrice();

    String getName();

    void setPrice(BigDecimal price);

    void setName(String name);

    Cuisine getCuisine();

    void setCuisine(Cuisine cuisine);
}
