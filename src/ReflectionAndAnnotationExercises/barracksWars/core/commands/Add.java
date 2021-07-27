package ReflectionAndAnnotationExercises.barracksWars.core.commands;

import ReflectionAndAnnotationExercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
