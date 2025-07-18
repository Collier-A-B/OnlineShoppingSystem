package collier.shopping_system.custom_exceptions;

import java.io.IOException;

public class InvalidInputException extends IOException{
    public InvalidInputException() {
        super("User input is invalid.");
    } 
    protected InvalidInputException(String msg) {
        super(msg);
    }
}
