package com.xformation.restaurant.data;

import com.xformation.restaurant.domain.model.MenuUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface MenuUnitRepository {
    Set<MenuUnit> repository = new HashSet<>();

    default void save(MenuUnit menuUnit) {
        repository.add(menuUnit);
    }

    default MenuUnit findByName(String name) {
        for (MenuUnit unit : repository) {
            if (unit.getName().equals(name)) {
                return unit;
            }
        }
        return null;
    }

    default void remove(MenuUnit menuUnit) {
        repository.remove(menuUnit);
    }

    default List<MenuUnit> findAll() {
        return new ArrayList<>(repository);
    }
}
