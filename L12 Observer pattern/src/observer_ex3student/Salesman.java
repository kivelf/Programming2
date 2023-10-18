package observer_ex3student;

import java.util.HashSet;
import java.util.Set;

public class Salesman implements BookObserver{
    private final String name; // not empty

    public Salesman(String name) {
        this.name = name;
    }

    @Override
    public void update(Book book){
        System.out.print("Customers that bought this book also bought: ");
        Set<String> books = new HashSet<>();
        for (Customer c : book.getCustomers()){
            for (Book b : c.getBooks()){
                if (!books.contains(b) && !b.equals(book)){
                    books.add(b.getTitle());
                }
            }
        }
        books.forEach(s -> System.out.print(s + ", "));
        System.out.println();
    }
}
