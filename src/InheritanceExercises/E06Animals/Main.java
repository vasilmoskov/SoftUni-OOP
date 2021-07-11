package InheritanceExercises.E06Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Beast!")) {
            String classType = input;

            input = scanner.nextLine();

            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                Animal currentAnimal = null;

                switch (classType) {
                    case "Cat":
                        currentAnimal = new Cat(name, age, gender);
                        break;
                    case "Dog":
                        currentAnimal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        currentAnimal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        currentAnimal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        currentAnimal = new Tomcat(name, age);
                        break;
                    case "Animal":
                        currentAnimal = new Animal(name, age, gender);
                        break;
                }

                if (currentAnimal != null) {
                    animals.add(currentAnimal);
                }

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
