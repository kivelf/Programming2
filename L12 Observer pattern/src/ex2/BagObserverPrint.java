package ex2;

public class BagObserverPrint implements BagObserver{
    @Override
    public void update(String s, int i){   // push
        System.out.println("Item " + s + ", count: " + i);
    }
}
