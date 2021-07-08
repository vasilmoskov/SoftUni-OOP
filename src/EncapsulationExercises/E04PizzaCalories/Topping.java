package EncapsulationExercises.E04PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Topping {
    private String toppingType;
    private double weight;
    private Map<String, Double> toppingModifiers = new HashMap<>();

    public Topping(String toppingType, double weight) {
        toppingModifiers.put("Meat", 1.2);
        toppingModifiers.put("Veggies", 0.8);
        toppingModifiers.put("Cheese", 1.1);
        toppingModifiers.put("Sauce", 0.9);

        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!toppingModifiers.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
//        int meatCalories = 1;
//        int veggiesCalories = 1;
//        int cheeseCalories = 1;
//        int sauceCalories = 1;

        return this.weight * 2 * toppingModifiers.get(toppingType);
    }
}

