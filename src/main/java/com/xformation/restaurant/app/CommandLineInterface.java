package com.xformation.restaurant.app;

import com.xformation.restaurant.domain.model.Additive;
import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.MenuUnit;
import com.xformation.restaurant.domain.model.impl.Drink;
import com.xformation.restaurant.domain.model.impl.Lunch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLineInterface {
    public static Map<Integer, String> getLunchOrDrink(List<MenuUnit> menuUnits, Cuisine cuisine) {
        Map<Integer, String> menu = new HashMap<>();
        int index = 0;
        menu.put(index, "finish");
        for (MenuUnit unit : menuUnits) {
            if ((unit.getClass().equals(Lunch.class) || unit.getClass().equals(Drink.class)) && unit.getCuisine() == cuisine)
                menu.put(++index, unit.getName());
        }
        return menu;
    }

    public static Map<Integer, String> getCuisineMenu() {
        Map<Integer, String> menu = new HashMap<>();
        int index = 0;
        menu.put(index, "finish");
        for (Cuisine cuisine : Cuisine.values()) {
            menu.put(++index, cuisine.name());
        }
        return menu;
    }

    public static Map<Integer, String> getAdditiveMenu() {
        Map<Integer, String> menu = new HashMap<>();
        int index = 0;
        menu.put(index, "finish");
        for (Additive additive : Additive.values()) {
            menu.put(++index, additive.name());
        }
        return menu;
    }

    public static void showMenu(Map<Integer, String> menuToShow) {
        for (Integer key : menuToShow.keySet()) {
            System.out.println(key + " : " + menuToShow.get(key));
        }
    }

    public static void showOrder(Map<MenuUnit, Integer> order) {
        System.out.println("Yours order is:");
        for (MenuUnit unit : order.keySet()) {
            System.out.println(unit + " : " + order.get(unit));
        }
    }
}
