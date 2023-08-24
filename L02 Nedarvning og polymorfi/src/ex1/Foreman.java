package ex1;

public class Foreman extends Employee {
    private int yearEducated;
    private int yearAppointed;
    private int weeklyBonus;
    private static final int weeklyWorkHours = 37;

    public Foreman(String name, String address, int yearEducated, int hourlyWage, int yearAppointed, int weeklyBonus) {
        super(name, address, hourlyWage);
        this.yearEducated = yearEducated;
        this.yearAppointed = yearAppointed;
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public int weeklySalary() {
        return weeklyWorkHours * super.getHourlyWage() + weeklyBonus;
    }
}
