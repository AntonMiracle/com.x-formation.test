package com.xformation.restaurant.data;

import com.xformation.restaurant.domain.model.MenuUnit;

import java.util.List;

public interface MenuUnitRepository {
    void save(MenuUnit menuUnit);

    MenuUnit findByName(String name);

    void remove(MenuUnit menuUnit);

    List<MenuUnit> findAll();
}
