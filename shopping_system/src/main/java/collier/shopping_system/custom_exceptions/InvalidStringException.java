package collier.shopping_system.custom_exceptions;

public class InvalidStringException extends InvalidInputException{
    public InvalidStringException() {
        super("Inputed string is not valid");
    }
    protected InvalidStringException(String msg) {
        super(msg);
    }
}
