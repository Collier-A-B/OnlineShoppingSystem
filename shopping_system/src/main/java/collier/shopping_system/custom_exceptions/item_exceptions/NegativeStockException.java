package collier.shopping_system.custom_exceptions.item_exceptions;

import collier.shopping_system.custom_exceptions.NegativeInputException;

public class NegativeStockException extends NegativeInputException {
    public NegativeStockException() {
        super("item stock cannot be less than zero");
    }
}
