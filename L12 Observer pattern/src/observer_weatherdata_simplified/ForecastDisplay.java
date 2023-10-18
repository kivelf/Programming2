package observer_weatherdata_simplified;

public class ForecastDisplay implements Observer {
    private float currentPressure = 29.92f;

    @Override
    public void update(float temp, float humidity, float pressure) { // push
        float lastPressure = currentPressure;
        currentPressure = pressure;
        System.out.println("*** Forecast *** ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
