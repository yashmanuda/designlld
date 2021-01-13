package splitwise.services.splitter;

import splitwise.model.split.Split;
import splitwise.services.ExpenseServiceInput;

import java.util.List;

public interface Splitter {
    List<Split> createSplits(ExpenseServiceInput expenseServiceInput);
}
