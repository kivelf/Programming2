package ex2;

public class Test {
    public static void main(String[] args) {
        ObservableBag observableBag = new ObservableBag();
        BagObserver observer = new BagObserverPrint();
        observableBag.addObserver(observer);

        observableBag.addItem("kitten");
        observableBag.addItem("kitten");
        observableBag.addItem("kitten");
        observableBag.remove("kitten");
        observableBag.addItem("hamster");
        observableBag.addItem("cheese");
        observableBag.addItem("hamster");
        System.out.println();

        observableBag.printBagContents();
    }
}
