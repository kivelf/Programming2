package controller;

import model.Person;
import storage.Storage;

import java.util.List;

public abstract class Controller {
    private static Storage storage;

    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    public static Person opretPerson(String name, String title, boolean senior) {
        Person person = new Person(name, title, senior);
        storage.storePerson(person);
        return person;
    }

    public static List<Person> getAllPersons() {
        return storage.getAllPersons();
    }
}
