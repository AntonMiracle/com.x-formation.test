package com.xformation.restaurant.app;

import com.xformation.restaurant.data.MenuUnitRepository;
import com.xformation.restaurant.data.impl.MenuUnitRepositoryImpl;
import com.xformation.restaurant.domain.model.Additive;
import com.xformation.restaurant.domain.model.Cuisine;
import com.xformation.restaurant.domain.model.MenuUnit;
import com.xformation.restaurant.domain.model.Order;
import com.xformation.restaurant.domain.model.impl.Course;
import com.xformation.restaurant.domain.model.impl.Dessert;
import com.xformation.restaurant.domain.model.impl.Drink;
import com.xformation.restaurant.domain.model.impl.Lunch;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuUnitRepository repository = new MenuUnitRepositoryImpl();
        initializationTestData(repository);
        Scanner scn = new Scanner(System.in);

        Order order = new Order(0L, new HashMap<>());
        Map<Integer, String> additiveMenu = CommandLineInterface.getAdditiveMenu();

        while (true) {
            CommandLineInterface.showMenu(CommandLineInterface.getCuisineMenu());
            System.out.println("choose cuisine : ");
            int cuisineChoose = scn.nextInt();
            if (cuisineChoose == 0) break;
            else {
                Map<Integer, String> cuisineMenu = CommandLineInterface.getLunchOrDrink(repository.findAll(), Cuisine.values()[cuisineChoose - 1]);
                CommandLineInterface.showMenu(cuisineMenu);
                System.out.println("choose meal : ");
                int chooseMeal = scn.nextInt();
                if (chooseMeal != 0) {
                    String menuUnitName = cuisineMenu.get(chooseMeal);
                    MenuUnit unit = repository.findByName(menuUnitName);
                    System.out.println("==== " + unit.getName());
                    if (unit.getClass().equals(Drink.class)) {
                        while (true) {
                            System.out.println("choose additive for drink");
                            CommandLineInterface.showMenu(CommandLineInterface.getAdditiveMenu());

                            System.out.println("enter number of additive for your " + unit.getName() + " : ");
                            int additiveChoose = scn.nextInt();
                            if (additiveChoose > 0 && additiveChoose < Additive.values().length + 1) {
                                ((Drink) unit).getAdditives().merge(Additive.values()[additiveChoose - 1], 1, (a, b) -> a + b);
                            } else break;
                        }
                    }
                    order.getMenuUnits().merge(unit, 1, (a, b) -> a + b);
                    CommandLineInterface.showOrder(order.getMenuUnits());
                } else break;
            }
        }
    }

    private static void initializationTestData(MenuUnitRepository repository) {
        MenuUnit drink1 = new Drink(BigDecimal.valueOf(22.6), "Tequila", Cuisine.MEXICAN);
        MenuUnit drink2 = new Drink(BigDecimal.valueOf(12.3), "Tea ", Cuisine.ITALY);
        MenuUnit drink3 = new Drink(BigDecimal.valueOf(20), "Coffee", Cuisine.POLISH);
        repository.save(drink1);
        repository.save(drink2);
        repository.save(drink3);

        MenuUnit course1 = new Course(BigDecimal.valueOf(45.6), "Pork steak", Cuisine.POLISH);
        MenuUnit course2 = new Course(BigDecimal.valueOf(22.6), "Spaghetti carbonara", Cuisine.ITALY);
        MenuUnit course3 = new Course(BigDecimal.valueOf(22.6), "Mexican potatoes", Cuisine.MEXICAN);
        repository.save(course1);
        repository.save(course2);
        repository.save(course3);

        MenuUnit dessert1 = new Dessert(BigDecimal.valueOf(12), "Tiramisu with Mascarpone", Cuisine.ITALY);
        MenuUnit dessert2 = new Dessert(BigDecimal.valueOf(8), "Donuts churros", Cuisine.MEXICAN);
        MenuUnit dessert3 = new Dessert(BigDecimal.valueOf(14), "Mazurka", Cuisine.POLISH);
        repository.save(dessert1);
        repository.save(dessert2);
        repository.save(dessert3);

        MenuUnit lunch1 = new Lunch(BigDecimal.valueOf(29), "lunch Mexican", Cuisine.MEXICAN);
        Map<MenuUnit, Integer> meals1 = ((Lunch) lunch1).getMeals();
        meals1.put(course3, 1);
        meals1.put(dessert2, 1);
        repository.save(lunch1);

        MenuUnit lunch2 = new Lunch(BigDecimal.valueOf(29), "lunch Italy", Cuisine.ITALY);
        Map<MenuUnit, Integer> meals2 = ((Lunch) lunch1).getMeals();
        meals2.put(course2, 1);
        meals2.put(dessert1, 1);
        repository.save(lunch2);


    }
}

