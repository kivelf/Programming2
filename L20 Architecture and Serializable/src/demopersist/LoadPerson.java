package demopersist;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadPerson {

    public static void main(String[] args) {
        Person p;

        String filename = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\Programming2" +
                "\\L20 Architecture and Serializable\\src\\demopersist\\Person.ser";
        try (FileInputStream f_in = new FileInputStream(filename);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            p = (Person) obj;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing object");
            System.out.println(ex);
            return;
        }

        System.out.println("Person er hentet: " + p);
    }
}
