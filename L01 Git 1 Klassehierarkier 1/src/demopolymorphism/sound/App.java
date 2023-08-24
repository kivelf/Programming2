package demopolymorphism.sound;

public class App {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Donkey donkey = new Donkey();
        Snake snake = new Snake();

        cat.makeSound();
        dog.makeSound();
        donkey.makeSound();
        snake.makeSound();
    }
}

class Cat {
    public void makeSound() {
        System.out.println("Cat: Meow");
    }
}

class Dog {
    public void makeSound() {
        System.out.println("Dog: woof");
    }
}

class Donkey {
    public void makeSound() {
        System.out.println("Donkey: hee-haw");
    }
}

class Snake {
    public void makeSound() {
        System.out.println("Snake: hiss");
    }
}
