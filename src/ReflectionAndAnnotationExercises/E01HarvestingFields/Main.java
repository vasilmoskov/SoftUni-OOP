package ReflectionAndAnnotationExercises.E01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Class reflection = RichSoilLand.class;

        Field[] fields = reflection.getDeclaredFields();

        Consumer<Field> fieldPrinter = f -> System.out.printf("%s %s %s%n",
                Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName());

        while (!input.equals("HARVEST")) {

            switch (input) {
                case "private":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "protected":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "public":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(fieldPrinter);
                    break;

            }

            input = scanner.nextLine();
        }
    }
}
