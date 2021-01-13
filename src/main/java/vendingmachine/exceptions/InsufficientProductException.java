package vendingmachine.exceptions;

public class InsufficientProductException extends Exception {
    public InsufficientProductException(String s) {
        super(s);
    }
}
