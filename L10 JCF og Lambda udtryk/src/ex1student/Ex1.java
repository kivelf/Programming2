package ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Bent", 25),
                new Person("Susan", 34),
                new Person("Mikael", 60),
                new Person("Klaus", 44),
                new Person("Birgitte", 17),
                new Person("Liselotte", 9)
        );
        System.out.println(persons);
        System.out.println();

        // a)
        System.out.print("The first person in the persons list with an age of 44: ");
        System.out.println(findFirst(persons, p -> p.getAge() == 44));
        // b)
        System.out.print("The first person in the persons list with a name starting with 'S': ");
        System.out.println(findFirst(persons, p -> p.getName().startsWith("S")));
        // c)
        System.out.print("The first person in the persons list with a name containing more than one ’i’.: ");
        System.out.println(findFirst(persons, p -> p.getName().matches(".*i.*i.*")));
        // d)
        System.out.print("Find the first person in the persons list with an age equal to the length of the name: ");
        System.out.println(findFirst(persons, p -> p.getName().length() == p.getAge()));
        // f)
        System.out.print("Find all persons with name containing the letter 'i': ");
        System.out.println(findAll(persons, p -> p.getName().contains("i")));
        // g)
        System.out.print("Find all persons with name starting with 'S': ");
        System.out.println(findAll(persons, p -> p.getName().startsWith("S")));
        // h)
        System.out.print("Find all persons with name of length 5: ");
        System.out.println(findAll(persons, p -> p.getName().length() == 5));
        // j)
        System.out.print("Find all persons with name of length at least 6 and age below 40: ");
        System.out.println(findAll(persons, p -> p.getName().length() >= 6 && p.getAge() < 40));
    }

    /**
     * Returns from the list the first person that satisfies the predicate.
     * Returns null, if no person satisfies the predicate.
     */
    public static Person findFirst(List<Person> list, Predicate<Person> filter) {
        for (Person p : list) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    // e)
    public static List<Person> findAll(List<Person> list, Predicate<Person> predicate){
        List<Person> result = new ArrayList<>();
        for (Person p: list){
            if (predicate.test(p)){
                result.add(p);
            }
        }
        return result;
    }
}
