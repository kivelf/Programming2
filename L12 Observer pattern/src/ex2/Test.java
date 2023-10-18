package ex2;

public class Test {
    public static void main(String[] args) {
        ObservableBag observableBag = new ObservableBag();
        BagObserver observer = new BagObserverPrint();
        observableBag.addObserver(observer);

        observableBag.add("kitten");
        observableBag.add("kitten");
        observableBag.add("kitten");
        observableBag.remove("kitten");
        observableBag.add("hamster");
        observableBag.add("cheese");
        observableBag.add("hamster");
        System.out.println();

        observableBag.printBagContents();
    }
}
