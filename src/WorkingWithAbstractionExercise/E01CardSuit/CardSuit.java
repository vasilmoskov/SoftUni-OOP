package WorkingWithAbstractionExercise.E01CardSuit;

public enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;


    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name());
    }

//    @Override
//    public Iterator<CardSuit> iterator() {
//        return new Iterator<CardSuit>() {
//            private int counter;
//
//            @Override
//            public boolean hasNext() {
//                return counter < CardSuit.values().length;
//            }
//
//            @Override
//            public CardSuit next() {
//                return CardSuit.values()[counter++];
//            }
//        };
//    }
}
