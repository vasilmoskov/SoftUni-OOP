package PolymorphismExercises.E01Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] carData = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble (carData[1]);
        double carLitersPerKm = Double.parseDouble (carData[2]);

        Car car = new Car(carFuelQuantity, carLitersPerKm);

        String [] truckData = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble (truckData[1]);
        double truckLitersPerKm = Double.parseDouble (truckData[2]);

        Truck truck = new Truck(truckFuelQuantity, truckLitersPerKm);

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String [] tokens = input.split(" ");

            String action = tokens[0];
            String vehicle = tokens[1];
            double parameter = Double.parseDouble (tokens[2]);

            switch (action) {
                case "Drive":
                    vehicles.get(vehicle).drive(parameter);
                    break;
                case "Refuel":
                    vehicles.get(vehicle).refuel(parameter);
                    break;
            }
        }

        for (Vehicle value : vehicles.values()) {
            System.out.println(value);;
        }


    }
}
