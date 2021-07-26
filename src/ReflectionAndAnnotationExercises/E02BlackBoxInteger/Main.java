package ReflectionAndAnnotationExercises.E02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        Scanner scanner = new Scanner(System.in);

        Class reflection = BlackBoxInt.class;

        Constructor constructor = reflection.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Method addMethod = reflection.getDeclaredMethod("add", int.class);
        addMethod.setAccessible(true);

        Method subtractMethod = reflection.getDeclaredMethod("subtract", int.class);
        subtractMethod.setAccessible(true);

        Method multiplyMethod = reflection.getDeclaredMethod("multiply", int.class);
        multiplyMethod.setAccessible(true);

        Method divideMethod = reflection.getDeclaredMethod("divide", int.class);
        divideMethod.setAccessible(true);

        Method leftShiftMethod = reflection.getDeclaredMethod("leftShift", int.class);
        leftShiftMethod.setAccessible(true);

        Method rightShiftMethod = reflection.getDeclaredMethod("rightShift", int.class);
        rightShiftMethod.setAccessible(true);

        Field field = reflection.getDeclaredField("innerValue");
        field.setAccessible(true);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String commandName = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            switch (commandName) {
                case "add":
                    addMethod.invoke(blackBoxInt, value);
                    Object fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
                case "subtract":
                    subtractMethod.invoke(blackBoxInt, value);
                    fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
                case "divide":
                    divideMethod.invoke(blackBoxInt, value);
                    fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
                case "multiply":
                    multiplyMethod.invoke(blackBoxInt, value);
                    fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
                case "rightShift":
                    rightShiftMethod.invoke(blackBoxInt, value);
                    fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
                case "leftShift":
                    leftShiftMethod.invoke(blackBoxInt, value);
                    fieldValue = field.get(blackBoxInt);
                    System.out.println(fieldValue);
                    break;
            }

            input = scanner.nextLine();
        }


    }
}
