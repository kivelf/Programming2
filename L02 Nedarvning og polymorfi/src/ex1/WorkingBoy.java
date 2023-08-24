package ex1;

public class WorkingBoy extends Employee {
    private int age;
    private static final int weeklyWorkHours = 25;

    public WorkingBoy(String name, String address, int age, int hourlyWage) {
        super(name, address, hourlyWage);
        this.age = age;
    }

    public int weeklySalary() {
        return weeklyWorkHours * super.getHourlyWage();
    }
}
