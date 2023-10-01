package ex3;

import java.util.Comparator;

// a class that compares customers by number
public class NumberCompare implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2){
        return c1.getNumber() - c2.getNumber();
    }
}
