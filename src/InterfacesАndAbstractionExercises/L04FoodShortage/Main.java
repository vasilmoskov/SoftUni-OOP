package InterfacesАndAbstractionExercises.L04FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        while (n-- > 0) {
            String [] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt (tokens[1]);

            Buyer buyer = null;

            if (tokens.length == 4) {
                String id = tokens[2];
                String birthdate = tokens[3];

                buyer = new Citizen(name, age, id, birthdate);

            } else if (tokens.length == 3) {
                String group = tokens[2];

                buyer = new Rebel(name, age, group);
            }

            if (buyer != null) {
                buyers.put(name, buyer);
            }

        }

        String name = scanner.nextLine();

        int totalFoodBought = 0;

        while (!name.equals("End")) {

            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }

            name = scanner.nextLine();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
