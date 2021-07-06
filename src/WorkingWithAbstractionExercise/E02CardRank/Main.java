package WorkingWithAbstractionExercise.E02CardRank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        for (CardRank value : CardRank.values()) {
            System.out.println(value);
        }
    }
}
