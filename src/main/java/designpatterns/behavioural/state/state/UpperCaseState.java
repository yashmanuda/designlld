package designpatterns.behavioural.state.state;

import designpatterns.behavioural.state.Context;

public class UpperCaseState implements State {
    private int count;

    UpperCaseState() {
        this.count = 0;
    }

    @Override
    public void writeName(Context context, String name) {
        System.out.println(name.toUpperCase());
        if (++count >= 2) context.setState(new LowerCaseState());

    }
}
