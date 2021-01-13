package designpatterns.behavioural.state;

import designpatterns.behavioural.state.state.LowerCaseState;
import designpatterns.behavioural.state.state.State;

/**
 * This is the context which has a state which will might change after printName is called
 */
public class Context {
    private State state;

    Context() {
        this.state = new LowerCaseState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void printName(String name) {
        state.writeName(this, name);
    }
}
