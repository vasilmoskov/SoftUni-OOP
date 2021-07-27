package ReflectionAndAnnotationExercises.barracksWars;

import ReflectionAndAnnotationExercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotationExercises.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationExercises.barracksWars.core.Engine;
import ReflectionAndAnnotationExercises.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationExercises.barracksWars.data.UnitRepository;

public class    Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
