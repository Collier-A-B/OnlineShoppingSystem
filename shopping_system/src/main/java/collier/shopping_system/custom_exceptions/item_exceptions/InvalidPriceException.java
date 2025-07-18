package collier.shopping_system.custom_exceptions.item_exceptions;

import collier.shopping_system.custom_exceptions.InvalidInputException;

public final class InvalidPriceException extends InvalidInputException{
    public InvalidPriceException() {
        super("Item price must be greater than zero");
    }
}
