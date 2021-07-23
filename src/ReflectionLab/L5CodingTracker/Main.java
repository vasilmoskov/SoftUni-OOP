package ReflectionLab.L5CodingTracker;

public class Main {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {

    }


}
