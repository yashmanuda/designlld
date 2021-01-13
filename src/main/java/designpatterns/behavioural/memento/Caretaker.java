package designpatterns.behavioural.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * The caretaker is responsible to store the state of the originator and manage its states
 */
public class Caretaker<T> {
    private final List<Memento<T>> mementoList;

    Caretaker() {
        this.mementoList = new ArrayList<>();
    }

    public void addMemento(Memento<T> memento) {
        mementoList.add(memento);
    }

    public Memento<T> getMemento(int stateIndex) {
        return mementoList.get(stateIndex);
    }
}
