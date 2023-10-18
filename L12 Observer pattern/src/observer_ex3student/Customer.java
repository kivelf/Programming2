package observer_ex3student;

import java.util.ArrayList;

public class Customer {
    private final String name; // not empty
    private final ArrayList<Book> books = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void removeBook(Book b){
        books.remove(b);
    }
}
