package opg5;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String make, String model, int year, double mileage, int numDoors) {
        super(make, model, year, mileage);
        this.numDoors = numDoors;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of doors: " + numDoors);
        System.out.println();
    }

    @Override
    public void start(){
        System.out.println("The car is now on...");
    }

    @Override
    public void stop(){
        System.out.println("The car is now turned off...");
    }

    @Override
    public void action(){
        System.out.println("Cars go vroom vroom, honk honk!");
    }
}
