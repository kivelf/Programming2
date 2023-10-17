package ex4;

import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class EmailEvaluator implements Evaluator {
    /**
     * Returns true, if s contains a valid email address.
     */
    @Override
    public boolean isValid(String s) {
        boolean isEmail = false;
        int minimumLength = 3;
        try {
            String[] s1 = s.split("@", -1);
            boolean isValid = true;
            if (s == null || s.length() < minimumLength) {
                isValid = false;
            }
            while (isValid) {
                try {
                    if (s1[0].contains(".")) {
                        String[] s2 = s1[0].split("\\.", -1);
                        if (!isWord(s2[0]) || !isWord(s2[1])) {
                            isValid = false;
                            break;
                        }
                    } else if (!isWord(s1[0])) {
                        isValid = false;
                        break;
                    } else if (s1[1].contains(".")) {
                        String[] s3 = s1[1].split("\\.", -1);
                        if (!isWord(s3[0]) || !isWord(s3[1])) {
                            isValid = false;
                            break;
                        }
                    } else if (!isWord(s1[1])) {
                        isValid = false;
                        break;
                    }
                    if (isValid) {
                        isEmail = true;
                        isValid = false;
                    }
                } catch (Exception e) {
                    System.out.println("Unexpected exception: " + e);
                    System.out.println("The string is not a valid email!");
                    isValid = false;
                }
            }

        } catch (PatternSyntaxException ps) {
            System.out.println("Unexpected error: " + ps);
            System.out.println("The string is not a valid email!");
        }
        return isEmail;
    }

    /**
     * Returns true, if s is an acceptable word.
     * That is, s is not empty, and all letters
     * are in 'A'..'Z', 'a'..'z' or '0'..'9'.
     */
    public boolean isWord(String s) {
        boolean isWord = false;
        if (s != null) {
            boolean isGut = true;
            if (s.length() < 1){
                isGut = false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < 48 || (s.charAt(i) > 57 && s.charAt(i) < 65)
                        || (s.charAt(i) > 90 && s.charAt(i) < 97) || s.charAt(i) > 122) {
                    isGut = false;
                }
            }
            if (isGut) {
                isWord = true;
            }

        }
        return isWord;
    }
}
