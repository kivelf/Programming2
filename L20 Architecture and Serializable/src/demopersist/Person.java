package demopersist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private final String name;
    private final List<Integer> grades;

    public Person(String name) {
        grades = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}
