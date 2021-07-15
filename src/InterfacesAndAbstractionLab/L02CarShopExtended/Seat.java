package InterfacesAndAbstractionLab.L02CarShopExtended;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Integer getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have 4 tires\n" +
                "%s sells for %f", getModel(), countryProduced(), getModel(), getPrice());
    }
}
