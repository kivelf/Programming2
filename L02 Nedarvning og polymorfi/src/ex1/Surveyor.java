package ex1;

public class Surveyor extends Mechanic {
    private int weeklyInspections = 0;
    private final static int inspectionPrice = 29;

    public Surveyor(String name, String address, int year, int hourlyWage, int weeklyInspections) {
        super(name, address, year, hourlyWage);
        this.weeklyInspections = weeklyInspections;
    }

    public int calculateWeeklyBonus(){
        return inspectionPrice * weeklyInspections;
    }

    @Override
    public int weeklySalary() {
        return super.weeklySalary() + calculateWeeklyBonus();
    }
}
