package ex5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        String fileName = "L10 JCF og Lambda udtryk/src/ex5/ratings.txt";  // relative path
        File in = new File(fileName);
        // K = the name of the film, V = the rating(s) for that film
        Map<String, List<Integer>> ratingsMap = new HashMap<>();

        try (Scanner scanner = new Scanner(in)){
            // discarding the first line since I don't need it for the way I solve the exercise
            scanner.nextLine();

            while (scanner.hasNextLine()){
                String film = scanner.nextLine();
                int rating = scanner.nextInt();
                if(scanner.hasNextLine()){
                    scanner.nextLine();
                }
                if (ratingsMap.containsKey(film)){
                    ratingsMap.get(film).add(rating);
                } else {
                    ratingsMap.put(film, new ArrayList<>(List.of(rating)));
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }

        // printing all the films and their average rating
        calculateAndPrintAverageRating(ratingsMap);
    }

    public static void calculateAndPrintAverageRating(Map<String, List<Integer>> ratingsMap){
        for (String film : ratingsMap.keySet()){
            double sum = 0;
            for (int rating : ratingsMap.get(film)){
                sum += rating;
            }
            double average = sum / ratingsMap.get(film).size();
            System.out.printf("%s: %d karakterer, gennemsnit %.1f\n", film, ratingsMap.get(film).size(), average);
        }
    }
}
