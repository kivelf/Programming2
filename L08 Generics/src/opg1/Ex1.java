package opg1;

public class Ex1 {
    public static void main(String[] args) {
        Person person1 = new Person<>("John Doe");
        FullName name = new FullName("Jane", "Doe");
        Person person2 = new Person<>(name);
        System.out.println("Person " + person1);
        System.out.println("Person " + person2);
    }
}
