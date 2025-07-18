package collier.shopping_system.custom_exceptions.item_exceptions;

import collier.shopping_system.custom_exceptions.InvalidStringException;

public final class InvalidHexIdException extends InvalidStringException{
    public InvalidHexIdException() {
        super("Item Hex Id String must be valid hex-decimal number greater than zero");
    }
}
