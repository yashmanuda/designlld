package splitwise.model.split;

import lombok.Getter;
import splitwise.model.User;

@Getter
public class PercentSplit extends Split {
    private final double percent;

    public PercentSplit(User user, double userShare, double percent) {
        super(user, userShare);
        this.percent = percent;
    }
}
