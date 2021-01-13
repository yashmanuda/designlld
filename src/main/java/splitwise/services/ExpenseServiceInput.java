package splitwise.services;

import lombok.Builder;
import lombok.Getter;
import splitwise.model.User;
import splitwise.model.expense.ExpenseType;

import java.util.List;
import java.util.Map;

@Builder
@Getter
public class ExpenseServiceInput {
    private ExpenseType expenseType;
    private User paidBy;
    private int date;
    private double totalAmount;
    private Map<User, Double> userToAmountMap;
    private Map<User, Double> userToPercentMap;
    private List<User> listOfUsers;
}
