package splitwise.services.splitter;

import splitwise.model.User;
import splitwise.model.split.PercentSplit;
import splitwise.model.split.Split;
import splitwise.services.ExpenseServiceInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentSplitter implements Splitter {
    @Override
    public List<Split> createSplits(ExpenseServiceInput expenseServiceInput) {
        double totalAmount = expenseServiceInput.getTotalAmount();
        Map<User, Double> userPercentMap = expenseServiceInput.getUserToPercentMap();
        List<Split> result = new ArrayList<>();
        for (Map.Entry<User, Double> entry : userPercentMap.entrySet()) {
            double userShare = totalAmount * entry.getValue() / 100.0d;
            result.add(new PercentSplit(entry.getKey(), userShare, entry.getValue()));
        }
        return result;
    }
}
