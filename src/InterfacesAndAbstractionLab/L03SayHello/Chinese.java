package InterfacesAndAbstractionLab.L03SayHello;

public class Chinese implements Person{
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public String sayHello() {
        return "Djydjybydjy";
    }
}
