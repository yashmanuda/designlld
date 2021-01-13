package splitwise;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.exeptions.InvalidExpenseTypeException;
import splitwise.manager.ExpenseManager;
import splitwise.model.User;
import splitwise.model.expense.ExpenseType;
import splitwise.services.ExpenseServiceInput;

import java.util.*;

public class SplitwiseTest {
    public static void main(String[] args) throws InvalidExpenseException, InvalidExpenseTypeException {
        ExpenseManager expenseManager = ExpenseManager.getInstance();
        expenseManager.addUser("1", "u1", 1, "e1");
        expenseManager.addUser("2", "u2", 2, "e2");
        expenseManager.addUser("3", "u3", 3, "e3");

        User u1 = expenseManager.getUser("1");
        User u2 = expenseManager.getUser("2");
        User u3 = expenseManager.getUser("3");


        ExpenseServiceInput equalAmount = ExpenseServiceInput.builder()
                .date(1)
                .expenseType(ExpenseType.EQUAL)
                .listOfUsers(getListOfUsers(u1, u2, u3))
                .paidBy(u1)
                .totalAmount(600).build();

        ExpenseServiceInput exactAmount = ExpenseServiceInput.builder()
                .date(2)
                .expenseType(ExpenseType.EXACT)
                .userToAmountMap(new HashMap<User, Double>() {{
                    put(u1, 500.0);
                    put(u3, 300.0);
                }})
                .paidBy(u2)
                .totalAmount(800).build();

        ExpenseServiceInput percentAmount = ExpenseServiceInput.builder()
                .date(3)
                .expenseType(ExpenseType.PERCENT)
                .userToPercentMap(new HashMap<User, Double>() {{
                    put(u2, 60.0);
                    put(u1, 40.0);
                }})
                .paidBy(u3)
                .totalAmount(750).build();

        expenseManager.createExpense(equalAmount);
        expenseManager.createExpense(exactAmount);
        expenseManager.createExpense(percentAmount);


        Set<String> finalBalance = expenseManager.showBalances();
        for (String s : finalBalance) System.out.println(s);
    }

    private static List<User> getListOfUsers(User... users) {
        return new ArrayList<>(Arrays.asList(users));
    }
}
