package collier.shopping_system.custom_exceptions.item_exceptions;

import collier.shopping_system.custom_exceptions.EmptyStringException;

public final class EmptyDescriptionException extends EmptyStringException {
    public EmptyDescriptionException() {
        super("Item description cannot be empty string");
    }
}
