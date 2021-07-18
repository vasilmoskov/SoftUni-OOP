package PolymorphismExercises.E01Vehicles;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity,
                fuelConsumptionInLitersPerKm + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION);
    }
}
