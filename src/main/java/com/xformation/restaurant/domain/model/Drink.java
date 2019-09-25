package com.xformation.restaurant.domain.model;

import java.math.BigDecimal;
import java.util.Map;

public class Drink {
    private BigDecimal price;
    private String name;
    private Map<Additive, Integer> additives;

    public Drink(BigDecimal price, String name, Map<Additive, Integer> additives) {
        this.price = price;
        this.name = name;
        this.additives = additives;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Map<Additive, Integer> getAdditives() {
        return additives;
    }
}
