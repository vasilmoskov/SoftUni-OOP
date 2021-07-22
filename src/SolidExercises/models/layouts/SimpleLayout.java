package SolidExercises.models.layouts;

import SolidExercises.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
