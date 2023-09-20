package ex2;

import java.util.ArrayList;

public class College {
    private String name;
    private final ArrayList<Student> students = new ArrayList<>();

    // constructor
    public College(String name) {
        this.name = name;
    }

    // getter method
    public String getName() {
        return name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        if (students.contains(student)){
            students.remove(student);
        }
    }

    // calculates the average of all grades for alls tudents
    public double calcAverage(){
        double average = 0;
        int count = 0;
        for (Student s : students){
            for (int grade : s.getGrades()){
                average += grade;
                count++;
            }
        }
        if (count == 0){
            return 0;
        } else
            return average / count;
    }

    public Student findStudent(int studentNo){
        if (!students.isEmpty()){
            for (Student s : students){
                if (s.getStudentNo() == studentNo){
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "College " + name;
    }
}
