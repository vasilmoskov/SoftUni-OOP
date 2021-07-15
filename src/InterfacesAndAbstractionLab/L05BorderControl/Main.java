package InterfacesAndAbstractionLab.L05BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> entrants = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split(" ");

            Identifiable entrant = null;

            if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];

                entrant = new Robot(id, model);

            } else {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                entrant = new Citizen(name, age, id);
            }

            entrants.add(entrant);

            input = scanner.nextLine();
        }

        String lastDigitsOfFakeId = scanner.nextLine();

       // Set<String> detainedIds = new HashSet<>();

        for (Identifiable entrant : entrants) {
            String currentEntrantId = entrant.getId();

            if (currentEntrantId.endsWith(lastDigitsOfFakeId)) {
                System.out.println(currentEntrantId);
                //detainedIds.add(currentEntrantId);
            }
        }

//        for (String detainedId : detainedIds) {
//            System.out.println(detainedId);
//        }

    }
}
