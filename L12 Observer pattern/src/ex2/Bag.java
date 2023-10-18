package ex2;

public interface Bag {
    /** Add the string to the bag */
    public void addItem(String s);


    /** Remove the string s from the bag (if it is the bag). */
    public void remove(String s);


    /** Get the count of the string s in the bag. */
    public int getCount(String s);
}
