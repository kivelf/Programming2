package opg3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Mechanic m1 = new Mechanic("Jens", "addr", 2002, 300);
        Mechanic m2 = new Foreman("Greg", "addr", 2013, 290, 2019, 1200);
        Mechanic m3 = new Mechanic("Ivan", "addr", 2018, 225);
        Mechanic m4 = new Foreman("Peter", "addr", 2009, 350, 2012, 1600);
        ArrayList<Mechanic> mechanics = new ArrayList<Mechanic>();
        mechanics.add(m1);
        mechanics.add(m2);
        mechanics.add(m3);
        mechanics.add(m4);

        System.out.println("Total wages for all workers this week: " + totalWeeklySalary(mechanics) + " kr.");

        Mechanic m5 = new Surveyor("Katja", "addr", 2016, 400, 8);
        mechanics.add(m5);

        System.out.println("Total wages for all workers this week: " + totalWeeklySalary(mechanics) + " kr.");
    }

    public static int totalWeeklySalary(ArrayList<Mechanic> list){
        int total = 0;
        for (Mechanic m : list){
            total += m.weeklySalary();
        }
        return total;
    }

}
