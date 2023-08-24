package ex1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Mechanic("Jens", "addr", 2002, 300);
        Employee e2 = new Foreman("Greg", "addr", 2013, 290, 2019, 1200);
        Employee e3 = new Mechanic("Ivan", "addr", 2018, 225);
        Employee e4 = new Foreman("Peter", "addr", 2009, 350, 2012, 1600);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        System.out.println("Total wages for all employees this week: " + totalWeeklySalary(employees) + " kr.");

        Employee e5 = new Surveyor("Katja", "addr", 2016, 400, 8);
        Employee e6 = new WorkingBoy("Jimmy", "addr", 18, 125);
        employees.add(e5);
        employees.add(e6);

        System.out.println("Total wages for all workers this week: " + totalWeeklySalary(employees) + " kr.");
    }

    public static int totalWeeklySalary(ArrayList<Employee> list){
        int total = 0;
        for (Employee e : list){
            total += e.weeklySalary();
        }
        return total;
    }
}
