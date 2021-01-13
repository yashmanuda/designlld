package vendingmachine.exceptions;

public class InsufficientAmountException extends Exception{
    public InsufficientAmountException(String s) {
        super(s);
    }
}
