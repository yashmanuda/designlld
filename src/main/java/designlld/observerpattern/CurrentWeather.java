package designlld.observerpattern;

import lombok.Getter;

@Getter
public class CurrentWeather implements Observer {
    private float currentTemperature;
    private float currentWindSpeed;


    @Override
    public String toString() {
        return "CurrentTemperature : " + currentTemperature +
                ", CurrentWindSpeed : " + currentWindSpeed;
    }

    CurrentWeather(Observable observable) {
        observable.addObserver(this);
    }

    /**
     * @param observable takes in an observable, to notify observable that observer is added
     * @throws ClassCastException if observable is not of type WeatherObservable, it will throw an exception
     */
    @Override
    public void update(Observable observable) throws ClassCastException {
        WeatherObservable weatherObservable = (WeatherObservable) observable;
        this.currentTemperature = weatherObservable.getTemperature();
        this.currentWindSpeed = weatherObservable.getWindSpeed();
        System.out.println("Observer " + this.getClass().getSimpleName() + " updated - " + this.toString());
    }

    /**
     * initializing can be different from update logic
     *
     * @param observable takes in an observable, to notify observable that observer is initialized
     */
    @Override
    public void initialize(Observable observable) {
        this.currentTemperature = 0f;
        this.currentWindSpeed = 0f;
        System.out.println("Observer " + this.getClass().getSimpleName() + " initialized : " + this.toString());

    }
}
