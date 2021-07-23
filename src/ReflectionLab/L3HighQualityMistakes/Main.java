package ReflectionLab.L3HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;

        Field[] fields = reflection.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Method[] methods = reflection.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(getter -> {
            int modifiers = getter.getModifiers();
            if (!Modifier.isPublic(modifiers)) {
                System.out.println(getter.getName() + " have to be public");
            }
        });

        Method[] setters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(setter -> {
            int modifiers = setter.getModifiers();
            if (!Modifier.isPrivate(modifiers)) {
                System.out.println(setter.getName() + " have to be private");
            }
        });

    }
}
