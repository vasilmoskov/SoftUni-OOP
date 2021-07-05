package WorkingWithAbstractionLab.L04HotelReservation;

public class PriceCalculator {

    public static String getPrice (DiscountType discountType, Season season, int numberOfDays, double pricePerDay) {
        double totalPrice = numberOfDays * pricePerDay * season.getSeasonNumber();
        double discount = totalPrice * discountType.getDiscountInPercent();

        return String.format("%.2f", totalPrice - discount);
    }

}
