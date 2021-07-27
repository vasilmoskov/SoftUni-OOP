package ReflectionAndAnnotationExercises.barracksWars.core.factories;

import ReflectionAndAnnotationExercises.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationExercises.barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotationExercises.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        try {
            Class<? extends AbstractUnit> clazz = (Class<? extends AbstractUnit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<? extends AbstractUnit> constructor = clazz.getConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }
}
