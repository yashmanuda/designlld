package designpatterns.behavioural.memento;

/**
 * The state of the originator is saved in this object
 * The state is immutable
 *
 * @param <T> type of the state
 */
public class Memento<T> {
    private final T state;

    Memento(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }
}
