package designpatterns.behavioural.memento;

/**
 * This is the object whose internal state needs to be saved
 * The state should be immutable
 *
 * @param <T> type of the state
 */
public class Originator<T> {
    private T state;

    Originator(T state) {
        this.state = state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public Memento<T> getMemento() {
        return new Memento<>(state);
    }

    public T getState() {
        return state;
    }

    /**
     * @param memento restore the state of the originator from memento
     */
    public void restoreFromMemento(Memento<T> memento) {
        this.state = memento.getState();
    }
}
