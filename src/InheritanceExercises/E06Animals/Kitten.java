package InheritanceExercises.E06Animals;

public class Kitten extends Cat {
    private static final String genderKitten = "Female";

    public Kitten(String name, int age) {
        super(name, age, genderKitten);
    }

    public static String getGenderKitten() {
        return genderKitten;
    }

    @Override
    public String produceSound() {
        return "Meow";
    }

}
