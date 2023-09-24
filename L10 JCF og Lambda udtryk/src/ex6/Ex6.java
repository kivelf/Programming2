package ex6;

import java.util.Comparator;
import java.util.Scanner;

// exercise 20.21 from the textbook
public class Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = new String[6];

        // get user input
        System.out.println("Enter the 6 strings:");
        for (int i = 0; i < 6; i++){
            strings[i] = input.next();
        }

        System.out.print("The strings are: ");
        for (String s : strings){
            System.out.print(s + ", ");
        }
        System.out.println();

        // sort the strings by their last char
        selectionSort(strings, Comparator.comparing(s -> s.charAt(s.length() - 1)));
        System.out.println("Strings sorted by last character: ");
        for (String s : strings){
            System.out.print(s + ", ");
        }
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
        for (int i = 0; i < list.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++){
                if (comparator.compare(list[j], list[minIndex]) < 0){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                // swap list[i] and list[minIndex]
                E temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }
}
