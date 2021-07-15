package InterfacesAndAbstractionLab.L04SayHelloExtended;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
