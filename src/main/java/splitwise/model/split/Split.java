package splitwise.model.split;

import lombok.AllArgsConstructor;
import lombok.Getter;
import splitwise.model.User;

@AllArgsConstructor
@Getter
public abstract class Split {
    private User user;
    private double userShare;

    public void setUserShare(double userShare) {
        this.userShare = userShare;
    }
}
