package opg4;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("The reverse of 'RANSLIRPA' is " + reverse("RANSLIRPA"));    // uneven
        System.out.println("The reverse of 'SRANSLIRPA' is " + reverse("SRANSLIRPA"));    // even
    }

    /** Returns the string with the characters in reverse order.
     * String is longer than 0. */
    public static String reverse(String s){
        String reversed = s;
        if (s.length() == 2){
            reversed = s.charAt(1) + "" + s.charAt(0);      // swapping the final 2 chars
        } else if (s.length() == 1){
            // the char in the middle is already correct, so no need to do anything
        }
        else {
            reversed = s.charAt(s.length() - 1) + reverse(s.substring(1, s.length() - 1)) + s.charAt(0);
        }
        return reversed;
    }
}
