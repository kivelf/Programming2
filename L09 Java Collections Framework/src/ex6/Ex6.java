package ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// (Count consonants and vowels) Write a program that prompts the user to enter a
// text file name and displays the number of vowels and consonants in the file. Use
// a set to store the vowels A, E, I, O, and U.
public class Ex6 {
    public static void main(String[] args) {
        String fileName = "L09 Java Collections Framework/src/ex6/myTestText.txt";  // relative path
        File in = new File(fileName);

        int[] count = countVowelsAndConsonants(in);
        System.out.println("Number of vowels and consonants in the text: " + count[0] + ", " + count[1]); // 17 vowels, 28 cons
    }

    public static int[] countVowelsAndConsonants(File in){
        // [0] - counter for vowels, [1] - counter for consonants
        int[] counter = new int[2];

        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        try (Scanner scanner = new Scanner(in)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++){
                    if (vowels.contains(chars[i])){
                        counter[0]++;
                    } else if ((65 <= chars[i] && chars[i] <= 90) || (97 <= chars[i] && chars[i] <= 122)){
                        counter[1]++;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
        return counter;
    }
}
