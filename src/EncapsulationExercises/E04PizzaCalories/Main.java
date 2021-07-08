package EncapsulationExercises.E04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pizzaName = scanner.nextLine();
        int toppingStartingIndex = 0;

        for (int i = 0; i < pizzaName.length(); i++) {
            if (Character.isDigit(pizzaName.charAt(i))) {
                toppingStartingIndex = i;
                break;
            }
        }

        int numberOfToppings = Integer.parseInt(pizzaName.substring(toppingStartingIndex));
        pizzaName = pizzaName.substring(0, toppingStartingIndex - 1);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] tokens = scanner.nextLine().split(" ");
            String flourType = tokens[1];
            String backingTechnique = tokens[2];
            double weight = Double.parseDouble(tokens[3]);

            Dough dough = new Dough(flourType, backingTechnique, weight);

            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!input.equals("END")) {
                String toppingType = input.split(" ")[1];
                double toppingWeight = Double.parseDouble(input.split(" ")[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
