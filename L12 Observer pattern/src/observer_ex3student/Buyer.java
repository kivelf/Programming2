package observer_ex3student;

public class Buyer {
    private final String name; // not empty

    public Buyer(String name) {
        this.name = name;
    }

    public void buyBook(Book b, int amount) {
        b.incCount(amount);
        System.out.println("Buyer " + name + ": " + b + ", " + amount + " copies");
    }
}
