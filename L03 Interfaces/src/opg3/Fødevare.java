package opg3;

public class Fødevare extends Vare {
    private int holdbarhedsperiode;

    public Fødevare(double price, String name, String description, int holdbarhedsperiode) {
        super(price, name, description);
        super.setTaxPercentage(5);
        this.holdbarhedsperiode = holdbarhedsperiode;
    }
}
