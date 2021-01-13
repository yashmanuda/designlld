package vendingmachine.exceptions;

public class IncorrectProductCountException extends Exception {
    public IncorrectProductCountException(String s) {
        super(s);
    }
}
