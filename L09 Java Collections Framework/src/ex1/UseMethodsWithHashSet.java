package ex1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseMethodsWithHashSet {
    public static void main(String[] args) {
        // a)
        Set<Integer> set = new HashSet<>();
        // b)
        set.add(34);
        set.add(12);
        set.add(23);
        set.add(45);
        set.add(67);
        set.add(34);
        set.add(98);
        // c)
        System.out.println("Set: " + set);
        // d)
        set.add(23);
        // e)
        System.out.println("Set: " + set);
        // f)
        set.remove(67);
        // g)
        System.out.println("Set: " + set);
        // h)
        System.out.println("Set contains 23? " + set.contains(23));
        // i)
        System.out.println("Amount of numbers in the set: " + set.size());
    }
}
