package PolymorphismExercises.E01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private DecimalFormat format = new DecimalFormat("#.##");

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public String getFormatParameter(double parameter) {
        return format.format(parameter);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    public void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    //protected abstract void drive(double distance);

    protected void drive(double distance) {
        double fuelNeeded = distance * fuelConsumptionInLitersPerKm;

        if (getFuelQuantity() >= fuelNeeded) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            System.out.println(this.getClass().getSimpleName() + " travelled "
                    + getFormatParameter(distance) + " km");
        } else {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        }
    }

    //public abstract void refuel(double liters);

    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    // public abstract void printRemainingFuel();

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
