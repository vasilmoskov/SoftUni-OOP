package WorkingWithAbstractionLab.L04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tokens = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble (tokens[0]);
        int numberOfDays = Integer.parseInt (tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());

        DiscountType discountType;

        switch (tokens[3]) {
            case "VIP":
                discountType = DiscountType.VIP;
                break;
            case "SecondVisit":
                discountType = DiscountType.SECOND_VISIT;
                break;
            case "None":
                discountType = DiscountType.NONE;
                break;
            default:
                throw new IllegalArgumentException("Unknown discount type " + tokens[3]);
        }

        System.out.println(PriceCalculator.getPrice(discountType, season, numberOfDays, pricePerDay));
    }
}
