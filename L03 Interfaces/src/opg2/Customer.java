package opg2;

public class Customer implements Comparable<Customer>{
    private String firstName;
    private String lastName;
    private int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // add get-methods as needed

    // compare order: last name --> first name if same --> age if also same
    @Override
    public int compareTo(Customer c) {
        if (this.lastName.compareTo(c.lastName) == 0){
            if (this.firstName.compareTo(c.firstName) == 0){
                return ((Integer)this.age).compareTo((Integer)c.age);
            }
            else return this.firstName.compareTo(c.firstName);
        }
        else return this.lastName.compareTo(c.lastName);
    }

    @Override
    public String toString(){
        return "Customer " + firstName + " " + lastName + ", age: " + age;
    }
}
