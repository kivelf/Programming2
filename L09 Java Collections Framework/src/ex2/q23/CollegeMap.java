package ex2.q23;

import ex2.Student;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CollegeMap {
    private String name;
    private final Map<Integer, Student> students = new LinkedHashMap<>();

    // constructor
    public CollegeMap(String name) {
        this.name = name;
    }

    // getter method
    public String getName() {
        return name;
    }

    public void addStudent(Student student){
        students.put(student.getStudentNo(), student);
    }

    public void removeStudent(Student student){
        if (students.containsValue(student)){
            students.remove(student.getStudentNo());
        }
    }

    // calculates the average of all grades for alls tudents
    public double calcAverage(){
        double average = 0;
        int count = 0;
        for (Map.Entry<Integer, Student> s : students.entrySet()){
            for (int grade : s.getValue().getGrades()){
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
        // returns the value that matches the key - either a Student-object or null
        return students.get(studentNo);
    }

    @Override
    public String toString(){
        return "College " + name;
    }
}
