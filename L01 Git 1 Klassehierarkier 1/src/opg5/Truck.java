package opg5;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, double mileage, double loadCapacity) {
        super(make, model, year, mileage);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Load capacity: " + loadCapacity + " tonnes");
        System.out.println();
    }

    @Override
    public void start(){
        System.out.println("The truck is now on...");
    }

    @Override
    public void stop(){
        System.out.println("The truck is now sleeping...");
    }

    @Override
    public void action(){
        System.out.println("Trucks gotta go truckin'!");
    }
}
