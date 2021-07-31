package ExceptionsAndErrorHandlingLab;

import java.util.Scanner;
import java.util.stream.IntStream;

public class L02EnterNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String start = scanner.nextLine();
            String end = scanner.nextLine();

            try {
                printNumbersRange(start, end);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void printNumbersRange(String start, String end) {

        int s;
        int e;

        try {
            s = Integer.parseInt(start);
            e = Integer.parseInt(end);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid input range. Please try again.", ex);
        }

        if (!(1 < s && s < e && e < 100)) {
            throw new IllegalArgumentException("Invalid input range. Please try again.");
        }

        IntStream.rangeClosed(s, e).forEach(System.out::println);
    }
}
