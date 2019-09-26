package com.xformation.restaurant.domain.validator;

public interface ModelValidator {
    default boolean isMenuUnitNameValid(String name) {
        return name != null && name.length() > 0;
    }
}
