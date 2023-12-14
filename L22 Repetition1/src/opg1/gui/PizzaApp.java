package opg1;

import opg1.controller.*;
import gui.PizzaWindow;
import javafx.application.Application;
import opg1.controller.Storage;
import storage.ListStorage;

public class PizzaApp {
    public static void main(String[] args) {
        Storage storage = ListStorage.loadStorage();
        if (storage == null) {
            storage = new ListStorage();
            System.out.println("Empty ListStorage created");
        }
        opg1.Controller.setStorage(storage);

        if (opg1.Controller.getPizzas().isEmpty()) {
            initStorage();
            System.out.println("Storage initialized");
        }

        Application.launch(PizzaWindow.class);

        ListStorage.saveStorage(storage);
    }

    public static void initStorage() {
        opg1.Controller.createPizza("Margherita", 40);
        opg1.Controller.createPizza("Americana", 50);
        opg1.Controller.createPizza("Rustica", 60);
        opg1.Controller.createPizza("Primavera", 60);
    }
}
