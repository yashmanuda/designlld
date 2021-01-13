package splitwise.exeptions;

public class InvalidExpenseTypeException extends Exception {
    public InvalidExpenseTypeException(String message) {
        super(message);
    }
}
