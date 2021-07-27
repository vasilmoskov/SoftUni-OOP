package ReflectionAndAnnotationExercises.barracksWars.core.commands;

import ReflectionAndAnnotationExercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
