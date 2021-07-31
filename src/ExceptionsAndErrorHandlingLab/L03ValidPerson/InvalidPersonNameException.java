package ExceptionsAndErrorHandlingLab.L03ValidPerson;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
