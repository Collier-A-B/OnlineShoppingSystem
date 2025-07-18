package collier.shopping_system.custom_exceptions;

public class NegativeStockException extends NegativeInputException {
    public NegativeStockException() {
        super("item stock cannot be less than zero");
    }
}
