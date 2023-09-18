package opg4;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayRing<Integer> ring = new ArrayRing<>();

        ring.add(1);
        ring.add(2);
        ring.add(3);
        ring.add(4);
        ring.add(5);
        System.out.println(ring.toString());        // 1 2 3 4 5
        System.out.println(ring.getCurrentItem());  // 5
        ring.removeCurrentItem();
        System.out.println(ring.toString());        // 1 2 3 4
        System.out.println(ring.getCurrentItem());  // 1
        ring.removeCurrentItem();
        System.out.println(ring.toString());        // 2 3 4
        System.out.println(ring.getCurrentItem());  // 2
        ring.removeCurrentItem();
        System.out.println(ring.toString());        // 3 4
        System.out.println(ring.getCurrentItem());  // 3
        ring.removeCurrentItem();
        System.out.println(ring.toString());        // 4
        System.out.println(ring.getCurrentItem());  // 4
        ring.removeCurrentItem();
        System.out.println(ring.toString());        // empty ring!
    }
}
