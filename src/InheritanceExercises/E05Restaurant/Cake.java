package InheritanceExercises.E05Restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static final double CAKE_GRAMS = 250;
    private static final double CAKE_CALORIES = 1000;
    private static final BigDecimal CAKE_PRICE = new BigDecimal("5");

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }

    public static BigDecimal getCakePrice() {
        return CAKE_PRICE;
    }

    public static double getCakeCalories() {
        return CAKE_CALORIES;
    }

    public static double getCakeGrams() {
        return CAKE_GRAMS;
    }

}
