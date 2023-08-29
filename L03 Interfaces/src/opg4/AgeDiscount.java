package opg4;

import java.time.LocalDate;
import java.time.Period;

public class AgeDiscount implements  Discount{
    private int age;

    public AgeDiscount(Customer c) {
        LocalDate now = LocalDate.now();
        this.age = Period.between(c.getBirthday(), now).getYears();
    }

    @Override
    public double discountedPrice(double price){
        return price * age / 100;
    }
}
