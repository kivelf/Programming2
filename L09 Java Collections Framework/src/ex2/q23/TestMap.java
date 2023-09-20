package ex2.q23;

import ex2.Student;

public class TestMap {
    public static void main(String[] args) {
        CollegeMap college = new CollegeMap("Berklee");
        Student s1 = new Student("Maria");
        Student s2 = new Student("Anna");
        Student s3 = new Student("James");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("Grade average: " + college.calcAverage());  // 0

        college.addStudent(s1);
        college.addStudent(s2);
        college.addStudent(s3);

        s1.addGrade(10);
        s1.addGrade(4);
        s2.addGrade(12);
        s2.addGrade(10);
        s3.addGrade(4);
        s3.addGrade(7);
        System.out.println("Grade average: " + college.calcAverage());  // 7.83
        college.removeStudent(s3);
        System.out.println("Grade average: " + college.calcAverage());  // 9
        System.out.println(college.findStudent(1));     // Maria
        System.out.println(college.findStudent(3));     // null
    }
}
