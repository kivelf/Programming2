package ex4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex4a {
    public static void main(String[] args) {
        String fileName = "L09 Java Collections Framework/src/ex4/Gjoengehoevdingen.txt";  // relative path
        File in = new File(fileName);

        // a)
        // try reading the words from the txt file and inserting them into a TreeSet
        Set<String> ts = insertWordsInTreeSet(in);
        System.out.println(ts);
        System.out.println("Total number of words: " + ts.size());
        System.out.println();

        // b)
        // do the same with a TreeMap where K = word, V = count of that word in the text
        TreeMap<String, Integer> tm = insertWordsInTreeMap(in);
        for (Map.Entry<String, Integer> entry : tm.entrySet()){
            if (entry.getValue() >= 1000){
                System.out.println(entry);
            }
        }
        System.out.println("Total number of words: " + tm.size());
        System.out.println();

        // c)
        // same exercise with a LinkedHashMap this time!
        LinkedHashMap<Integer, Set<String>> lhm = insertWordsInLinkedHashMap(in);
        // for (Map.Entry<Integer, Set<String>> entry : lhm.entrySet()){
        //     System.out.println(entry);
        // }
        System.out.println("Total number of words: " + lhm.size());
    }

    public static TreeSet<String> insertWordsInTreeSet(File in){
        TreeSet<String> allWords = new TreeSet<>();
        try (Scanner scanner = new Scanner(in)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                // finds all occurences of 1 or more whitespace characters in line
                // and splits line in substrings wherever it finds them
                // the substrings are then stored in an array of strings
                String[] words = line.split("\\s+");
                for (String word : words){
                    // remove punctuation and such
                    String w = word.replaceAll("[^\\sa-zæøåA-ZÆØÅ]", "");
                    // duplicates don't get inserted in a TreeSet so no need to check for those
                    if (w.length() > 0){
                        allWords.add(w.toLowerCase());
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
        return allWords;
    }

    public static TreeMap<String, Integer> insertWordsInTreeMap(File in){
        TreeMap<String, Integer> allWords = new TreeMap<>();
        try (Scanner scanner = new Scanner(in)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                // finds all occurences of 1 or more whitespace characters in line
                // and splits line in substrings wherever it finds them
                // the substrings are then stored in an array of strings
                String[] words = line.split("\\s+");
                for (String word : words){
                    // remove punctuation and such
                    String w = (word.replaceAll("[^\\sa-zæøåA-ZÆØÅ]", "")).toLowerCase();
                    if (w.length() > 0){
                        // if the TreeMap already contains the word we get the current count, else we set it to 0
                        int count = allWords.containsKey(w) ? allWords.get(w) : 0;
                        // then we add the word and the updated count for it
                        allWords.put(w, count + 1);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
        return allWords;
    }

    public static LinkedHashMap<Integer, Set<String>> insertWordsInLinkedHashMap(File in){
        LinkedHashMap<Integer, Set<String>> allWords = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(in)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                // finds all occurences of 1 or more whitespace characters in line
                // and splits line in substrings wherever it finds them
                // the substrings are then stored in an array of strings
                String[] words = line.split("\\s+");
                for (String word : words){
                    // remove punctuation and such
                    String w = (word.replaceAll("[^\\sa-zæøåA-ZÆØÅ]", "")).toLowerCase();
                    if (w.length() > 0){
                        // getting the hashCode of the string
                        int hashVal = w.hashCode();
                        if (allWords.containsKey(hashVal)) {
                            Set set = new HashSet<>(allWords.get(hashVal));
                            set.add(w);
                            allWords.put(hashVal, set);
                        } else {
                            Set set = new HashSet<>();
                            set.add(w);
                            allWords.put(hashVal, set);
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
        return allWords;
    }
}
