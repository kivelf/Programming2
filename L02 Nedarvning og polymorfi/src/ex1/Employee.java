package ex1;

public abstract class Employee {
    private String name;
    private String address;
    private int hourlyWage;

    public Employee(String name, String address, int hourlyWage) {
        this.name = name;
        this.address = address;
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public abstract int weeklySalary();
}
