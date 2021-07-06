package WorkingWithAbstractionExercise.E03CardsWithPower;

public class Card {
    private RankPower rankPower;
    private SuitPower suitPower;
    private int power;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
        this.power = rankPower.getValue() + suitPower.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rankPower.name(), suitPower.name(), power);
    }
}
