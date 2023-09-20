package ex2;


import java.util.ArrayList;

public class Student {
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
}
