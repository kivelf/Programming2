package observer_weatherdata_simplified;

public interface Observer {
    void update(float temp, float humidity, float pressure); // push
}
