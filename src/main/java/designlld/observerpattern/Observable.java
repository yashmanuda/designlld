package designlld.observerpattern;

public interface Observable<T> {
    /**
     * @param values only T type class instance can change state of observable
     */
    void changeState(T values);

    /**
     * Once the state of observable is changed, it has to notify all the observers
     */
    void notifyAllClients();

    /**
     * @param o observer to add
     */
    void addObserver(Observer o);

    /**
     * @param o observer to remove
     * @return false if no such observer exists to remove
     */
    boolean removeObserver(Observer o);

}
