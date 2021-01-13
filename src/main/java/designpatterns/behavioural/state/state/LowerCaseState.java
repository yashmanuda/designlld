package designpatterns.behavioural.state.state;

import designpatterns.behavioural.state.Context;

public class LowerCaseState implements State {

    @Override
    public void writeName(Context context, String name) {
        System.out.println(name.toLowerCase());
        context.setState(new UpperCaseState());
    }
}
