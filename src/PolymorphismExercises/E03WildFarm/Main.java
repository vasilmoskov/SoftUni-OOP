package PolymorphismExercises.E03WildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //Map<String, Animal> animals = new HashMap<>();

        Set<Animal> animals = new LinkedHashSet<>();

        while (!input.equals("End")) {

            String tokens[] = input.split(" ");

            String animalType = tokens[0];
            String animalName = tokens[1];
            Double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String catBreed = tokens[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
            }

            String[] foodData = scanner.nextLine().split(" ");
            String foodType = foodData[0];
            Integer quantity = Integer.parseInt(foodData[1]);

            Food food = null;

            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(quantity);
                    break;
                case "Meat":
                    food = new Meat(quantity);
            }

            animals.add(animal);

            animal.makeSound();

            try {
                animal.eat(food);
//                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
