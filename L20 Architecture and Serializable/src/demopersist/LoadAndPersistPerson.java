package demopersist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadAndPersistPerson {

    public static void main(String[] args) {
        Person person;

        String filename = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\Programming2\\" +
                "L20 Architecture and Serializable\\src\\demopersist\\Person.ser";
        try (FileInputStream f_in = new FileInputStream(filename);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            person = (Person) obj;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing object");
            System.out.println(ex);
            return;
        }
        System.out.println("Person er hentet: " + person);

        person.addGrade(4);
        person.addGrade(7);

        try (FileOutputStream f_out = new FileOutputStream(filename);
             ObjectOutputStream obj_out = new ObjectOutputStream(f_out)
        ) {
            obj_out.writeObject(person);
            System.out.println("Person er gemt: " + person);
        } catch (IOException ex) {
            System.out.println("Error serializing object");
            System.out.println(ex);
        }
    }
}
