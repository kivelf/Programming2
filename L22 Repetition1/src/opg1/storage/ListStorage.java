package storage;

import model.Pizza;
import opg1.controller.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage, Serializable {
    private final List<Pizza> pizzas = new ArrayList<>();

    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }

    public void storePizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // -------------------------------------------------------------------------

    public static ListStorage loadStorage() {
        String fileName = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\Programming2\\L22 Repetition1\\src\\opg1\\storage.ser";
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)
        ) {
            Object obj = objIn.readObject();
            ListStorage storage = (ListStorage) obj;
            System.out.println("Storage loaded from file " + fileName);
            return storage;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing storage");
            System.out.println(ex);
            return null;
        }
    }

    public static void saveStorage(Storage storage) {
        String fileName = "D:\\Datamatiker\\1 semester\\Programmering 1\\Java projects\\Programming2\\L22 Repetition1\\src\\opg1\\storage.ser";
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ) {
            objOut.writeObject(storage);
            System.out.println("Storage saved in file " + fileName);
        } catch (IOException ex) {
            System.out.println("Error serializing storage");
            System.out.println(ex);
            throw new RuntimeException();
        }
    }
}
