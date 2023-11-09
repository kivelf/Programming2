package ex3;

public class Ex3App {
    public static void main(String[] args) {
        Ring<Person> ring = new Ring<>(2);
        ring.add(new Person("Alice"));
        // System.out.println(ring.toString());    // Alice
        ring.add(new Person("Bob"));
        ring.add(new Person("Clementine"));
        ring.add(new Person("Dexter"));
        // System.out.println(ring.toString());    // current = D; A, B, C, D
        ring.add(new Person("Ed"));
        ring.add(new Person("Flo"));
        ring.add(new Person("Greg"));
        System.out.println(ring.toString());    // A, B, C, D, E, F, G
        System.out.println();

        System.out.println("Time to eat the captured missionaries!");
        System.out.println("Eating " + ring.removeFirst() + " first!");
        System.out.println("Missionaries left: " + ring.toString());
        System.out.println();

        int ringSizeAfterEatFirst = ring.getSize();
        for (int i = 0; i < ringSizeAfterEatFirst; i++){
            System.out.println("Eating " + ring.removeNext() + " now!");
            System.out.println("Missionaries left: " + ring.toString());
            System.out.println();
        }
    }
}
