package opg2;

import opg1.Measurable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Customer c1 = new Customer("Anna", "Jackson", 22);
        Customer c2 = new Customer("Jenny", "Jackson", 32);
        Customer c3 = new Customer("Jenny", "Johnson", 25);
        Customer c4 = new Customer("Jill", "Johnson", 28);
        Customer c5 = new Customer("Jill", "Johnson", 29);

        Customer[] customers = new Customer[]{c1, c2, c3, c4, c5};
        System.out.println("The biggest customer is " + biggestCustomer(customers));
        System.out.println();
        System.out.println("Customers bigger than " + c4 + ":");
        System.out.println(Arrays.toString(biggerThanCustomer(customers, c4)));
        System.out.println();
        System.out.println("Customers bigger than " + c2 + ":");
        System.out.println(Arrays.toString(biggerThanCustomer(customers, c2)));
        System.out.println();
        System.out.println("Customers bigger than " + c5 + ":");
        System.out.println(Arrays.toString(biggerThanCustomer(customers, c5)));
    }

    public static Customer biggestCustomer(Customer[] customers){
        Customer biggest = customers[0];
        for (int i = 1; i < customers.length; i++){
            if (customers[i].compareTo(biggest) > 0){
                biggest = customers[i];
            }
        }
        return biggest;
    }

    public static Customer[] biggerThanCustomer(Customer[] customers, Customer customer){
        Customer[] temp = new Customer[customers.length];   // max posible size
        int count = 0;
        for (Customer c: customers){
            if (c.compareTo(customer) > 0){
                temp[count] = c;
                count++;
            }
        }
        // trimming any null positions
        Customer[] biggerCustomers = new Customer[count];
        for (int i = 0; i < count; i++){
            biggerCustomers[i] = temp[i];
        }
        return biggerCustomers;
    }
}
