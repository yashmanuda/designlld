package splitwise.manager;

import splitwise.exeptions.InvalidExpenseException;
import splitwise.exeptions.InvalidExpenseTypeException;
import splitwise.model.User;
import splitwise.model.expense.Expense;
import splitwise.model.split.Split;
import splitwise.services.ExpenseService;
import splitwise.services.ExpenseServiceInput;

import java.util.*;

public class ExpenseManager {
    private static ExpenseManager INSTANCE;
    private final Map<String, User> userIdToUser;
    private final Map<String, Map<String, Double>> userToUserAmount;
    private final List<Expense> listOfExpenses;

    private ExpenseManager() {
        this.userIdToUser = new HashMap<>();
        this.userToUserAmount = new HashMap<>();
        this.listOfExpenses = new ArrayList<>();
    }

    public static ExpenseManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ExpenseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ExpenseManager();
                }
            }
        }
        return INSTANCE;
    }

    public void addUser(String userId, String name, int number, String email) {
        User user = new User(userId, name, number, email);
        userIdToUser.put(userId, user);
        userToUserAmount.put(userId, new HashMap<>());
    }

    public void createExpense(ExpenseServiceInput expenseServiceInput) throws InvalidExpenseException, InvalidExpenseTypeException {
        Expense expense = ExpenseService.createExpense(expenseServiceInput);
        listOfExpenses.add(expense);
        String paidByUserId = expense.getPaidBy().getUserId();
        for (Split split : expense.getSplits()) {
            String paidForUserId = split.getUser().getUserId();
            double amountPaid = split.getUserShare();
            if (paidByUserId.equals(paidForUserId)) continue;
            updatePaidUser(paidByUserId, paidForUserId, amountPaid);
            updatePaidUser(paidForUserId, paidByUserId, -amountPaid);
        }
    }

    private void updatePaidUser(String paidByUserId, String paidForUserId, double amountPaid) {
        Map<String, Double> paidByBalances = userToUserAmount.get(paidByUserId);
        paidByBalances.put(paidForUserId, paidByBalances.getOrDefault(paidForUserId, 0.0d) + amountPaid);
    }

    private Set<String> showBalances(String userId) {
        Set<String> owingAmounts = new HashSet<>();
        Map<String, Double> userBalances = userToUserAmount.get(userId);
        for (Map.Entry<String, Double> entry : userBalances.entrySet()) {
            double paid = entry.getValue();
            String result = null;
            if (paid > 0) result = printBalance(userId, entry.getKey(), paid);
            else if (paid < 0) result = printBalance(entry.getKey(), userId, -paid);
            if (result != null) owingAmounts.add(result);
        }
        return owingAmounts;
    }

    public Set<String> showBalances() {
        Set<String> owningAmount = new HashSet<>();
        for (Map.Entry<String, Map<String, Double>> entry : userToUserAmount.entrySet()) {
            Set<String> userOwes = showBalances(entry.getKey());
            owningAmount.addAll(userOwes);
        }
        return owningAmount;
    }

    private String printBalance(String payer, String payee, double amount) {
        User payerUser = userIdToUser.get(payer);
        User payeeUser = userIdToUser.get(payee);
        return payeeUser + " owes " + String.format("%.2f", amount) + " to " + payerUser;
    }

    public User getUser(String userId) {
        return userIdToUser.get(userId);
    }

}
