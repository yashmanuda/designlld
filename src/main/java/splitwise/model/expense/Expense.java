package splitwise.model.expense;

import lombok.Getter;
import splitwise.exeptions.InvalidExpenseException;
import splitwise.model.User;
import splitwise.model.split.Split;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public abstract class Expense {
    private final double EPSILON = 0.00000d;
    private final User paidBy;
    protected List<Split> splits;
    protected double totalAmount;
    private String expenseId;
    private int date;

    Expense(User paidBy, List<Split> splits, double totalAmount, int date) throws InvalidExpenseException {
        this.paidBy = paidBy;
        this.splits = splits;
        this.totalAmount = totalAmount;
        this.date = date;
        this.expenseId = UUID.randomUUID().toString();
        if (!isValidInput() || !validateExpense()) throw new InvalidExpenseException("Invalid expense created!");
    }

    private boolean isValidInput() {
        return splits.size() > 0 && !(totalAmount <= 0) && areAllUsersUnique();
    }

    private boolean areAllUsersUnique() {
        return splits.stream().map(x -> x.getUser().getUserId()).collect(Collectors.toSet()).size() == splits.size();
    }

    boolean areDoubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) == 0 || Math.abs(d1 - d2) < EPSILON;
    }

    abstract boolean validateExpense();
}
