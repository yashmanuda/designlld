package designpatterns.behavioural.observer;

/**
 * All observers must implement this class
 */
public interface IObserver {
    void update(String event);
}
