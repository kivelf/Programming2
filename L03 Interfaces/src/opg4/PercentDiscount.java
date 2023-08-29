package opg4;

public class PercentDiscount implements Discount {
    private int discountPercentage;

    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double discountedPrice(double price){
        return price * discountPercentage / 100;
    }
}
