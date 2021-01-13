package designlld.observerpattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * push architecture observable example
 */
@Getter
public class WeatherObservable implements Observable<WeatherMeasurements> {
    // observer list in the observable
    private List<Observer> observerList;

    // member variables of observable
    private float temperature;
    private float windSpeed;


    WeatherObservable(float temperature, float windSpeed) {
        this.observerList = new ArrayList<>();
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    /**
     * It updates the member variables of this observable and notifies all the observers
     *
     * @param values only WeatherMeasurements can update the state of this observable
     */
    @Override
    public void changeState(WeatherMeasurements values) {
        this.windSpeed = values.getWindSpeed();
        this.temperature = values.getTemperature();
        System.out.println(this.getClass().getSimpleName() + " state changed.");
        this.notifyAllClients();

    }

    @Override
    public void notifyAllClients() {
        if (observerList.size() == 0) {
            System.out.println("No observer to notify in " + this.getClass().getSimpleName());
        } else {
            for (Observer observer : observerList) {
                observer.update(this);
            }
        }
    }

    /**
     * When observer is removed and added again it gets initialized
     *
     * @param o observer which needs to be added in the observer list
     * @throws NullPointerException if o is null
     */
    @Override
    public void addObserver(Observer o) throws NullPointerException {
        if (this.observerList.contains(o)) {
            System.out.println("Observer already exists in " + this.getClass().getSimpleName() + ", not adding again.");
        } else {
            o.initialize(this);
            this.observerList.add(o);
        }
    }

    /**
     * @param o observer which needs to be removed from observed list
     * @return true if observer is removed; else false
     */
    @Override
    public boolean removeObserver(Observer o) {
        return this.observerList.remove(o);
    }

}
