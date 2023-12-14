package opg1;

import model.Pizza;
import opg1.controller.Storage;
import opg1.gui.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    private static Storage storage;

    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //-----------------------------------------------------

    /**
     * Create a new pizza.
     * Pre: name not empty, price > 0.
     */
    public static Pizza createPizza(String name, double pris) {
        Pizza pizza = new Pizza(name, pris);
        storage.storePizza(pizza);
        notifyObservers();
        return pizza;
    }

    //-----------------------------------------------------

    public static List<Pizza> getPizzas() {
        return storage.getPizzas();
    }

    //-----------------------------------------------------

    private static final List<Observer> observers = new ArrayList<>();

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    private static void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
