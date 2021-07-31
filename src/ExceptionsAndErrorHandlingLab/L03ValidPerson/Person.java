package ExceptionsAndErrorHandlingLab.L03ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkNameValidity(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkNameValidity(lastName);
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw  new IllegalArgumentException("Age should be in the range [0...120]");
        }
        this.age = age;
    }

    public void checkNameValidity(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException ("The name cannot be null or empty");
        }

        for (int currChar = 0; currChar < name.length(); currChar++) {
            if (!Character.isAlphabetic(name.charAt(currChar))) {
                throw new InvalidPersonNameException("Name should consist only alphabetical letters");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}
