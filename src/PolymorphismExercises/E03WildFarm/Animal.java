package PolymorphismExercises.E03WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten = 0;
    DecimalFormat decimalFormat = new DecimalFormat("#.######");

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    public String getAnimalName() {
        return animalName;
    }
    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalWeight() {
        return decimalFormat.format(animalWeight);
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        if (foodEaten < 0) {
            throw new IllegalArgumentException("Food quantity must be positive");
        }
        this.foodEaten = getFoodEaten() + foodEaten;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);
}
