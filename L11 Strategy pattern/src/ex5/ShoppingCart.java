package ex5;

import java.util.ArrayList;
import java.util.Comparator;

public class ShoppingCart {
    private static ArrayList<Item> items = new ArrayList<Item>();
    private Payment payment;

    public ShoppingCart() {
    }

    public void addItem(Item item){
        items.add(item);
    }

    /** Pre: payment =! null. */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int calculateTotal(){
        int total = 0;
        for (Item i : items){
            total += i.getPrice();
        }
        return total;
    }

    /** Pre: payment =! null. */
    public void pay(Payment payment){
        int amount = calculateTotal();
        payment.pay(amount);
    }
}
