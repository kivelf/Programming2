package opg4;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("Anagrams of CAT:");
        printAnagrams("", "CAT");
    }

    /** Pre: For both strings String.length() >= 0. */
    public static void printAnagrams(String prefix, String word){
        int n = word.length();
        if (n == 0){
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++){
                String newPrefix = prefix + word.charAt(i);
                String newWord = word.substring(0, i) + word.substring(i + 1, n);
                printAnagrams(newPrefix, newWord);
            }
        }
    }
}
