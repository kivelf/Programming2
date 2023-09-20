package ex3;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final int studentNo;
    private static int students = 0;
    private String name;
    private final ArrayList<Integer> grades = new ArrayList<>();

    // constructor
    public Student(String name) {
        this.name = name;
        students++;
        studentNo = students;
    }

    // getter and setter methods
    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString(){
        return "Student " + name + ", nr. " + studentNo;
    }

    @Override
    public int compareTo(Student s){
        return studentNo - s.getStudentNo();
    }

    @Override
    public int hashCode(){
        return studentNo;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(!(obj instanceof Student other)) return false;
        return studentNo == other.studentNo;
    }
}
