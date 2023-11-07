package ex3;

import stack23ystudent.ArrayStack23Y;
import stack23ystudent.Stack23Y;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Is 'madam' a palindrome? " + isPalindrome("madam"));        // true
        System.out.println("Is 'maddam' a palindrome? " + isPalindrome("maddam"));      // true
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));    // true
        System.out.println("Is 'refers' a palindrome? " + isPalindrome("refers"));      // false

        System.out.println("Is 'ABCDEFGFEDCBA' a palindrome? " + isPalindrome("ABCDEFGFEDCBA"));    // true
        System.out.println("Is 'ABCCA' a palindrome? " + isPalindrome("ABCCA"));      // false
    }

    public static boolean isPalindrome(String s){
        boolean isPalindrome = true;
        if (s.length() <= 1){
            return isPalindrome;
        } else {
            Stack23Y stack = new ArrayStack23Y();
            for (int i = 0; i <= s.length() / 2 - 1; i++){
                stack.push(s.charAt(i));
            }

            boolean keepGoing = true;
            while (isPalindrome && keepGoing){
                for (int i = (s.length() + 1) / 2; i <= s.length() - 1; i++){
                    if ((char) stack.peek() == s.charAt(i)){
                        stack.pop();
                    } else {
                        isPalindrome = false;
                    }
                    if (i == s.length() - 1){
                        keepGoing = false;
                    }
                }
            }
        }
        return isPalindrome;
    }
}