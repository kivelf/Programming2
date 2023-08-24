package demopolymorphism.animals_polymorphic;

import java.util.ArrayList;

public class PolyApp {

    public static void main(String[] args) {
        System.out.println("POLYMORPHISM\n");

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Cat(500));
        animals.add(new Dog(1000));
        animals.add(new Donkey(3000));
        animals.add(new Snake(2000));

        for (Animal animal : animals) {
            animal.makeSound();
        }
        System.out.println();

        for (Animal animal : animals) {
            System.out.println(animal.getPrice());
        }

        int totalPrice = 0;
        for (Animal animal : animals) {
            totalPrice += animal.getPrice();
        }
        System.out.println("Total price: " + totalPrice);
    }
}

class Animal {
    private int price;

    public int getPrice() {
        return price;
    }

    public Animal(int price) {
        this.price = price;
    }

    public void makeSound() {
        System.out.println("Animal: ???");
    }
}

class Cat extends Animal {

    public Cat(int price) {
        super(price);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat: Meow");
    }
}

class Dog extends Animal {

    public Dog(int price) {
        super(price);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog: woof");
    }
}

class Donkey extends Animal {

    public Donkey(int price) {
        super(price);
    }

    @Override
    public void makeSound() {
        System.out.println("Donkey: hee-haw");
    }
}

class Snake extends Animal {

    public Snake(int price) {
        super(price);
    }

    @Override
    public void makeSound() {
        System.out.println("Snake: hiss");
    }
}
