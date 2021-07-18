package PolymorphismExercises.E02VehiclesExtension;

public class Bus extends Vehicle{
    private boolean busIsEmpty = false;

    protected Bus(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public void setBusIsEmpty() {
        this.busIsEmpty = true;
    }

    @Override
    protected void drive(double distance) {
        double fuelNeeded = busIsEmpty ? distance * getFuelConsumptionInLitersPerKm() :
                distance * (getFuelConsumptionInLitersPerKm() + 1.4);

        if (getFuelQuantity() >= fuelNeeded) {
            setFuelQuantity(getFuelQuantity() - fuelNeeded);

            System.out.println("Bus travelled " + getFormatParameter(distance) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

}
