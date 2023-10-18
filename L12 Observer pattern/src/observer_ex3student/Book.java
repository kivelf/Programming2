package observer_ex3student;

import java.util.ArrayList;

public class Book {
    private final String title; // not empty
    private int count;
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<BookObserver> observers = new ArrayList<>();

    public Book(String title) {
        this.title = title;
        this.count = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void incCount(int amount) {
        count += amount;
    }

    public void decCount(int amount) {
        count -= amount;
        notifyObservers();
    }


    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public void removeCustomer(Customer c){
        customers.remove(c);
    }

    public void addObserver(BookObserver observer){
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        for (BookObserver observer : observers){
            observer.update(this);  // push
        }
    }

    @Override
    public String toString() {
        return title + "(" + count + ")";
    }
}
