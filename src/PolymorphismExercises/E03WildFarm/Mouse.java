package PolymorphismExercises.E03WildFarm;

import static PolymorphismExercises.E03WildFarm.ConsolePrinter.printLine;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        printLine("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass() != Vegetable.class) {
            throw new IllegalArgumentException(getAnimalType() + "s are not eating that type of food!");
        }
        setFoodEaten(food.getQuantity());
    }
}
