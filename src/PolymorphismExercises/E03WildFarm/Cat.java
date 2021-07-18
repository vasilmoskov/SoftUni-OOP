package PolymorphismExercises.E03WildFarm;

import static PolymorphismExercises.E03WildFarm.ConsolePrinter.printLine;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    protected void makeSound() {
        printLine("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getBreed(),
                getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
