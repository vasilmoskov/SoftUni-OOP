package WorkingWithAbstractionLab.L02PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottomLeftX = scanner.nextInt();
        int bottomLeftY = scanner.nextInt();
        int topRightX = scanner.nextInt();
        int topRightY = scanner.nextInt();

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = scanner.nextInt();

        while (n-- > 0) {
            int currX = scanner.nextInt();
            int currY = scanner.nextInt();

            Point currPoint = new Point(currX, currY);

            System.out.println(rectangle.contains(currPoint));
        }
    }
}
