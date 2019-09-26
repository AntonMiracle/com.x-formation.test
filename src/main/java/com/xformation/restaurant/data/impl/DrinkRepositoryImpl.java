package com.xformation.restaurant.data.impl;

import com.xformation.restaurant.data.MenuUnitRepository;
import com.xformation.restaurant.domain.model.MenuUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrinkRepositoryImpl implements MenuUnitRepository {
    private static final Set<MenuUnit> repository = new HashSet<>();

    @Override
    public void save(MenuUnit menuUnit) {
        repository.add(menuUnit);
    }

    @Override
    public MenuUnit findByName(String name) {
        for (MenuUnit unit : repository) {
            if (unit.getName().equals(name)) {
                return unit;
            }
        }
        return null;
    }

    @Override
    public void remove(MenuUnit menuUnit) {
        repository.remove(menuUnit);
    }

    @Override
    public List<MenuUnit> findAll() {
        return new ArrayList<>(repository);
    }
}
