package EncapsulationExercises.E04PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private Map<String, Double> doughModifiers = new HashMap<>();;


    public Dough(String flourType, String bakingTechnique, double weight) {
        doughModifiers.put("White", 1.5);
        doughModifiers.put("Wholegrain", 1.0);
        doughModifiers.put("Crispy", 0.9);
        doughModifiers.put("Chewy", 1.1);
        doughModifiers.put("Homemade", 1.0);

        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight (double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.length() < 1 || bakingTechnique.contains("  ")
                || !doughModifiers.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        if (flourType.length() < 1 || flourType.contains(" ")
                || !doughModifiers.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public double calculateCalories() {
        return this.weight * 2 * doughModifiers.get(flourType) * doughModifiers.get(bakingTechnique);
    }
}
