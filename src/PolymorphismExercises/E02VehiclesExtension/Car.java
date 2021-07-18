package PolymorphismExercises.E02VehiclesExtension;

public class Car extends Vehicle {

    protected Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    protected void drive(double distance) {
        double fuelNeeded = distance * (getFuelConsumptionInLitersPerKm() + 0.9);

        if (getFuelQuantity() >= fuelNeeded) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);

            System.out.println("Car travelled " + getFormatParameter(distance) + " km");
        } else {
            System.out.println("Car needs refueling");
        }
    }

//    @Override
//    public void printRemainingFuel() {
//        System.out.printf("Car: %.2f%n", getFuelQuantity());
//    }
}
