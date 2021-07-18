package PolymorphismExercises.E02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private double tankCapacity;
    DecimalFormat format = new DecimalFormat("#.##");

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public String getFormatParameter(double parameter) {
        return format.format(parameter);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    public void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected abstract void drive(double distance);

    public void refuel(double fuelLiters) {
        if (fuelLiters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double newFuelQuantity = getFuelQuantity() + fuelLiters;

        if (newFuelQuantity > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(newFuelQuantity);
    }

    public void printRemainingFuel() {
        System.out.printf("%s: %.2f%n", getClass().getSimpleName(), getFuelQuantity());
    }
}
