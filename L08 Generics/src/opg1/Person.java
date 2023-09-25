package opg1;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>>{
    private T name;
    private int age = 0;

    public Person(T name) {
        this.name = name;
    }

    public Person(T name, int age){
        this(name);
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Person<T> p){
        return this.name.toString().compareTo(p.getName().toString());
    }

    @Override
    public String toString(){
        if (age == 0){
            return "Person " + name.toString();
        } else
            return "Person " + name.toString() + ", age: " + age;
    }
}
