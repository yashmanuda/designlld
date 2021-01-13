package splitwise.model.expense;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.model.User;
import splitwise.model.split.PercentSplit;
import splitwise.model.split.Split;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(User paidBy, List<Split> splits, double totalAmount, int date) throws InvalidExpenseException {
        super(paidBy, splits, totalAmount, date);
    }

    @Override
    boolean validateExpense() {
        double currentTotalPercent = 0.0d;
        double currentTotalAmount = 0.0d;
        for (Split split : splits) {
            if (!(split instanceof PercentSplit)) return false;
            currentTotalPercent += ((PercentSplit) split).getPercent();
            currentTotalAmount += split.getUserShare();
        }
        return areDoubleEqual(currentTotalPercent, 100.0d) && areDoubleEqual(currentTotalAmount, totalAmount);
    }
}
