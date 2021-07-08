package EncapsulationExercises.E03ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            Map<String, Person> people = new LinkedHashMap<>();
            Map<String, Product> products = new LinkedHashMap<>();

            String[] input = scanner.nextLine().split(";");

            for (int i = 0; i < input.length; i ++) {
                String name = input[i].split("=")[0];
                double money = Double.parseDouble(input[i].split("=")[1]);

                Person person = new Person(name, money);
                people.put(name, person);
            }

            input = scanner.nextLine().split(";");

            for (int i = 0; i < input.length; i ++) {
                String name = input[i].split("=")[0];
                double cost = Double.parseDouble(input[i].split("=")[1]);

                Product product = new Product(name, cost);
                products.put(name, product);
            }

            String command = scanner.nextLine();

            while (!command.equals("END")) {

                String personName = command.split(" ")[0];
                String productName = command.split(" ")[1];

                Person person = people.get(personName);
                Product product = products.get(productName);

                if (person.getMoney() < product.getCost()) {
                    System.out.println(personName + " can't afford " + productName);
                } else {
                    person.buyProduct(product);
                    System.out.println(personName + " bought " + productName);
                }

                command = scanner.nextLine();
            }

            for (Person person : people.values()) {
                System.out.println(person);
            }


        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
