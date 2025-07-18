package collier.shopping_system.custom_exceptions;

public class NegativeInputException extends InvalidInputException {
    public NegativeInputException() {
        super("Negative numbers are not valid input.");
    }
    protected NegativeInputException(String msg) {
        super(msg);
    }
}
