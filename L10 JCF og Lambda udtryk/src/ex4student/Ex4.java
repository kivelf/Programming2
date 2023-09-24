package ex4student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex4 {

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

        // OBS: Throws exception.
//        for (Runner runner : runners) {
//            if (runner.getLapTime() >= 40) {
//                runners.remove(runner);
//            }
//        }
//        System.out.println(runners);
//        System.out.println();

        // a) The programme throws a ConcurrentModificationException bc you cannot modify a List in a forEach loop

        // b)
        Iterator<Runner> i = runners.iterator();
        while (i.hasNext()){
            if (i.next().getLapTime() >= 40){
                i.remove();
            }
        }
        System.out.println(runners);
        System.out.println();

        // c)
        Predicate<Runner> filter = runner -> runner.getLapTime() >= 40;

        // d)
        runners.add(new Runner("Per", 50));
        runners.add(new Runner("Ulla", 40));
        System.out.println(runners);
        System.out.println("Got any runners to remove from the list? " + removeIf(runners, filter));
        System.out.println("New list:");
        System.out.println(runners);
        System.out.println();

        // e)
        runners.add(new Runner("Per", 50));
        runners.add(new Runner("Ulla", 40));
        System.out.println(runners);
        runners.removeIf(filter);
        System.out.println("New list:");
        System.out.println(runners);
    }

    /**
     * Removes runners that satisfies the given filter.
     * Returns true, if any runner is removed.
     */
    public static boolean removeIf(List<Runner> runners, Predicate<Runner> filter){
        boolean gotAnyRemoved = false;
        Iterator<Runner> iterator = runners.iterator();
        while (iterator.hasNext()){
            if (filter.test(iterator.next())){
                iterator.remove();
                gotAnyRemoved = true;
            }
        }
        return gotAnyRemoved;
    }
}