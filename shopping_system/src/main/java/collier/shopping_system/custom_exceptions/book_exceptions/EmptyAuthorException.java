package collier.shopping_system.custom_exceptions.book_exceptions;

import collier.shopping_system.custom_exceptions.EmptyStringException;

public final class EmptyAuthorException extends EmptyStringException{
    public EmptyAuthorException() {
        super("Book Author cannot be empty");
    }
}
