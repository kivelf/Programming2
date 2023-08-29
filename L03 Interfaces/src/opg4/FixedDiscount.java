package opg4;

public class FixedDiscount implements Discount{
    private final int fixedDiscount;
    private final int discountLimit;

    public FixedDiscount(int fixedDiscount, int discountLimit) {
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double discountedPrice(double price){
        if (price >= discountLimit){
            return fixedDiscount;
        }
        else return 0;
    }
}
