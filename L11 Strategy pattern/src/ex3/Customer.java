package ex3;

import java.util.Comparator;

public class Customer implements Comparable<Customer>{
    private final int number;
    private static int nrOfCustomers = 0;
    private String name;
    private static Comparator<Customer> comparator;

    // constructor
    public Customer(String name) {
        this.name = name;
        nrOfCustomers++;
        number = nrOfCustomers;
    }

    // getter methods
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Comparator<Customer> getComparator() {
        return comparator;
    }

    // setter methods
    public static void setComparator(Comparator<Customer> comparator) {
        Customer.comparator = comparator;
    }

    @Override
    public String toString(){
        return "Customer nr. " + number + ", " + name;
    }

    @Override
    public int compareTo(Customer c){
        return comparator.compare(this, c);
    }
}
