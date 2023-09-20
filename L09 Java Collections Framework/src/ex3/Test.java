package ex3;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Maria");
        Student s2 = new Student("Anna");
        Student s3 = new Student("James");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // Q 3.1
        System.out.println(s1.compareTo(s2));   // 1 vs 2
        System.out.println(s2.compareTo(s1));   // 2 vs 1
        System.out.println(s1.compareTo(s3));   // 1 vs 3
        System.out.println();

        // Q 3.2
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println("List before it's sorted: " + list);
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        System.out.println("List after it's been sorted: " + list);
        System.out.println();

        // Q 3.3
        System.out.println(s1.equals(s1));      // true
        System.out.println(s1.equals(s2));      // false
        System.out.println(s3.equals(new Student("James")));    // false
        Student s4 = s1;
        System.out.println(s1.equals(s4));      // true - both variables point at the same object
    }
}
