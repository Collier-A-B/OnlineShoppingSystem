package collier.shopping_system.custom_exceptions;

public final class EmptyDescriptionException extends EmptyStringException {
    public EmptyDescriptionException() {
        super("Item description cannot be empty string");
    }
}
