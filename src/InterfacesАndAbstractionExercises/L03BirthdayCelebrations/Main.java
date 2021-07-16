package InterfacesАndAbstractionExercises.L03BirthdayCelebrations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Birthable> birthables = new HashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String className = tokens[0];

            Birthable birthable = null;

            switch (className) {
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthdate = tokens[4];

                    birthable = new Citizen(name, age, birthdate, id);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthdate = tokens[2];

                    birthable = new Pet(name, birthdate);

                    break;
                case "Robot":
                    break;
            }

            if (birthable != null) {
                birthables.add(birthable);
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().contains(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
