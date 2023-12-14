package opg1.controller;

import model.Pizza;

import java.util.List;

public interface Storage {
    List<Pizza> getPizzas();
    void storePizza(Pizza pizza);
}
