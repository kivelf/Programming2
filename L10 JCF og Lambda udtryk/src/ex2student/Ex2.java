package ex2student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<>(List.of(
                new Runner("Ib", 30),
                new Runner("Per", 50),
                new Runner("Ole", 27),
                new Runner("Ulla", 40),
                new Runner("Jens", 35),
                new Runner("Hans", 28)
        ));
        System.out.println(runners);
        System.out.println();

        // a)
        System.out.println("Udskriv en linie for hver løber med name og lapTime:");
        runners.forEach(r -> System.out.println(r.getName() + ", lap time: " + r.getLapTime() + " sec."));
        System.out.println();
        // b)
        System.out.println("Udskriv en linie for hver løber med lapTime < 30 med name og lapTime:");
        runners.forEach(r -> { if (r.getLapTime() < 30) {
            System.out.println(r.getName() + ", lap time: " + r.getLapTime() + " sec.");}});
        System.out.println();
        // c)
        System.out.println("Sorter løberne stigende efter lapTime:");
        runners.sort((r1, r2) -> Integer.compare(r1.getLapTime(), r2.getLapTime()));
        System.out.println(runners);
        // d)
    }
}