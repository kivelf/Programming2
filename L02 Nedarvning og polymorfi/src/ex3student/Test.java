package ex3student;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Product p1 = new Product(001, "shampoo", 12.99);
        Product p2 = new Product(002, "cat toy", 2.99);
        Product p3 = new Product(003, "dog toy", 4.99);
        Product p4 = new Product(004, "cat food", 18.99);
        Product p5 = new Product(005, "dog food", 20.99);

        Customer c1 = new Customer("Jenny", LocalDate.of(1990, 2, 3));
        Customer c2 = new Customer("Johnny", LocalDate.of(1991, 3, 4));

        OrderLine ol1 = new OrderLine(1, 2, p1);    // 2x shampoo
        OrderLine ol2 = new OrderLine(2, 1, p2);    // 1x cat toy
        OrderLine ol3 = new OrderLine(3, 3, p3);    // 3x dog toy
        OrderLine ol4 = new OrderLine(4, 1, p3);    // 1x dog toy
        OrderLine ol5 = new OrderLine(5, 1, p4);    // 1x cat food
        OrderLine ol6 = new OrderLine(6, 2, p5);    // 2x dog food
        OrderLine ol7 = new OrderLine(7, 50, p5);   // 50x dog food

        Order o1 = new Order(1);
        o1.addOrderLine(ol1);
        o1.addOrderLine(ol2);
        Order o2 = new Order(2);
        o2.addOrderLine(ol2);
        o2.addOrderLine(ol1);
        o2.addOrderLine(ol5);
        c1.addOrder(o1);
        c1.addOrder(o2);

        Order o3 = new Order(3);
        o3.addOrderLine(ol1);
        o3.addOrderLine(ol3);
        Order o4 = new Order(4);
        o4.addOrderLine(ol3);
        o4.addOrderLine(ol1);
        o4.addOrderLine(ol6);
        Order o5 = new Order(5);
        o5.addOrderLine(ol1);
        o5.addOrderLine(ol6);
        Order o6 = new Order(6);
        o6.addOrderLine(ol3);
        o6.addOrderLine(ol4);
        o6.addOrderLine(ol6);
        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        System.out.println("Price of order 1: " + o1.getOrderPrice());
        System.out.println("Price of order 2: " + o2.getOrderPrice());
        System.out.println();
        System.out.println("Customer 1 has purchased for a total of: " + c1.getTotalBuy());
        System.out.println("Customer 2 has purchased for a total of: " + c2.getTotalBuy());
        System.out.println();

        // testing d)
        Discount discount1 = new PercentDiscount(15);
        c1.setDiscount(discount1);
        Discount discount2 = new FixedDiscount(250, 1000);
        c2.setDiscount(discount2);

        Order o7 = new Order(7);
        o7.addOrderLine(ol7);
        c2.addOrder(o7);

        System.out.println("Customer 1's order summary:");
        c1.printPricesForOrdersWithAndWithoutDisount();
        System.out.println();
        System.out.println("Customer 2's order summary:");
        c2.printPricesForOrdersWithAndWithoutDisount();
    }
}
