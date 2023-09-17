package opg4;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayRing<Integer> ring = new ArrayRing<>();
        System.out.println(ring.size());        // 0
        System.out.println(ring.isEmpty());     // true
        ring.removeCurrentItem();               // throws error

        ring.add(1);
        System.out.println(ring.getCurrentItem());  // 1
        ring.add(2);
        ring.add(3);

        System.out.println();
        System.out.println(ring.getCurrentItem());  // 3
        ring.advance();
        System.out.println(ring.getCurrentItem());  // 1
        System.out.println(ring.removeCurrentItem());
        System.out.println(ring.toString());
        System.out.println(ring.removeItem(2));     // true
        System.out.println(ring.removeItem(5));     // false
    }
}
