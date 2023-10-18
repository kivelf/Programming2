package observer_weatherdata_book;


public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // push
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.display();
    }

    @Override
    public void display() {
        System.out.println("*** Current conditions ***");
        System.out.println(temperature + "F degrees and " + humidity + "% humidity");
    }
}
