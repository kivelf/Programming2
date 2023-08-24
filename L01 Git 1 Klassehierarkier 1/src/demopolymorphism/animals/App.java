package demopolymorphism.animals;

public class App {

    public static void main(String[] args) {
        Cat cat = new Cat(500);
        Dog dog = new Dog(1000);
        Donkey donkey = new Donkey(3000);
        Snake snake = new Snake(2000);

        cat.makeSound();
        dog.makeSound();
        donkey.makeSound();
        snake.makeSound();

        System.out.println();

        System.out.println(cat.getPrice());
        System.out.println(dog.getPrice());
        System.out.println(donkey.getPrice());
        System.out.println(snake.getPrice());

        int totalPrice = cat.getPrice() + dog.getPrice() + donkey.getPrice() + snake.getPrice();
        System.out.println("Total price: " + totalPrice);
    }
}

class Cat {
    private int price;

    public int getPrice() {
        return price;
    }

    public Cat(int price) {
        this.price = price;
    }

    public void makeSound() {
        System.out.println("Cat: Meow");
    }

}

class Dog {
    private int price;

    public int getPrice() {
        return price;
    }

    public Dog(int price) {
        this.price = price;
    }

    public void makeSound() {
        System.out.println("Dog: woof");
    }
}

class Donkey {
    private int price;

    public int getPrice() {
        return price;
    }

    public Donkey(int price) {
        this.price = price;
    }

    public void makeSound() {
        System.out.println("Donkey: hee-haw");
    }
}

class Snake {
    private int price;

    public int getPrice() {
        return price;
    }

    public Snake(int price) {
        this.price = price;
    }

    public void makeSound() {
        System.out.println("Snake: hiss");
    }
}
