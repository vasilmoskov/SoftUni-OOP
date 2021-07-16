package InterfacesАndAbstractionExercises.L04FoodShortage;

public class Citizen implements Birthable, Identifiable, Person, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food = 0;


    public Citizen(String name, int age, String id, String birthDate) {
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
    public void buyFood() {
        food += 10;
    }

    @Override
    public int getFood() {
        return food;
    }
}
