package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.MenuUnit;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MenuUnitService<T extends MenuUnit> {
    Optional<T> add(String menuUnitName, BigDecimal menuUnitPrice);

    boolean remove(MenuUnit menuUnitToRemove);

    Optional<T> findByName(String name);

    boolean isUnique(MenuUnit menuUnitToCheck);

    List<T> findAllMenuUnit();


}
