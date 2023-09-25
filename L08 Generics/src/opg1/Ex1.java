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

        // c) Extra exercise - sort the list on age with the sort() method
        // in the List class using a lambda expression.
        person1.setAge(18);
        person2.setAge(22);
        person3.setAge(23);
        person4.setAge(21);
        person5.setAge(21);
        person6.setAge(22);
        persons.add(person1);
        persons.add(person3);
        System.out.println("List of persons with ages: " + persons.toString());
        persons.sort((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("List of persons after sorting by age: " + persons.toString());
    }
}
