package opg1;

public class Person<T> implements Comparable<Person<T>>{
    private T name;

    public Person(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public int compareTo(Person<T> p){
        return this.name.toString().compareTo(p.getName().toString());
    }

    @Override
    public String toString(){
        return name.toString();
    }
}
