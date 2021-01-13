package splitwise.services.splitter;

import splitwise.model.User;
import splitwise.model.split.EqualSplit;
import splitwise.model.split.Split;
import splitwise.services.ExpenseServiceInput;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitter implements Splitter {
    @Override
    public List<Split> createSplits(ExpenseServiceInput expenseServiceInput) {
        double amount = expenseServiceInput.getTotalAmount();
        List<User> userList = expenseServiceInput.getListOfUsers();
        List<Split> result = new ArrayList<>();
        double perUserAmount = amount / userList.size();
        for (User user : userList) {
            EqualSplit equalSplit = new EqualSplit(user, perUserAmount);
            result.add(equalSplit);
        }
        return result;
    }
}
