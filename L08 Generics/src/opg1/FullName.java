package opg1;

public class FullName implements Comparable<FullName> {
    private String firstname;
    private String lastname;

    public FullName(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString(){
        return firstname + " " + lastname;
    }

    @Override
    public int compareTo(FullName n){
        return this.toString().compareTo(n.toString());
    }
}
