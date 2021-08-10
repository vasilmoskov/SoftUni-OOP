package DesignPatternsExercises.E03CommandPattern;

public class IncreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public IncreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeAction() {
        this.product.increasePrice(this.amount);
        return String.format("The price for the %s has been decreased by %d$.%n"
                , this.product.getName(), this.amount);
    }
}
