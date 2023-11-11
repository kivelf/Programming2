package ex1;

public class Ex1App {
    public static void main(String[] args) {
        SortedSingleList23Y<String> sortedList = new SortedSingleList23Y<>();
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
        System.out.println();

        // testing exercise 3)
        SortedSingleList23Y<String> sortedList2 = new SortedSingleList23Y<>();
        sortedList2.add("Tokyo");
        sortedList2.add("London");
        sortedList2.add("Athen");   // duplicate city!
        sortedList2.add("Washington D.C.");
        sortedList2.add("Sofia");
        System.out.println("Sorted list 1: " + sortedList);
        System.out.println("Sorted list 2: " + sortedList2);
        sortedList.addAll(sortedList2);
        System.out.println("Sorted list 1 after merge: " + sortedList);
    }
}
