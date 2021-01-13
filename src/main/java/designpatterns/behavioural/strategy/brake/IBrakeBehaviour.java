package designpatterns.behavioural.strategy.brake;

/**
 * This is the actual strategy that a car will use
 * Traditional composition over inheritance is preferred
 */
public interface IBrakeBehaviour {

    void applyBreak();
}
