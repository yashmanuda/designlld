package splitwise.services;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.exeptions.InvalidExpenseTypeException;
import splitwise.model.User;
import splitwise.model.expense.*;
import splitwise.services.splitter.EqualSplitter;
import splitwise.services.splitter.ExactSplitter;
import splitwise.services.splitter.PercentSplitter;
import splitwise.services.splitter.Splitter;

public class ExpenseService {
    private static final Splitter exactSplitter = new ExactSplitter();
    private static final Splitter equalSplitter = new EqualSplitter();
    private static final Splitter percentSplitter = new PercentSplitter();

    public static Expense createExpense(ExpenseServiceInput expenseServiceInput) throws InvalidExpenseException, InvalidExpenseTypeException {
        try {
            ExpenseType expenseType = expenseServiceInput.getExpenseType();
            User paidBy = expenseServiceInput.getPaidBy();
            int date = expenseServiceInput.getDate();
            double totalAmount = expenseServiceInput.getTotalAmount();

            switch (expenseType) {
                case EXACT:
                    return new ExactExpense(paidBy, exactSplitter.createSplits(expenseServiceInput), totalAmount, date);
                case EQUAL:
                    return new EqualExpense(paidBy, equalSplitter.createSplits(expenseServiceInput), totalAmount, date);
                case PERCENT:
                    return new PercentExpense(paidBy, percentSplitter.createSplits(expenseServiceInput), totalAmount, date);
                default:
                    throw new InvalidExpenseTypeException("Invalid expense type!");
            }
        } catch (InvalidExpenseException | InvalidExpenseTypeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
