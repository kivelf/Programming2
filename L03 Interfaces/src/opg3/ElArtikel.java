package opg3;

public class ElArtikel extends Vare {
    private double averageElConsumptionPrH;

    public ElArtikel(double price, String name, String description, double averageElConsumptionPrH) {
        super(price, name, description);
        super.setTaxPercentage(30);
        this.averageElConsumptionPrH = averageElConsumptionPrH;
    }

    @Override
    public double getTax(){
        if (super.getPrice() * getTaxPercentage() / 100 < 3){
            return 3.0;
        }
        else return super.getPrice() * getTaxPercentage() / 100;
    }
}
