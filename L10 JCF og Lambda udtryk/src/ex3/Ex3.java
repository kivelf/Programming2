package ex3;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        // a)
        List<Integer> nums = new ArrayList<>(List.of(93, 84, 17, 3, 64, 15, 23, 89));
        nums.forEach(num -> System.out.print(num + ", "));
        System.out.println();
        // b)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 4);
        map.put(3, 9);
        map.put(4, 16);
        map.put(5, 25);
        map.put(6, 36);

        map.forEach((key, value) -> System.out.printf("Pair [%d, %d], ", key, value));
    }
}
