package opg3;

import javax.lang.model.element.Name;

public class Spiritus extends Vare {
    private final double alcoholPercentage;

    public Spiritus(double price, String name, String description, double alcoholPercentage) {
        super(price, name, description);
        if (price > 90){
            super.setTaxPercentage(120);
        } else super.setTaxPercentage(80);
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public String toString(){
        return super.toString() + ", alcohol %: " + alcoholPercentage;
    }
}
