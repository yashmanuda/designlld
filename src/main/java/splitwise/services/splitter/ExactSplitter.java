package splitwise.services.splitter;

import splitwise.model.User;
import splitwise.model.split.ExactSplit;
import splitwise.model.split.Split;
import splitwise.services.ExpenseServiceInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExactSplitter implements Splitter {
    @Override
    public List<Split> createSplits(ExpenseServiceInput expenseServiceInput) {
        Map<User, Double> userAmountMap = expenseServiceInput.getUserToAmountMap();
        List<Split> result = new ArrayList<>();
        for (Map.Entry<User, Double> entry : userAmountMap.entrySet()) {
            result.add(new ExactSplit(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
