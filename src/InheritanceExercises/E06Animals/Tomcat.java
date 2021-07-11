package InheritanceExercises.E06Animals;

public class Tomcat extends Cat {
    private static final String genderTomcat = "Male";

    public Tomcat(String name, int age) {
        super(name, age, genderTomcat);
    }

    public static String getGenderTomcat() {
        return genderTomcat;
    }

    @Override
    public String produceSound() {
        return "MEOW";

    }
}
