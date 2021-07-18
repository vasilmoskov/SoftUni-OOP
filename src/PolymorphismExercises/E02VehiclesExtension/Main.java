package PolymorphismExercises.E02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] carData = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble (carData[1]);
        double carLitersPerKm = Double.parseDouble (carData[2]);
        double carTankCapacity = Double.parseDouble (carData[3]);

        Car car = new Car(carFuelQuantity, carLitersPerKm, carTankCapacity);

        String [] truckData = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble (truckData[1]);
        double truckLitersPerKm = Double.parseDouble (truckData[2]);
        double truckTankCapacity = Double.parseDouble (truckData[3]);

        Truck truck = new Truck(truckFuelQuantity, truckLitersPerKm, truckTankCapacity);

        String [] busData = scanner.nextLine().split(" ");
        double busFuelQuantity = Double.parseDouble (busData[1]);
        double busLitersPerKm = Double.parseDouble (busData[2]);
        double busTankCapacity = Double.parseDouble (busData[3]);

        Bus bus = new Bus(busFuelQuantity, busLitersPerKm, busTankCapacity);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String [] tokens = input.split(" ");

            String action = tokens[0];
            String vehicle = tokens[1];
            double parameter = Double.parseDouble (tokens[2]);

            try {
                switch (action) {
                    case "Drive":
                        vehicles.get(vehicle).drive(parameter);
                        break;
                    case "DriveEmpty":
                        bus.setBusIsEmpty();
                        vehicles.get(vehicle).drive(parameter);
                        break;
                    case "Refuel":
                        vehicles.get(vehicle).refuel(parameter);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Vehicle value : vehicles.values()) {
            value.printRemainingFuel();
        }


    }
}
