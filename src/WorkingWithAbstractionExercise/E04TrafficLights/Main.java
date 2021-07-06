package WorkingWithAbstractionExercise.E04TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        Lamp [] lamps = new Lamp[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            lamps[i] = new Lamp(TrafficLight.valueOf(tokens[i]));
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            for (Lamp lamp : lamps) {
                lamp.changeColor();
                System.out.print(lamp + " ");
            }

            System.out.println();
        }
    }
}

        /*

        String[] tokens = scanner.nextLine().split(" ");

        TrafficLight[] trafficLights = new TrafficLight[tokens.length];

        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(tokens[i]);
        }

        int n = Integer.parseInt(scanner.nextLine());

        TrafficLight[] trafficLightsChange = new TrafficLight[trafficLights.length];

        for (int i = 0; i < n; i++) {
            trafficLightsChange[0] = trafficLights[trafficLights.length - 1];

            for (int value = 1; value < trafficLightsChange.length; value++) {
                trafficLightsChange[value] = trafficLights [value - 1];

//                if (trafficLightsChange[value - 1] == TrafficLight.GREEN) {
//                    trafficLightsChange[value] = TrafficLight.YELLOW;
//                } else if (trafficLightsChange[value - 1] == TrafficLight.YELLOW) {
//                    trafficLightsChange[value] = TrafficLight.RED;
//                } else if (trafficLightsChange[value - 1] == TrafficLight.RED) {
//                    trafficLightsChange[value] = TrafficLight.GREEN;
//                }
            }

            for (TrafficLight trafficLight : trafficLightsChange) {
                System.out.print(trafficLight.name() + " ");
            }

            System.out.println();

            System.arraycopy(trafficLightsChange, 0, trafficLights, 0, trafficLights.length);
        }

    }
}


         */