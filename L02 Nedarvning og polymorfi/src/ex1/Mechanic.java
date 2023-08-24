package ex1;

public class Mechanic extends Employee{
    private int yearEducated;
    private static final int weeklyWorkHours = 37;

    public Mechanic(String name, String address, int year, int hourlyWage) {
        super(name, address, hourlyWage);   // uses the constructor from the superclass
        this.yearEducated = year;
    }

    public int weeklySalary() {
        return weeklyWorkHours * super.getHourlyWage();
    }
}
