package opg3;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    // test of Merge-sorting algorithm
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(){{add(8); add(56);
            add(45); add(34); add(15); add(12); add(34); add(44);}};

        System.out.println("List before sorting: " + nums.toString());
        mergesort(nums);
        System.out.println("List after sorting: " + nums.toString());
    }

    /** Pre: list.size() >= 0. */
    public static void mergesort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    private static void mergesort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(list, low, middle);
            mergesort(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int i = low; // index for the left subarray
        int j = middle + 1; // index for the right subarray

        while (i <= middle && j <= high) {
            if (list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        // copy the remaining elements from the left subarray if any
        while (i <= middle) {
            temp.add(list.get(i));
            i++;
        }

        // copy the remaining elements from the right subarray if any
        while (j <= high) {
            temp.add(list.get(j));
            j++;
        }

        // copy the merged elements from temp back into the original list
        for (int k = 0; k < temp.size(); k++) {
            list.set(low + k, temp.get(k));
        }
    }
}
