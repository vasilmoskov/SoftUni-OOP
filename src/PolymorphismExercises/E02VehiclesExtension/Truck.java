package PolymorphismExercises.E02VehiclesExtension;

public class Truck extends Vehicle {
    protected Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void drive(double distance) {
        double fuelNeeded = distance * (getFuelConsumptionInLitersPerKm() + 1.6);

        if (getFuelQuantity() >= fuelNeeded) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            System.out.println("Truck travelled " + getFormatParameter(distance) + " km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double fuelLiters) {
        if (fuelLiters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double newFuelQuantity = getFuelQuantity() + fuelLiters * 0.95;

        if (newFuelQuantity > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(newFuelQuantity);
    }

//    @Override
//    public void printRemainingFuel() {
//        System.out.printf("Truck: %.2f%n", getFuelQuantity());
//    }
}
