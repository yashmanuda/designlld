package designlld.observerpattern;

public class Main {
    public static void main(String[] args) {
        // created one observable
        WeatherObservable weatherObservable = new WeatherObservable(1.0f, 2.0f);

        // created one observer
        CurrentWeather currentWeather = new CurrentWeather(weatherObservable);

        // updated observable state
        for (int i = 0; i < 2; i++) {
            weatherObservable.changeState(new WeatherMeasurements((float) i, (float) i));
        }

        // removed one observer
        System.out.println("Observer " + currentWeather.getClass().getSimpleName() + " removed - " + weatherObservable.removeObserver(currentWeather));


        // updated observable state again
        for (int i = 0; i < 1; i++) {
            weatherObservable.changeState(new WeatherMeasurements((float) i, (float) i));
        }

        // adding observer twice
        weatherObservable.addObserver(currentWeather);
        weatherObservable.addObserver(currentWeather);
    }
}
