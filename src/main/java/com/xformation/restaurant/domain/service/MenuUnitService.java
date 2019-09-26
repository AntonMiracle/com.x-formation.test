package com.xformation.restaurant.domain.service;

import com.xformation.restaurant.domain.model.MenuUnit;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MenuUnitService {
    Optional<MenuUnit> addMenuUnit(String menuUnitName, BigDecimal menuUnitPrice);

    boolean removeMenuUnit(MenuUnit menuUnitToRemove);

    Optional<MenuUnit> findMenuUnitByName(String name);

    boolean isMenuUnitUnique(MenuUnit menuUnitToCheck);

    List<MenuUnit> findAllMenuUnit();



}
