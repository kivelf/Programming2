package storage;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final List<Person> allPersons = new ArrayList<>();

    public List<Person> getAllPersons() {
        return new ArrayList<>(allPersons);
    }

    public void storePerson(Person person) {
        allPersons.add(person);
    }
}
