package opg4;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int number;

    // composition 1 --> 0..* OrderLine
    private final List<OrderLine> orderLines = new ArrayList<>();

    public Order(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    public void addOrderLine(OrderLine line) {
        orderLines.add(line);
    }

    public double getOrderPrice(){
        double total = 0;
        for (OrderLine ol : orderLines){
            total += ol.getOrderLinePrice();
        }
        return total;
    }

    @Override
    public String toString(){
        return "The total price of the order is: " + this.getOrderPrice() + " kr.";
    }
}
