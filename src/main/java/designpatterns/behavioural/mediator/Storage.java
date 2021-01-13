package designpatterns.behavioural.mediator;

/**
 * Storage class which will be read or modified only via mediator
 *
 * @param <T>
 */
public class Storage<T> {
    private T value;

    T getValue() {
        return value;
    }

    /**
     * @param mediator    via which client calls
     * @param storageName all the observers of storageName will be notified
     * @param value       new value of the storage
     */
    void setValue(Mediator<T> mediator, String storageName, T value) {
        this.value = value;
        mediator.notifyAllObservers(storageName);
    }
}
