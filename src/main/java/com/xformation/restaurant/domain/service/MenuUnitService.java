package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.MenuUnit;

import java.util.List;
import java.util.Optional;

public interface MenuUnitService<T extends MenuUnit> {
    Optional<T> add(T menuUnitToAdd);

    boolean remove(T menuUnitToRemove);

    Optional<T> findByName(String menuUnitName);

    boolean isUnique(T menuUnitToCheck);

    List<T> findAll();


}
