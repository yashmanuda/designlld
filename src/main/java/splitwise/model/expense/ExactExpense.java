package splitwise.model.expense;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.model.User;
import splitwise.model.split.ExactSplit;
import splitwise.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(User paidBy, List<Split> splits, double totalAmount, int date) throws InvalidExpenseException {
        super(paidBy, splits, totalAmount, date);
    }

    @Override
    public boolean validateExpense() {
        double currentTotalAmount = 0.0d;
        for (Split split : splits) {
            if (!(split instanceof ExactSplit)) return false;
            currentTotalAmount += split.getUserShare();
        }
        return areDoubleEqual(currentTotalAmount, totalAmount);
    }
}
