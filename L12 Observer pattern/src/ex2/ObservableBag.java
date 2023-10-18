package ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObservableBag implements Bag{
    private final HashMap<String, Integer> items = new HashMap<>();
    private final List<BagObserver> observers = new ArrayList<>();

    public ObservableBag() {
    }

    public void addObserver(BagObserver o) {
        observers.add(o);
    }

    public void removeObserver(BagObserver o) {
        observers.remove(o);
    }

    private void notifyObservers(String s, int count) {
        for (BagObserver o : observers) {
            o.update(s, count); // push
        }
    }
    @Override
    public void add(String s){
        if (items.containsKey(s)){
            items.put(s, getCount(s) + 1);
        } else {
            items.put(s, 1);
        }
        notifyObservers(s, getCount(s));
    }

    @Override
    public void remove(String s){
        if (items.containsKey(s)){
            if (getCount(s) > 1){
                items.put(s, getCount(s) - 1);
            } else {
                items.remove(s);
            }
        }
        notifyObservers(s, getCount(s));
    }

    @Override
    public int getCount(String s){
        int count = 0;
        if (items.containsKey(s)){
            count = items.get(s);
        }
        return count;
    }

    public void printBagContents(){
        System.out.println("Bag contents:");
        System.out.println("_______________");
        for (String key : items.keySet()){
            System.out.println("Item: " + key + ", count: " + getCount(key));
        }
    }
}
