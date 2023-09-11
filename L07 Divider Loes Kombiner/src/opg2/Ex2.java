package opg2;

import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(8, 56, 45, 34, 15, 12, 34, 44);    // 0
        System.out.println("The total number of 0's in the list is " + countZeroes(nums));

        List<Integer> nums2 = List.of(8, 0, 56, 45, 34, 0, 15, 12, 34, 0, 44);    // 3
        System.out.println("The total number of 0's in the list is " + countZeroes(nums2));
    }

    /** Pre: list.size() >= 0. */
    public static int countZeroes(List<Integer> list) {
        return countZeroes(list, 0, list.size() - 1, 0);
    }
    private static int countZeroes(List<Integer> list, int l, int r, int count) {
        if (l == r) {
            if (list.get(l) == 0){
                count++;
            }
            return count;
        } else {
            int m = (l + r) / 2;
            int left = countZeroes(list, l, m, count);
            int right = countZeroes(list, m + 1, r, count);
            return left + right;
        }
    }
}
