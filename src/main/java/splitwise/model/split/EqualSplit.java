package splitwise.model.split;

import splitwise.model.User;

public class EqualSplit extends Split {
    public EqualSplit(User user, double userShare) {
        super(user, userShare);
    }
}
