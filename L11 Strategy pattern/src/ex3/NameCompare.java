package ex3;

import java.util.Comparator;

// a class that compares customers by name
public class NameCompare implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2){
        return c1.getName().compareTo(c2.getName());
    }
}
