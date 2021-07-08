package EncapsulationExercises.E04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        toppings = new ArrayList<>();
    }

    private void setToppings(int toppings) {
        if (toppings < 0 ||toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.numberOfToppings = toppings;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.contains("  ") || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories () {
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
