package opg1;

public class Beer implements Measurable {
    private final String name;
    private final double alcoholPercentage;

    public Beer(String name, double alcoholPercentage) {
        this.name = name;
        this.alcoholPercentage = alcoholPercentage;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure(){
        return alcoholPercentage;
    }
}
