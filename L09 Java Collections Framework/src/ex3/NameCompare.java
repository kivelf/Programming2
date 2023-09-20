package ex3;

import java.util.Comparator;

// a class that compares students on name
public class NameCompare implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}
