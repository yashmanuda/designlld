package designlld.observerpattern;

import lombok.Getter;

@Getter
class WeatherMeasurements {
    private float temperature;
    private float windSpeed;

    WeatherMeasurements(float temperature, float windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }
}
