package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final int age;
    private final List<Integer> grades = new ArrayList<>(MAX_NUMBER_OF_GRADES);
    private static final int MAX_NUMBER_OF_GRADES = 10;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    /** Add a grade to this student's grades.
     * Throw ToManyGradesException, if the student has 10 grades beforehand.
     * Pre: The grade is a legal grade. */
    public void addGrade(int grade) {
        if (grades.size() == MAX_NUMBER_OF_GRADES) {
            throw new TooManyGradesException("For mange karakterer givet");
        }
        grades.add(grade);
    }

    /** Return the average of this student's grades.
     * Pre: This student has at least one grade. */
    public double averageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
