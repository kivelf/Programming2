package ex1;

import java.io.*;

public class Ex1App {
    public static void main(String[] args) {
        // 1.1) create an object of the MyTime class
        MyTime myTime = new MyTime();

        // 1.2) increase the time a couple of times
        myTime.saveTime();
        myTime.increase();
        myTime.increase();
        myTime.saveTime();
        myTime.increase();
        myTime.saveTime();

        // 1.3) test the method getTime()
        System.out.println("The time is now: " + myTime.getTime());

        // 1.4) serialize the object to a file
        String filename = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\" +
                "Programming2\\L20 Architecture and Serializable\\src\\ex1\\MyTime.ser";
        try(FileOutputStream f_out = new FileOutputStream(filename);
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out)
        ) {
            obj_out.writeObject(myTime);
            System.out.println("myTime objektet er gemt: " + myTime);
        } catch (IOException ex) {
            System.out.println("Error serializing object");
            System.out.println(ex);
        }

        // 1.5) change the code so the object is being read from the file
        // 1.6) run the program a couple of times to mkae sure it loads correctly from the file
        String filename2 = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\" +
                "Programming2\\L20 Architecture and Serializable\\src\\ex1\\MyTime.ser";
        try (FileInputStream f_in = new FileInputStream(filename2);
             ObjectInputStream obj_in = new ObjectInputStream(f_in)
        ) {
            Object obj = obj_in.readObject();
            myTime = (MyTime) obj;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing object");
            System.out.println(ex);
            return;
        }
        System.out.println("myTime er hentet: " + myTime);

        myTime.reset();

        try (FileOutputStream f_out = new FileOutputStream(filename2);
             ObjectOutputStream obj_out = new ObjectOutputStream(f_out)
        ) {
            obj_out.writeObject(myTime);
            System.out.println("myTime er gemt: " + myTime);
        } catch (IOException ex) {
            System.out.println("Error serializing object");
            System.out.println(ex);
        }
    }
}
