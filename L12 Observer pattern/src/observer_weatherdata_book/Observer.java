package observer_weatherdata_book;

public interface Observer {
    void update(float temp, float humidity, float pressure); // push
}
