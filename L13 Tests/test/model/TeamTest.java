package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    @Test
    public void constructTeam() {
        // arrange

        // act
        Team team = new Team("A1", "Room B");
        //assert
        assertEquals("A1", team.getName());
        assertEquals("Room B", team.getRoom());
        assertEquals(0, team.getNumberOfStudents());
        assertArrayEquals(new Team[0], team.getStudents());
    }

    @Test
    void addStudent() {
        // arrange
        Team team = new Team("A1", "Room B");
        Student s1 = new Student("Jane Jensen", 21);
        Student s2 = new Student("Lene Hansen", 22);
        Student s3 = new Student("Mette Nielsen", 20);

        // act
        team.addStudent(s1);
        team.addStudent(s2);
        team.addStudent(s3);
        // assert
        assertEquals(3, team.getNumberOfStudents());
        Student[] expected = {s1, s2, s3};
        assertArrayEquals(expected, team.getStudents());
    }
}
