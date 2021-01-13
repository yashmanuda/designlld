package splitwise.model.expense;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.model.User;
import splitwise.model.split.EqualSplit;
import splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {


    public EqualExpense(User paidBy, List<Split> splits, double totalAmount, int date) throws InvalidExpenseException {
        super(paidBy, splits, totalAmount, date);
    }

    @Override
    boolean validateExpense() {
        double currentTotalAmount = 0.0d;
        double equalExpenseForEach = splits.get(0).getUserShare();
        for (Split split : splits) {
            if (!(split instanceof EqualSplit)) return false;
            if (!areDoubleEqual(equalExpenseForEach, split.getUserShare())) return false;
            currentTotalAmount += split.getUserShare();
        }
        return areDoubleEqual(currentTotalAmount, totalAmount);
    }
}
