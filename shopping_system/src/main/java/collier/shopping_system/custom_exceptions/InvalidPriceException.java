package collier.shopping_system.custom_exceptions;

public final class InvalidPriceException extends InvalidInputException{
    public InvalidPriceException() {
        super("Item price must be greater than zero");
    }
}
