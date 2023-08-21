package opg3;

public class Mechanic extends Person {
    private int yearEducated;
    private int hourlyWage;
    private static final int weeklyWorkHours = 37;

    public Mechanic(String name, String address, int year, int hourlyWage) {
        super(name, address);   // uses the constructor from the superclass
        this.yearEducated = year;
        this.hourlyWage = hourlyWage;
    }

    public int weeklySalary() {
        return weeklyWorkHours * hourlyWage;
    }

    public int getHourlyWage(){
        return hourlyWage;
    }
}
