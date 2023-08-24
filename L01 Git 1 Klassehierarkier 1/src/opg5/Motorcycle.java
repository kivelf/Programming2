package opg5;

public class Motorcycle extends Vehicle {
    private int engineSize;

    public Motorcycle(String make, String model, int year, double mileage, int engineSize) {
        super(make, model, year, mileage);
        this.engineSize = engineSize;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Engine size: " + engineSize + " cc");
        System.out.println();
    }

    @Override
    public void start(){
        System.out.println("The motorcycle is now on...");
    }

    @Override
    public void stop(){
        System.out.println("The motorcycle is now off...");
    }

    @Override
    public void action(){
        System.out.println("Motorcycle goes rrrrrrr-ftftfttftfttftf!");
    }
}
