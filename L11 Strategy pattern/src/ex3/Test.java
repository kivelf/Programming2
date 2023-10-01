package ex3;

public class Test {
    public static void main(String[] args) {
        Customer c1 = new Customer("Jimmy");
        Customer c2 = new Customer("Jane");

        System.out.println(c1);
        System.out.println(c2);

        c1.setComparator(new NameCompare());
        System.out.println(c1.compareTo(c2));
        c1.setComparator(new NumberCompare());
        System.out.println(c1.compareTo(c2));
    }
}
