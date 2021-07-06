package WorkingWithAbstractionExercise.E01CardSuit;

public class Main {
    public static void main(String[] args) {

        CardSuit[] values = CardSuit.values();

        System.out.println("Card Suits:");

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }


    }
}
