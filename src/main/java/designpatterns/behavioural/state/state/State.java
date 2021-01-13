package designpatterns.behavioural.state.state;

import designpatterns.behavioural.state.Context;

/**
 * State will modify the context when the method is called
 */
public interface State {
    void writeName(Context context, String name);
}
