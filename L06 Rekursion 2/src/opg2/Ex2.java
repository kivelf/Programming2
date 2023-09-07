package opg2;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("Is 'madam' a palindrome? " + isPalindrome("madam"));
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Is 'refers' a palindrome? " + isPalindrome("refers"));
    }

    /** Pre: s.length() >= 0. */
    public static boolean isPalindrome(String s){
        if (s.length() <= 1){
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)){
            return false;
        } else {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
    }
}
