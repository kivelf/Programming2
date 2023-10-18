package observer_ex3student;

public class TestApp {

    public static void main(String[] args) {
        Salesman salesman = new Salesman("Sally");
        Purchaser purchaser = new Purchaser("Patricia");

        Book donaldDuck = new Book("Donald Duck");
        donaldDuck.addObserver(salesman);
        donaldDuck.addObserver(purchaser);

        purchaser.buyBook(donaldDuck, 6);
        System.out.println(donaldDuck);
        System.out.println();

        Book java = new Book("Java");
        java.addObserver(salesman);
        java.addObserver(purchaser);

        purchaser.buyBook(java, 8);
        System.out.println();

        Book designPatterns = new Book("Design Patterns");
        designPatterns.addObserver(salesman);
        designPatterns.addObserver(purchaser);

        purchaser.buyBook(designPatterns, 10);
        System.out.println();

        Customer bob = new Customer("Bob");
        Customer alice = new Customer("Alice");
        Customer harry = new Customer("Harry");

        //---------------------------------------------------------------------

        makeSale(donaldDuck, bob);
        System.out.println();
        makeSale(donaldDuck, alice);
        System.out.println();
        makeSale(donaldDuck, harry);
        System.out.println();

        makeSale(java, bob);
        System.out.println();
        makeSale(java, alice);
        System.out.println();
        makeSale(java, harry);
        System.out.println();

        makeSale(designPatterns, bob);
        System.out.println();

        System.out.println("Bob has bought: " + bob.getBooks());
        System.out.println("Alice has bought: " + alice.getBooks());
        System.out.println("Harry has bought: " + harry.getBooks());
    }

    public static void makeSale(Book b, Customer c) {
        System.out.println("Sale: " + b + " sold to " + c.getName());
        b.addCustomer(c);
        c.addBook(b);
        b.decCount(1);
    }
}
