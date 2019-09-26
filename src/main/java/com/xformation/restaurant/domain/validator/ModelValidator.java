package com.xformation.restaurant.domain.validator;

import com.xformation.restaurant.domain.model.MenuUnit;

public interface ModelValidator {
    default boolean isMenuUnitNameValid(MenuUnit menuUnit) {
        if (menuUnit != null && menuUnit.getName() != null) {
            return menuUnit.getName().length() > 0;
        }
        return false;
    }
}
