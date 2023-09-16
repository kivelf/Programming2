package opg1;

import java.util.ArrayList;
import java.util.Collections;

public class Ex1 {
    public static void main(String[] args) {
        // a)
        Person person1 = new Person<>("John Doe");
        FullName name = new FullName("Jane", "Doe");
        Person person2 = new Person<>(name);
        System.out.println("Person " + person1);
        System.out.println("Person " + person2);

        // b)
        System.out.println(person1.compareTo(person2));
        System.out.println(person2.compareTo(person1));

        Person person3 = new Person<>("Bob Bobson");
        Person person4 = new Person<>(new FullName("Bobsine", "Bobson"));
        Person person5 = new Person<>(new FullName("Bobbie", "Bobson"));
        Person person6 = new Person<>(new FullName("Bob", "Bobbieson"));

        System.out.println(person3.compareTo(person6));
        System.out.println(person5.compareTo(person6));
        System.out.println(person6.compareTo(person5));

        ArrayList<Person<FullName>> persons = new ArrayList<>();
        persons.add(person2);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

        System.out.println("List of persons: " + persons.toString());
        Collections.sort(persons);
        System.out.println("List of persons after sorting: " + persons.toString());
    }
}
