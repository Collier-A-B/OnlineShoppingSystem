package collier.shopping_system.custom_exceptions.book_exceptions;

import collier.shopping_system.custom_exceptions.EmptyStringException;

public final class EmptyTitleException extends EmptyStringException{
    public EmptyTitleException() {
        super("Book title cannot be empty");
    }
}
