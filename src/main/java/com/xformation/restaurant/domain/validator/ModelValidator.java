package com.xformation.restaurant.domain.validator;

import com.xformation.restaurant.domain.model.MenuUnit;

public interface ModelValidator {
    default boolean isMenuUnitNameValid(MenuUnit menuUnit) {
        return menuUnit.getName() != null && menuUnit.getName().length() > 0;
    }
}
