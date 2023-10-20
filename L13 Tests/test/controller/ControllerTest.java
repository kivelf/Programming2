package controller;

import model.Student;
import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
        Controller.setStorage(storage);
    }

    @Test
    void createTeam() {
        // arrange

        // act
        Team t = Controller.createTeam("T1", "R1");
        // assert
        assertEquals("T1", t.getName());
        assertEquals("R1", t.getRoom());
        assertEquals(0, t.getNumberOfStudents());
        assertArrayEquals(new Team[0], t.getStudents());

        Set<Team> expected = new HashSet<>();
        expected.add(t);
        assertEquals(expected, storage.getAllTeams());
    }

    @Test
    void createStudent() {
        // arrange

        // act
        Student s = Controller.createStudent("N1", 20);
        // assert
        assertEquals("N1", s.getName());
        assertEquals(20, s.getAge());
        assertEquals(new ArrayList<Integer>(), s.getGrades());
        Set<Student> expected = new HashSet<>();
        expected.add(s);
        assertEquals(expected, storage.getAllStudents());
    }
}