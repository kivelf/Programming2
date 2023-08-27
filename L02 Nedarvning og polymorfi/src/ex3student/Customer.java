package ex3student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private final LocalDate birthday;

    // association 1 --> 0..* Order
    private final ArrayList<Order> orders = new ArrayList<>();

    private Discount discount;

    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void setDiscount(Discount discount){
        this.discount = discount;
    }

    public double getTotalBuy(){
        double total = 0;
        for (Order o : orders){
            total += o.getOrderPrice();
        }
        return total;
    }

    public double totalBuyWithDiscount(){
        if (discount != null){
            double total = 0;
            for (Order o : orders){
                total += o.getOrderPrice() - discount.getDiscount(o.getOrderPrice());
            }
            return total;
        }
        else return this.getTotalBuy();
    }

    public void printPricesForOrdersWithAndWithoutDisount(){
        if (discount == null){
            for (Order o : orders){
                System.out.println(o);
            }
        } else {
            for (Order o : orders){
                System.out.println("The total price of the order without discount is: " + o.getOrderPrice() + " kr.");
                if (discount.getDiscount(o.getOrderPrice()) != 0){
                    System.out.println("The total price of the order with discount is: " + (o.getOrderPrice() - discount.getDiscount(o.getOrderPrice())) + " kr.");
                }
            }
        }
    }
}
