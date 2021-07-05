package WorkingWithAbstractionLab.L04HotelReservation;

public enum DiscountType {
    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0);

    private double discountInPercent;

    DiscountType(double discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    public double getDiscountInPercent() {
        return discountInPercent;
    }
}
