package ex3;

public class Test {
    public static void main(String[] args) {
        Customer c1 = new Customer("Jimmy");
        Customer c2 = new Customer("Jane");

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(c1.compareTo(c2));
        // c1.setComparator(new NameCompare());
        // alt: using a lambda expression to set the comparator
        c1.setComparator((cust1, cust2) -> cust1.getName().compareTo(cust2.getName()));
        System.out.println(c1.compareTo(c2));
    }
}
