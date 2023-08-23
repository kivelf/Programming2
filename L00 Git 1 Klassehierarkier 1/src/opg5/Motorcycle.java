package opg5;

public class Motorcycle extends Vehicle {
    private int engineSize;

    public Motorcycle(String make, String model, int year, double mileage, int engineSize) {
        super(make, model, year, mileage);
        this.engineSize = engineSize;
    }
}
