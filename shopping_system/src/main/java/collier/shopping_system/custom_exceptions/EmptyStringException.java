package collier.shopping_system.custom_exceptions;

public class EmptyStringException extends InvalidStringException {
    public EmptyStringException() {
        super("inputed string cannot be empty.");
    }
    protected EmptyStringException(String msg) {
        super(msg);
    }
}
