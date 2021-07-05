package WorkingWithAbstractionLab;

import java.util.Scanner;

public class L01RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int starsCount = 1; starsCount <= size; starsCount++) {
            printRow(size, starsCount);
        }

        for (int starsCount = size - 1; starsCount > 0; starsCount--) {
            printRow(size, starsCount);
        }
    }

    static void printRow(int figureSize, int starCount) {
        for (int i = 0; i < figureSize - starCount; i++) {
            System.out.print(" ");
        }

        for (int col = 1; col < starCount; col++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }

}
