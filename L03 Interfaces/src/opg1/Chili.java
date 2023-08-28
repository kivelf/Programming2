package opg1;

public class Chili implements Measurable {
    private final String name;
    private final int strength;

    public Chili(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure(){
        double measure = switch(strength) {
            case 0 -> 100;
            case 1 -> 300;
            case 2 -> 750;
            case 3 -> 1300;
            case 4 -> 2000;
            case 5 -> 4000;
            case 6 -> 10000;
            case 7 -> 20000;
            case 8 -> 40000;
            case 9 -> 75000;
            case 10 -> 100000;
            default -> 0;
        };
        return measure;
    }
}
