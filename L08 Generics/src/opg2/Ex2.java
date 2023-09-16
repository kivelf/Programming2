package opg2;

import java.util.HashSet;

public class Ex2 {
    public static void main(String[] args) {
        // testing with ints
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        System.out.println("set1 ∪ set2: " + getUnion(set1, set2));
        System.out.println("set1 ∩ set2: " + getIntersection(set1, set2));

        // testing with doubles
        HashSet<Double> set3 = new HashSet<>();
        set3.add(2.3);
        set3.add(10.5);
        HashSet<Double> set4 = new HashSet<>();
        set4.add(3.4);
        set4.add(2.3);
        System.out.println("set3 ∪ set4: " + getUnion(set3, set4));
        System.out.println("set3 ∩ set4: " + getIntersection(set3, set4));

        // testing the method that adds 3 sets together
        HashSet<Integer> set5 = new HashSet<>();
        set5.add(3);
        set5.add(4);
        System.out.println("Set 5 before adding: " + set5);
        combineThree(set1, set2, set5);
        System.out.println("Set 5 after adding: " + set5);
    }

    public static <T, E> HashSet<T> getUnion(HashSet<E> set1, HashSet<E> set2){
        HashSet<T> union = new HashSet<>();
        for (E e : set1){
            union.add((T) e);
        }
        for (E e : set2){
            union.add((T) e);
        }
        return union;
    }

    public static <T, E> HashSet<T> getIntersection(HashSet<E> set1, HashSet<E> set2){
        HashSet<T> intersection = new HashSet<>();
        for (E e : set1){
            if (set2.contains(e)){
                intersection.add((T) e);
            }
        }
        return intersection;
    }

    public static <E> HashSet<E> combineThree(HashSet<E> set1, HashSet<E> set2, HashSet<E> set3){
        for (E e : set1){
            set3.add(e);
        }
        for (E e : set2){
            set3.add(e);
        }
        return set3;
    }
}
