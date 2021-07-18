package PolymorphismExercises.E01Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity,
                fuelConsumptionInLitersPerKm + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
