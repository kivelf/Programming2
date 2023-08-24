package opg5;

public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private double mileage;

    public Vehicle(String make, String model, int year, double mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public void displayInfo(){
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year produced: " + year);
        System.out.println("Mileage: " + mileage + " km");
    }

    public abstract void start();

    public abstract void stop();

    public void performAction(){
        this.action();
    }

    public void action(){
        // empty method...
    }
}
