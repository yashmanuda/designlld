package designlld.observerpattern;

public interface Observer {
    /**
     * Each observer will define this method
     *
     * @param observable takes in an observable, to notify observable that observer is added
     */
    void update(Observable observable);

    /**
     * Observer initialization can be different from update method
     * @param observable takes in an observable, to notify observable that observer is initialized
     */
    void initialize(Observable observable);
}
