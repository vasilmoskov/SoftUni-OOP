package ExceptionsAndErrorHandlingLab;

import java.util.Scanner;

public class L01SquareRoot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            double number = sqrt(scanner);
            System.out.println(number);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Good bye");
        }

    }

    public static double sqrt (Scanner scanner) {

        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new NumberFormatException("Invalid number");
            }
        }

        int number = Integer.parseInt (str);

        return Math.sqrt(number);
    }
}
