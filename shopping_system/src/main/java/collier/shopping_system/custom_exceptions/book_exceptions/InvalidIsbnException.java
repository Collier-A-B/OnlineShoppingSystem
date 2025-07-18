package collier.shopping_system.custom_exceptions.book_exceptions;

import collier.shopping_system.custom_exceptions.InvalidStringException;

public final class InvalidIsbnException extends InvalidStringException {
    public InvalidIsbnException() {
        super("Book ISBN must be a string of numbers 13 characters long");
    }
}
