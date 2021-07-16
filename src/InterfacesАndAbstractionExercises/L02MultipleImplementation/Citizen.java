package InterfacesАndAbstractionExercises.L02MultipleImplementation;

public class Citizen implements Birthable, Identifiable, Person {
    private String name;
    private int age;
    private String birthDate;
    private String id;

    public Citizen(String name, int age, String birthDate, String id) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.id = id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate='" + birthDate + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
