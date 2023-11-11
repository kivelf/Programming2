package ex2;

import ex1.SortedList23Y;

public class Ex2App {
    public static void main(String[] args) {
        SortedList23Y<String> sortedList = new SortedDoubleList23Y<>();
        sortedList.add("Berlin");
        sortedList.add("Madrid");
        sortedList.add("Athen");
        sortedList.add("Rom");
        sortedList.add("Amsterdam");

        System.out.println("Sorted list: " + sortedList);
        System.out.println();

        sortedList.add("Paris");
        System.out.println("Sorted list: " + sortedList);
        System.out.println();

        System.out.println(sortedList.removeFirst());
        System.out.println(sortedList.removeLast());
        System.out.println("Sorted list: " + sortedList);
        System.out.println();

        System.out.println(sortedList.remove("Sofia"));
        System.out.println(sortedList.remove("Madrid"));
        System.out.println("Sorted list: " + sortedList + ", size: " + sortedList.size());
    }
}
