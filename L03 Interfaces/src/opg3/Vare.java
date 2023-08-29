package opg3;

public class Vare {
    private double price;   // excl. moms
    private String name;
    private String description;
    private double taxPercentage = 25;

    public Vare(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getTax(){
        return price * taxPercentage / 100;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public double getTotalPrice(){
        return price + getTax();
    }

    @Override
    public String toString(){
        return name + ", price: " + getTotalPrice() + " kr.";
    }
}
