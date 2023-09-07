package opg0;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex0 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers1 = new ArrayList<Integer>(Arrays.asList(2, 18, 19, 23, 2038, 2039));     // 3
        System.out.println("Number of even numbers in the list: " + countEven(numbers1));
        ArrayList<Integer> numbers2 = new ArrayList<Integer>(Arrays.asList(2, 18, 24, 28, 2038, 2040));      // 6
        System.out.println("Number of even numbers in the list: " + countEven(numbers2));
        ArrayList<Integer> numbers3 = new ArrayList<Integer>(Arrays.asList(3, 15, 19, 23, 2037, 2039));      // 0
        System.out.println("Number of even numbers in the list: " + countEven(numbers3));
    }

    /** Pre: listen er ikke tom. */
    public static int countEven(ArrayList<Integer> nums){
        return countEven(nums, 0, 0);
    }

    /** Pre: 0 <= index < list.size() */
    private static int countEven(ArrayList<Integer> nums, int i, int count){
        if (nums.get(i) % 2 == 0){
            count++;
        }
        i++;
        if (i < nums.size()){
            count = countEven(nums, i, count);
        }
        return count;
    }
}
