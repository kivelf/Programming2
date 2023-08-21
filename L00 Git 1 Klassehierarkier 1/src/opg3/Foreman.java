package opg3;

public class Foreman extends Mechanic{
    private int yearAppointed;
    private int weeklyBonus;

    public Foreman(String name, String address, int year, int hourlyWage, int yearAppointed, int weeklyBonus) {
        super(name, address, year, hourlyWage);
        this.yearAppointed = yearAppointed;
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public int weeklySalary() {
        return super.weeklySalary() + weeklyBonus;
    }
}
