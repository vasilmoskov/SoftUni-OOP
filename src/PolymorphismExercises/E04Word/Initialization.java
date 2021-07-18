package PolymorphismExercises.E04Word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandInterface() {
            @Override
            public void init() {

            }

            @Override
            public void handleInput(String input) {

            }
        };
    }
}
