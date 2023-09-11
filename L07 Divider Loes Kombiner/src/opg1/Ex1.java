package opg1;

import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(8, 56, 45, 34, 15, 12, 34, 44);    // 248
        System.out.println("The total of the numbers is " + total(nums));
    }

    /** Pre: list.size() >= 0. */
    public static int total(List<Integer> list) {
        return calcTotal(list, 0, list.size() - 1);
    }
    private static int calcTotal(List<Integer> list, int l, int r) {
        if (l == r) {
            return list.get(l);
        } else {
            int m = (l + r) / 2;
            int left = calcTotal(list, l, m);
            int right = calcTotal(list, m + 1, r);
            return left + right;
        }
    }
}
