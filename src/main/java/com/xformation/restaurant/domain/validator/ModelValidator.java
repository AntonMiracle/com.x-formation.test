package com.xformation.restaurant.domain.validator;

import java.math.BigDecimal;

public interface ModelValidator {
    default boolean isMenuUnitNameValid(String name) {
        return name != null && name.length() > 0;
    }

    default boolean isPriceValueValid(BigDecimal price) {
        return price != null && BigDecimal.ZERO.compareTo(price) <= 0;
    }

    default boolean isOrderIdValid(Long id) {
        return Long.valueOf(0).compareTo(id) < 0;
    }
}
