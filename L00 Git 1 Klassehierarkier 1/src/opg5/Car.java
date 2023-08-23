package opg5;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String make, String model, int year, double mileage, int numDoors) {
        super(make, model, year, mileage);
        this.numDoors = numDoors;
    }
}
