package com.xformation.restaurant.domain.service.impl;

import com.xformation.restaurant.data.MenuUnitRepository;
import com.xformation.restaurant.data.impl.MenuUnitRepositoryImpl;
import com.xformation.restaurant.domain.model.impl.Lunch;
import com.xformation.restaurant.domain.service.MenuUnitService;
import com.xformation.restaurant.domain.validator.ModelValidator;
import com.xformation.restaurant.domain.validator.impl.ModelValidatorImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LunchService implements MenuUnitService<Lunch> {
    private MenuUnitRepository menuUnitR = new MenuUnitRepositoryImpl();
    private ModelValidator validator = new ModelValidatorImpl();

    @Override
    public Optional<Lunch> add(Lunch menuUnitToAdd) {
        if (isUnique(menuUnitToAdd) && validator.isPriceValueValid(menuUnitToAdd.getPrice())) {
            menuUnitR.save(menuUnitToAdd);
            return Optional.of(menuUnitToAdd);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(Lunch menuUnitToRemove) {
        menuUnitToRemove = findByName(menuUnitToRemove.getName()).orElse(null);
        if (menuUnitToRemove != null) {
            menuUnitR.remove(menuUnitToRemove);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Lunch> findByName(String menuUnitName) {
        if (validator.isMenuUnitNameValid(menuUnitName)) {
            for (Lunch lunch : findAll()) {
                if (lunch.getName().equals(menuUnitName)) {
                    return Optional.of(lunch);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean isUnique(Lunch menuUnitToCheck) {
        String name = menuUnitToCheck.getName();
        if (validator.isMenuUnitNameValid(name)) {
            return menuUnitR.findAll().stream().filter(menuUnit -> menuUnit.getName().equals(name)).count() == 0;
        }
        return false;
    }

    @Override
    public List<Lunch> findAll() {
        return menuUnitR.findAll().stream()
                .filter(menuUnit -> menuUnit.getClass().equals(Lunch.class))
                .map(lunch -> (Lunch) lunch)
                .collect(Collectors.toList());
    }
}
