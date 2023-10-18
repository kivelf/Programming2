package observer_ex3student;

public class Purchaser implements BookObserver{
    private final String name; // not empty

    public Purchaser(String name) {
        this.name = name;
    }

    public void buyBook(Book b, int amount) {
        b.incCount(amount);
        System.out.println("Purchaser " + name + ": " + b + ", " + amount + " copies");
    }

    @Override
    public void update(Book book){
        if (book.getCount() < 6){
            buyBook(book, 10);
        }
    }
}
